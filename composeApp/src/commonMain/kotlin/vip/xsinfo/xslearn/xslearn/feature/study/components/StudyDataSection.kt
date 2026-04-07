package vip.xsinfo.xslearn.xslearn.feature.study.components

import androidx.compose.foundation.layout.Arrangement
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
import vip.xsinfo.xslearn.xslearn.shared.components.AppCard

/**
 * 学习页面数据区
 */
@Composable
fun StudyDataSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "学习数据",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // 数据卡片
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StudyDataCard(
                title = "今日学习",
                value = "2h",
                color = AppColor.Primary,
                modifier = Modifier.weight(1f)
            )
            StudyDataCard(
                title = "本周刷题",
                value = "120道",
                color = AppColor.Secondary,
                modifier = Modifier.weight(1f)
            )
            StudyDataCard(
                title = "本月学习",
                value = "45h",
                color = AppColor.Warning,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

/**
 * 学习页面数据卡片
 */
@Composable
fun StudyDataCard(
    title: String,
    value: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    AppCard(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
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
