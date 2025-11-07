package com.calyrsoft.ucbp1.features.movie.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.calyrsoft.ucbp1.features.movie.domain.model.MovieModel
import org.koin.androidx.compose.koinViewModel

import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asAndroidPath

import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin




//pRIMERA VESION
class ComponentCardsave(
    private val radius: Dp,
    private val horizontalLineLength: Dp,
    private val verticalLineLength: Dp,
    private val rotationDegrees: Float,
    private val finalCurveRotationDegrees: Float = -180f,
    private val fourthCurveRotationDegrees: Float = 90f // 👈 NUEVO PARÁMETRO
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val r = with(density) { radius.toPx() }
        val hLength = with(density) { horizontalLineLength.toPx() }
        val vLength = with(density) { verticalLineLength.toPx() }

        // Puntos de inicio que estabas usando:
        val startX = 30f
        val startY = 400f

        val path = Path().apply {

            // --- 1. PRIMERA CURVA ---
            val curve1Start = Offset(startX, startY)
            val curve1Control = Offset(startX + r, startY)
            val curve1End = Offset(startX + r, startY + r)
            moveTo(curve1Start.x, curve1Start.y)
            quadraticTo(x1 = curve1Control.x, y1 = curve1Control.y, x2 = curve1End.x, y2 = curve1End.y)

            // --- 2. LÍNEA HORIZONTAL 1 ---
            val pivotX_2 = curve1End.x + hLength
            val pivotY_2 = curve1End.y
            lineTo(pivotX_2, pivotY_2)

            // --- 3. SEGUNDA CURVA (ROTADA) ---
            val originalControlX_2 = pivotX_2; val originalControlY_2 = pivotY_2 + r
            val originalEndX_2 = pivotX_2 - r; val originalEndY_2 = pivotY_2 + r
            val rotatedControl_2 = rotatePoint(originalControlX_2, originalControlY_2, pivotX_2, pivotY_2, rotationDegrees)
            val rotatedEnd_2 = rotatePoint(originalEndX_2, originalEndY_2, pivotX_2, pivotY_2, rotationDegrees)
            quadraticTo(x1 = rotatedControl_2.x, y1 = rotatedControl_2.y, x2 = rotatedEnd_2.x, y2 = rotatedEnd_2.y)

            // --- 4. LÍNEA VERTICAL 1 ---
            val finalPointLineVertical = Offset(rotatedEnd_2.x, rotatedEnd_2.y - vLength)
            lineTo(finalPointLineVertical.x, finalPointLineVertical.y)

            // --- 5. TERCERA CURVA (ROTADA) ---
            val pivotX_3 = finalPointLineVertical.x
            val pivotY_3 = finalPointLineVertical.y
            val originalControlX_3 = pivotX_3; val originalControlY_3 = pivotY_3 + r
            val originalEndX_3 = pivotX_3 + r; val originalEndY_3 = pivotY_3 + r
            val rotatedControl_3 = rotatePoint(originalControlX_3, originalControlY_3, pivotX_3, pivotY_3, finalCurveRotationDegrees)
            val rotatedEnd_3 = rotatePoint(originalEndX_3, originalEndY_3, pivotX_3, pivotY_3, finalCurveRotationDegrees)
            quadraticTo(x1 = rotatedControl_3.x, y1 = rotatedControl_3.y, x2 = rotatedEnd_3.x, y2 = rotatedEnd_3.y)

            // --- 6. CIERRE HORIZONTAL (Pre-Curva 4) ---
            // Este es el final de la línea horizontal de cierre
            val pivotX_4 = startX + r
            val pivotY_4 = rotatedEnd_3.y
            lineTo(pivotX_4, pivotY_4)


            // =======================================================
            // --- 7. CUARTA CURVA (ROTADA) ---

            // El pivote es (pivotX_4, pivotY_4), que es el final de la línea horizontal de cierre.

            // Curva base (abierta hacia abajo)
            val originalControlX_4 = pivotX_4
            val originalControlY_4 = pivotY_4 + r
            val originalEndX_4 = pivotX_4 + r
            val originalEndY_4 = pivotY_4 + r

            // Aplicar la rotación (usando fourthCurveRotationDegrees)
            val rotatedControl_4 = rotatePoint(originalControlX_4, originalControlY_4, pivotX_4, pivotY_4, fourthCurveRotationDegrees)
            val rotatedEnd_4 = rotatePoint(originalEndX_4, originalEndY_4, pivotX_4, pivotY_4, fourthCurveRotationDegrees)

            quadraticTo(
                x1 = rotatedControl_4.x, y1 = rotatedControl_4.y,
                x2 = rotatedEnd_4.x, y2 = rotatedEnd_4.y // Termina aquí
            )

            // --- 8. CIERRE VERTICAL FINAL ---

            // Conecta el final de la Curva 4 (rotatedEnd_4) con el inicio de la Curva 1 (curve1Start).
            lineTo(curve1Start.x, curve1Start.y)

            // Opcional: close() asegura el relleno, aunque LineTo debería haberlo hecho.
            // close()
            // =======================================================
        }

        return Outline.Generic(path)
    }
}


fun rotatePoint(x: Float, y: Float, px: Float, py: Float, degrees: Float): Offset {
    // 1. Convertir grados a radianes
    val radians = (degrees * PI / 180f).toFloat()

    // 2. Trasladar el punto para que el pivote sea el origen (0, 0)
    val dx = x - px
    val dy = y - py

    // 3. Aplicar la fórmula de rotación
    val cosTheta = cos(radians)
    val sinTheta = sin(radians)

    val xPrime = dx * cosTheta - dy * sinTheta
    val yPrime = dx * sinTheta + dy * cosTheta

    // 4. Trasladar el punto de vuelta sumando el pivote
    return Offset(
        x = xPrime + px,
        y = yPrime + py
    )
}



class ComponentCardOld(
    private val radius: Dp,
    private val verticalLineLength: Dp,
    private val rotationDegrees: Float,
    private val finalCurveRotationDegrees: Float = -180f,
    private val fourthCurveRotationDegrees: Float = 90f
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val r = with(density) { radius.toPx() }
        val vLength = with(density) { verticalLineLength.toPx() }

        val fullWidth = size.width
        val fullHeight = size.height


        val startX = 0f
        val startY = fullHeight / 2f

        val path = Path().apply {

            // --- 1. PRIMERA CURVA ---
            val curve1Start = Offset(startX, startY)
            val curve1Control = Offset(startX + r, startY)
            val curve1End = Offset(startX + r, startY + r)
            moveTo(curve1Start.x, curve1Start.y)
            quadraticTo(curve1Control.x, curve1Control.y, curve1End.x, curve1End.y)

            // --- 2. LÍNEA HORIZONTAL 1 ---
            val pivotX_2 = fullWidth - r
            val pivotY_2 = curve1End.y
            lineTo(pivotX_2, pivotY_2)

            // --- 3. SEGUNDA CURVA (ROTADA) ---
            val originalControlX_2 = pivotX_2
            val originalControlY_2 = pivotY_2 + r
            val originalEndX_2 = pivotX_2 - r
            val originalEndY_2 = pivotY_2 + r
            val rotatedControl_2 =
                rotatePoint(originalControlX_2, originalControlY_2, pivotX_2, pivotY_2, rotationDegrees)
            val rotatedEnd_2 =
                rotatePoint(originalEndX_2, originalEndY_2, pivotX_2, pivotY_2, rotationDegrees)
            quadraticTo(rotatedControl_2.x, rotatedControl_2.y, rotatedEnd_2.x, rotatedEnd_2.y)

            // --- 4. LÍNEA VERTICAL 1 ---
            val finalPointLineVertical = Offset(rotatedEnd_2.x, rotatedEnd_2.y - vLength)
            lineTo(finalPointLineVertical.x, finalPointLineVertical.y)

            // --- 5. TERCERA CURVA (ROTADA) ---
            val pivotX_3 = finalPointLineVertical.x
            val pivotY_3 = finalPointLineVertical.y
            val originalControlX_3 = pivotX_3
            val originalControlY_3 = pivotY_3 + r
            val originalEndX_3 = pivotX_3 + r
            val originalEndY_3 = pivotY_3 + r
            val rotatedControl_3 =
                rotatePoint(originalControlX_3, originalControlY_3, pivotX_3, pivotY_3, finalCurveRotationDegrees)
            val rotatedEnd_3 =
                rotatePoint(originalEndX_3, originalEndY_3, pivotX_3, pivotY_3, finalCurveRotationDegrees)
            quadraticTo(rotatedControl_3.x, rotatedControl_3.y, rotatedEnd_3.x, rotatedEnd_3.y)

            // --- 6. CIERRE HORIZONTAL (Pre-Curva 4) ---
            val pivotX_4 = startX + r
            val pivotY_4 = rotatedEnd_3.y
            lineTo(pivotX_4, pivotY_4)

            // --- 7. CUARTA CURVA (ROTADA) ---
            val originalControlX_4 = pivotX_4
            val originalControlY_4 = pivotY_4 + r
            val originalEndX_4 = pivotX_4 + r
            val originalEndY_4 = pivotY_4 + r
            val rotatedControl_4 =
                rotatePoint(originalControlX_4, originalControlY_4, pivotX_4, pivotY_4, fourthCurveRotationDegrees)
            val rotatedEnd_4 =
                rotatePoint(originalEndX_4, originalEndY_4, pivotX_4, pivotY_4, fourthCurveRotationDegrees)
            quadraticTo(rotatedControl_4.x, rotatedControl_4.y, rotatedEnd_4.x, rotatedEnd_4.y)

            // --- 8. CIERRE FINAL ---
            lineTo(curve1Start.x, curve1Start.y)
        }

        return Outline.Generic(path)
    }
}

class ComponentCard(
    private val radius: Dp,
    private val verticalLineLength: Dp,
    private val rotationDegrees: Float,
    private val finalCurveRotationDegrees: Float = -180f,
    private val fourthCurveRotationDegrees: Float = 90f,
    private val globalRotationDegrees: Float = 0f  // 🔹 Nuevo parámetro
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val r = with(density) { radius.toPx() }
        val vLength = with(density) { verticalLineLength.toPx() }
        val fullWidth = size.width
        val fullHeight = size.height

        val hLength = fullWidth - (r * 3)
        val startX = r
        val startY = fullHeight / 2f

        val path = Path().apply {
            // --- 1. PRIMERA CURVA ---
            val curve1Start = Offset(startX, startY)
            val curve1Control = Offset(startX + r, startY)
            val curve1End = Offset(startX + r, startY + r)
            moveTo(curve1Start.x, curve1Start.y)
            quadraticTo(curve1Control.x, curve1Control.y, curve1End.x, curve1End.y)

            // --- 2. LÍNEA HORIZONTAL 1 ---
            val pivotX_2 = curve1End.x + hLength
            val pivotY_2 = curve1End.y
            lineTo(pivotX_2, pivotY_2)

            // --- 3. SEGUNDA CURVA (ROTADA) ---
            val originalControlX_2 = pivotX_2
            val originalControlY_2 = pivotY_2 + r
            val originalEndX_2 = pivotX_2 - r
            val originalEndY_2 = pivotY_2 + r
            val rotatedControl_2 = rotatePoint(originalControlX_2, originalControlY_2, pivotX_2, pivotY_2, rotationDegrees)
            val rotatedEnd_2 = rotatePoint(originalEndX_2, originalEndY_2, pivotX_2, pivotY_2, rotationDegrees)
            quadraticTo(rotatedControl_2.x, rotatedControl_2.y, rotatedEnd_2.x, rotatedEnd_2.y)

            // --- 4. LÍNEA VERTICAL 1 ---
            val finalPointLineVertical = Offset(rotatedEnd_2.x, rotatedEnd_2.y - vLength)
            lineTo(finalPointLineVertical.x, finalPointLineVertical.y)

            // --- 5. TERCERA CURVA (ROTADA) ---
            val pivotX_3 = finalPointLineVertical.x
            val pivotY_3 = finalPointLineVertical.y
            val originalControlX_3 = pivotX_3
            val originalControlY_3 = pivotY_3 + r
            val originalEndX_3 = pivotX_3 + r
            val originalEndY_3 = pivotY_3 + r
            val rotatedControl_3 = rotatePoint(originalControlX_3, originalControlY_3, pivotX_3, pivotY_3, finalCurveRotationDegrees)
            val rotatedEnd_3 = rotatePoint(originalEndX_3, originalEndY_3, pivotX_3, pivotY_3, finalCurveRotationDegrees)
            quadraticTo(rotatedControl_3.x, rotatedControl_3.y, rotatedEnd_3.x, rotatedEnd_3.y)

            // --- 6. CIERRE HORIZONTAL (Pre-Curva 4) ---
            val pivotX_4 = startX + r
            val pivotY_4 = rotatedEnd_3.y
            lineTo(pivotX_4, pivotY_4)

            // --- 7. CUARTA CURVA (ROTADA) ---
            val originalControlX_4 = pivotX_4
            val originalControlY_4 = pivotY_4 + r
            val originalEndX_4 = pivotX_4 + r
            val originalEndY_4 = pivotY_4 + r
            val rotatedControl_4 = rotatePoint(originalControlX_4, originalControlY_4, pivotX_4, pivotY_4, fourthCurveRotationDegrees)
            val rotatedEnd_4 = rotatePoint(originalEndX_4, originalEndY_4, pivotX_4, pivotY_4, fourthCurveRotationDegrees)
            quadraticTo(rotatedControl_4.x, rotatedControl_4.y, rotatedEnd_4.x, rotatedEnd_4.y)

            // --- 8. CIERRE FINAL ---
            lineTo(curve1Start.x, curve1Start.y)
        }

        // 🔹 ROTACIÓN GLOBAL (opcional)
        if (globalRotationDegrees != 0f) {
            val rotatedPath = Path().apply {
                val cx = fullWidth / 2
                val cy = fullHeight / 2
                path.asAndroidPath().apply {
                    val matrix = android.graphics.Matrix()
                    matrix.postRotate(globalRotationDegrees, cx, cy)
                    transform(matrix)
                }.let { addPath(Path().apply { addPath(it as Path) }) }
            }
            return Outline.Generic(rotatedPath)
        }

        return Outline.Generic(path)
    }
}



@Composable
fun PopularMoviesScreen(
    popularMoviesViewModel: PopularMoviesViewModel = koinViewModel(),
    navigateToDetail: (movie: MovieModel) -> Unit
) {
    val state = popularMoviesViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        popularMoviesViewModel.fetchPopularMovies()
    }
    Column(
        modifier = Modifier.padding(25.dp)
            .background(Color.Red)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    color = Color(0xFF90CAF9),
                    shape = ComponentCard(
                          radius = 45.dp,
             verticalLineLength = 100.dp,
         rotationDegrees = -180f,
                        globalRotationDegrees = 0f
        )
                )
        ) {
            Column {
                Text("aaa")
                Text("BBB" )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    color = Color(0xFF90CAF9),
                    shape = ComponentCardOld(
                        radius = 45.dp,
                        verticalLineLength = 100.dp,
                        rotationDegrees = -180f
                    )
                )
        ) {
            Column {
                Text("aaa")
                Text("BBB" )
            }
        }
    }}