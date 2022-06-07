package org.zky.genshinwidgets.main

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color.alpha
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.webview.WebLoginActivity
import org.zky.genshinwidgets.res.color
import org.zky.genshinwidgets.ui.DefaultCard
import org.zky.genshinwidgets.ui.SettingItemView
import org.zky.genshinwidgets.utils.*
import org.zky.genshinwidgets.widgets.Config
import java.io.File
import org.zky.genshinwidgets.widgets.WidgetsConfigActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var launcher: ActivityResultLauncher<Intent>

    private val activityResultCallback: ActivityResultCallback<ActivityResult> =
        ActivityResultCallback {
            Log.i("kyle", "got cookie:${it.data?.getStringExtra("cookie")}")
            val cookie = it.data?.getStringExtra("cookie") ?: return@ActivityResultCallback
            checkCookie(cookie)
        }

    private fun checkCookie(cookie: String) {
        if (checkToken(cookie)) {
            loginCookie = cookie
            viewModel.cookie.value = cookie
            viewModel.onPageStart()
        } else {
            getString(R.string.get_cookie_fail).toast()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colors = MaterialTheme.colors.copy(primary = color.primary)) {
                MainPage(viewModel())
            }
        }
        launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            activityResultCallback
        )
        viewModel = ViewModelProvider(this).get()

        viewModel.onPageStart()
    }

    @Composable
    fun MainPage(model: MainViewModel) {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val cookie = model.cookie.observeAsState("")
        val signInfo = model.signInfo.observeAsState()
        val signReward = model.signReward.observeAsState()
        val userRole = model.roleInfo.observeAsState()
        val showInfoDialog = remember { mutableStateOf(false) }
        val showCookieInputDialog = remember { mutableStateOf(false) }
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                MainPageTopBar(
                    onMenuClick = {
//                        scope.launch { scaffoldState.drawerState.open() }
                    },
                    onInfoClick = { showInfoDialog.value = !showInfoDialog.value }
                )
            },
//            drawerContent = { MainDrawerView() }
        ) {
            Column(
                Modifier
                    .padding(15.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                if (!TextUtils.isEmpty(cookie.value)) {
                    DefaultCard(
                        text = "${getString(R.string.hello_traveler)} ${userRole.value?.nickname ?: ""} Lv.${userRole.value?.level ?: "?"}",
                        Modifier.padding(bottom = 10.dp)
                    ) {
                        UserRoleView(
                            userRole = userRole.value,
                            onRefresh = { viewModel.onPageStart() },
                            copyUid = ::copyToClipboard
                        )
                    }
                }
                DefaultCard(
                    text = getString(R.string.cookie_info),
                    Modifier.padding(bottom = 10.dp)
                ) {
                    CookieView(
                        cookie = cookie.value,
                        onLaunchToCookiePage = { startActivityForResult<WebLoginActivity>(launcher) },
                        onInputCookie = { showCookieInputDialog.value = true },
                        copyToClipboard = ::copyToClipboard,
                        clearCookie = ::clearCookie
                    )
                }
                if (!TextUtils.isEmpty(cookie.value)) {
                    DefaultCard(
                        text = getString(R.string.genshin_sign),
                        Modifier.padding(bottom = 10.dp)
                    ) {
                        SignView(
                            signInfo = signInfo.value,
                            signReward = signReward.value,
                            onRefreshSignInfo = { viewModel.getSignInfo(viewModel.roleInfo.value) },
                            onRequestSign = { viewModel.sign(viewModel.roleInfo.value) }
                        )
                    }
                }
                DefaultCard(
                    text = getString(R.string.observation_pivot),
                    Modifier.padding(bottom = 10.dp)
                ) {
                    ObservationPivotView(
                        onClickTodayMaterial = {
                            startWebViwActivity(
                                getString(R.string.today_material),
                                ApiCst.WEB_URL_TODAY_MATERIAL
                            )
                        },
                        onClickMap = {
                            startWebViwActivity(
                                getString(R.string.map),
                                ApiCst.WEB_URL_GENSHIN_MAP
                            )
                        },
                        onClickWiki = {
                            startWebViwActivity(
                                getString(R.string.wiki),
                                ApiCst.WEB_URL_ROLE_WIKI
                            )
                        },
                    )
                }
                DefaultCard(
                    text = getString(R.string.start_app),
                    Modifier.padding(bottom = 10.dp)
                ) {
                    JumpAppView(
                        onClickGenshin = { launchApp(ApiCst.APP_PACKAGE_NAME_GENSHIN) },
                        onClickCloud = { launchApp(ApiCst.APP_PACKAGE_NAME_GENSHIN_CLOUD) },
                        onClickBBS = { launchApp(ApiCst.APP_PACKAGE_NAME_BBS) },
                    )
                }
            }

            if (showInfoDialog.value) {
                VersionDialog { showInfoDialog.value = false }
            }
            if (showCookieInputDialog.value) {
                CookieInputDialog(
                    onDismissRequest = { showCookieInputDialog.value = false },
                    onSubmit = {
                        checkCookie(cookie.value)
                    })
            }
        }
    }

    @Composable
    fun ColumnScope.MainDrawerView() {
        Image(
            painter = painterResource(id = R.drawable.bg_drawer_keli),
            contentDescription = "drawer",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        SettingItemView(
            text = getString(R.string.widget_setting),
            imageRes = R.drawable.ic_baseline_cookie_24
        ) {
            startActivity<WidgetsConfigActivity>()
        }
    }

    @Composable
    fun VersionDialog(onDismissRequest: () -> Unit) {
        var crashReport by remember { mutableStateOf(Config.crashReport) }
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = { Text("${getString(R.string.app_name)} v${getAppVersionName()}") },
            text = {
                Column(Modifier.fillMaxWidth()) {
                    Text(
                        getString(R.string.github_repository),
                        fontSize = 11.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { startBrowser(getString(R.string.github_repository)) })
                    Divider(
                        Modifier
                            .padding(top = 5.dp, bottom = 5.dp)
                            .height(1.dp)

                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = getString(R.string.crash_report))
                        Switch(checked = crashReport, onCheckedChange = {
                            crashReport = it
                        })
                    }
                    Divider(
                        Modifier
                            .padding(top = 5.dp, bottom = 5.dp)
                            .height(1.dp)
                    )
                    Text(text = getString(R.string.permission_info))
                    Text(text = getString(R.string.permission_info_network))
                    Text(text = getString(R.string.permission_info_storage))
                    Text(text = getString(R.string.permission_info_wake_app))
                    Text(text = getString(R.string.permission_info_clipboard))
                    Divider(
                        Modifier
                            .padding(top = 5.dp, bottom = 5.dp)
                            .height(1.dp)
                    )
                    Text(
                        getString(R.string.issue_report),
                        fontFamily = FontFamily.Monospace,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { startBrowser(getString(R.string.issue_report_url)) })
                }
            },
            buttons = {}
        )
    }

    @Composable()
    private fun MainPageTopBar(onMenuClick: () -> Unit, onInfoClick: () -> Unit) {
        TopAppBar(
//            navigationIcon = {
//                Icon(
//                    imageVector = Icons.Filled.Menu,
//                    contentDescription = "menu",
//                    modifier = Modifier
//                        .padding(start = 10.dp)
//                        .clickable(onClick = onMenuClick)
//                )
//            },
            title = { Text(text = getString(R.string.app_name)) },
            actions = {
                IconButton(onClick = onInfoClick) {
                    Icon(imageVector = Icons.Filled.Info, contentDescription = "info")
                }
            })
    }

    // todo its not working now -_-
    private fun clearCookie() {
        loginCookie = ""
        viewModel.cookie.value = ""
    }

    private fun copyToClipboard(value: String) {
        val clipboardManager =
            getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        clipboardManager.setPrimaryClip(ClipData.newPlainText("cookie", value))
        getString(R.string.copy_to_clipboard).toast()
    }

}