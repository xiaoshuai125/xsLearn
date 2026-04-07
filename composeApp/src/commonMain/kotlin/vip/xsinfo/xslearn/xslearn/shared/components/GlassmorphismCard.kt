package vip.xsinfo.xslearn.xslearn.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * 毛玻璃特效组件
 * @param modifier 修饰符
 * @param content 内容
 */
@Composable
fun GlassmorphismCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(
                color = Color.White.copy(alpha = 0.5f),
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.3f),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        content()
    }
}

/**
 * 深色模式毛玻璃特效组件
 * @param modifier 修饰符
 * @param content 内容
 */
@Composable
fun GlassmorphismCardDark(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(
                color = Color.Black.copy(alpha = 0.5f),
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.1f),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        content()
    }
}

/**
 * 根据当前主题选择毛玻璃特效组件
 * @param modifier 修饰符
 * @param isDark 是否为深色模式
 * @param content 内容
 */
@Composable
fun AdaptiveGlassmorphismCard(
    modifier: Modifier = Modifier,
    isDark: Boolean = false,
    content: @Composable () -> Unit
) {
    if (isDark) {
        GlassmorphismCardDark(modifier, content)
    } else {
        GlassmorphismCard(modifier, content)
    }
}