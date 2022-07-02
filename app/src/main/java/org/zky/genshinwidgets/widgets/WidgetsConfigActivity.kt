package org.zky.genshinwidgets.widgets

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.glance.action.actionParametersOf
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import coil.compose.rememberImagePainter
import com.google.accompanist.flowlayout.FlowRow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.cst.SpCst
import org.zky.genshinwidgets.main.MainActivity
import org.zky.genshinwidgets.model.WidgetsConfigModel
import org.zky.genshinwidgets.network.Request
import org.zky.genshinwidgets.res.color
import org.zky.genshinwidgets.res.themes
import org.zky.genshinwidgets.ui.*
import org.zky.genshinwidgets.utils.*
import org.zky.genshinwidgets.utils.BitmapFillet.CORNER_ALL
import java.io.File
import java.io.FileOutputStream


class WidgetsConfigActivity : AppCompatActivity() {

    private lateinit var viewModel: WidgetsConfigViewModel

    private lateinit var launcher: ActivityResultLauncher<Intent>

    private val activityResultCallback: ActivityResultCallback<ActivityResult> =
        ActivityResultCallback {
            val fileUri = it.data?.data
            if (fileUri != null) {
                viewModel.localPickImageFile.value = fileUri.toString()
                return@ActivityResultCallback
            }
        }

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
            viewModel.isAddWidgetModeFromHome = false
        }
        lifecycleScope.launch {
            viewModel.getUserRole()
        }
        setContent {
            MaterialTheme(colors = MaterialTheme.colors.copy(primary = color.primary)) {
                RootView(
                    onConfirmClick = onConfirmClick,
                    onJumpToLoginClick = onLoginClick,
                    onValueChange = onImageValueChange,
                ) {
                    finish()
                }
            }
        }

        PinBroadcastReceiver.onPinListener = onPinListener@{
            val config = viewModel.widgetsConfigModel ?: return@onPinListener
            if (it != -1) {
                viewModel.appWidgetId.value = it
                onConfirmClick(config)
            }
        }
    }

    @Composable
    private fun RootView(
        onConfirmClick: (WidgetsConfigModel) -> Unit,
        onJumpToLoginClick: () -> Unit,
        onValueChange: (File?, Dp?, Float?) -> Unit,
        onBackClick: () -> Unit,
    ) {
        val appWidgetId = viewModel.appWidgetId.observeAsState()
        val userRoles = viewModel.roleInfo.observeAsState()
        val userRole = viewModel.currentUseRole.observeAsState()
        val pageRequesting = viewModel.pageRequesting.observeAsState()
        val pageLoading = viewModel.pageLoading.observeAsState()
        var target by remember { mutableStateOf(launchTargets[0].first) }
        var showUID by remember { mutableStateOf(Config.showUID) }
        var showBgConfig by remember { mutableStateOf(false) }
        val showSpannerDialog = remember { mutableStateOf(false) }
        val image = viewModel.localPickImageFile.observeAsState()
        val historyPickImage = viewModel.historyPickImage

        val userRoleList = userRoles.value
        Log.i("kyle", "userRole:$userRole")
        themes.Theme {
            Scaffold(topBar = {
                TopAppBar(
                    title = { Text(text = org.zky.genshinwidgets.utils.getString(R.string.config_widget)) },
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
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    if (userRole.value == null) {
                        Button(onJumpToLoginClick) {
                            Text(org.zky.genshinwidgets.utils.getString(R.string.login_plz))
                        }
                    } else if (viewModel.isAddWidgetModeFromHome && appWidgetId.value == AppWidgetManager.INVALID_APPWIDGET_ID) {
                        Text(org.zky.genshinwidgets.utils.getString(R.string.did_not_add_widget))
                    } else {
                        val role = userRole.value
                        if (role != null) {
                            when {
                                pageRequesting.value == true -> {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(100.dp), contentAlignment = Alignment.Center
                                    ) {
                                        CircularProgressIndicator()
                                    }
                                }
                                userRoleList?.isNotEmpty() != true -> {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(100.dp), contentAlignment = Alignment.Center
                                    ) {
                                        Text(text = getString(R.string.seems_you_donot_have_role))
                                    }
                                }
                                else -> {
                                    SpannerView(
                                        modifier = Modifier.padding(bottom = 10.dp),
                                        expanded = showSpannerDialog.value,
                                        onVisibilityChange = { s -> showSpannerDialog.value = s },
                                        data = userRoleList,
                                        defaultIndex = userRoleList.indexOf(userRole.value),
                                        itemContentGetter = { _, it ->
                                            Text(
                                                text = "${it?.nickname ?: ""}\n${it?.region_name} Lv.${it?.level ?: "?"} UID:${it?.game_uid ?: "?"}",
                                                fontSize = 17.sp
                                            )
                                        },
                                        onItemClick = { _, it ->
                                            viewModel.currentUseRole.value = it
                                        }
                                    )
                                }
                            }
                        }
                        DefaultCard(
                            text = org.zky.genshinwidgets.utils.getString(R.string.widget_ui_config),
                            modifier = Modifier.padding(bottom = 10.dp)
                        ) {
                            Column {
                                Row {
                                    SwitchView(
                                        text = org.zky.genshinwidgets.utils.getString(R.string.show_uid),
                                        checked = showUID,
                                        onCheckedChange = { showUID = it }
                                    )
                                    SwitchView(
                                        text = org.zky.genshinwidgets.utils.getString(R.string.config_bg),
                                        checked = showBgConfig,
                                        onCheckedChange = {
                                            showBgConfig = it
                                            if (!showBgConfig) {
                                                onValueChange(null, null, null)
                                            }
                                        })
                                }
                                if (showBgConfig) {
                                    PreviewConfigWidgetView(
                                        image.value ?: "",
                                        onInputChange = { viewModel.localPickImageFile.value = it },
                                        historyImage = historyPickImage,
                                        onSelectFileClick = {
                                            startActivityForResult2(launcher) {
                                                val intent = Intent(Intent.ACTION_GET_CONTENT)
                                                intent.type = "image/*"
                                                intent.addCategory(Intent.CATEGORY_OPENABLE)
                                                intent
                                            }
                                        }
                                    ) { f, c, a ->
                                        viewModel.widgetImageFile.value = f
                                        viewModel.widgetImageCorner.value = c
                                        viewModel.widgetImageAlpha.value = a
                                    }
                                }
                            }

                        }
                        DefaultCard(
                            text = org.zky.genshinwidgets.utils.getString(R.string.click_widget_launch),
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
                            Text(org.zky.genshinwidgets.utils.getString(R.string.save_config))
                        }
                    }
                }
            }

            if (pageLoading.value == true) {
                LoadingView {
                    viewModel.pageLoading.value = false
                }
            }
        }
    }

    private val onImageValueChange: (File?, Dp?, Float?) -> Unit = { f, c, a ->
        viewModel.widgetImageFile.value = f
        viewModel.widgetImageCorner.value = c
        viewModel.widgetImageAlpha.value = a

    }

    private val onLoginClick: () -> Unit = {
//        startActivityForResult<WebLoginActivity>(launcher)
        startActivity<MainActivity>()
        finish()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun tryToPinWidget() {
        val appWidgetManager: AppWidgetManager = getSystemService(AppWidgetManager::class.java)
        val myProvider = ComponentName(this, GlanceReceiver::class.java)
        if (appWidgetManager.isRequestPinAppWidgetSupported) {
            appWidgetManager.requestPinAppWidget(
                myProvider,
                null,
                PinBroadcastReceiver.obtainPendingIntent(this)
            )
        }
    }

    private val onConfirmClick: (WidgetsConfigModel) -> Unit = {
        lifecycleScope.launch {
            if (!viewModel.isAddWidgetModeFromHome && viewModel.appWidgetId.value == AppWidgetManager.INVALID_APPWIDGET_ID) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    viewModel.widgetsConfigModel = it
                    tryToPinWidget()
                }
                return@launch
            }
            viewModel.pageLoading.value = true
            Config.launchTarget = it.targetLaunchApp
            Config.showUID = it.showUID

            val ids = GlanceAppWidgetManager(this@WidgetsConfigActivity).getGlanceIds(
                GenshinDailyNoteWidget::class.java
            )
            val curId = ids.find { it.getId() == viewModel.appWidgetId.value }
            if (curId == null) {
                R.string.add_widget_fialed.toast()
                viewModel.pageLoading.value = false
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
                            val history = viewModel.historyPickImage.toMutableList()
                            if (history.size == 6) {
                                history.removeLast()
                            }
                            val absolutePath = viewModel.widgetImageFile.value!!.absolutePath
                            if (!history.contains(absolutePath)) {
                                history.add(0, absolutePath)
                            }
                            val string = StringBuilder()
                            history.forEach {
                                if (string.isNotEmpty()) {
                                    string.append(",")
                                }
                                string.append(it)
                            }
                            Sp.setValue(SpCst.KEY_HISTORY_PICK_IMAGES, string.toString())
                        } else {
                            R.string.save_bg_error.toast()
                        }
                    }
                }
            }

            Sp.setValue(
                "${SpCst.KEY_ROLE_INFO}_${viewModel.appWidgetId.value}",
                viewModel.currentUseRole.value.toJson()
            )
            GlanceCallbackAction().onRun(
                this@WidgetsConfigActivity,
                curId,
                actionParametersOf(GenshinDailyNoteWidget.ACTION_PARAMETERS_BG to imageFile)
            )
            val resultIntent = Intent()
            resultIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, viewModel.appWidgetId.value)
            setResult(RESULT_OK, resultIntent)
            viewModel.pageLoading.value = false
            finish()
            // todo auto refresh seems not work when app died -_-
            GlanceReceiver.startRefreshAlarm(application, Config.autoRefreshMs)
        }
    }
}


val launchTargets = arrayOf(
    getString(R.string.current_app) to "",
    getString(R.string.genshin) to ApiCst.APP_PACKAGE_NAME_GENSHIN,
    getString(R.string.yun_genshin) to ApiCst.APP_PACKAGE_NAME_GENSHIN_CLOUD,
    getString(R.string.miyoushe) to ApiCst.APP_PACKAGE_NAME_BBS,
)

//"https://gw.alicdn.com/imgextra/i1/O1CN01wAe0EH1pUlFsEnT58_!!6000000005364-0-tps-747-499.jpg"
@Composable
fun PreviewConfigWidgetView(
    imageUrl: String,
    onInputChange: (String) -> Unit,
    historyImage: List<String>,
    onSelectFileClick: () -> Unit,
    onValueChange: (File, Dp, Float) -> Unit,
) {
    val scope = rememberCoroutineScope()
    var con by remember { mutableStateOf(0.5f) }
    var alpha by remember { mutableStateOf(0.5f) }
    val cornerFuc: (Float) -> Dp = { (it * 30 + 5).dp }
    val alphaFuc: (Float) -> Float = { it * 0.7f + 0.3f }
    var imageFile by remember { mutableStateOf<File?>(null) }
    var showPop by remember { mutableStateOf(false) }

    val onLoadImageClick: () -> Unit = {
        scope.launch {
            if (TextUtils.isEmpty(imageUrl)) {
                return@launch
            }
            val handler = imageHandlers.find {
                it.handle(imageUrl)
            }
            if (handler == null) {
                getString(R.string.input_error).toast()
                return@launch
            }
            val urlToFile = handler.getImageFile()
            if (urlToFile != null && urlToFile.exists()) {
                urlToFile.createNewFile()
            }
            handler.loadImage()
            imageFile = urlToFile
            onValueChange(imageFile!!, cornerFuc(con), alphaFuc(alpha))
        }
    }
    Box {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = imageUrl,
            onValueChange = onInputChange,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "history image",
                    modifier = Modifier.clickable { showPop = true }
                )
            })
        DropdownMenu(
            expanded = showPop,
            onDismissRequest = { showPop = false }) {
            historyImage.forEach {
                DropdownMenuItem(onClick = {
                    onInputChange(it)
                    showPop = false
                }) {
                    if (CacheImageHandler.handle(it)) {
                        val imageBitmap =
                            remember { CacheImageHandler.getBitmap()?.asImageBitmap() }
                        if (imageBitmap != null) {
                            Image(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(RoundedCornerShape(5.dp)),
                                bitmap = imageBitmap,
                                contentDescription = "history image",
                                contentScale = ContentScale.Crop
                            )
                        }
                    } else {
                        Image(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(RoundedCornerShape(5.dp)),
                            painter = rememberImagePainter(data = it),
                            contentDescription = "history image",
                            contentScale = ContentScale.Crop
                        )
                    }

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 5.dp),
                        text = it,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
    Row {
        Button(
            modifier = Modifier.padding(end = 10.dp),
            onClick = {
                imageFile = null
                onSelectFileClick()
            }
        ) {
            Text(text = "选择本地图片")
        }
        Button(onClick = onLoadImageClick) {
            Text(text = "加载图片")
        }
    }

    if (imageFile != null) {
        val handler = imageHandlers.find {
            it.handle(imageUrl)
        }
        val bitmap = handler?.getBitmap()?.asImageBitmap()
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (bitmap != null) {
                Image(
                    bitmap = bitmap,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(160.dp)
                        .alpha(alphaFuc(alpha))
                        .clip(RoundedCornerShape(cornerFuc(con)))
                )
            }
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

val imageHandlers = arrayOf(FileImageHandler, UrlImageHandler, CacheImageHandler)

interface ImageHandler {

    fun handle(imageUrl: String): Boolean

    fun getImageFile(): File?

    suspend fun loadImage(): File?

    fun getBitmap(): Bitmap?

}

object FileImageHandler : ImageHandler {

    lateinit var imageUrl: String


    override fun handle(imageUrl: String): Boolean {
        this.imageUrl = imageUrl
        return imageUrl.startsWith("content://") || imageUrl.startsWith("file://")
    }

    override fun getImageFile(): File {
        return uriToFile(imageUrl)

    }

    override suspend fun loadImage(): File {
        val imageFile = getImageFile()
        if (imageFile.length() > 0L) {
            return imageFile
        }
        application.contentResolver.openInputStream(Uri.parse(imageUrl)).use { input ->
            input?.let {
                FileOutputStream(imageFile).use {
                    it.write(input.readBytes())
                }
            }
        }
        return imageFile
    }

    override fun getBitmap(): Bitmap? {
        return Uri.parse(imageUrl).toImage()
    }
}

object UrlImageHandler : ImageHandler {

    lateinit var imageUrl: String

    override fun handle(imageUrl: String): Boolean {
        this.imageUrl = imageUrl
        return imageUrl.startsWith("http") || imageUrl.startsWith("https")
    }


    override fun getImageFile(): File? {
        val urlToFile = imageUrlToFile(imageUrl)
        if (urlToFile != null && urlToFile.exists()) {
            urlToFile.createNewFile()
        }
        return urlToFile
    }

    override suspend fun loadImage(): File? {
        val imageFile = getImageFile()
        if (imageFile != null && imageFile.length() == 0L) {
            Request.download(imageUrl, imageFile)
        }
        return imageFile
    }

    override fun getBitmap(): Bitmap? {
        return fileToBitmap(getImageFile())
    }


}


object CacheImageHandler : ImageHandler {

    lateinit var imageUrl: String

    lateinit var file: File

    override fun handle(imageUrl: String): Boolean {
        this.imageUrl = imageUrl
        file = File(imageUrl)
        return imageUrl.startsWith("/data/")
    }

    override fun getImageFile(): File {
        return file

    }

    override suspend fun loadImage(): File {
        return file
    }

    override fun getBitmap(): Bitmap? {
        val uri =
            FileProvider.getUriForFile(application, "org.zky.genshinwidgets.fileprovider", file)
                ?: return null
        return uri.toImage()
    }
}