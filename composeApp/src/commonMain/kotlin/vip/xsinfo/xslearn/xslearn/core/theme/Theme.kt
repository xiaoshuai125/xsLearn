package vip.xsinfo.xslearn.xslearn.core.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
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
        darkColorScheme(
            primary = AppColor.Primary,
            primaryContainer = AppColor.PrimaryLight,
            secondary = AppColor.Secondary,
            secondaryContainer = AppColor.SecondaryLight,
            background = Color.Transparent,
            surface = AppColor.Surface,
            error = AppColor.Error,
            onPrimary = AppColor.White,
            onSecondary = AppColor.White,
            onBackground = AppColor.TextPrimary,
            onSurface = AppColor.TextPrimary,
            onError = AppColor.White
        )
    } else {
        lightColorScheme(
            primary = AppColor.Primary,
            primaryContainer = AppColor.PrimaryLight,
            secondary = AppColor.Secondary,
            secondaryContainer = AppColor.SecondaryLight,
            background = Color.Transparent,
            surface = AppColor.Surface,
            error = AppColor.Error,
            onPrimary = AppColor.White,
            onSecondary = AppColor.White,
            onBackground = AppColor.TextPrimary,
            onSurface = AppColor.TextPrimary,
            onError = AppColor.White
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography(),
        content = content
    )
}

/**
 * 应用Typography
 */
@Composable
fun AppTypography(): Typography {
    val defaultFontFamily = FontFamily(
        org.jetbrains.compose.resources.Font(
            Res.font.DouyinSansBold
        )
    )

    return Typography(
        bodySmall = MaterialTheme.typography.bodySmall.copy(
            fontFamily = defaultFontFamily,
            fontSize = 12.sp,
            color = AppColor.TextSecondary
        ),
        bodyMedium = MaterialTheme.typography.bodyMedium.copy(
            fontFamily = defaultFontFamily,
            fontSize = 14.sp,
            color = AppColor.TextPrimary
        ),
        bodyLarge = MaterialTheme.typography.bodyLarge.copy(
            fontFamily = defaultFontFamily,
            fontSize = 16.sp,
            color = AppColor.TextPrimary
        ),
        titleSmall = MaterialTheme.typography.titleSmall.copy(
            fontFamily = defaultFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary
        ),
        titleMedium = MaterialTheme.typography.titleMedium.copy(
            fontFamily = defaultFontFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary
        ),
        titleLarge = MaterialTheme.typography.titleLarge.copy(
            fontFamily = defaultFontFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary
        ),
        headlineSmall = MaterialTheme.typography.headlineSmall.copy(
            fontFamily = defaultFontFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary
        ),
        headlineMedium = MaterialTheme.typography.headlineMedium.copy(
            fontFamily = defaultFontFamily,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary
        ),
        headlineLarge = MaterialTheme.typography.headlineLarge.copy(
            fontFamily = defaultFontFamily,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.TextPrimary
        ),
    )
}
