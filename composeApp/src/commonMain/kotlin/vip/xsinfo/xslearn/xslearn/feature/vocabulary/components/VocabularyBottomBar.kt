package vip.xsinfo.xslearn.xslearn.feature.vocabulary.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
            .padding(horizontal = 20.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AnimatedVisibility(
            visible = !showAnswer,
            enter = fadeIn() + slideInVertically(initialOffsetY = { 20 }),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { -20 })
        ) {
            PrimaryActionButton(
                text = "查看答案",
                onClick = onViewAnswer,
                modifier = Modifier.fillMaxWidth()
            )
        }

        AnimatedVisibility(
            visible = showAnswer,
            enter = fadeIn() + slideInVertically(initialOffsetY = { 20 }),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { -20 })
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = "根据你的熟悉程度选择",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = AppColor.TextSecondary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OptionButton(
                        text = "不认识",
                        color = AppColor.Error,
                        icon = "?",
                        onClick = onMarkUnknown,
                        modifier = Modifier.weight(1f)
                    )

                    OptionButton(
                        text = "模糊",
                        color = AppColor.Warning,
                        icon = "~",
                        onClick = onMarkUncertain,
                        modifier = Modifier.weight(1f)
                    )

                    OptionButton(
                        text = "认识",
                        color = AppColor.Success,
                        icon = "✓",
                        onClick = onMarkKnown,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

/**
 * 主要操作按钮
 */
@Composable
private fun PrimaryActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(56.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        AppColor.Primary,
                        AppColor.PrimaryDark
                    )
                )
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            color = AppColor.White,
            letterSpacing = 0.5.sp
        )
    }
}

/**
 * 选项按钮
 */
@Composable
private fun OptionButton(
    text: String,
    color: Color,
    icon: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(AppColor.Surface)
            .border(
                width = 1.5.dp,
                color = color.copy(alpha = 0.3f),
                shape = RoundedCornerShape(20.dp)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                onClick = onClick
            )
            .padding(vertical = 20.dp, horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(color.copy(alpha = 0.12f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = icon,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = color
            )
        }

        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = color,
            textAlign = TextAlign.Center
        )
    }
}
