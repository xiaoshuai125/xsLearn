package vip.xsinfo.xslearn.xslearn.shared.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape

/**
 * 通用卡片组件 - 使用毛玻璃特效
 * @param modifier 修饰符
 * @param padding 内边距
 * @param onClick 点击回调
 * @param content 卡片内容
 */
@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(16.dp),
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    
    val clickModifier = if (onClick != null) {
        Modifier
            .clickable(
                onClick = onClick,
                interactionSource = interactionSource,
                indication = ripple(
                    color = Color.White.copy(alpha = 0.3f),
                    radius = 300.dp
                )
            )
    } else {
        Modifier
    }
    
    GlassmorphismCard(
        modifier = modifier.then(clickModifier)
    ) {
        Box(
            modifier = Modifier.padding(padding)
        ) {
            content()
        }
    }
}

/**
 * 小型卡片组件 - 使用毛玻璃特效
 * @param modifier 修饰符
 * @param onClick 点击回调
 * @param content 卡片内容
 */
@Composable
fun AppSmallCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    AppCard(
        modifier = modifier,
        padding = PaddingValues(12.dp),
        onClick = onClick,
        content = content
    )
}

/**
 * 大型卡片组件 - 使用毛玻璃特效
 * @param modifier 修饰符
 * @param onClick 点击回调
 * @param content 卡片内容
 */
@Composable
fun AppLargeCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    AppCard(
        modifier = modifier,
        padding = PaddingValues(20.dp),
        onClick = onClick,
        content = content
    )
}
