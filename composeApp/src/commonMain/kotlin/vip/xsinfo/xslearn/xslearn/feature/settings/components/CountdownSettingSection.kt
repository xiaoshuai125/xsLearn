package vip.xsinfo.xslearn.xslearn.feature.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.icons.TablerIcons
import compose.icons.tablericons.Edit
import compose.icons.tablericons.Trash
import vip.xsinfo.xslearn.xslearn.shared.components.AppCard

/**
 * 考试倒计时设置专区
 */
@Composable
fun CountdownSettingSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "考试倒计时设置",
                style = androidx.compose.material3.MaterialTheme.typography.headlineSmall
            )
            Button(onClick = { /* 新增考试 */ }) {
                Text("新增")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 考试列表
        val exams = listOf(
            ExamItem("学位英语", "2024-12-23", true),
            ExamItem("考研初试", "2024-12-24", true)
        )
        
        exams.forEach { exam ->
            ExamItemCard(exam)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

/**
 * 考试项数据类
 */
data class ExamItem(
    val name: String,
    val date: String,
    val showOnHome: Boolean
)

/**
 * 考试项卡片
 */
@Composable
fun ExamItemCard(exam: ExamItem) {
    AppCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = exam.name,
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = exam.date,
                    style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                    color = androidx.compose.ui.graphics.Color.Gray
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = if (exam.showOnHome) "首页展示" else "不展示",
                    style = androidx.compose.material3.MaterialTheme.typography.bodySmall
                )
                IconButton(onClick = { /* 编辑 */ }) {
                    Icon(TablerIcons.Edit, contentDescription = "编辑")
                }
                IconButton(onClick = { /* 删除 */ }) {
                    Icon(TablerIcons.Trash, contentDescription = "删除")
                }
            }
        }
    }
}
