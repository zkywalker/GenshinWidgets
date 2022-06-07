package org.zky.genshinwidgets.widgets

import android.appwidget.AppWidgetManager
import android.content.Intent
import android.graphics.BitmapFactory
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.glance.action.actionParametersOf
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.flowlayout.FlowRow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.model.UserRole
import org.zky.genshinwidgets.model.WidgetsConfigModel
import org.zky.genshinwidgets.network.Request
import org.zky.genshinwidgets.res.color
import org.zky.genshinwidgets.utils.*
import org.zky.genshinwidgets.webview.WebLoginActivity
import java.io.File
import org.zky.genshinwidgets.ui.DefaultCard
import org.zky.genshinwidgets.ui.SwitchView
import org.zky.genshinwidgets.utils.BitmapFillet.CORNER_ALL
import org.zky.genshinwidgets.utils.getString
import org.zky.genshinwidgets.utils.loginCookie
import org.zky.genshinwidgets.utils.toast

class WidgetsConfigActivity : AppCompatActivity() {

    private lateinit var viewModel: WidgetsConfigViewModel

    private lateinit var launcher: ActivityResultLauncher<Intent>

    private val activityResultCallback: ActivityResultCallback<ActivityResult> =
        ActivityResultCallback {
            Log.i("kyle", "got cookie:${it.data?.getStringExtra("cookie")}")
            val cookie = it.data?.getStringExtra("cookie") ?: return@ActivityResultCallback
            checkCookie(cookie)
            lifecycleScope.launch {
                viewModel.requestUserRole(cookie)
            }
        }

    private val showInputDialog = mutableStateOf(false)

    private lateinit var widgetIds: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            activityResultCallback
        )
        viewModel = ViewModelProvider(this).get()

        intent.extras?.also {
            viewModel.appWidgetId.value = it.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
        } ?: kotlin.run {
            viewModel.appWidgetId.value = AppWidgetManager.INVALID_APPWIDGET_ID
            viewModel.isAddWidgetMode = false
        }
        lifecycleScope.launch {
            viewModel.requestUserRole(loginCookie)
        }
        setContent {
            val appWidgetId = viewModel.appWidgetId.observeAsState()
            val cookie = viewModel.widgetCookie.observeAsState()
            val userRole = viewModel.roleInfo.observeAsState()
            MaterialTheme(colors = MaterialTheme.colors.copy(primary = color.primary)) {
                RootView(
                    widgetId = appWidgetId.value ?: AppWidgetManager.INVALID_APPWIDGET_ID,
                    cookie = cookie.value,
                    role = userRole.value,
                    onConfirmClick = onConfirmClick,
                    onJumpToLoginClick = onLoginClick,
                    onInputCookieClick = onInputCookieClick,
                    onValueChange = onImageValueChange,
                ) {
                    finish()
                }
                if (showInputDialog.value) {
                    CookieInputDialog(
                        onDismissRequest = { showInputDialog.value = false },
                        onSubmit = { cookie ->
                            checkCookie(cookie)
                            lifecycleScope.launch {
                                viewModel.requestUserRole(cookie)
                            }
                        }
                    )
                }
            }
        }
    }

    private fun checkCookie(cookie: String) {
        if (checkToken(cookie)) {
            viewModel.widgetCookie.value = cookie
            if (TextUtils.isEmpty(loginCookie)) {
                loginCookie = cookie
            }
        } else {
            getString(R.string.get_cookie_fail).toast()
        }
    }

    private val onImageValueChange: (File?, Dp?, Float?) -> Unit = { f, c, a ->
        viewModel.widgetImageFile.value = f
        viewModel.widgetImageCorner.value = c
        viewModel.widgetImageAlpha.value = a

    }

    private val onInputCookieClick = { showInputDialog.value = true }

    private val onLoginClick: () -> Unit = { startActivityForResult<WebLoginActivity>(launcher) }

    private val onConfirmClick: (WidgetsConfigModel) -> Unit = {
        lifecycleScope.launch {
            Config.launchTarget = it.targetLaunchApp
            Config.showUID = it.showUID

            val ids = GlanceAppWidgetManager(this@WidgetsConfigActivity).getGlanceIds(
                GenshinDailyNoteWidget::class.java
            )
            val curId = ids.find { it.getId() == viewModel.appWidgetId.value }
            if (curId == null) {
                R.string.add_widget_fialed.toast()
                finish()
                return@launch
            }
            viewModel.refreshLocalWidgetCookie()
            var imageFile = ""
            if (viewModel.widgetImageFile.value != null) {
                withContext(Dispatchers.IO) {
                    val file = viewModel.widgetImageFile.value
                    val corner = viewModel.widgetImageCorner.value ?: 15.dp
                    val alpha = viewModel.widgetImageAlpha.value ?: 0.5f
                    if (file != null) {
                        val clip =
                            BitmapFillet.clip(BitmapFactory.decodeFile(file.absolutePath))
                        val target = (clip.width / 160) * corner.value
                        val decodeResource =
                            BitmapFillet.fillet(clip, target.toInt(), CORNER_ALL, alpha)
                        val save = decodeResource.save("bg_2x2_${System.currentTimeMillis()}.png")
                        if (save.exists() && save.length() > 0) {
                            imageFile = save.absolutePath
                        } else {
                            R.string.save_bg_error.toast()
                        }
                    }

                }
            }
            GlanceCallbackAction().onRun(
                this@WidgetsConfigActivity,
                curId,
                actionParametersOf(GenshinDailyNoteWidget.ACTION_PARAMETERS_BG to imageFile)
            )
            val resultIntent = Intent()
            resultIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, viewModel.appWidgetId.value)
            setResult(RESULT_OK, resultIntent)
            finish()
            // todo auto refresh seems not work when app died -_-
//            GlanceReceiver.startRefreshAlarm(application, WidgetsConfig.autoRefreshMs)
        }
    }
}


val launchTargets = arrayOf(
    getString(R.string.current_app) to "",
    getString(R.string.genshin) to ApiCst.APP_PACKAGE_NAME_GENSHIN,
    getString(R.string.yun_genshin) to ApiCst.APP_PACKAGE_NAME_GENSHIN_CLOUD,
    getString(R.string.miyoushe) to ApiCst.APP_PACKAGE_NAME_BBS,
)

@Composable
private fun RootView(
    widgetId: Int,
    cookie: String?,
    role: UserRole?,
    onConfirmClick: (WidgetsConfigModel) -> Unit,
    onJumpToLoginClick: () -> Unit,
    onInputCookieClick: () -> Unit,
    onValueChange: (File?, Dp?, Float?) -> Unit,
    onBackClick: () -> Unit,
) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = getString(R.string.config_widget)) },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back",
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable(onClick = onBackClick)
                )
            }
        )
    }) {
        var target by remember { mutableStateOf(launchTargets[0].first) }
        var showUID by remember { mutableStateOf(Config.showUID) }
        var showBgConfig by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(15.dp)
        ) {
            if (TextUtils.isEmpty(cookie)) {
                Button(onJumpToLoginClick) {
                    Text(getString(R.string.login_plz))
                }
            } else if (widgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
                Text(getString(R.string.did_not_add_widget))
            } else {
                if (role != null) {
                    DefaultCard(
                        text = "${role.nickname}(UID:${role.game_uid})",
                        modifier = Modifier.padding(bottom = 10.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                getString(R.string.use_other_account),
                                modifier = Modifier.padding(10.dp)
                            )
                            Button(onJumpToLoginClick, modifier = Modifier.padding(10.dp)) {
                                Text(getString(R.string.login))
                            }
                            Button(onInputCookieClick, modifier = Modifier.padding(10.dp)) {
                                Text(getString(R.string.by_input_cookie))
                            }
                        }
                    }
                }
                DefaultCard(
                    text = getString(R.string.widget_ui_config),
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    Column {
                        Row {
                            SwitchView(
                                text = getString(R.string.show_uid),
                                checked = showUID,
                                onCheckedChange = { showUID = it }
                            )
                            SwitchView(
                                text = getString(R.string.config_bg),
                                checked = showBgConfig,
                                onCheckedChange = {
                                    showBgConfig = it
                                    if (!showBgConfig) {
                                        onValueChange(null, null, null)
                                    }
                                })
                        }
                        if (showBgConfig) {
                            PreviewWidgetView { f, c, a ->
                                if (showBgConfig) {
                                    onValueChange(f, c, a)
                                }
                            }
                        }
                    }

                }
                DefaultCard(
                    text = getString(R.string.click_widget_launch),
                    modifier = Modifier.padding(bottom = 20.dp)
                ) {
                    FlowRow {
                        launchTargets.forEach {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(selected = target == it.first, onClick = {
                                    target = it.first
                                })
                                Text(text = it.first)
                            }
                        }
                    }
                }
                Button(onClick = {
                    onConfirmClick(
                        WidgetsConfigModel(
                            launchTargets.find { it.first == target }!!.second,
                            showUID
                        )
                    )
                }) {
                    Text(getString(R.string.save_config))
                }
            }
        }
    }
}


@Composable
fun PreviewWidgetView(
    onValueChange: (File, Dp, Float) -> Unit
) {
    val scope = rememberCoroutineScope()
    var con by remember { mutableStateOf(0.5f) }
    var alpha by remember { mutableStateOf(0.5f) }
    val cornerFuc: (Float) -> Dp = { (it * 20 + 5).dp }
    val alphaFuc: (Float) -> Float = { it * 0.7f + 0.3f }
    var imageFile by remember { mutableStateOf<File?>(null) }
    var imageUrl by remember { mutableStateOf("https://gw.alicdn.com/imgextra/i1/O1CN01wAe0EH1pUlFsEnT58_!!6000000005364-0-tps-747-499.jpg") }
    TextField(value = imageUrl, onValueChange = { imageUrl = it })
    Button(onClick = {
        scope.launch {
            if (TextUtils.isEmpty(imageUrl)) {
                return@launch
            }
            val urlToFile = imageUrlToFile(imageUrl)
            if (urlToFile != null && urlToFile.exists()) {
                urlToFile.createNewFile()
            }
            if (urlToFile?.length() == 0L) {
                Request.download(imageUrl, urlToFile)
            }
            imageFile = urlToFile
            onValueChange(imageFile!!, cornerFuc(con), alphaFuc(alpha))
        }
    }) {
        Text(text = "加载网络图片")
    }
    if (imageFile != null) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                bitmap = imageUrlToBitmap(imageUrl)!!.asImageBitmap(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(160.dp)
                    .alpha(alphaFuc(alpha))
                    .clip(RoundedCornerShape(cornerFuc(con)))
            )
            Column {
                Text(text = "${getString(R.string.corner)}:${cornerFuc(con)}")
                SliderView(
                    value = con,
                    onValueChange = {
                        con = it
                        onValueChange(imageFile!!, cornerFuc(con), alphaFuc(alpha))

                    },
                    start = cornerFuc(0.0f).toString(), end = cornerFuc(1.0f).toString()
                )
                Text(text = "${getString(R.string.alpha)}:${alphaFuc(alpha)}")
                SliderView(
                    value = alpha,
                    onValueChange = {
                        alpha = it
                        onValueChange(imageFile!!, cornerFuc(con), alphaFuc(alpha))
                    },
                    valueRange = 0.3f..1f,
                    start = alphaFuc(0.0f).toString(), end = alphaFuc(1.0f).toString()
                )
            }
        }

    }
}

@Composable
fun SliderView(
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    start: String,
    end: String
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = start,
        )
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = valueRange,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = end,
        )
    }

}