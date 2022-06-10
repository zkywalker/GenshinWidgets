package org.zky.genshinwidgets.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import org.zky.genshinwidgets.utils.toast


@Composable
public fun ColumnScope.DefaultCard(
    modifier: Modifier = Modifier,
    text: String? = null,
    content: @Composable () -> Unit
) {
    if (text != null) {
        Text(text = text, modifier = Modifier.padding(bottom = 10.dp), fontSize = 17.sp)
    }
    Card(modifier.fillMaxWidth()) {
        Box(Modifier.padding(10.dp)) {
            content()
        }
    }
}

@Composable
fun SwitchView(
    text: String, checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = text)
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Composable
fun SettingItemView(text: String, imageRes: Int, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(10.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(
            painter = painterResource(id = imageRes),
            contentDescription = text,
            modifier = Modifier
                .size(24.dp)
                .padding(end = 10.dp)
        )
        Text(text = text, fontWeight = FontWeight.Bold)
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

@Composable
fun <T> SpannerView(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    onVisibilityChange: (Boolean) -> Unit,
    defaultIndex: Int = 0,
    data: List<T>,
    itemContentGetter: @Composable RowScope.(Int, T?) -> Unit,
    onItemClick: (Int, T) -> Unit,
    menuHeader: (@Composable ColumnScope.() -> Unit)? = null,
) {
    var selectedIndex by remember {
        mutableStateOf(if (defaultIndex < data.size) defaultIndex else -1)
    }
    val selectedItem = (if (selectedIndex > -1) data[defaultIndex] else null)
    Box(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onVisibilityChange(!expanded) }) {
            itemContentGetter(-1, selectedItem)
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "down")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { onVisibilityChange(false) }) {
            menuHeader?.invoke(this)
            data.forEachIndexed { index, item ->
                DropdownMenuItem(onClick = {
                    onItemClick(index, item)
                    selectedIndex = index
                    onVisibilityChange(false)
                }) {
                    itemContentGetter(index, item)
                }
            }

        }
    }
}

@Composable
fun LoadingView(modifier: Modifier = Modifier, onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = onDismissRequest) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun Test() {
    Column {
        val listOf = listOf("第一个", "第二个", "第三个")
        var expanded by remember { mutableStateOf(false) }
        SpannerView(
            expanded = expanded,
            onVisibilityChange = { expanded = it },
            data = listOf,
            defaultIndex = 1,
            itemContentGetter = { i, it ->
                Text(text = it ?: "null")
            },
            onItemClick = { i, it -> it.toast() }
        )
    }
}