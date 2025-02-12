package com.bsoft.bnews.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Cog: ImageVector
    get() {
        if (_Cog8Tooth != null) {
            return _Cog8Tooth!!
        }
        _Cog8Tooth = ImageVector.Builder(
            name = "Cog8Tooth",
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
                moveTo(10.3426f, 3.94002f)
                curveTo(10.433f, 3.3976f, 10.9024f, 3f, 11.4523f, 3f)
                horizontalLineTo(12.5463f)
                curveTo(13.0962f, 3f, 13.5656f, 3.3976f, 13.656f, 3.94f)
                lineTo(13.8049f, 4.83383f)
                curveTo(13.8757f, 5.2581f, 14.1886f, 5.5983f, 14.5858f, 5.7633f)
                curveTo(14.9832f, 5.9283f, 15.4396f, 5.9063f, 15.7897f, 5.6561f)
                lineTo(16.5273f, 5.1293f)
                curveTo(16.9748f, 4.8097f, 17.5878f, 4.8604f, 17.9767f, 5.2493f)
                lineTo(18.7503f, 6.02281f)
                curveTo(19.1391f, 6.4117f, 19.1899f, 7.0247f, 18.8702f, 7.4722f)
                lineTo(18.3432f, 8.21003f)
                curveTo(18.0931f, 8.5601f, 18.0711f, 9.0163f, 18.236f, 9.4136f)
                curveTo(18.4009f, 9.8108f, 18.7411f, 10.1236f, 19.1653f, 10.1943f)
                lineTo(20.0592f, 10.3433f)
                curveTo(20.6017f, 10.4337f, 20.9993f, 10.903f, 20.9993f, 11.453f)
                verticalLineTo(12.547f)
                curveTo(20.9993f, 13.0969f, 20.6017f, 13.5662f, 20.0592f, 13.6566f)
                lineTo(19.1654f, 13.8056f)
                curveTo(18.7412f, 13.8763f, 18.4009f, 14.1892f, 18.236f, 14.5865f)
                curveTo(18.071f, 14.9839f, 18.093f, 15.4402f, 18.3431f, 15.7904f)
                lineTo(18.8699f, 16.5278f)
                curveTo(19.1895f, 16.9753f, 19.1388f, 17.5883f, 18.7499f, 17.9772f)
                lineTo(17.9764f, 18.7507f)
                curveTo(17.5875f, 19.1396f, 16.9745f, 19.1903f, 16.527f, 18.8707f)
                lineTo(15.7894f, 18.3438f)
                curveTo(15.4393f, 18.0938f, 14.983f, 18.0717f, 14.5857f, 18.2367f)
                curveTo(14.1885f, 18.4016f, 13.8757f, 18.7418f, 13.805f, 19.166f)
                lineTo(13.656f, 20.0599f)
                curveTo(13.5656f, 20.6024f, 13.0962f, 21f, 12.5463f, 21f)
                horizontalLineTo(11.4523f)
                curveTo(10.9024f, 21f, 10.433f, 20.6024f, 10.3426f, 20.0599f)
                lineTo(10.1937f, 19.1661f)
                curveTo(10.1229f, 18.7418f, 9.81f, 18.4016f, 9.4128f, 18.2367f)
                curveTo(9.0154f, 18.0717f, 8.559f, 18.0937f, 8.2089f, 18.3438f)
                lineTo(7.47128f, 18.8707f)
                curveTo(7.0238f, 19.1903f, 6.4108f, 19.1396f, 6.0219f, 18.7507f)
                lineTo(5.24834f, 17.9772f)
                curveTo(4.8595f, 17.5883f, 4.8087f, 16.9753f, 5.1284f, 16.5278f)
                lineTo(5.65542f, 15.7899f)
                curveTo(5.9055f, 15.4399f, 5.9275f, 14.9837f, 5.7626f, 14.5863f)
                curveTo(5.5977f, 14.1892f, 5.2575f, 13.8763f, 4.8333f, 13.8056f)
                lineTo(3.93935f, 13.6566f)
                curveTo(3.3969f, 13.5662f, 2.9993f, 13.0969f, 2.9993f, 12.547f)
                verticalLineTo(11.453f)
                curveTo(2.9993f, 10.903f, 3.3969f, 10.4337f, 3.9394f, 10.3433f)
                lineTo(4.83316f, 10.1943f)
                curveTo(5.2574f, 10.1236f, 5.5977f, 9.8107f, 5.7626f, 9.4134f)
                curveTo(5.9276f, 9.016f, 5.9056f, 8.5597f, 5.6555f, 8.2095f)
                lineTo(5.12878f, 7.47213f)
                curveTo(4.8091f, 7.0246f, 4.8599f, 6.4116f, 5.2487f, 6.0227f)
                lineTo(6.02228f, 5.24919f)
                curveTo(6.4112f, 4.8603f, 7.0242f, 4.8096f, 7.4717f, 5.1292f)
                lineTo(8.20927f, 5.65609f)
                curveTo(8.5593f, 5.9062f, 9.0156f, 5.9282f, 9.4129f, 5.7632f)
                curveTo(9.8101f, 5.5983f, 10.1229f, 5.2582f, 10.1936f, 4.834f)
                lineTo(10.3426f, 3.94002f)
                close()
            }
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
                moveTo(15f, 12f)
                curveTo(15f, 13.6568f, 13.6569f, 15f, 12f, 15f)
                curveTo(10.3431f, 15f, 9f, 13.6568f, 9f, 12f)
                curveTo(9f, 10.3431f, 10.3431f, 9f, 12f, 9f)
                curveTo(13.6569f, 9f, 15f, 10.3431f, 15f, 12f)
                close()
            }
        }.build()
        return _Cog8Tooth!!
    }

private var _Cog8Tooth: ImageVector? = null
