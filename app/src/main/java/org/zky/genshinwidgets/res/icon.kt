package org.zky.genshinwidgets.res

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object icon {

    val star = ImageVector.Builder(
        name = "test",
        defaultHeight = 24.dp,
        defaultWidth = 24.dp,
        viewportHeight = 1024f,
        viewportWidth = 1024f,
    ).path(
        fill = SolidColor(Color.White)
    ) {
        moveTo(1004.1f, 512.0f)
        lineTo(692.0f, 332.0f)
        lineTo(512.0f, 19.9f)
        lineTo(332.0f, 332.0f)
        lineTo(19.9f, 512.0f)
        lineTo(332.0f, 692.0f)

        lineToRelative(180.0f, 312.1f)
        lineTo(692.0f, 692.0f)
        close()

    }
        .build()


    val stars = ImageVector.Builder(
        name = "test",
        defaultHeight = 24.dp,
        defaultWidth = 24.dp,
        viewportHeight = 24f,
        viewportWidth = 24f,
    ).path(
        fill = SolidColor(Color(0xff000000))
    ) {
        moveTo(7.06f, 8.94f)
        lineTo(5.0f, 8.0f)
        lineToRelative(2.06f, -0.94f)
        lineTo(8.0f, 5.0f)
        lineToRelative(0.94f, 2.06f)
        lineTo(11.0f, 8.0f)
        lineTo(8.94f, 8.94f)
        lineTo(8.0f, 11.0f)
        lineTo(7.06f, 8.94f)
        close()
        moveTo(8.0f, 21.0f)
        lineToRelative(0.94f, -2.06f)
        lineTo(11.0f, 18.0f)
        lineToRelative(-2.06f, -0.94f)
        lineTo(8.0f, 15.0f)
        lineToRelative(-0.94f, 2.06f)
        lineTo(5.0f, 18.0f)
        lineToRelative(2.06f, 0.94f)
        lineTo(8.0f, 21.0f)
        close()
        moveTo(4.37f, 12.37f)
        lineTo(3.0f, 13.0f)
        lineToRelative(1.37f, 0.63f)
        lineTo(5.0f, 15.0f)
        lineToRelative(0.63f, -1.37f)
        lineTo(7.0f, 13.0f)
        lineToRelative(-1.37f, -0.63f)
        lineTo(5.0f, 11.0f)
        lineTo(4.37f, 12.37f)
        close()
    }.build()
}