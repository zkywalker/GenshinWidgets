package org.zky.genshinwidgets.main

import android.content.ClipData
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.compose.viewModel
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.webview.WebLoginActivity
import org.zky.genshinwidgets.res.color
import org.zky.genshinwidgets.utils.*
import org.zky.genshinwidgets.widgets.Config

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var launcher: ActivityResultLauncher<Intent>

    private val activityResultCallback: ActivityResultCallback<ActivityResult> =
        ActivityResultCallback {
            Log.i("kyle", "got cookie")
            val cookie = loginCookie
            if (checkToken(cookie)) {
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
        val cookie = model.cookie.observeAsState("")
        val signInfo = model.signInfo.observeAsState()
        val signReward = model.signReward.observeAsState()
        val userRole = model.roleInfo.observeAsState()
        val showInfoDialog = remember { mutableStateOf(false) }
        Scaffold(
            topBar = {
                MainPageTopBar { showInfoDialog.value = !showInfoDialog.value }
            }) {
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
        }
    }

    @Composable
    fun VersionDialog(onDismissRequest: () -> Unit) {
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
                    Text(text = getString(R.string.permission_info))

                    Text(text = getString(R.string.permission_info_network))
                    Text(text = getString(R.string.permission_info_storage))
                    Text(text = getString(R.string.permission_info_wake_app))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Switch(checked = Config.crashReport, onCheckedChange = {
                            Config.crashReport = it
                            getString(R.string.restart_app_enable_crash_report).toast()
                        })
                        Text(text = getString(R.string.crash_report))
                    }
                }
            },
            buttons = {}
        )
    }

    @Composable()
    private fun MainPageTopBar(onInfoClick: () -> Unit) {
        TopAppBar(
            title = { Text(text = getString(R.string.app_name)) },
            actions = {
                IconButton(onClick = onInfoClick) {
                    Icon(imageVector = Icons.Filled.Info, contentDescription = "info")
                }
            })
    }

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