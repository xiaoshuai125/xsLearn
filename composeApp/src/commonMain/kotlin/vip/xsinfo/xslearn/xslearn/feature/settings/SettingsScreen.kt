package vip.xsinfo.xslearn.xslearn.feature.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import vip.xsinfo.xslearn.xslearn.core.components.AppTopBar
import vip.xsinfo.xslearn.xslearn.feature.settings.components.CountdownSettingSection
import vip.xsinfo.xslearn.xslearn.feature.settings.components.SubjectSubscriptionSection

/**
 * 设置屏幕
 */
@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // 顶部标题（固定）
        AppTopBar(title = "设置")
        
        // 设置内容（可滚动）
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, bottom = 0.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // 考试倒计时设置专区
            item {
                CountdownSettingSection()
            }
            
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
            
            // 科目订阅管理专区
            item {
                SubjectSubscriptionSection()
            }
            
            // TODO: 学习计划与偏好设置专区
            // TODO: 数据管理专区
        }
    }
}

