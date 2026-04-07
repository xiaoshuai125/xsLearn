package vip.xsinfo.xslearn.xslearn.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vip.xsinfo.xslearn.xslearn.feature.home.components.ExamCountdownSection
import vip.xsinfo.xslearn.xslearn.feature.home.components.LearningDataSection
import vip.xsinfo.xslearn.xslearn.feature.home.components.SubjectProgressSection
import vip.xsinfo.xslearn.xslearn.feature.home.components.TopBar
import vip.xsinfo.xslearn.xslearn.feature.home.components.TodayTasksSection

/**
 * 首页屏幕
 * 包含：顶部状态栏、考试倒计时、今日待办、订阅科目进度、学习数据概览
 */
@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // 顶部状态栏（固定）
        TopBar()
        
        // 内容区域（可滚动）
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
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
}
