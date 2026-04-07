package vip.xsinfo.xslearn.xslearn.feature.vocabulary.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowLeft
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.viewmodel.VocabularyViewModel
import vip.xsinfo.xslearn.xslearn.core.theme.AppColor

/**
 * 背单词页面顶部导航栏
 */
@Composable
fun VocabularyTopBar(
    viewModel: VocabularyViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Button(
            onClick = { viewModel.back() },
            modifier = Modifier.size(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColor.Surface
            )
        ) {
            Icon(
                imageVector = TablerIcons.ArrowLeft,
                contentDescription = "返回",
                tint = AppColor.TextPrimary
            )
        }
        Text(
            text = "${viewModel.subjectType.displayName} - 背单词",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
