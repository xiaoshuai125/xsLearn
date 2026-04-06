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
import androidx.navigation.NavHostController
import compose.icons.TablerIcons
import compose.icons.tablericons.Book
import compose.icons.tablericons.Edit
import compose.icons.tablericons.FileText
import compose.icons.tablericons.Language
import vip.xsinfo.xslearn.xslearn.navigation.VOCABULARY_ROUTE
import vip.xsinfo.xslearn.xslearn.screens.study.SubjectType
import vip.xsinfo.xslearn.xslearn.screens.vocabulary.viewmodel.VocabularyViewModel
import vip.xsinfo.xslearn.xslearn.theme.AppColor

/**
 * 英语类科目专属功能模块区
 */
@Composable
fun EnglishFeatureModulesSection(
    subjectType: SubjectType,
    viewModel: VocabularyViewModel,
    onNavigateToVocabulary: () -> Unit
) {
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
                modifier = Modifier.weight(1f),
                onClick = {
                    // 设置当前科目类型
                    viewModel.subjectType = subjectType
                    // 跳转到刷单词页面
                    onNavigateToVocabulary()
                }
            )
            FeatureModuleCard(
                title = "专项刷题",
                icon = TablerIcons.Edit,
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
                title = "翻译&写作",
                icon = TablerIcons.Language,
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
