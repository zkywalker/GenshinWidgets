package org.zky.genshinwidgets.main

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.google.accompanist.flowlayout.FlowRow
import kotlinx.coroutines.launch
import org.zky.genshinwidgets.Account
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.cst.SpCst
import org.zky.genshinwidgets.model.GameActivity
import org.zky.genshinwidgets.model.getTypeName
import org.zky.genshinwidgets.res.*
import org.zky.genshinwidgets.ui.DefaultCard
import org.zky.genshinwidgets.ui.LoadingView
import org.zky.genshinwidgets.ui.SettingItemView
import org.zky.genshinwidgets.ui.SpannerView
import org.zky.genshinwidgets.utils.*
import org.zky.genshinwidgets.webview.CookieInputDialog
import org.zky.genshinwidgets.webview.WebLoginActivity
import org.zky.genshinwidgets.widgets.Config
import org.zky.genshinwidgets.widgets.WidgetsConfigActivity
import org.zky.genshinwidgets.widgets.format
import java.util.*


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get()
    }

    private lateinit var launcher: ActivityResultLauncher<Intent>

    private val activityResultCallback: ActivityResultCallback<ActivityResult> =
        ActivityResultCallback {
            Log.i("kyle", "got cookie:${it.data?.getStringExtra("cookie")}")
            val cookie = it.data?.getStringExtra("cookie") ?: return@ActivityResultCallback
            checkCookie(cookie)
        }

    private fun checkCookie(cookie: String) {
        if (checkToken(cookie)) {
            viewModel.saveAccountByCookie(cookie)
            viewModel.onPageStart()
        } else {
            getString(R.string.get_cookie_fail).toast()
        }
    }

    private val items = listOf(Screen.Main, Screen.Profile)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            themes.Theme {
                val scope = rememberCoroutineScope()
                val scaffoldState = rememberScaffoldState()
                val navController = rememberNavController()
                val showInfoDialog = remember { mutableStateOf(false) }
                val signAllInfoDialog = viewModel.showSignResponse.observeAsState(false)
                val pageRequesting = viewModel.pageRequesting.observeAsState(false)
                val accountDialog = remember { mutableStateOf(false) }
                val showCookieInputDialog = remember { mutableStateOf(false) }
                val settingsDialog = remember { mutableStateOf(false) }
                val depsDialog = remember { mutableStateOf(false) }
                val showAddWidgetAlert = viewModel.showAddWidgetAlert.observeAsState(false)

                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        MainPageTopBar(model = viewModel, onMenuClick = {
                            scope.launch { scaffoldState.drawerState.open() }
                        })
                    },
                    bottomBar = { MainPageBottomBar(navController) },
                    drawerContent = {
                        MainDrawerView(
                            viewModel = viewModel,
                            onCopyCookie = {
                                copyToClipboard(
                                    it,
                                    getString(R.string.copy_cookie_success)
                                )
                            },
                            onCopyUID = { copyToClipboard(it) },
                            onClickManageAccount = { accountDialog.value = true },
                            onClickAddWidget = { addWidget() },
                            onClickSignAll = { viewModel.signAll() },
                            onClickSetting = { settingsDialog.value = true },
                            onClickDps = { depsDialog.value = true },
                            onClickAbout = { showInfoDialog.value = true },
                        )
                    }
                ) {
                    NavHost(
                        navController,
                        startDestination = Screen.Main.route,
                        modifier = Modifier.padding(
                            top = 15.dp,
                            start = 15.dp,
                            end = 15.dp,
                            bottom = 55.dp
                        ),
                    ) {
                        composable(Screen.Main.route) {
                            MainPage(model = viewModel) {
                                accountDialog.value = true
                            }
                        }
                        composable(Screen.Profile.route) {
                            ProfilePage(model = viewModel)
                        }
                    }

                    if (showAddWidgetAlert.value) {
                        AlertAddWidget()
                    }
                    if (signAllInfoDialog.value) {
                        SignAllInfoView()
                    }
                    if (settingsDialog.value) {
                        SettingsView { settingsDialog.value = false }
                    }
                    if (depsDialog.value) {
                        DepsView { depsDialog.value = false }
                    }
                    if (accountDialog.value) {
                        AccountsView(
                            onDismissRequest = { accountDialog.value = false },
                            onDelete = { viewModel.deleteAccount(it) },
                            onAddAccount = {
                                startActivityForResult<WebLoginActivity>(launcher)
                                accountDialog.value = false
                            },
                            onAddAccountByCookie = {
                                showCookieInputDialog.value = true
                                accountDialog.value = false
                            },
                            onCopyCookie = { copyToClipboard(it) },
                        )
                    }
                    if (showCookieInputDialog.value) {
                        CookieInputDialog(
                            onDismissRequest = { showCookieInputDialog.value = false },
                            onSubmit = {
                                checkCookie(it)
                            })
                    }
                    if (showInfoDialog.value) {
                        VersionDialog { showInfoDialog.value = false }
                    }
                    if (pageRequesting.value) {
                        LoadingView()
                    }
                }
            }
        }
        launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(), activityResultCallback
        )

        viewModel.onPageStart()
    }

    @Composable
    fun AlertAddWidget() {
        AlertDialog(
            onDismissRequest = { viewModel.showAddWidgetAlert.value = false },
            title = { Text(getString(R.string.add_widget_alert)) },
            text = { Text(getString(R.string.add_widget_alert_text)) },
            buttons = {
                Row(Modifier.padding(10.dp)) {
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        modifier = Modifier.padding(end = 5.dp),
                        onClick = {
                            startActivity<WidgetsConfigActivity>()
                            viewModel.showAddWidgetAlert.value = false
                            Sp.setValue(SpCst.KEY_SHOW_ADD_WIDGET_ALERT, false)
                        }) {
                        Text(text = getString(R.string.add_widget_alert_button))
                    }
                    Button(onClick = { viewModel.showAddWidgetAlert.value = false }) {
                        Text(text = getString(R.string.cancel))
                    }
                }
            }
        )
    }

    private fun addWidget() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            getString(R.string.needs_android_o).toast()
            return
        }
        val value = Sp.getValue(SpCst.KEY_SHOW_ADD_WIDGET_ALERT, true)
        if (value) {
            viewModel.showAddWidgetAlert.value = true
        } else {
            startActivity<WidgetsConfigActivity>()
        }
    }

    @Composable
    fun DepsView(onDismissRequest: () -> Unit = {}) {
        val deps = arrayOf(
            "Jetpack Compose",
            "Google Material Design",
            "Kotlin Coroutines",
            "com.google.code.gson:gson",
            "com.squareup.okhttp3:okhttp",
            "com.squareup.retrofit2:retrofit",
            "com.google.firebase:firebase",
            "com.squareup.sqldelight:android-driver"
        )
        Dialog(onDismissRequest = onDismissRequest) {
            Card {
                Column(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .height(300.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    deps.forEach {
                        Text(it)
                    }
                    Divider(
                        Modifier
                            .padding(top = 5.dp, bottom = 5.dp)
                            .height(1.dp)
                    )
                    Text(string.license)
                }
            }
        }
    }

    @Composable
    fun SettingsView(onDismissRequest: () -> Unit = {}) {
        var crashReport by remember { mutableStateOf(Config.crashReport) }
        var allowDarkMode by remember { mutableStateOf(Config.allowDarkMode) }

        AlertDialog(onDismissRequest = onDismissRequest,
            title = { Text(getString(R.string.settings)) },
            text = {
                Column(Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = getString(R.string.crash_report))
                        Switch(checked = crashReport, onCheckedChange = {
                            Config.crashReport = it
                            crashReport = it
                        })
                    }
//                    Row(verticalAlignment = Alignment.CenterVertically) {
//                        Text(text = getString(R.string.turn_off_drak_mode))
//                        Switch(checked = allowDarkMode, onCheckedChange = {
//                            Config.allowDarkMode = it
//                            allowDarkMode = it
//                        })
//                    }
                }
            },
            buttons = {})
    }

    @Composable
    private fun MainPageBottomBar(navController: NavController) {
        BottomNavigation {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            items.forEach { screen ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = getString(screen.resourceId)
                        )
                    },
                    label = {
                        Text(
                            getString(screen.resourceId),
                            color = themes.colors.buttonText
                        )
                    },
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    onClick = {
                        navController.navigate(screen.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
            }
        }
    }

    @Composable
    fun ProfilePage(model: MainViewModel) {
        val characters = model.characters.observeAsState()
        val activities = model.activities.observeAsState()
        Column(Modifier.verticalScroll(rememberScrollState())) {
            DefaultCard(
                text = getString(R.string.today_activities),
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                activities.value?.let {
                    // it cant nest with vertical scroll column
//                LazyVerticalGrid(
//                    modifier = Modifier.fillMaxWidth(),
//                    columns = GridCells.Adaptive(60.dp),
//                    horizontalArrangement = Arrangement.spacedBy(5.dp),
//                    verticalArrangement = Arrangement.spacedBy(5.dp)
//                ) {
//                    items(it) { activity ->
//                        ActivityView(activity)
//                    }
//                }
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        FlowRow(
                            mainAxisSpacing = 5.dp,
                            crossAxisSpacing = 5.dp
                        ) {
                            it.forEach { activity ->
                                ActivityView(activity)
                            }
                        }
                    }
                }
            }

            DefaultCard(
                text = getString(R.string.my_wives),
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CharacterListView(characters.value)
                }
            }

            DefaultCard(
                text = getString(R.string.miyoushe),
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                Row {
                    Button(onClick = {
                        startWebViwActivity(
                            getString(R.string.map), ApiCst.WEB_URL_MY_CHAR
                        )
                    }, modifier = Modifier.padding(end = 10.dp)) {
                        Text(text = getString(R.string.my_char))
                    }
//                    Button(onClick = onClickMap, modifier = Modifier.padding(end = 10.dp)) {
//                        Text(text = org.zky.genshinwidgets.utils.getString(R.string.map))
//                    }
//                    Button(onClick = onClickWiki, modifier = Modifier.padding(end = 10.dp)) {
//                        Text(text = org.zky.genshinwidgets.utils.getString(R.string.wiki))
//                    }
                }
            }

        }
    }

    @Composable
    fun ActivityView(activity: GameActivity) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(5.dp))
        ) {
            if (!TextUtils.isEmpty(activity.img_url)) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = rememberImagePainter(data = activity.img_url),
                    contentDescription = activity.title,
                    contentScale = ContentScale.Crop
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color.primary)
                )
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0x77444444)
                            )
                        )
                    )
                    .padding(3.dp)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                val start = (activity.start_time.toLongOrNull() ?: 0) * 1000
                val end = (activity.end_time.toLongOrNull() ?: 0) * 1000
                if (start != 0L && end != 0L) {
                    Text(
                        "${format.format(Date(start))}\n${format.format(Date(end))}",
                        color = Color.White,
                        fontSize = 7.sp
                    )
                }
                if (activity.drop_day.isNotEmpty()) {
                    Text(
                        "星期:${activity.drop_day}",
                        color = Color.White,
                        fontSize = 7.sp
                    )
                }
                Text(activity.title, color = Color.White, fontSize = 8.sp, maxLines = 1)
            }
        }
    }

    @Composable
    fun MainPage(model: MainViewModel, onClickLogin: () -> Unit) {
        val account = model.account.observeAsState()
        val signInfo = model.signInfo.observeAsState()
        val signReward = model.signReward.observeAsState()
        val userRoles = model.roleInfo.observeAsState()
        val showCookieInputDialog = remember { mutableStateOf(false) }
        val characters = model.characters.observeAsState()
        val activities = model.activities.observeAsState()
        val dailyNote = model.dailyNote.observeAsState()

        Column(
            Modifier
                .verticalScroll(rememberScrollState())
        ) {

            val userRoleList = userRoles.value
            when {
                TextUtils.isEmpty(account.value?.cookie) -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = onClickLogin) {
                            Text(text = getString(R.string.login_plz))
                        }
                    }
                }
                userRoleList?.isNotEmpty() != true -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = getString(R.string.seems_you_donot_have_role))
                    }
                }
            }
            if (!TextUtils.isEmpty(account.value?.cookie)) {
                DefaultCard(
                    text = getString(R.string.genshin_sign),
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    SignView(signInfo = signInfo.value,
                        signReward = signReward.value,
                        onRefreshSignInfo = { viewModel.refreshSignInfo(viewModel.currentUseRole.value) },
                        onRequestSign = { viewModel.signMain(viewModel.currentUseRole.value) })
                }
            }
            dailyNote.value?.let {
                DefaultCard(
                    text = getString(R.string.daily_note),
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    DailyNoteView(it)
                }
            }
            val tempList = characters.value?.filter {
                activities.value?.find { it2 -> it.name == it2.title } != null
            }
            if (tempList?.isNotEmpty() == true) {
                DefaultCard(
                    text = getString(R.string.foster_wives),
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {

                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        CharacterListView(tempList)
                    }
                }
            }
            DefaultCard(
                text = getString(R.string.observation_pivot),
                modifier = Modifier.padding(bottom = 10.dp)
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
                            getString(R.string.map), ApiCst.WEB_URL_GENSHIN_MAP
                        )
                    },
                    onClickWiki = {
                        startWebViwActivity(
                            getString(R.string.wiki), ApiCst.WEB_URL_ROLE_WIKI
                        )
                    },
                )
            }
            DefaultCard(
                text = getString(R.string.start_app),
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                JumpAppView(
                    onClickGenshin = { launchApp(ApiCst.APP_PACKAGE_NAME_GENSHIN) },
                    onClickCloud = { launchApp(ApiCst.APP_PACKAGE_NAME_GENSHIN_CLOUD) },
                    onClickBBS = { launchApp(ApiCst.APP_PACKAGE_NAME_BBS) },
                )
            }
        }

        if (showCookieInputDialog.value) {
            CookieInputDialog(onDismissRequest = { showCookieInputDialog.value = false },
                onSubmit = {
                    checkCookie(it)
                })
        }
    }

    @Composable
    fun MainDrawerView(
        viewModel: MainViewModel,
        onCopyCookie: (String) -> Unit,
        onCopyUID: (String) -> Unit,
        onClickManageAccount: () -> Unit,
        onClickAddWidget: () -> Unit,
        onClickSignAll: () -> Unit,
        onClickSetting: () -> Unit,
        onClickDps: () -> Unit,
        onClickAbout: () -> Unit
    ) {
        val account = viewModel.account.observeAsState().value
        val role = viewModel.currentUseRole.observeAsState().value
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(themes.colors.surface),
            contentAlignment = Alignment.BottomStart
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_drawer_keli),
                contentDescription = "drawer",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0xff444444)
                            )
                        )
                    )
                    .padding(10.dp)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                if (role != null) {
                    Text(
                        text = "${role.nickname} (${role.region_name} Lv.${role.level})",
                        color = Color.White
                    )
                }
                if (account != null) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${account.getTypeName()}ID:${account.account_id}",
                            color = Color.White
                        )
                        Image(
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .size(15.dp)
                                .clickable(onClick = { onCopyCookie(account.cookie) }),
                            painter = painterResource(id = R.drawable.ic_baseline_cookie_24_w),
                            contentDescription = "copy cookie"
                        )
                    }
                }
                if (role != null) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "UID:${role.game_uid}", color = Color.White)
                        Image(
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .size(15.dp)
                                .clickable(onClick = { onCopyUID(role.game_uid) }),
                            painter = painterResource(id = R.drawable.ic_baseline_content_copy_24),
                            contentDescription = "copy uid"
                        )
                    }
                }
            }
        }

        SettingItemView(
            text = getString(R.string.manage_account),
            imageRes = R.drawable.ic_baseline_account_circle_24_b,
            onClick = onClickManageAccount
        )
        SettingItemView(
            text = getString(R.string.add_widget), imageRes = R.drawable.ic_baseline_widgets_24_b,
            onClick = onClickAddWidget
        )
        SettingItemView(
            text = getString(R.string.sign_all_role),
            imageRes = R.drawable.ic_baseline_assignment_turned_in_24_b,
            onClick = onClickSignAll
        )
        SettingItemView(
            text = getString(R.string.settings), imageRes = R.drawable.ic_baseline_settings_24_b,
            onClick = onClickSetting
        )
        SettingItemView(
            text = getString(R.string.deps), imageRes = R.drawable.ic_baseline_api_24_b,
            onClick = onClickDps
        )
        SettingItemView(
            text = getString(R.string.about), imageRes = R.drawable.ic_baseline_info_24,
            onClick = onClickAbout
        )

    }

    @Composable
    fun AccountsView(
        onDismissRequest: () -> Unit,
        onDelete: (String) -> Unit,
        onAddAccount: () -> Unit,
        onAddAccountByCookie: () -> Unit,
        onCopyCookie: (String) -> Unit
    ) {
        val accounts = viewModel.accounts.observeAsState().value
        Dialog(onDismissRequest = onDismissRequest) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(15.dp)) {
                    if (accounts?.isNotEmpty() == true) {
                        Text(
                            modifier = Modifier.padding(bottom = 5.dp),
                            text = getString(R.string.accounts),
                            fontSize = font.bodyL
                        )
                        accounts.forEachIndexed { index, account ->
                            AccountItemView(index, account, onDelete, onCopyCookie)
                        }
                    } else {
                        Text(text = getString(R.string.no_account))
                    }
                    Text(
                        modifier = Modifier.padding(top = 15.dp, bottom = 5.dp),
                        text = getString(R.string.add_account),
                        fontSize = font.bodyL
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Button(modifier = Modifier.padding(end = 5.dp), onClick = onAddAccount) {
                            Text(text = getString(R.string.web_login))
                        }
                        Button(onClick = onAddAccountByCookie) {
                            Text(text = getString(R.string.cookie_login))
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun AccountItemView(
        index: Int,
        it: Account,
        onDelete: (String) -> Unit,
        onCopyCookie: (String) -> Unit
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "${index + 1} ${it.getTypeName()}ID:${it.account_id}",
            )
            Image(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(15.dp)
                    .clickable(onClick = { onDelete(it.account_id) }),
                painter = painterResource(id = R.drawable.ic_baseline_delete_outline_24_r),
                contentDescription = "delete"
            )
            Image(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(15.dp)
                    .clickable(onClick = { onCopyCookie(it.cookie) }),
                painter = painterResource(id = R.drawable.ic_baseline_cookie_24_b),
                contentDescription = "copy cookie"
            )
        }
    }

    @Composable
    fun SignAllInfoView() {
        val info = viewModel.signResponse.observeAsState(0 to 0)
        AlertDialog(onDismissRequest = { viewModel.showSignResponse.value = false },
            title = { Text(text = getString(R.string.sign_response)) },
            text = {
                when {
                    info.value.second == 0 -> {
                        Text(text = getString(R.string.data_error))
                    }
                    info.value.first == 0 -> {
                        Text(text = "${getString(R.string.sign_fail)} ${info.value.first}/${info.value.second}", color = themes.colors.error)
                    }
                    info.value.first == info.value.second -> {
                        Text(text = "${getString(R.string.sign_success)} ${info.value.first}/${info.value.second}")
                    }
                    else -> {
                        Text(text = "${getString(R.string.sign_end)} ${info.value.first}/${info.value.second}")
                    }
                }
            },
            buttons = {})

    }

    @Composable
    fun VersionDialog(onDismissRequest: () -> Unit) {
        AlertDialog(onDismissRequest = onDismissRequest,
            title = { Text("${getString(R.string.app_name)} v${getAppVersionName()}") },
            text = {
                Column(Modifier.fillMaxWidth()) {
                    Text(getString(R.string.github_repository),
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
                    Text(text = getString(R.string.permission_info_clipboard))

                    Divider(
                        Modifier
                            .padding(top = 5.dp, bottom = 5.dp)
                            .height(1.dp)
                    )
                    Text(getString(R.string.issue_report),
                        fontFamily = FontFamily.Monospace,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { startBrowser(getString(R.string.issue_report_url)) })
                }
            },
            buttons = {})
    }

    @Composable
    private fun MainPageTopBar(
        model: MainViewModel,
        onMenuClick: () -> Unit,
    ) {
        TopAppBar(
            navigationIcon = {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "menu",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .clickable(onClick = onMenuClick)
                )
            },
            title = {
                val userRoles = model.roleInfo.observeAsState()
                val userRole = model.currentUseRole.observeAsState()
                val showSpannerDialog = remember { mutableStateOf(false) }
                val userRoleList = userRoles.value ?: return@TopAppBar
                SpannerView(
                    expanded = showSpannerDialog.value,
                    onVisibilityChange = { s -> showSpannerDialog.value = s },
                    data = userRoleList,
                    defaultIndex = userRoleList.indexOf(userRole.value),
                    itemContentGetter = { i, it ->
                        var textColor = themes.colors.buttonText
                        val text = if (i == -1) {
                            "${getString(R.string.hello_traveler)} ${it?.nickname ?: ""}"
                        } else {
                            textColor = themes.colors.textPrimary
                            "${it?.nickname ?: ""}(${it?.region_name} Lv.${it?.level ?: "?"})"
                        }
                        Text(
                            text = text, fontSize = 17.sp, color = textColor
                        )
                    },
                    onItemClick = { _, it ->
                        viewModel.onSelectRole(it)
                    })
            },
            actions = {
                IconButton(
                    onClick = {
                        viewModel.onPageStart()
                    },
                    content = {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = "info",
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    }
                )
            }
        )
    }

    private fun copyToClipboard(
        value: String,
        toastMsg: String = getString(R.string.copy_to_clipboard)
    ) {
        val clipboardManager =
            getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        clipboardManager.setPrimaryClip(ClipData.newPlainText("cookie", value))
        toastMsg.toast()
    }

    sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
        object Main : Screen("main", R.string.main, icon.star)
        object Profile : Screen("profile", R.string.profile, Icons.Filled.AccountCircle)
    }

}