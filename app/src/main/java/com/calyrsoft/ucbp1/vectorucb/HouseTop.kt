package com.calyrsoft.ucbp1.vectorucb

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.calyrsoft.ucbp1.VectorUcb
import kotlin.Unit

public val VectorUcb.HouseTop: ImageVector
    get() {
        if (_houseTop != null) {
            return _houseTop!!
        }
        _houseTop = Builder(name = "HouseTop", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 64.0f, viewportHeight = 64.0f).apply {
            path(fill = SolidColor(Color(0xFFF9EBB2)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(56.0f, 60.0f)
                curveToRelative(0.0f, 1.104f, -0.896f, 2.0f, -2.0f, 2.0f)
                horizontalLineTo(38.0f)
                verticalLineTo(47.0f)
                curveToRelative(0.0f, -0.553f, -0.447f, -1.0f, -1.0f, -1.0f)
                horizontalLineTo(27.0f)
                curveToRelative(-0.553f, 0.0f, -1.0f, 0.447f, -1.0f, 1.0f)
                verticalLineToRelative(15.0f)
                horizontalLineTo(10.0f)
                curveToRelative(-1.104f, 0.0f, -2.0f, -0.896f, -2.0f, -2.0f)
                verticalLineTo(31.411f)
                lineTo(32.009f, 7.403f)
                lineTo(56.0f, 31.394f)
                verticalLineTo(60.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF76D57)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(14.0f, 6.0f)
                lineToRelative(4.0f, 0.0f)
                lineToRelative(0.0f, 6.601f)
                lineToRelative(-4.0f, 3.992f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF9EBB2)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(28.0f, 48.0f)
                horizontalLineToRelative(8.0f)
                verticalLineToRelative(14.0f)
                horizontalLineToRelative(-8.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF76D57)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(61.0f, 33.0f)
                curveToRelative(-0.276f, 0.0f, -0.602f, -0.036f, -0.782f, -0.217f)
                lineTo(32.716f, 5.281f)
                curveToRelative(-0.195f, -0.195f, -0.451f, -0.293f, -0.707f, -0.293f)
                reflectiveCurveToRelative(-0.512f, 0.098f, -0.707f, 0.293f)
                lineTo(3.791f, 32.793f)
                curveTo(3.61f, 32.974f, 3.276f, 33.0f, 3.0f, 33.0f)
                curveToRelative(-0.553f, 0.0f, -1.0f, -0.447f, -1.0f, -1.0f)
                curveToRelative(0.0f, -0.276f, 0.016f, -0.622f, 0.197f, -0.803f)
                lineTo(31.035f, 2.41f)
                curveToRelative(0.0f, 0.0f, 0.373f, -0.41f, 0.974f, -0.41f)
                reflectiveCurveToRelative(0.982f, 0.398f, 0.982f, 0.398f)
                lineToRelative(28.806f, 28.805f)
                curveTo(61.978f, 31.384f, 62.0f, 31.724f, 62.0f, 32.0f)
                curveTo(62.0f, 32.552f, 61.553f, 33.0f, 61.0f, 33.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF394240)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(63.211f, 29.789f)
                lineTo(34.438f, 1.015f)
                curveToRelative(0.0f, 0.0f, -0.937f, -1.015f, -2.43f, -1.015f)
                reflectiveCurveToRelative(-2.376f, 0.991f, -2.376f, 0.991f)
                lineTo(20.0f, 10.604f)
                verticalLineTo(5.0f)
                curveToRelative(0.0f, -0.553f, -0.447f, -1.0f, -1.0f, -1.0f)
                horizontalLineToRelative(-6.0f)
                curveToRelative(-0.553f, 0.0f, -1.0f, 0.447f, -1.0f, 1.0f)
                verticalLineToRelative(13.589f)
                lineTo(0.783f, 29.783f)
                curveTo(0.24f, 30.326f, 0.0f, 31.172f, 0.0f, 32.0f)
                curveToRelative(0.0f, 1.656f, 1.343f, 3.0f, 3.0f, 3.0f)
                curveToRelative(0.828f, 0.0f, 1.662f, -0.251f, 2.205f, -0.794f)
                lineTo(6.0f, 33.411f)
                verticalLineTo(60.0f)
                curveToRelative(0.0f, 2.211f, 1.789f, 4.0f, 4.0f, 4.0f)
                horizontalLineToRelative(44.0f)
                curveToRelative(2.211f, 0.0f, 4.0f, -1.789f, 4.0f, -4.0f)
                verticalLineTo(33.394f)
                lineToRelative(0.804f, 0.804f)
                curveTo(59.347f, 34.739f, 60.172f, 35.0f, 61.0f, 35.0f)
                curveToRelative(1.657f, 0.0f, 3.0f, -1.343f, 3.0f, -3.0f)
                curveTo(64.0f, 31.171f, 63.754f, 30.332f, 63.211f, 29.789f)
                close()
                moveTo(14.0f, 6.0f)
                horizontalLineToRelative(4.0f)
                verticalLineToRelative(6.601f)
                lineToRelative(-4.0f, 3.992f)
                verticalLineTo(6.0f)
                close()
                moveTo(36.0f, 62.0f)
                horizontalLineToRelative(-8.0f)
                verticalLineTo(48.0f)
                horizontalLineToRelative(8.0f)
                verticalLineTo(62.0f)
                close()
                moveTo(56.0f, 60.0f)
                curveToRelative(0.0f, 1.104f, -0.896f, 2.0f, -2.0f, 2.0f)
                horizontalLineTo(38.0f)
                verticalLineTo(47.0f)
                curveToRelative(0.0f, -0.553f, -0.447f, -1.0f, -1.0f, -1.0f)
                horizontalLineTo(27.0f)
                curveToRelative(-0.553f, 0.0f, -1.0f, 0.447f, -1.0f, 1.0f)
                verticalLineToRelative(15.0f)
                horizontalLineTo(10.0f)
                curveToRelative(-1.104f, 0.0f, -2.0f, -0.896f, -2.0f, -2.0f)
                verticalLineTo(31.411f)
                lineTo(32.009f, 7.403f)
                lineTo(56.0f, 31.394f)
                verticalLineTo(60.0f)
                close()
                moveTo(61.0f, 33.0f)
                curveToRelative(-0.276f, 0.0f, -0.602f, -0.036f, -0.782f, -0.217f)
                lineTo(32.716f, 5.281f)
                curveToRelative(-0.195f, -0.195f, -0.451f, -0.293f, -0.707f, -0.293f)
                reflectiveCurveToRelative(-0.512f, 0.098f, -0.707f, 0.293f)
                lineTo(3.791f, 32.793f)
                curveTo(3.61f, 32.974f, 3.276f, 33.0f, 3.0f, 33.0f)
                curveToRelative(-0.553f, 0.0f, -1.0f, -0.447f, -1.0f, -1.0f)
                curveToRelative(0.0f, -0.276f, 0.016f, -0.622f, 0.197f, -0.803f)
                lineTo(31.035f, 2.41f)
                curveToRelative(0.0f, 0.0f, 0.373f, -0.41f, 0.974f, -0.41f)
                reflectiveCurveToRelative(0.982f, 0.398f, 0.982f, 0.398f)
                lineToRelative(28.806f, 28.805f)
                curveTo(61.978f, 31.384f, 62.0f, 31.724f, 62.0f, 32.0f)
                curveTo(62.0f, 32.552f, 61.553f, 33.0f, 61.0f, 33.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF394240)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(23.0f, 32.0f)
                horizontalLineToRelative(-8.0f)
                curveToRelative(-0.553f, 0.0f, -1.0f, 0.447f, -1.0f, 1.0f)
                verticalLineToRelative(8.0f)
                curveToRelative(0.0f, 0.553f, 0.447f, 1.0f, 1.0f, 1.0f)
                horizontalLineToRelative(8.0f)
                curveToRelative(0.553f, 0.0f, 1.0f, -0.447f, 1.0f, -1.0f)
                verticalLineToRelative(-8.0f)
                curveTo(24.0f, 32.447f, 23.553f, 32.0f, 23.0f, 32.0f)
                close()
                moveTo(22.0f, 40.0f)
                horizontalLineToRelative(-6.0f)
                verticalLineToRelative(-6.0f)
                horizontalLineToRelative(6.0f)
                verticalLineTo(40.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF394240)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(41.0f, 42.0f)
                horizontalLineToRelative(8.0f)
                curveToRelative(0.553f, 0.0f, 1.0f, -0.447f, 1.0f, -1.0f)
                verticalLineToRelative(-8.0f)
                curveToRelative(0.0f, -0.553f, -0.447f, -1.0f, -1.0f, -1.0f)
                horizontalLineToRelative(-8.0f)
                curveToRelative(-0.553f, 0.0f, -1.0f, 0.447f, -1.0f, 1.0f)
                verticalLineToRelative(8.0f)
                curveTo(40.0f, 41.553f, 40.447f, 42.0f, 41.0f, 42.0f)
                close()
                moveTo(42.0f, 34.0f)
                horizontalLineToRelative(6.0f)
                verticalLineToRelative(6.0f)
                horizontalLineToRelative(-6.0f)
                verticalLineTo(34.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF506C7F)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(28.0f, 48.0f)
                horizontalLineToRelative(8.0f)
                verticalLineToRelative(14.0f)
                horizontalLineToRelative(-8.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF45AAB8)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(16.0f, 34.0f)
                horizontalLineToRelative(6.0f)
                verticalLineToRelative(6.0f)
                horizontalLineToRelative(-6.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF45AAB8)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(42.0f, 34.0f)
                horizontalLineToRelative(6.0f)
                verticalLineToRelative(6.0f)
                horizontalLineToRelative(-6.0f)
                close()
            }
        }
        .build()
        return _houseTop!!
    }

private var _houseTop: ImageVector? = null

