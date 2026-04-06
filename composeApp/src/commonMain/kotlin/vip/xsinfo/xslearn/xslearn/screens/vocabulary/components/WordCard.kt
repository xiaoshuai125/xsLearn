package vip.xsinfo.xslearn.xslearn.screens.vocabulary.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import compose.icons.tablericons.Volume2
import vip.xsinfo.xslearn.xslearn.screens.vocabulary.data.Word
import vip.xsinfo.xslearn.xslearn.theme.AppColor

/**
 * 单词卡片
 */
@Composable
fun WordCard(
    word: Word,
    showAnswer: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = word.meaning,
            fontSize = 24.sp,
            color = AppColor.TextPrimary
        )
        if (showAnswer) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = word.word,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColor.TextPrimary
                )
                Text(
                    text = word.phonetic,
                    fontSize = 18.sp,
                    color = AppColor.TextSecondary
                )
                // 发音按钮
                Button(
                    onClick = { /* 播放发音 */ },
                    modifier = Modifier.size(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColor.Primary.copy(alpha = 0.1f)
                    )
                ) {
                    Icon(
                        imageVector = TablerIcons.Volume2,
                        contentDescription = "发音",
                        tint = AppColor.Primary,
                        modifier = Modifier.size(24.dp)
                    )
                }
                // 例句
                if (word.example.isNotEmpty()) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        elevation = CardDefaults.cardElevation(4.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = AppColor.Surface.copy(alpha = 0.8f)
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = word.example,
                                fontSize = 16.sp,
                                color = AppColor.TextPrimary
                            )
                        }
                    }
                }
                // 词组搭配
                if (word.collocations.isNotEmpty()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "词组搭配",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = AppColor.TextPrimary
                        )
                        word.collocations.forEach {
                            Text(
                                text = it,
                                fontSize = 14.sp,
                                color = AppColor.TextSecondary
                            )
                        }
                    }
                }
            }
        }
    }
}
