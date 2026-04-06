package vip.xsinfo.xslearn.xslearn.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vip.xsinfo.xslearn.xslearn.theme.AppColor

/**
 * 学习数据概览专区
 */
@Composable
fun LearningDataSection() {
    Column {
        Text(
            text = "学习数据概览",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        
        // 核心数据卡片
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            DataCard(
                title = "累计学习时长",
                value = "120h",
                color = AppColor.Primary,
                modifier = Modifier.weight(1f)
            )
            DataCard(
                title = "总刷题量",
                value = "2500",
                color = AppColor.Secondary,
                modifier = Modifier.weight(1f)
            )
            DataCard(
                title = "单词掌握量",
                value = "4200",
                color = AppColor.Warning,
                modifier = Modifier.weight(1f)
            )
            DataCard(
                title = "连续学习",
                value = "15天",
                color = AppColor.Info,
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 近7天学习时长折线图（模拟）
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = AppColor.Surface
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "近7天学习时长",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColor.TextPrimary,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                
                // 模拟折线图
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(AppColor.LightGray)
                ) {
                    Text(
                        text = "学习时长趋势图",
                        color = AppColor.TextSecondary,
                        fontSize = 12.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}

/**
 * 数据卡片
 */
@Composable
fun DataCard(
    title: String,
    value: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColor.Surface
        )
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = color
            )
            Text(
                text = title,
                fontSize = 10.sp,
                color = AppColor.TextSecondary
            )
        }
    }
}
