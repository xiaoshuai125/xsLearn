package vip.xsinfo.xslearn.xslearn.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.CssGgIcons
import compose.icons.EvaIcons
import compose.icons.TablerIcons
import compose.icons.evaicons.Fill
import compose.icons.evaicons.fill.Book
import compose.icons.evaicons.fill.BookOpen
import compose.icons.evaicons.fill.CreditCard
import compose.icons.evaicons.fill.Edit2
import compose.icons.evaicons.fill.FileRemove
import compose.icons.tablericons.ChevronRight
import compose.icons.tablericons.Edit
import compose.icons.tablericons.Search
import compose.icons.tablericons.Star
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vip.xsinfo.xslearn.xslearn.theme.AppColor

/**
 * 学习中心页面
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudyScreen() {
    val subjects = listOf(
        "学位英语", "考研英语二", "考研数学二", "考研政治", "数据结构", "计算机组成原理", "操作系统", "计算机网络"
    )
    var selectedSubject by remember { mutableStateOf(subjects[0]) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // 顶部状态栏（包含科目选择）
        item {
            StudyTopBar(
                subjects = subjects,
                selectedSubject = selectedSubject,
                onSubjectChange = { selectedSubject = it }
            )
        }
        
        // 功能模块区
        item {
            FeatureModulesSection()
        }
        
        // 专项练习区
        item {
            PracticeSection()
        }
        
        // 学习数据区
        item {
            StudyDataSection()
        }
    }
}

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
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 左侧：科目选择
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "选择科目：",
                    fontSize = 14.sp,
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
                                style = MaterialTheme.typography.bodyMedium,
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
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.width(200.dp)
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
                // 双向箭头切换图标
                IconButton(onClick = { /* 切换功能 */ }) {
                    Icon(
                        imageVector = TablerIcons.Search,
                        contentDescription = "切换",
                        tint = AppColor.Primary
                    )
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



/**
 * 功能模块卡片
 */
@Composable
fun FeatureCard(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit = {}
) {
    var scale by remember { mutableStateOf(1f) }
    val animatedScale by animateFloatAsState(targetValue = scale)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .scale(animatedScale),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        onClick = {
            scale = 0.95f
            // 恢复原始大小
            kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.Main).launch {
                kotlinx.coroutines.delay(100)
                scale = 1f
            }
            onClick()
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .width(48.dp)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

/**
 * 练习卡片
 */
@Composable
fun PracticeCard(
    title: String,
    questionCount: String,
    onClick: () -> Unit = {}
) {
    var scale by remember { mutableStateOf(1f) }
    val animatedScale by animateFloatAsState(targetValue = scale)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .scale(animatedScale),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        onClick = {
            scale = 0.98f
            // 恢复原始大小
            kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.Main).launch {
                kotlinx.coroutines.delay(100)
                scale = 1f
            }
            onClick()
        }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = questionCount,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp),
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

/**
 * 英语类科目布局
 */
@Composable
fun EnglishSubjectLayout(subject: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = subject, style = MaterialTheme.typography.headlineMedium)
        
        // 功能模块卡片
        Column(modifier = Modifier.padding(top = 16.dp)) {
            FeatureCard(
                title = "背单词",
                icon = EvaIcons.Fill.BookOpen
            )
            FeatureCard(
                title = "知识点练习",
                icon = EvaIcons.Fill.Book
            )
            FeatureCard(
                title = "专项练习",
                icon = EvaIcons.Fill.CreditCard
            )
            FeatureCard(
                title = "套卷模考",
                icon = EvaIcons.Fill.FileRemove
            )
        }
        
        // 专项练习列表
        Text(
            text = "专项练习",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
        )
        
        LazyColumn {
            items(10) { index ->
                PracticeCard(
                    title = "练习题目 $index",
                    questionCount = "10道题"
                )
            }
        }
    }
}

/**
 * 数学科目布局
 */
@Composable
fun MathSubjectLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "考研数学二", style = MaterialTheme.typography.headlineMedium)
        
        // 功能模块卡片
        Column(modifier = Modifier.padding(top = 16.dp)) {
            Card(
                modifier = Modifier.padding(bottom = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = "知识点专项刷题",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Card(
                modifier = Modifier.padding(bottom = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = "套卷模考",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Card(
                modifier = Modifier.padding(bottom = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = "辅助工具",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        
        // 专项练习列表
        Text(
            text = "专项练习",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
        )
        
        LazyColumn {
            items(10) { index ->
                Card(
                    modifier = Modifier.padding(bottom = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "数学练习 $index",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "10道题",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

/**
 * 政治科目布局
 */
@Composable
fun PoliticalSubjectLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "考研政治", style = MaterialTheme.typography.headlineMedium)
        
        // 功能模块卡片
        Column(modifier = Modifier.padding(top = 16.dp)) {
            Card(
                modifier = Modifier.padding(bottom = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = "知识点专项刷题",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Card(
                modifier = Modifier.padding(bottom = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = "套卷模考",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Card(
                modifier = Modifier.padding(bottom = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = "时政与背诵",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        
        // 专项练习列表
        Text(
            text = "专项练习",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
        )
        
        LazyColumn {
            items(10) { index ->
                Card(
                    modifier = Modifier.padding(bottom = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "政治练习 $index",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "10道题",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

/**
 * 408专业课布局
 */
@Composable
fun CS408SubjectLayout(subject: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = subject, style = MaterialTheme.typography.headlineMedium)
        
        // 功能模块卡片
        Column(modifier = Modifier.padding(top = 16.dp)) {
            Card(
                modifier = Modifier.padding(bottom = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = "知识点专项刷题",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Card(
                modifier = Modifier.padding(bottom = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = "套卷模考",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Card(
                modifier = Modifier.padding(bottom = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = "考点速记",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        
        // 专项练习列表
        Text(
            text = "专项练习",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
        )
        
        LazyColumn {
            items(10) { index ->
                Card(
                    modifier = Modifier.padding(bottom = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "$subject 练习 $index",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "10道题",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

/**
 * 功能模块区
 */
@Composable
fun FeatureModulesSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "功能模块",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // 功能模块网格
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FeatureModuleCard(
                title = "背单词",
                icon = EvaIcons.Fill.Book,
                color = AppColor.Primary,
                modifier = Modifier.weight(1f)
            )
            FeatureModuleCard(
                title = "知识点练习",
                icon = EvaIcons.Fill.BookOpen,
                color = AppColor.Secondary,
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FeatureModuleCard(
                title = "专项练习",
                icon = EvaIcons.Fill.Edit2,
                color = AppColor.Warning,
                modifier = Modifier.weight(1f)
            )
            FeatureModuleCard(
                title = "套卷模考",
                icon = EvaIcons.Fill.CreditCard,
                color = AppColor.Info,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

/**
 * 功能模块卡片
 */
@Composable
fun FeatureModuleCard(
    title: String,
    icon: ImageVector,
    color: Color,
    modifier: Modifier = Modifier
) {
    var scale by remember { mutableStateOf(1f) }
    val animatedScale by animateFloatAsState(targetValue = scale)

    Card(
        modifier = modifier
            .scale(animatedScale),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColor.Surface
        ),
        onClick = {
            scale = 0.95f
            // 恢复原始大小
            CoroutineScope(Dispatchers.Main).launch {
                kotlinx.coroutines.delay(100)
                scale = 1f
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .background(color.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = color,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .align(Alignment.Center)
                )
            }
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = AppColor.TextPrimary
            )
        }
    }
}

/**
 * 专项练习区
 */
@Composable
fun PracticeSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "专项练习",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor.TextPrimary
            )
            TextButton(onClick = { /* 查看全部 */ }) {
                Text(
                    text = "查看全部",
                    color = AppColor.Primary,
                    fontSize = 12.sp
                )
            }
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // 练习列表
        val practiceItems = listOf(
            PracticeItem("词汇练习", "10道题", 85),
            PracticeItem("阅读理解", "5道题", 70),
            PracticeItem("完形填空", "15道题", 60),
            PracticeItem("翻译练习", "2道题", 90)
        )
        
        practiceItems.forEach { item ->
            PracticeItemCard(item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

/**
 * 练习数据类
 */
data class PracticeItem(
    val title: String,
    val questionCount: String,
    val correctRate: Int
)

/**
 * 练习项卡片
 */
@Composable
fun PracticeItemCard(item: PracticeItem) {
    var scale by remember { mutableStateOf(1f) }
    val animatedScale by animateFloatAsState(targetValue = scale)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animatedScale),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColor.Surface
        ),
        onClick = {
            scale = 0.98f
            // 恢复原始大小
            CoroutineScope(Dispatchers.Main).launch {
                kotlinx.coroutines.delay(100)
                scale = 1f
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = AppColor.TextPrimary
                )
                Text(
                    text = item.questionCount,
                    fontSize = 12.sp,
                    color = AppColor.TextSecondary
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "正确率",
                    fontSize = 12.sp,
                    color = AppColor.TextSecondary
                )
                Text(
                    text = "${item.correctRate}%",
                    fontSize = 12.sp,
                    color = if (item.correctRate >= 80) AppColor.Success else AppColor.Warning
                )
            }
            
            Spacer(modifier = Modifier.height(4.dp))
            
            LinearProgressIndicator(
                progress = item.correctRate.toFloat() / 100,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp),
                color = if (item.correctRate >= 80) AppColor.Success else AppColor.Warning,
                trackColor = AppColor.LightGray
            )
        }
    }
}

/**
 * 学习页面数据区
 */
@Composable
fun StudyDataSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "学习数据",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // 数据卡片
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StudyDataCard(
                title = "今日学习",
                value = "2h",
                color = AppColor.Primary,
                modifier = Modifier.weight(1f)
            )
            StudyDataCard(
                title = "本周刷题",
                value = "120道",
                color = AppColor.Secondary,
                modifier = Modifier.weight(1f)
            )
            StudyDataCard(
                title = "本月学习",
                value = "45h",
                color = AppColor.Warning,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

/**
 * 学习页面数据卡片
 */
@Composable
fun StudyDataCard(
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
            verticalArrangement = Arrangement.Center
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
