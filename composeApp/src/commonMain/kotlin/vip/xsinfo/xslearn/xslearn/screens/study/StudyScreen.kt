package vip.xsinfo.xslearn.xslearn.screens.study

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vip.xsinfo.xslearn.xslearn.screens.study.components.StudyTopBar
import vip.xsinfo.xslearn.xslearn.screens.study.components.FeatureModulesSection
import vip.xsinfo.xslearn.xslearn.screens.study.components.PracticeSection
import vip.xsinfo.xslearn.xslearn.screens.study.components.StudyDataSection

/**
 * 学习中心页面
 */
@Composable
fun StudyScreen() {
    val subjects = listOf(
        "学位英语", "考研英语二", "考研数学二", "考研政治", "数据结构", "计算机组成原理", "操作系统", "计算机网络"
    )
    var selectedSubject by remember { mutableStateOf(subjects[0]) }

    Column(modifier = Modifier.fillMaxSize()) {
        // 顶部状态栏（固定，包含科目选择）
        StudyTopBar(
            subjects = subjects,
            selectedSubject = selectedSubject,
            onSubjectChange = { selectedSubject = it }
        )
        
        // 内容区域（可滚动）
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
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
}
