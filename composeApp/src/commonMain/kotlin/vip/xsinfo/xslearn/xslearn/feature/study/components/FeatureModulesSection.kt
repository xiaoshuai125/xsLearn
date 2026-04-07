package vip.xsinfo.xslearn.xslearn.feature.study.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import compose.icons.tablericons.Book
import compose.icons.tablericons.Edit
import compose.icons.tablericons.FileText
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor
import vip.xsinfo.xslearn.xslearn.shared.components.AppCard

/**
 * 功能模块区
 */
@Composable
fun FeatureModulesSection() {
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
                title = "背单词",
                icon = TablerIcons.Book,
                color = AppColor.Primary,
                modifier = Modifier.weight(1f)
            )
            FeatureModuleCard(
                title = "知识点练习",
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

/**
 * 功能模块卡片
 */
@Composable
fun FeatureModuleCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { /* 功能模块点击 */ }
) {
    AppCard(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .background(color.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = color,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .align(Alignment.Center)
                )
            }
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = AppColor.TextPrimary
            )
        }
    }
}
