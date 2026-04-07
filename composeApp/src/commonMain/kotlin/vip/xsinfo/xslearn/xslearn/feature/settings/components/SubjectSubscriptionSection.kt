package vip.xsinfo.xslearn.xslearn.feature.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vip.xsinfo.xslearn.xslearn.shared.components.AppCard

/**
 * 科目订阅管理专区
 */
@Composable
fun SubjectSubscriptionSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "科目订阅管理",
                style = androidx.compose.material3.MaterialTheme.typography.headlineSmall
            )
            Button(onClick = { /* 批量操作 */ }) {
                Text("批量操作")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 科目列表
        val subjects = listOf(
            "学位英语", "考研英语二", "考研数学二", "考研政治", "数据结构", "计算机组成原理", "操作系统", "计算机网络"
        )
        
        subjects.forEach { subject ->
            var isSubscribed by remember { mutableStateOf(true) }
            SubjectItemCard(subject, isSubscribed) { isSubscribed = it }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

/**
 * 科目项卡片
 */
@Composable
fun SubjectItemCard(
    subject: String,
    isSubscribed: Boolean,
    onSubscribeChange: (Boolean) -> Unit
) {
    AppCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = subject,
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
            )
            Switch(
                checked = isSubscribed,
                onCheckedChange = onSubscribeChange
            )
        }
    }
}
