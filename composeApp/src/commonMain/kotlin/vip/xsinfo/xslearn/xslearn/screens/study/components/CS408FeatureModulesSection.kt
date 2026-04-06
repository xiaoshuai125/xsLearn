package vip.xsinfo.xslearn.xslearn.screens.study.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import compose.icons.tablericons.Book
import compose.icons.tablericons.Edit
import compose.icons.tablericons.FileText
import vip.xsinfo.xslearn.xslearn.theme.AppColor

/**
 * 408专业类科目专属功能模块区
 */
@Composable
fun CS408FeatureModulesSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "功能模块",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // 功能模块网格
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FeatureModuleCard(
                title = "知识点专项",
                icon = TablerIcons.Book,
                color = AppColor.Primary,
                modifier = Modifier.weight(1f)
            )
            FeatureModuleCard(
                title = "考点速记",
                icon = TablerIcons.Book,
                color = AppColor.Secondary,
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FeatureModuleCard(
                title = "专项练习",
                icon = TablerIcons.Edit,
                color = AppColor.Warning,
                modifier = Modifier.weight(1f)
            )
            FeatureModuleCard(
                title = "套卷模考",
                icon = TablerIcons.FileText,
                color = AppColor.Info,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
