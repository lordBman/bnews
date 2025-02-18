package com.bsoft.bnews.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ArrowLeft: ImageVector
    get() {
        if (_ArrowLeft != null) {
            return _ArrowLeft!!
        }
        _ArrowLeft = ImageVector.Builder(
            name = "ArrowLeft",
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
                moveTo(10.5f, 19.5f)
                lineTo(3f, 12f)
                moveTo(3f, 12f)
                lineTo(10.5f, 4.5f)
                moveTo(3f, 12f)
                horizontalLineTo(21f)
            }
        }.build()
        return _ArrowLeft!!
    }

private var _ArrowLeft: ImageVector? = null
