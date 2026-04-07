package vip.xsinfo.xslearn.xslearn.feature.study

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vip.xsinfo.xslearn.xslearn.feature.study.components.PoliticsFeatureModulesSection
import vip.xsinfo.xslearn.xslearn.feature.study.components.PracticeSection
import vip.xsinfo.xslearn.xslearn.feature.study.components.StudyDataSection

/**
 * 政治类科目页面
 */
@Composable
fun PoliticsSubjectScreen(subjectType: SubjectType) {
    Column(modifier = Modifier.fillMaxSize()) {
        // 内容区域（可滚动）
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // 政治专属功能模块区
            item {
                PoliticsFeatureModulesSection()
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
