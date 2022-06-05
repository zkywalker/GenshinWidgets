package org.zky.genshinwidgets.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
public fun ColumnScope.DefaultCard(
    text: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Text(text = text, modifier = Modifier.padding(bottom = 10.dp), fontSize = 17.sp)
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
fun SpannerView(modifier: Modifier = Modifier) {
    Box(modifier = modifier){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "测试一下")
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "down")
        }
        DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {

        }
    }
}