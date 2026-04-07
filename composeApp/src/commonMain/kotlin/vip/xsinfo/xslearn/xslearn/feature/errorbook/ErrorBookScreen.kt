package vip.xsinfo.xslearn.xslearn.feature.errorbook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import vip.xsinfo.xslearn.xslearn.core.components.AppTopBar
import vip.xsinfo.xslearn.xslearn.feature.errorbook.components.FilterSection
import vip.xsinfo.xslearn.xslearn.feature.errorbook.components.ErrorListSection
import vip.xsinfo.xslearn.xslearn.shared.components.AppCard

/**
 * 错题本屏幕
 * 包含：顶部标题、筛选卡片、错题列表、核心操作功能
 */
@Composable
fun ErrorBookScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // 顶部标题（固定）
        AppTopBar(title = "错题本")
        
        // 内容区域
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 筛选条件卡片
            AppCard {
                FilterSection()
            }
            
            // 错题列表
            ErrorListSection()
        }
    }
}

