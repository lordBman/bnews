package com.bsoft.bnews.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ArchiveBox: ImageVector
    get() {
        if (_ArchiveBox != null) {
            return _ArchiveBox!!
        }
        _ArchiveBox = ImageVector.Builder(
            name = "ArchiveBox",
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
                moveTo(20.25f, 7.5f)
                lineTo(19.6246f, 18.1321f)
                curveTo(19.5546f, 19.3214f, 18.5698f, 20.25f, 17.3785f, 20.25f)
                horizontalLineTo(6.62154f)
                curveTo(5.4302f, 20.25f, 4.4454f, 19.3214f, 4.3754f, 18.1321f)
                lineTo(3.75f, 7.5f)
                moveTo(9.99976f, 11.25f)
                horizontalLineTo(13.9998f)
                moveTo(3.375f, 7.5f)
                horizontalLineTo(20.625f)
                curveTo(21.2463f, 7.5f, 21.75f, 6.9963f, 21.75f, 6.375f)
                verticalLineTo(4.875f)
                curveTo(21.75f, 4.2537f, 21.2463f, 3.75f, 20.625f, 3.75f)
                horizontalLineTo(3.375f)
                curveTo(2.7537f, 3.75f, 2.25f, 4.2537f, 2.25f, 4.875f)
                verticalLineTo(6.375f)
                curveTo(2.25f, 6.9963f, 2.7537f, 7.5f, 3.375f, 7.5f)
                close()
            }
        }.build()
        return _ArchiveBox!!
    }

private var _ArchiveBox: ImageVector? = null