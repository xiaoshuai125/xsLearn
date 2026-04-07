package vip.xsinfo.xslearn.xslearn.shared.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp

/**
 * 动态背景组件
 * 包含几何图形随机缓慢飘动的效果
 */
@Composable
fun DynamicBackground() {
    Box(modifier = Modifier.fillMaxSize()) {
        // 绘制静态背景色
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(
                color = Color(0xFFF0F2F5), // 偏灰色背景
                size = size
            )
        }
        
        // 绘制动态几何图形
        DynamicShapes()
    }
}

/**
 * 动态几何图形
 */
@Composable
fun DynamicShapes() {
    // 固定图形数量，确保分布均匀
    val shapeCount = 4
    
    // 生成随机分布的形状
    val shapes = List(shapeCount) { index ->
        // 确保初始位置均匀分布
        val initialX = (index % 2) * 0.5f + 0.1f
        val initialY = (index / 2) * 0.5f + 0.1f
        
        // 随机颜色
        val colorIndex = index % 4
        val color = when (colorIndex) {
            0 -> Color(0xFFE3F2FD) // 浅蓝色
            1 -> Color(0xFFE8F5E8) // 浅绿色
            2 -> Color(0xFFFFF3E0) // 浅橙色
            3 -> Color(0xFFF3E5F5) // 浅紫色
            else -> Color(0xFFE3F2FD)
        }
        
        // 随机大小
        val size = (60 + (index * 20)) % 80 + 60 // 60-140dp
        
        // 随机动画 duration
        val durationX = 12000 + (index * 2000) // 12-20秒
        val durationY = 14000 + (index * 1500) // 14-19.5秒
        
        // 每个形状对应一种类型
        val shapeType = when (index % 3) {
            0 -> ShapeType.CIRCLE
            1 -> ShapeType.TRIANGLE
            2 -> ShapeType.SQUARE
            else -> ShapeType.CIRCLE
        }
        
        ShapeData(
            color = color,
            size = size.dp,
            initialX = initialX,
            initialY = initialY,
            durationX = durationX,
            durationY = durationY,
            shapeType = shapeType
        )
    }
    
    // 为每个形状创建动画
    shapes.forEach { shapeData ->
        val infiniteTransition = rememberInfiniteTransition()
        
        val xOffset by infiniteTransition.animateFloat(
            initialValue = shapeData.initialX,
            targetValue = shapeData.initialX + 0.6f, // 移动范围
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = shapeData.durationX,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        
        val yOffset by infiniteTransition.animateFloat(
            initialValue = shapeData.initialY,
            targetValue = shapeData.initialY + 0.4f, // 移动范围
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = shapeData.durationY,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        
        // 绘制形状
        Canvas(modifier = Modifier.fillMaxSize()) {
            val shapeSize = shapeData.size.toPx()
            val centerX = size.width * xOffset
            val centerY = size.height * yOffset
            
            // 根据形状类型绘制不同的形状
            when (shapeData.shapeType) {
                ShapeType.CIRCLE -> {
                    drawCircle(
                        color = shapeData.color,
                        radius = shapeSize / 2,
                        center = Offset(centerX, centerY)
                    )
                }
                ShapeType.TRIANGLE -> {
                    val trianglePath = Path().apply {
                        moveTo(centerX, centerY - shapeSize / 2)
                        lineTo(centerX + shapeSize / 2, centerY + shapeSize / 2)
                        lineTo(centerX - shapeSize / 2, centerY + shapeSize / 2)
                        close()
                    }
                    drawPath(
                        path = trianglePath,
                        color = shapeData.color
                    )
                }
                ShapeType.SQUARE -> {
                    drawRect(
                        color = shapeData.color,
                        topLeft = Offset(centerX - shapeSize / 2, centerY - shapeSize / 2),
                        size = Size(shapeSize, shapeSize)
                    )
                }
            }
        }
    }
}

/**
 * 形状类型
 */
enum class ShapeType {
    CIRCLE,
    TRIANGLE,
    SQUARE
}

/**
 * 形状数据
 */
data class ShapeData(
    val color: Color,
    val size: androidx.compose.ui.unit.Dp,
    val initialX: Float,
    val initialY: Float,
    val durationX: Int, // 动画持续时间（毫秒）
    val durationY: Int, // 动画持续时间（毫秒）
    val shapeType: ShapeType // 形状类型
)

/**
 * 深色模式动态背景组件
 */
@Composable
fun DynamicBackgroundDark() {
    Box(modifier = Modifier.fillMaxSize()) {
        // 绘制静态背景色
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(
                color = Color(0xFF1A1A2E), // 深色背景
                size = size
            )
        }
        
        // 绘制动态几何图形
        DynamicShapesDark()
    }
}

/**
 * 深色模式动态几何图形
 */
@Composable
fun DynamicShapesDark() {
    // 固定图形数量，确保分布均匀
    val shapeCount = 4
    
    // 生成随机分布的形状
    val shapes = List(shapeCount) { index ->
        // 确保初始位置均匀分布
        val initialX = (index % 2) * 0.5f + 0.1f
        val initialY = (index / 2) * 0.5f + 0.1f
        
        // 随机颜色
        val colorIndex = index % 4
        val color = when (colorIndex) {
            0 -> Color(0xFF16213E) // 深蓝色
            1 -> Color(0xFF0F3460) // 深蓝色
            2 -> Color(0xFF1A1A2E) // 深蓝色
            3 -> Color(0xFF2C3E50) // 深蓝色
            else -> Color(0xFF16213E)
        }
        
        // 随机大小
        val size = (60 + (index * 20)) % 80 + 60 // 60-140dp
        
        // 随机动画 duration
        val durationX = 12000 + (index * 2000) // 12-20秒
        val durationY = 14000 + (index * 1500) // 14-19.5秒
        
        // 每个形状对应一种类型
        val shapeType = when (index % 3) {
            0 -> ShapeType.CIRCLE
            1 -> ShapeType.TRIANGLE
            2 -> ShapeType.SQUARE
            else -> ShapeType.CIRCLE
        }
        
        ShapeData(
            color = color,
            size = size.dp,
            initialX = initialX,
            initialY = initialY,
            durationX = durationX,
            durationY = durationY,
            shapeType = shapeType
        )
    }
    
    // 为每个形状创建动画
    shapes.forEach { shapeData ->
        val infiniteTransition = rememberInfiniteTransition()
        
        val xOffset by infiniteTransition.animateFloat(
            initialValue = shapeData.initialX,
            targetValue = shapeData.initialX + 0.6f, // 移动范围
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = shapeData.durationX,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        
        val yOffset by infiniteTransition.animateFloat(
            initialValue = shapeData.initialY,
            targetValue = shapeData.initialY + 0.4f, // 移动范围
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = shapeData.durationY,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        
        // 绘制形状
        Canvas(modifier = Modifier.fillMaxSize()) {
            val shapeSize = shapeData.size.toPx()
            val centerX = size.width * xOffset
            val centerY = size.height * yOffset
            
            // 根据形状类型绘制不同的形状
            when (shapeData.shapeType) {
                ShapeType.CIRCLE -> {
                    drawCircle(
                        color = shapeData.color,
                        radius = shapeSize / 2,
                        center = Offset(centerX, centerY)
                    )
                }
                ShapeType.TRIANGLE -> {
                    val trianglePath = Path().apply {
                        moveTo(centerX, centerY - shapeSize / 2)
                        lineTo(centerX + shapeSize / 2, centerY + shapeSize / 2)
                        lineTo(centerX - shapeSize / 2, centerY + shapeSize / 2)
                        close()
                    }
                    drawPath(
                        path = trianglePath,
                        color = shapeData.color
                    )
                }
                ShapeType.SQUARE -> {
                    drawRect(
                        color = shapeData.color,
                        topLeft = Offset(centerX - shapeSize / 2, centerY - shapeSize / 2),
                        size = Size(shapeSize, shapeSize)
                    )
                }
            }
        }
    }
}
