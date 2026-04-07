package vip.xsinfo.xslearn.xslearn.shared.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor

/**
 * 通用卡片组件
 * @param modifier 修饰符
 * @param padding 内边距
 * @param content 卡片内容
 */
@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(16.dp),
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColor.Surface
        )
    ) {
        Box(
            modifier = Modifier.padding(padding)
        ) {
            content()
        }
    }
}

/**
 * 小型卡片组件
 * @param modifier 修饰符
 * @param content 卡片内容
 */
@Composable
fun AppSmallCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    AppCard(
        modifier = modifier,
        padding = PaddingValues(12.dp),
        content = content
    )
}

/**
 * 大型卡片组件
 * @param modifier 修饰符
 * @param content 卡片内容
 */
@Composable
fun AppLargeCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    AppCard(
        modifier = modifier,
        padding = PaddingValues(20.dp),
        content = content
    )
}