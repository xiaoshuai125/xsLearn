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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.CssGgIcons
import compose.icons.TablerIcons
import compose.icons.cssggicons.Add
import compose.icons.tablericons.Edit
import compose.icons.tablericons.Search
import compose.icons.tablericons.Star
import vip.xsinfo.xslearn.xslearn.theme.AppColor

/**
 * 首页屏幕
 * 包含：顶部状态栏、考试倒计时、今日待办、订阅科目进度、学习数据概览
 */
@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // 顶部状态栏
        item {
            TopBar()
        }
        
        // 考试倒计时专区
        item {
            ExamCountdownSection()
        }
        
        // 今日学习待办专区
        item {
            TodayTasksSection()
        }
        
        // 订阅科目进度专区
        item {
            SubjectProgressSection()
        }
        
        // 学习数据概览专区
        item {
            LearningDataSection()
        }
    }
}

/**
 * 顶部状态栏
 */
@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
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

/**
 * 考试倒计时专区
 */
@Composable
fun ExamCountdownSection() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "考试倒计时",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor.TextPrimary
            )
            TextButton(onClick = { /* 跳转到设置 */ }) {
                Text(
                    text = "设置",
                    color = AppColor.Primary
                )
            }
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // 倒计时卡片
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CountdownCard(
                examName = "学位英语",
                daysLeft = 30,
                examDate = "2024-12-21",
                modifier = Modifier.weight(1f)
            )
            CountdownCard(
                examName = "考研初试",
                daysLeft = 60,
                examDate = "2025-01-15",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

/**
 * 倒计时卡片
 */
@Composable
fun CountdownCard(
    examName: String,
    daysLeft: Int,
    examDate: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColor.Surface
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = examName,
                fontSize = 14.sp,
                color = AppColor.TextSecondary
            )
            Text(
                text = daysLeft.toString(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor.Primary
            )
            Text(
                text = "剩余天数",
                fontSize = 12.sp,
                color = AppColor.TextSecondary
            )
            Text(
                text = examDate,
                fontSize = 12.sp,
                color = AppColor.TextSecondary
            )
        }
    }
}

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

/**
 * 订阅科目进度专区
 */
@Composable
fun SubjectProgressSection() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "我的备考进度",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor.TextPrimary
            )
            TextButton(onClick = { /* 科目管理 */ }) {
                Text(
                    text = "科目管理",
                    color = AppColor.Primary
                )
            }
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // 科目卡片网格
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SubjectCard(
                subject = "学位英语",
                progress = 45,
                totalQuestions = 1200,
                correctRate = 75,
                knowledgeRate = 60,
                wordProgress = 3500,
                modifier = Modifier.weight(1f)
            )
            SubjectCard(
                subject = "考研数学",
                progress = 30,
                totalQuestions = 800,
                correctRate = 65,
                knowledgeRate = 50,
                wordProgress = 0,
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SubjectCard(
                subject = "政治",
                progress = 20,
                totalQuestions = 1500,
                correctRate = 70,
                knowledgeRate = 45,
                wordProgress = 0,
                modifier = Modifier.weight(1f)
            )
            SubjectCard(
                subject = "408专业课",
                progress = 25,
                totalQuestions = 600,
                correctRate = 60,
                knowledgeRate = 40,
                wordProgress = 0,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

/**
 * 科目卡片
 */
@Composable
fun SubjectCard(
    subject: String,
    progress: Int,
    totalQuestions: Int,
    correctRate: Int,
    knowledgeRate: Int,
    wordProgress: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColor.Surface
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = subject,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor.TextPrimary
            )
            
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "备考进度",
                        fontSize = 12.sp,
                        color = AppColor.TextSecondary
                    )
                    Text(
                        text = "$progress%",
                        fontSize = 12.sp,
                        color = AppColor.TextSecondary
                    )
                }
                LinearProgressIndicator(
                    progress = progress.toFloat() / 100,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp),
                    color = AppColor.Primary,
                    trackColor = AppColor.LightGray
                )
            }
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = totalQuestions.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppColor.TextPrimary
                    )
                    Text(
                        text = "总题量",
                        fontSize = 10.sp,
                        color = AppColor.TextSecondary
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$correctRate%",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppColor.TextPrimary
                    )
                    Text(
                        text = "正确率",
                        fontSize = 10.sp,
                        color = AppColor.TextSecondary
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$knowledgeRate%",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppColor.TextPrimary
                    )
                    Text(
                        text = "掌握率",
                        fontSize = 10.sp,
                        color = AppColor.TextSecondary
                    )
                }
            }
            
            if (wordProgress > 0) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "词书进度",
                        fontSize = 12.sp,
                        color = AppColor.TextSecondary
                    )
                    Text(
                        text = wordProgress.toString(),
                        fontSize = 12.sp,
                        color = AppColor.TextSecondary
                    )
                }
            }
        }
    }
}

/**
 * 学习数据概览专区
 */
@Composable
fun LearningDataSection() {
    Column {
        Text(
            text = "学习数据概览",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        
        // 核心数据卡片
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            DataCard(
                title = "累计学习时长",
                value = "120h",
                color = AppColor.Primary,
                modifier = Modifier.weight(1f)
            )
            DataCard(
                title = "总刷题量",
                value = "2500",
                color = AppColor.Secondary,
                modifier = Modifier.weight(1f)
            )
            DataCard(
                title = "单词掌握量",
                value = "4200",
                color = AppColor.Warning,
                modifier = Modifier.weight(1f)
            )
            DataCard(
                title = "连续学习",
                value = "15天",
                color = AppColor.Info,
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 近7天学习时长折线图（模拟）
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = AppColor.Surface
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "近7天学习时长",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColor.TextPrimary,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                
                // 模拟折线图
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(AppColor.LightGray)
                ) {
                    Text(
                        text = "学习时长趋势图",
                        color = AppColor.TextSecondary,
                        fontSize = 12.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}

/**
 * 数据卡片
 */
@Composable
fun DataCard(
    title: String,
    value: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColor.Surface
        )
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = color
            )
            Text(
                text = title,
                fontSize = 10.sp,
                color = AppColor.TextSecondary
            )
        }
    }
}
