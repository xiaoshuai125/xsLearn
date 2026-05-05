package vip.xsinfo.xslearn.xslearn.feature.vocabulary

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
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
    val wordList = VocabularyData.getWordList(viewModel.subjectType)

    var currentIndex by remember { mutableStateOf(0) }
    var showAnswer by remember { mutableStateOf(false) }
    val currentWord = wordList.getOrNull(currentIndex)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.Background)
            .systemBarsPadding()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VocabularyTopBar(
                viewModel = viewModel,
                currentIndex = currentIndex,
                totalWords = wordList.size
            )

            if (wordList.isNotEmpty() && currentWord != null) {
                AnimatedContent(
                    targetState = currentIndex,
                    transitionSpec = {
                        fadeIn() togetherWith fadeOut()
                    },
                    label = "WordCardAnimation"
                ) { _ ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(horizontal = 20.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        WordCard(
                            word = currentWord,
                            showAnswer = showAnswer
                        )
                    }
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "词库为空",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = AppColor.TextSecondary
                    )
                }
            }

            if (wordList.isNotEmpty()) {
                VocabularyBottomBar(
                    currentIndex = currentIndex,
                    totalWords = wordList.size,
                    showAnswer = showAnswer,
                    onViewAnswer = { showAnswer = true },
                    onMarkKnown = {
                        if (currentIndex < wordList.size - 1) {
                            currentIndex++
                            showAnswer = false
                        }
                    },
                    onMarkUncertain = {
                        if (currentIndex < wordList.size - 1) {
                            currentIndex++
                            showAnswer = false
                        }
                    },
                    onMarkUnknown = {
                        if (currentIndex < wordList.size - 1) {
                            currentIndex++
                            showAnswer = false
                        }
                    }
                )
            }
        }
    }
}
