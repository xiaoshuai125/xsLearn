package vip.xsinfo.xslearn.xslearn.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor
import vip.xsinfo.xslearn.xslearn.shared.components.AppCard

/**
 * 订阅科目进度专区
 */
@Composable
fun SubjectProgressSection() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "我的备考进度",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor.TextPrimary
            )
            TextButton(onClick = { /* 科目管理 */ }) {
                Text(
                    text = "科目管理",
                    color = AppColor.Primary
                )
            }
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // 科目卡片网格
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SubjectCard(
                subject = "学位英语",
                progress = 45,
                totalQuestions = 1200,
                correctRate = 75,
                knowledgeRate = 60,
                wordProgress = 3500,
                modifier = Modifier.weight(1f)
            )
            SubjectCard(
                subject = "考研数学",
                progress = 30,
                totalQuestions = 800,
                correctRate = 65,
                knowledgeRate = 50,
                wordProgress = 0,
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SubjectCard(
                subject = "政治",
                progress = 20,
                totalQuestions = 1500,
                correctRate = 70,
                knowledgeRate = 45,
                wordProgress = 0,
                modifier = Modifier.weight(1f)
            )
            SubjectCard(
                subject = "408专业课",
                progress = 25,
                totalQuestions = 600,
                correctRate = 60,
                knowledgeRate = 40,
                wordProgress = 0,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

/**
 * 科目卡片
 */
@Composable
fun SubjectCard(
    subject: String,
    progress: Int,
    totalQuestions: Int,
    correctRate: Int,
    knowledgeRate: Int,
    wordProgress: Int,
    modifier: Modifier = Modifier
) {
    AppCard(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = subject,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor.TextPrimary
            )
            
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "备考进度",
                        fontSize = 12.sp,
                        color = AppColor.TextSecondary
                    )
                    Text(
                        text = "$progress%",
                        fontSize = 12.sp,
                        color = AppColor.TextSecondary
                    )
                }
                LinearProgressIndicator(
                    progress = progress.toFloat() / 100,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp),
                    color = AppColor.Primary,
                    trackColor = AppColor.LightGray
                )
            }
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = totalQuestions.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppColor.TextPrimary
                    )
                    Text(
                        text = "总题量",
                        fontSize = 10.sp,
                        color = AppColor.TextSecondary
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$correctRate%",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppColor.TextPrimary
                    )
                    Text(
                        text = "正确率",
                        fontSize = 10.sp,
                        color = AppColor.TextSecondary
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$knowledgeRate%",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppColor.TextPrimary
                    )
                    Text(
                        text = "掌握率",
                        fontSize = 10.sp,
                        color = AppColor.TextSecondary
                    )
                }
            }
            
            if (wordProgress > 0) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "词书进度",
                        fontSize = 12.sp,
                        color = AppColor.TextSecondary
                    )
                    Text(
                        text = wordProgress.toString(),
                        fontSize = 12.sp,
                        color = AppColor.TextSecondary
                    )
                }
            }
        }
    }
}
