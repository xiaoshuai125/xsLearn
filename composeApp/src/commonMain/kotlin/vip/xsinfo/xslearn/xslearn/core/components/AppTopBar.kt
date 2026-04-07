package vip.xsinfo.xslearn.xslearn.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import compose.icons.tablericons.Search
import compose.icons.tablericons.Edit
import compose.icons.tablericons.Star
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor

/**
 * 统一的顶部状态栏组件
 * @param title 页面标题
 * @param showActions 是否显示右侧操作按钮
 */
@Composable
fun AppTopBar(
    title: String,
    showActions: Boolean = true
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 左侧：标题
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary
        )
        
        // 右侧：操作按钮
        if (showActions) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                IconButton(onClick = { /* 搜索功能 */ }) {
                    Icon(
                        imageVector = TablerIcons.Search,
                        contentDescription = "搜索",
                        tint = AppColor.TextPrimary
                    )
                }
                IconButton(onClick = { /* 笔记功能 */ }) {
                    Icon(
                        imageVector = TablerIcons.Edit,
                        contentDescription = "笔记",
                        tint = AppColor.TextPrimary
                    )
                }
                IconButton(onClick = { /* 收藏功能 */ }) {
                    Icon(
                        imageVector = TablerIcons.Star,
                        contentDescription = "收藏",
                        tint = AppColor.TextPrimary
                    )
                }
            }
        }
    }
}