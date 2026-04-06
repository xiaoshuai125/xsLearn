package vip.xsinfo.xslearn.xslearn.screens.study.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vip.xsinfo.xslearn.xslearn.theme.AppColor

/**
 * 专项练习区
 */
@Composable
fun PracticeSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "专项练习",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor.TextPrimary
            )
            TextButton(onClick = { /* 查看全部 */ }) {
                Text(
                    text = "查看全部",
                    color = AppColor.Primary,
                    fontSize = 12.sp
                )
            }
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // 练习列表
        val practiceItems = listOf(
            PracticeItem("词汇练习", "10道题", 85),
            PracticeItem("阅读理解", "5道题", 70),
            PracticeItem("完形填空", "15道题", 60),
            PracticeItem("翻译练习", "2道题", 90)
        )
        
        practiceItems.forEach { item ->
            PracticeItemCard(item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

/**
 * 练习项数据类
 */
data class PracticeItem(
    val title: String,
    val description: String,
    val correctRate: Int
)

/**
 * 练习项卡片
 */
@Composable
fun PracticeItemCard(item: PracticeItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColor.Surface
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = item.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = AppColor.TextPrimary
                )
                Text(
                    text = item.description,
                    fontSize = 12.sp,
                    color = AppColor.TextSecondary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "正确率",
                        fontSize = 12.sp,
                        color = AppColor.TextSecondary
                    )
                    Text(
                        text = "${item.correctRate}%",
                        fontSize = 12.sp,
                        color = AppColor.TextPrimary,
                        fontWeight = FontWeight.Medium
                    )
                }
                LinearProgressIndicator(
                    progress = item.correctRate.toFloat() / 100,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp),
                    color = AppColor.Primary,
                    trackColor = AppColor.LightGray
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            TextButton(onClick = { /* 开始练习 */ }) {
                Text(
                    text = "开始",
                    color = AppColor.Primary,
                    fontSize = 14.sp
                )
            }
        }
    }
}
