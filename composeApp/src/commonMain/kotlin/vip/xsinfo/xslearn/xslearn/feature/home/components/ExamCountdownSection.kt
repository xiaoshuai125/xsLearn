package vip.xsinfo.xslearn.xslearn.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor
import vip.xsinfo.xslearn.xslearn.shared.components.AppCard
import vip.xsinfo.xslearn.xslearn.shared.components.AppSecondaryText
import vip.xsinfo.xslearn.xslearn.shared.components.AppTextButton
import vip.xsinfo.xslearn.xslearn.shared.components.AppWidgetTitle

/**
 * 考试倒计时专区
 */
@Composable
fun ExamCountdownSection() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppWidgetTitle(text = "考试倒计时")
            AppTextButton(text = "设置", onClick = { /* 跳转到设置 */ })
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // 倒计时卡片
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CountdownCard(
                examName = "学位英语",
                daysLeft = 30,
                examDate = "2024-12-21",
                modifier = Modifier.weight(1f)
            )
            CountdownCard(
                examName = "考研初试",
                daysLeft = 60,
                examDate = "2025-01-15",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

/**
 * 倒计时卡片
 */
@Composable
fun CountdownCard(
    examName: String,
    daysLeft: Int,
    examDate: String,
    modifier: Modifier = Modifier
) {
    AppCard(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AppSecondaryText(text = examName)
            Text(
                text = daysLeft.toString(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor.Primary
            )
            AppSecondaryText(text = "剩余天数")
            AppSecondaryText(text = examDate)
        }
    }
}


