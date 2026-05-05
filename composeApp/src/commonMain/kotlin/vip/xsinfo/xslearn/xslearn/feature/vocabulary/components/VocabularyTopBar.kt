package vip.xsinfo.xslearn.xslearn.feature.vocabulary.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowLeft
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.viewmodel.VocabularyViewModel
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor

/**
 * 背单词页面顶部导航栏
 */
@Composable
fun VocabularyTopBar(
    viewModel: VocabularyViewModel,
    currentIndex: Int = 0,
    totalWords: Int = 0
) {
    val progress = if (totalWords > 0) currentIndex.toFloat() / totalWords.toFloat() else 0f
    val progressColor by animateColorAsState(
        targetValue = when {
            progress >= 0.75f -> AppColor.Success
            progress >= 0.5f -> AppColor.Warning
            else -> AppColor.Primary
        }
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(AppColor.Surface)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(bounded = false, radius = 22.dp),
                        onClick = { viewModel.back() }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = TablerIcons.ArrowLeft,
                    contentDescription = "返回",
                    tint = AppColor.TextPrimary,
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = "${viewModel.subjectType.displayName} - 背单词",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColor.TextPrimary
            )

            Spacer(modifier = Modifier.size(44.dp))
        }

        if (totalWords > 0) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "学习进度",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = AppColor.TextSecondary
                    )
                    Text(
                        text = "${(progress * 100).toInt()}%",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = progressColor
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(AppColor.LightGray)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(progress)
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(progressColor)
                    )
                }

                Text(
                    text = "${currentIndex + 1} / $totalWords 单词",
                    fontSize = 12.sp,
                    color = AppColor.TextSecondary,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
        }
    }
}
