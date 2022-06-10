package org.zky.genshinwidgets.webview

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.network.Request
import org.zky.genshinwidgets.utils.getString
import org.zky.genshinwidgets.utils.toast


@Composable
fun CookieInputDialog(onDismissRequest: () -> Unit, onSubmit: (String) -> Unit) {
    val cookie = remember { mutableStateOf("") }
    val title = remember { mutableStateOf(getString(R.string.input_cookie)) }
    val showLoading = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    Dialog(onDismissRequest = onDismissRequest) {
        Card {
            Box(contentAlignment = Alignment.Center) {
                Column(Modifier.padding(10.dp)) {
                    Text(title.value, modifier = Modifier.padding(bottom = 10.dp))
                    TextField(
                        value = cookie.value, onValueChange = {
                            cookie.value = it
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Row(Modifier.padding(start = 10.dp, end = 10.dp)) {
                        Spacer(modifier = Modifier.weight(1f))
                        TextButton(
                            onClick = onDismissRequest,
                            modifier = Modifier.padding(end = 10.dp)
                        ) {
                            Text(getString(R.string.cancel))
                        }
                        Button(onClick = {
                            scope.launch {
                                showLoading.value = true
                                withContext(Dispatchers.IO) {
                                    val cookieRes = cookie.value.replace("\n","")
                                    val userRole = Request.getUserRole(cookieRes)
                                    if (userRole != null) {
                                        withContext(Dispatchers.Main) {
                                            onSubmit(cookie.value)
                                        }
                                        onDismissRequest()
                                    } else {
                                        R.string.error_cookie.toast()
                                    }
                                }
                                showLoading.value = false
                            }
                        }) {
                            Text(getString(R.string.confirm))
                        }
                    }
                }
                if (showLoading.value) {
                    Box(Modifier.size(50.dp)) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}