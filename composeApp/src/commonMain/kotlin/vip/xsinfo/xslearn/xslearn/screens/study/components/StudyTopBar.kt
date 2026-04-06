package vip.xsinfo.xslearn.xslearn.screens.study.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import compose.icons.tablericons.ChevronRight
import compose.icons.tablericons.Edit
import compose.icons.tablericons.Search
import compose.icons.tablericons.Star
import vip.xsinfo.xslearn.xslearn.theme.AppColor

/**
 * 学习页面顶部状态栏
 */
@Composable
fun StudyTopBar(
    subjects: List<String>,
    selectedSubject: String,
    onSubjectChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // 顶部科目选择和操作按钮
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 左侧：科目选择
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "当前科目：",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = AppColor.TextPrimary
                )
                var expanded by remember { mutableStateOf(false) }
                
                Box {
                    TextButton(
                        onClick = { expanded = true }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = selectedSubject,
                                style = MaterialTheme.typography.bodyLarge,
                                color = AppColor.Primary
                            )
                            Icon(
                                imageVector = TablerIcons.ChevronRight,
                                contentDescription = "下拉",
                                tint = AppColor.Primary
                            )
                        }
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        subjects.forEach { subject ->
                            DropdownMenuItem(
                                text = { Text(subject) },
                                onClick = {
                                    onSubjectChange(subject)
                                    expanded = false
                                }
                            )
                        }
                    }
                }
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
}


