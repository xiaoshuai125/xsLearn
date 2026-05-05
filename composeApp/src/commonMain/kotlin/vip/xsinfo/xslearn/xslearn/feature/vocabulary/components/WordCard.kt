package vip.xsinfo.xslearn.xslearn.feature.vocabulary.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import compose.icons.tablericons.Volume2
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.data.Word
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor

/**
 * 单词卡片
 */
@Composable
fun WordCard(
    word: Word,
    showAnswer: Boolean
) {
    val scale by animateFloatAsState(
        targetValue = if (showAnswer) 1f else 0.98f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColor.Surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(28.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "看汉语想英语",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = AppColor.TextSecondary,
                    letterSpacing = 0.5.sp
                )
                Text(
                    text = word.meaning,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColor.TextPrimary,
                    textAlign = TextAlign.Center,
                    lineHeight = 36.sp
                )
            }

            AnimatedVisibility(
                visible = showAnswer,
                enter = fadeIn() + scaleIn(initialScale = 0.95f),
                exit = fadeOut() + scaleOut(targetScale = 0.95f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = word.word,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = AppColor.Primary,
                            letterSpacing = 1.sp
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(
                                                AppColor.Primary.copy(alpha = 0.15f),
                                                AppColor.Primary.copy(alpha = 0.08f)
                                            )
                                        )
                                    )
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = rememberRipple(bounded = false, radius = 18.dp),
                                        onClick = { /* 播放发音 */ }
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = TablerIcons.Volume2,
                                    contentDescription = "发音",
                                    tint = AppColor.Primary,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Text(
                                text = "/${word.phonetic}/",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                                color = AppColor.TextSecondary
                            )
                        }
                    }

                    if (word.example.isNotEmpty()) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = AppColor.Primary.copy(alpha = 0.05f)
                            ),
                            elevation = CardDefaults.cardElevation(0.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(20.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = "例句",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = AppColor.Primary,
                                    letterSpacing = 0.5.sp
                                )
                                Text(
                                    text = word.example,
                                    fontSize = 15.sp,
                                    color = AppColor.TextPrimary,
                                    lineHeight = 22.sp
                                )
                            }
                        }
                    }

                    if (word.collocations.isNotEmpty()) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(
                                text = "词组搭配",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = AppColor.TextSecondary,
                                letterSpacing = 0.5.sp
                            )
                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                word.collocations.forEach { collocation ->
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(20.dp))
                                            .background(AppColor.LightGray)
                                            .padding(horizontal = 14.dp, vertical = 8.dp)
                                    ) {
                                        Text(
                                            text = collocation,
                                            fontSize = 13.sp,
                                            color = AppColor.TextPrimary,
                                            fontWeight = FontWeight.Medium
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
