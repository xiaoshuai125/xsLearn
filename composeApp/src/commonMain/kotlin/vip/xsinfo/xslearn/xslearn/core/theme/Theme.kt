package vip.xsinfo.xslearn.xslearn.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import xslearn.composeapp.generated.resources.DouyinSansBold
import xslearn.composeapp.generated.resources.Res

/**
 * 应用主题
 */
@Composable
fun AppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme()
    } else {
        lightColorScheme()
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = HTypography(),
        content = content
    )
}

/**
 * 自定义Typography
 */
@Composable
fun HTypography(): Typography {
    val defaultFontFamily = FontFamily(
        org.jetbrains.compose.resources.Font(
            Res.font.DouyinSansBold
        )
    )

    return Typography(
        bodySmall = MaterialTheme.typography.bodySmall.copy(
            fontFamily = defaultFontFamily,
        ),
        bodyMedium = MaterialTheme.typography.bodyMedium.copy(
            fontFamily = defaultFontFamily,
        ),
        bodyLarge = MaterialTheme.typography.bodyLarge.copy(
            fontFamily = defaultFontFamily,
            //fontWeight = FontWeight.Bold,
        ),
        titleSmall = MaterialTheme.typography.titleSmall.copy(
            fontFamily = defaultFontFamily,
        ),
        titleMedium = MaterialTheme.typography.titleMedium.copy(
            fontFamily = defaultFontFamily,
        ),
        titleLarge = MaterialTheme.typography.titleLarge.copy(
            fontFamily = defaultFontFamily,
        ),
        headlineSmall = MaterialTheme.typography.headlineSmall.copy(
            fontFamily = defaultFontFamily,
        ),
        headlineMedium = MaterialTheme.typography.headlineMedium.copy(
            fontFamily = defaultFontFamily,
        ),
        headlineLarge = MaterialTheme.typography.headlineLarge.copy(
            fontFamily = defaultFontFamily,
        ),
    )
}
