package vip.xsinfo.xslearn.xslearn.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import compose.icons.tablericons.Edit
import compose.icons.tablericons.Search
import compose.icons.tablericons.Star
import vip.xsinfo.xslearn.xslearn.theme.AppColor

/**
 * 顶部状态栏
 */
@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 左侧：APP名称/头像
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(AppColor.Primary)
            ) {
                Text(
                    text = "XS",
                    color = AppColor.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Text(
                text = "学习助手",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor.TextPrimary
            )
        }
        
        // 右侧：搜索、笔记、收藏
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
