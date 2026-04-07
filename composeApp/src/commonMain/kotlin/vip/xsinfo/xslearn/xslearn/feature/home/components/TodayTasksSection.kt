package vip.xsinfo.xslearn.xslearn.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.CssGgIcons
import compose.icons.cssggicons.Add
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor

/**
 * 今日学习待办专区
 */
@Composable
fun TodayTasksSection() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "今日待办",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor.TextPrimary
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(onClick = { /* 一键全完成 */ }) {
                    Text(
                        text = "一键完成",
                        color = AppColor.Primary,
                        fontSize = 12.sp
                    )
                }
                IconButton(onClick = { /* 新增任务 */ }) {
                    Icon(
                        imageVector = CssGgIcons.Add,
                        contentDescription = "新增任务",
                        tint = AppColor.Primary
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // 任务列表
        val tasks = listOf(
            Task("学位英语", "背单词", 50, 30, false),
            Task("考研数学", "刷题", 20, 10, false),
            Task("政治", "背诵", 30, 15, false)
        )
        
        tasks.forEach { task ->
            TaskItem(task)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

/**
 * 任务数据类
 */
data class Task(
    val subject: String,
    val content: String,
    val target: Int,
    val progress: Int,
    var completed: Boolean
)

/**
 * 任务项
 */
@Composable
fun TaskItem(task: Task) {
    var isCompleted by remember { mutableStateOf(task.completed) }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColor.Surface
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isCompleted,
                onCheckedChange = { isCompleted = it }
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "${task.subject} - ${task.content}",
                    fontSize = 14.sp,
                    color = AppColor.TextPrimary
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${task.progress}/${task.target}",
                        fontSize = 12.sp,
                        color = AppColor.TextSecondary
                    )
                    Text(
                        text = "${(task.progress.toFloat() / task.target * 100).toInt()}%",
                        fontSize = 12.sp,
                        color = AppColor.TextSecondary
                    )
                }
                LinearProgressIndicator(
                    progress = task.progress.toFloat() / task.target,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp),
                    color = AppColor.Primary,
                    trackColor = AppColor.LightGray
                )
            }
        }
    }
}


