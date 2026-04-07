package vip.xsinfo.xslearn.xslearn.shared.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor

/**
 * 页面标题组件
 * @param text 标题文字
 * @param modifier 修饰符
 */
@Composable
fun AppPageTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = AppColor.TextPrimary,
        modifier = modifier
    )
}

/**
 * 区块标题组件
 * @param text 标题文字
 * @param modifier 修饰符
 */
@Composable
fun AppSectionTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = AppColor.TextPrimary,
        modifier = modifier
    )
}

/**
 * 小组件标题组件
 * @param text 标题文字
 * @param modifier 修饰符
 */
@Composable
fun AppWidgetTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = AppColor.TextPrimary,
        modifier = modifier
    )
}

/**
 * 正文文字组件
 * @param text 正文文字
 * @param modifier 修饰符
 */
@Composable
fun AppBodyText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = AppColor.TextPrimary,
        modifier = modifier
    )
}

/**
 * 辅助文字组件
 * @param text 辅助文字
 * @param modifier 修饰符
 */
@Composable
fun AppSecondaryText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 12.sp,
        color = AppColor.TextSecondary,
        modifier = modifier
    )
}