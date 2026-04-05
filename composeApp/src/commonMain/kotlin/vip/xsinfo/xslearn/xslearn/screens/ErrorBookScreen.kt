package vip.xsinfo.xslearn.xslearn.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.CssGgIcons
import compose.icons.EvaIcons
import compose.icons.TablerIcons
import compose.icons.evaicons.Fill
import compose.icons.evaicons.fill.Edit
import compose.icons.evaicons.fill.Refresh
import compose.icons.tablericons.Atom2
import compose.icons.tablericons.Edit
import compose.icons.tablericons.Refresh
import compose.icons.tablericons.School
import compose.icons.tablericons.StarOff
import vip.xsinfo.xslearn.xslearn.theme.AppColor

/**
 * 错题本屏幕
 * 包含：顶部筛选栏、错题列表、核心操作功能
 */
@Composable
fun ErrorBookScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 顶部标题
        Text(
            text = "错题本",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // 顶部筛选栏
        FilterSection()
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 错题列表
        ErrorListSection()
    }
}

/**
 * 顶部筛选栏
 */
@Composable
fun FilterSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // 科目筛选
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "科目：",
                style = MaterialTheme.typography.bodyMedium,
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
                style = MaterialTheme.typography.bodyMedium,
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

/**
 * 错题数据类
 */
data class ErrorQuestion(
    val id: Int,
    val subject: String,
    val knowledgePoint: String,
    val questionPreview: String,
    val errorCount: Int,
    val lastReviewTime: String,
    val masteryStatus: String
)

/**
 * 模拟错题数据
 */
val errorQuestions = listOf(
    ErrorQuestion(
        id = 1,
        subject = "英语",
        knowledgePoint = "阅读理解",
        questionPreview = "What is the main idea of the passage?",
        errorCount = 2,
        lastReviewTime = "2023-10-01",
        masteryStatus = "未掌握"
    ),
    ErrorQuestion(
        id = 2,
        subject = "数学",
        knowledgePoint = "微积分",
        questionPreview = "计算定积分 ∫(0,1) x² dx",
        errorCount = 3,
        lastReviewTime = "2023-10-02",
        masteryStatus = "部分掌握"
    ),
    ErrorQuestion(
        id = 3,
        subject = "政治",
        knowledgePoint = "马原",
        questionPreview = "简述矛盾的普遍性和特殊性的关系",
        errorCount = 1,
        lastReviewTime = "2023-10-03",
        masteryStatus = "未掌握"
    ),
    ErrorQuestion(
        id = 4,
        subject = "英语",
        knowledgePoint = "完形填空",
        questionPreview = "Choose the correct word to fill in the blank...",
        errorCount = 2,
        lastReviewTime = "2023-10-04",
        masteryStatus = "部分掌握"
    )
)

/**
 * 错题列表区
 */
@Composable
fun ErrorListSection() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(errorQuestions) { question ->
            ErrorQuestionCard(question)
        }
    }
}

/**
 * 错题卡片
 */
@Composable
fun ErrorQuestionCard(question: ErrorQuestion) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // 题目来源
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = question.subject,
                        style = MaterialTheme.typography.bodySmall,
                        color = AppColor.Primary,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = question.knowledgePoint,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                        .background(
                            if (question.masteryStatus == "未掌握") Color.Red.copy(alpha = 0.1f)
                            else if (question.masteryStatus == "部分掌握") Color.Yellow.copy(alpha = 0.1f)
                            else Color.Green.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(4.dp)
                        )
                ) {
                    Text(
                        text = question.masteryStatus,
                        style = MaterialTheme.typography.bodySmall,
                        color = if (question.masteryStatus == "未掌握") Color.Red
                        else if (question.masteryStatus == "部分掌握") Color.Yellow
                        else Color.Green,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // 题干预览
            Text(
                text = question.questionPreview,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            
            // 错误信息和操作按钮
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "错误次数: ${question.errorCount}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Text(
                        text = "最近重做: ${question.lastReviewTime}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    IconButton(onClick = { /* 重做 */ }) {
                        Icon(TablerIcons.Refresh, contentDescription = "重做")
                    }
                    IconButton(onClick = { /* 查看解析 */ }) {
                        Icon(TablerIcons.Atom2, contentDescription = "查看解析")
                    }
                    IconButton(onClick = { /* 编辑笔记 */ }) {
                        Icon(TablerIcons.Edit, contentDescription = "编辑笔记")
                    }
                    IconButton(onClick = { /* 标记已掌握 */ }) {
                        Icon(TablerIcons.School, contentDescription = "标记已掌握")
                    }
                    IconButton(onClick = { /* 移除错题 */ }) {
                        Icon(TablerIcons.StarOff, contentDescription = "移除错题")
                    }
                }
            }
        }
    }
}
