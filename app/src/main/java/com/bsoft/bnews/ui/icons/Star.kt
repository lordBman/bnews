package com.bsoft.bnews.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Star: ImageVector
    get() {
        if (_Star != null) {
            return _Star!!
        }
        _Star = ImageVector.Builder(
            name = "Star",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(354f, 673f)
                lineToRelative(126f, -76f)
                lineToRelative(126f, 77f)
                lineToRelative(-33f, -144f)
                lineToRelative(111f, -96f)
                lineToRelative(-146f, -13f)
                lineToRelative(-58f, -136f)
                lineToRelative(-58f, 135f)
                lineToRelative(-146f, 13f)
                lineToRelative(111f, 97f)
                close()
                moveToRelative(126f, 18f)
                lineTo(314f, 791f)
                quadToRelative(-11f, 7f, -23f, 6f)
                reflectiveQuadToRelative(-21f, -8f)
                reflectiveQuadToRelative(-14f, -17.5f)
                reflectiveQuadToRelative(-2f, -23.5f)
                lineToRelative(44f, -189f)
                lineToRelative(-147f, -127f)
                quadToRelative(-10f, -9f, -12.5f, -20.5f)
                reflectiveQuadTo(140f, 389f)
                reflectiveQuadToRelative(12f, -18f)
                reflectiveQuadToRelative(22f, -9f)
                lineToRelative(194f, -17f)
                lineToRelative(75f, -178f)
                quadToRelative(5f, -12f, 15.5f, -18f)
                reflectiveQuadToRelative(21.5f, -6f)
                reflectiveQuadToRelative(21.5f, 6f)
                reflectiveQuadToRelative(15.5f, 18f)
                lineToRelative(75f, 178f)
                lineToRelative(194f, 17f)
                quadToRelative(14f, 2f, 22f, 9f)
                reflectiveQuadToRelative(12f, 18f)
                reflectiveQuadToRelative(1.5f, 22.5f)
                reflectiveQuadTo(809f, 432f)
                lineTo(662f, 559f)
                lineToRelative(44f, 189f)
                quadToRelative(3f, 13f, -2f, 23.5f)
                reflectiveQuadTo(690f, 789f)
                reflectiveQuadToRelative(-21f, 8f)
                reflectiveQuadToRelative(-23f, -6f)
                close()
                moveToRelative(0f, -201f)
            }
        }.build()
        return _Star!!
    }

private var _Star: ImageVector? = null
