package vip.xsinfo.xslearn.xslearn.feature.vocabulary.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor

/**
 * 背单词页面底部操作区域
 */
@Composable
fun VocabularyBottomBar(
    currentIndex: Int,
    totalWords: Int,
    showAnswer: Boolean,
    onViewAnswer: () -> Unit,
    onMarkKnown: () -> Unit,
    onMarkUncertain: () -> Unit,
    onMarkUnknown: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(16.dp)
    ) {
        // 进度指示器
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${currentIndex + 1}/$totalWords",
                fontSize = 16.sp,
                color = AppColor.TextSecondary
            )
            // 顶部操作按钮（可选）
            Row(
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
            ) {
                // 可以添加收藏、笔记等按钮
            }
        }

        if (!showAnswer) {
            ActionButton(
                text = "查看答案",
                color = AppColor.Primary,
                onClick = onViewAnswer,
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            Column(
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)
            ) {
                // 提示文本
                Text(
                    text = "瞬间想起单词，选「认识」\n思考后想起单词，选「模糊」",
                    fontSize = 14.sp,
                    color = AppColor.TextSecondary,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                // 三个选项按钮
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
                ) {
                    ActionButton(
                        text = "认识",
                        color = AppColor.Success,
                        onClick = onMarkKnown,
                        modifier = Modifier.weight(1f)
                    )

                    ActionButton(
                        text = "模糊",
                        color = AppColor.Warning,
                        onClick = onMarkUncertain,
                        modifier = Modifier.weight(1f)
                    )

                    ActionButton(
                        text = "不认识",
                        color = AppColor.Error,
                        onClick = onMarkUnknown,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

/**
 * 操作按钮
 */
@Composable
private fun ActionButton(
    text: String,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    androidx.compose.material3.Button(
        onClick = onClick,
        modifier = modifier,
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
