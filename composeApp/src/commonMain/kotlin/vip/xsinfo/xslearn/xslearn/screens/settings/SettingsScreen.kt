package vip.xsinfo.xslearn.xslearn.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import vip.xsinfo.xslearn.xslearn.screens.settings.components.CountdownSettingSection
import vip.xsinfo.xslearn.xslearn.screens.settings.components.SubjectSubscriptionSection

/**
 * 设置屏幕
 */
@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // 顶部标题
        Text(
            text = "设置",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        // 考试倒计时设置专区
        CountdownSettingSection()
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // 科目订阅管理专区
        SubjectSubscriptionSection()
        
        // TODO: 学习计划与偏好设置专区
        // TODO: 数据管理专区
    }
}

