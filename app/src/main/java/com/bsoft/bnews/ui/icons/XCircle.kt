package com.bsoft.bnews.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val XCircle: ImageVector
    get() {
        if (_XCircle != null) {
            return _XCircle!!
        }
        _XCircle = ImageVector.Builder(
            name = "XCircle",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF0F172A)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(9.75f, 9.75f)
                lineTo(14.25f, 14.25f)
                moveTo(14.25f, 9.75f)
                lineTo(9.75f, 14.25f)
                moveTo(21f, 12f)
                curveTo(21f, 16.9706f, 16.9706f, 21f, 12f, 21f)
                curveTo(7.0294f, 21f, 3f, 16.9706f, 3f, 12f)
                curveTo(3f, 7.0294f, 7.0294f, 3f, 12f, 3f)
                curveTo(16.9706f, 3f, 21f, 7.0294f, 21f, 12f)
                close()
            }
        }.build()
        return _XCircle!!
    }

private var _XCircle: ImageVector? = null
