package vip.xsinfo.xslearn.xslearn.feature.study

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import vip.xsinfo.xslearn.xslearn.feature.study.components.StudyTopBar
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.viewmodel.VocabularyViewModel

/**
 * 学习中心页面
 */
@Composable
fun StudyScreen(
    navController: NavHostController,
    viewModel: VocabularyViewModel,
    onNavigateToVocabulary: () -> Unit
) {
    val subjects = SubjectType.entries
    var selectedSubject by remember { mutableStateOf(subjects[0]) }

    Column(modifier = Modifier.fillMaxSize()) {
        // 顶部状态栏（固定，包含科目选择）
        StudyTopBar(
            subjects = subjects,
            selectedSubject = selectedSubject,
            onSubjectChange = { selectedSubject = it }
        )
        
        // 根据选择的科目类型显示不同的页面
        when (selectedSubject) {
            SubjectType.DEGREE_ENGLISH, SubjectType.POSTGRADUATE_ENGLISH_2 -> {
                EnglishSubjectScreen(
                    subjectType = selectedSubject,
                    navController = navController,
                    viewModel = viewModel,
                    onNavigateToVocabulary = onNavigateToVocabulary
                )
            }
            SubjectType.POSTGRADUATE_MATH_2 -> {
                MathSubjectScreen(selectedSubject)
            }
            SubjectType.POSTGRADUATE_POLITICS -> {
                PoliticsSubjectScreen(selectedSubject)
            }
            SubjectType.DATA_STRUCTURE, SubjectType.COMPUTER_ORGANIZATION, 
            SubjectType.OPERATING_SYSTEM, SubjectType.COMPUTER_NETWORK -> {
                CS408SubjectScreen(selectedSubject)
            }
        }
    }
}
