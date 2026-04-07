package vip.xsinfo.xslearn.xslearn.feature.errorbook

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
import vip.xsinfo.xslearn.xslearn.feature.errorbook.components.FilterSection
import vip.xsinfo.xslearn.xslearn.feature.errorbook.components.ErrorListSection

/**
 * 错题本屏幕
 * 包含：顶部筛选栏、错题列表、核心操作功能
 */
@Composable
fun ErrorBookScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // 顶部标题和筛选栏（固定）
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            // 顶部标题
            Text(
                text = "错题本",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            // 顶部筛选栏
            FilterSection()
            
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        // 错题列表（可滚动）
        ErrorListSection()
    }
}

