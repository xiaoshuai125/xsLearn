package vip.xsinfo.xslearn.xslearn.feature.vocabulary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.components.VocabularyBottomBar
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.components.VocabularyTopBar
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.components.WordCard
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.data.VocabularyData
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.viewmodel.VocabularyViewModel
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor

/**
 * 刷单词页面
 * 与 Scaffold 平级，实现沉浸式学习体验
 */
@Composable
fun VocabularyScreen(
    viewModel: VocabularyViewModel
) {
    // 获取词库
    val wordList = VocabularyData.getWordList(viewModel.subjectType)

    var currentIndex by remember { mutableStateOf(0) }
    var showAnswer by remember { mutableStateOf(false) }
    val currentWord = wordList.getOrNull(currentIndex)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 顶部导航栏
        VocabularyTopBar(
            viewModel = viewModel
        )

        // 智能推荐学习模式，无需用户选择

        // 单词卡片区域
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
        ) {
            if (currentWord != null) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // 智能推荐学习模式：看汉语想英语
                    WordCard(
                        word = currentWord,
                        showAnswer = showAnswer
                    )
                }
            } else {
                Text(
                    text = "词库为空",
                    fontSize = 20.sp,
                    color = AppColor.TextSecondary
                )
            }
        }

        // 底部操作区域
        if (wordList.isNotEmpty()) {
            VocabularyBottomBar(
                currentIndex = currentIndex,
                totalWords = wordList.size,
                showAnswer = showAnswer,
                onViewAnswer = { showAnswer = true },
                onMarkKnown = {
                    // 标记为认识，继续下一个单词
                    if (currentIndex < wordList.size - 1) {
                        currentIndex++
                        showAnswer = false
                    }
                },
                onMarkUncertain = {
                    // 标记为模糊，继续下一个单词
                    if (currentIndex < wordList.size - 1) {
                        currentIndex++
                        showAnswer = false
                    }
                },
                onMarkUnknown = {
                    // 标记为不认识，继续下一个单词
                    if (currentIndex < wordList.size - 1) {
                        currentIndex++
                        showAnswer = false
                    }
                }
            )
        }
    }
}
