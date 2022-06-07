package org.zky.genshinwidgets.main

import android.text.TextUtils
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.flowlayout.FlowRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.unit.sp
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.model.SignInfo
import org.zky.genshinwidgets.model.SignReward
import org.zky.genshinwidgets.model.UserRole
import org.zky.genshinwidgets.res.font
import org.zky.genshinwidgets.utils.getString


@Composable
fun UserRoleView(
    userRole: UserRole?,
    onRefresh: () -> Unit,
    copyUid: (String) -> Unit,
) {
    if (userRole == null) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = getString(R.string.no_user_role_info),
                modifier = Modifier.padding(end = 10.dp)
            )
            Button(onClick = onRefresh) {
                Text(text = getString(R.string.refresh_page))
            }
        }
        return
    }
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "UID:${userRole.game_uid}", modifier = Modifier.padding(end = 10.dp))
            Button(onClick = { copyUid(userRole.game_uid) }) {
                Text(text = getString(R.string.copy_uid))
            }
        }
        Text(
            text = "game:${userRole.game_biz} region:${userRole.region}(${userRole.region_name})",
            modifier = Modifier.padding(end = 10.dp)
        )
    }

}

@Composable
fun CookieView(
    cookie: String?,
    onLaunchToCookiePage: () -> Unit,
    onInputCookie:() -> Unit,
    copyToClipboard: (String) -> Unit,
    clearCookie: () -> Unit,
) {
    var showCookie by remember { mutableStateOf(false) }

    if (cookie == null || TextUtils.isEmpty(cookie)) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = getString(R.string.did_not_get_cookie),
                    modifier = Modifier.padding(end = 10.dp)
                )
                Button(onClick = onLaunchToCookiePage) {
                    Text(text = getString(R.string.get_cookie))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = getString(R.string.already_got_cookie),
                    modifier = Modifier.padding(end = 10.dp)
                )
                Button(onClick = onInputCookie) {
                    Text(text = getString(R.string.input_cookie))
                }
            }
        }
    } else {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(if (showCookie) R.drawable.ic_baseline_cookie_24_b else R.drawable.ic_baseline_cookie_24),
                    contentDescription = "cookie icon",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(5.dp)
                        .clickable { showCookie = !showCookie }
                )
                SelectionContainer {
                    Text(
                        text = if (showCookie) cookie else getString(R.string.got_cookie),
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .fillMaxWidth()
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(
                    modifier = Modifier.padding(end = 10.dp),
                    onClick = { copyToClipboard(cookie) }) {
                    Text(text = getString(R.string.copy_cookie))
                }
                Button(
                    modifier = Modifier.padding(end = 10.dp),
                    onClick = { clearCookie() }) {
                    Text(text = getString(R.string.clear_cookie))
                }
            }
        }

    }
}

@Composable
fun SignView(
    signInfo: SignInfo?,
    signReward: SignReward?,
    onRefreshSignInfo: () -> Unit,
    onRequestSign: () -> Unit
) {
    var showSignReward by remember { mutableStateOf(false) }
    if (signInfo == null) {
        SignErrorView(errorText = getString(R.string.no_data), onRefresh = onRefreshSignInfo)
        return
    }
    if (signInfo.first_bind) {
        SignErrorView(
            errorText = getString(R.string.msg_first_bind_bbs),
            onRefresh = onRefreshSignInfo
        )
        return
    }
    var signNum = signInfo.total_sign_day
    var text = ""
    if (signInfo.is_sign) {
        text = getString(R.string.has_signed)
    } else {
        signNum += 1
    }
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            val rewardItem = signReward?.awards?.get(signNum - 1)
            Image(
                painter = painterResource(if (showSignReward) R.drawable.ic_baseline_assistant_24_b else R.drawable.ic_baseline_assistant_24),
                modifier = Modifier
                    .size(24.dp)
                    .padding(5.dp)
                    .clickable {
                        showSignReward = !showSignReward
                    },
                contentDescription = "details"
            )
            Text(text = "${text}${getString(R.string.today_reward)}")
            if (rewardItem == null) {
                Text(text = getString(R.string.no_reward_info))
            } else {
                Image(
                    painter = rememberImagePainter(data = rewardItem.icon),
                    modifier = Modifier
                        .size(24.dp)
                        .padding(5.dp),
                    contentDescription = rewardItem.name
                )
                Text(text = "${rewardItem.name} x ${rewardItem.cnt}")
            }
            if (!signInfo.is_sign) {
                Button(onClick = onRequestSign, modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = getString(R.string.sign_in))
                }
            }


        }
        if (showSignReward) {
            AlertDialog(
                onDismissRequest = { showSignReward = false },
                buttons = { },
                text = {
                    SignRewardsView(signInfo, signReward)
                }

            )
        }
    }
}

@Composable
fun SignRewardsView(signInfo: SignInfo, signReward: SignReward?) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${getString(R.string.total_sign_day)}:${signInfo.total_sign_day} ${
                getString(R.string.sign_cnt_missed)
            }:${signInfo.sign_cnt_missed}",
            modifier = Modifier.padding(5.dp)
        )
        val awards = signReward?.awards ?: return@Column
        FlowRow {
            awards.forEachIndexed { index, rewardItem ->
                Box(
                    Modifier
                        .size(60.dp, 70.dp)
                        .padding(2.dp)
                        .border(
                            width = 0.5.dp,
                            color = Color(0x55000000),
                            shape = RoundedCornerShape(5.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Day ${index + 1}", fontSize = font.bodySize)
                        Image(
                            painter = rememberImagePainter(data = rewardItem.icon),
                            modifier = Modifier.size(24.dp),
                            contentDescription = rewardItem.name
                        )
                        Text(text = "x ${rewardItem.cnt}", fontSize = font.bodySize)
                    }
                    if (signInfo.total_sign_day >= index + 1) {
                        Image(
                            painter = ColorPainter(Color(0x55000000)),
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape),
                            contentDescription = null
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_done_24),
                            modifier = Modifier.fillMaxWidth(),
                            contentDescription = null
                        )
                    } else if (signInfo.sign_cnt_missed != 0 && (awards.size - signInfo.sign_cnt_missed) <= index) {
                        Image(
                            painter = ColorPainter(Color(0x55000000)),
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape),
                            contentDescription = null
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_close_24),
                            modifier = Modifier.fillMaxWidth(),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SignErrorView(errorText: String, onRefresh: () -> Unit) {
    Column {
        Text(text = errorText)
        Button(onClick = { onRefresh() }) {
            Text(text = getString(R.string.sign_refresh))
        }
    }
}

@Composable
fun ObservationPivotView(
    onClickTodayMaterial: () -> Unit,
    onClickMap: () -> Unit,
    onClickWiki: () -> Unit
) {
    Row {
        Button(onClick = onClickTodayMaterial, modifier = Modifier.padding(end = 10.dp)) {
            Text(text = getString(R.string.today_material))
        }
        Button(onClick = onClickMap, modifier = Modifier.padding(end = 10.dp)) {
            Text(text = getString(R.string.map))
        }
        Button(onClick = onClickWiki, modifier = Modifier.padding(end = 10.dp)) {
            Text(text = getString(R.string.wiki))
        }
    }
}

@Composable
fun JumpAppView(
    onClickGenshin: () -> Unit,
    onClickCloud: () -> Unit,
    onClickBBS: () -> Unit
) {
    Row {
        Button(onClick = onClickGenshin, modifier = Modifier.padding(end = 10.dp)) {
            Text(text = getString(R.string.genshin))
        }
        Button(onClick = onClickCloud, modifier = Modifier.padding(end = 10.dp)) {
            Text(text = getString(R.string.yun_genshin))
        }
        Button(onClick = onClickBBS, modifier = Modifier.padding(end = 10.dp)) {
            Text(text = getString(R.string.miyoushe))
        }
    }
}