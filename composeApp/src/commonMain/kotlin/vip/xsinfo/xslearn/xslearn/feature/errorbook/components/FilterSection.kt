package vip.xsinfo.xslearn.xslearn.feature.errorbook.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor

/**
 * 顶部筛选栏
 */
@Composable
fun FilterSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        // 科目筛选
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "科目：",
                fontWeight = FontWeight.Medium
            )
            FilterChip(
                selected = true,
                onClick = { /* 切换全科目 */ },
                label = { Text("全科目") },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = AppColor.Primary,
                    selectedLabelColor = Color.White
                )
            )
            FilterChip(
                selected = false,
                onClick = { /* 切换英语 */ },
                label = { Text("英语") }
            )
            FilterChip(
                selected = false,
                onClick = { /* 切换数学 */ },
                label = { Text("数学") }
            )
            FilterChip(
                selected = false,
                onClick = { /* 切换政治 */ },
                label = { Text("政治") }
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // 维度筛选
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "筛选：",
                fontWeight = FontWeight.Medium
            )
            FilterChip(
                selected = false,
                onClick = { /* 按知识点筛选 */ },
                label = { Text("知识点") }
            )
            FilterChip(
                selected = false,
                onClick = { /* 按错题时间筛选 */ },
                label = { Text("时间") }
            )
            FilterChip(
                selected = false,
                onClick = { /* 按错误次数筛选 */ },
                label = { Text("错误次数") }
            )
            FilterChip(
                selected = false,
                onClick = { /* 按掌握状态筛选 */ },
                label = { Text("掌握状态") }
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // 批量操作按钮
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                onClick = { /* 批量重做 */ },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text("批量重做")
            }
            OutlinedButton(
                onClick = { /* 标记已掌握 */ },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text("标记已掌握")
            }
            OutlinedButton(
                onClick = { /* 导出错题 */ }
            ) {
                Text("导出")
            }
        }
    }
}
