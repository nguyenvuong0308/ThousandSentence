package com.example.compose
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.chatgpt.ai.thousandphrases.ui.theme.AppTypography
import com.chatgpt.ai.thousandphrases.ui.theme.backgroundDark
import com.chatgpt.ai.thousandphrases.ui.theme.backgroundDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.backgroundDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.backgroundLight
import com.chatgpt.ai.thousandphrases.ui.theme.backgroundLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.backgroundLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.errorContainerDark
import com.chatgpt.ai.thousandphrases.ui.theme.errorContainerDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.errorContainerDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.errorContainerLight
import com.chatgpt.ai.thousandphrases.ui.theme.errorContainerLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.errorContainerLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.errorDark
import com.chatgpt.ai.thousandphrases.ui.theme.errorDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.errorDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.errorLight
import com.chatgpt.ai.thousandphrases.ui.theme.errorLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.errorLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.inverseOnSurfaceDark
import com.chatgpt.ai.thousandphrases.ui.theme.inverseOnSurfaceDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.inverseOnSurfaceLight
import com.chatgpt.ai.thousandphrases.ui.theme.inverseOnSurfaceLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.inverseOnSurfaceLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.inversePrimaryDark
import com.chatgpt.ai.thousandphrases.ui.theme.inversePrimaryDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.inversePrimaryDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.inversePrimaryLight
import com.chatgpt.ai.thousandphrases.ui.theme.inversePrimaryLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.inversePrimaryLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.inverseSurfaceDark
import com.chatgpt.ai.thousandphrases.ui.theme.inverseSurfaceDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.inverseSurfaceDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.inverseSurfaceLight
import com.chatgpt.ai.thousandphrases.ui.theme.inverseSurfaceLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.inverseSurfaceLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onBackgroundDark
import com.chatgpt.ai.thousandphrases.ui.theme.onBackgroundDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onBackgroundDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onBackgroundLight
import com.chatgpt.ai.thousandphrases.ui.theme.onBackgroundLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onBackgroundLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onErrorContainerDark
import com.chatgpt.ai.thousandphrases.ui.theme.onErrorContainerDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onErrorContainerDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onErrorContainerLight
import com.chatgpt.ai.thousandphrases.ui.theme.onErrorContainerLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onErrorContainerLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onErrorDark
import com.chatgpt.ai.thousandphrases.ui.theme.onErrorDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onErrorDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onErrorLight
import com.chatgpt.ai.thousandphrases.ui.theme.onErrorLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onErrorLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onPrimaryContainerDark
import com.chatgpt.ai.thousandphrases.ui.theme.onPrimaryContainerDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onPrimaryContainerDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onPrimaryContainerLight
import com.chatgpt.ai.thousandphrases.ui.theme.onPrimaryContainerLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onPrimaryContainerLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onPrimaryDark
import com.chatgpt.ai.thousandphrases.ui.theme.onPrimaryDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onPrimaryDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onPrimaryLight
import com.chatgpt.ai.thousandphrases.ui.theme.onPrimaryLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onPrimaryLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSecondaryContainerDark
import com.chatgpt.ai.thousandphrases.ui.theme.onSecondaryContainerDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSecondaryContainerDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSecondaryContainerLight
import com.chatgpt.ai.thousandphrases.ui.theme.onSecondaryContainerLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSecondaryContainerLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSecondaryDark
import com.chatgpt.ai.thousandphrases.ui.theme.onSecondaryDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSecondaryDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSecondaryLight
import com.chatgpt.ai.thousandphrases.ui.theme.onSecondaryLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSecondaryLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSurfaceDark
import com.chatgpt.ai.thousandphrases.ui.theme.onSurfaceDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSurfaceDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSurfaceLight
import com.chatgpt.ai.thousandphrases.ui.theme.onSurfaceLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSurfaceLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSurfaceVariantDark
import com.chatgpt.ai.thousandphrases.ui.theme.onSurfaceVariantDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSurfaceVariantDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSurfaceVariantLight
import com.chatgpt.ai.thousandphrases.ui.theme.onSurfaceVariantLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onSurfaceVariantLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onTertiaryContainerDark
import com.chatgpt.ai.thousandphrases.ui.theme.onTertiaryContainerDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onTertiaryContainerDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onTertiaryContainerLight
import com.chatgpt.ai.thousandphrases.ui.theme.onTertiaryContainerLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onTertiaryContainerLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onTertiaryDark
import com.chatgpt.ai.thousandphrases.ui.theme.onTertiaryDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onTertiaryDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onTertiaryLight
import com.chatgpt.ai.thousandphrases.ui.theme.onTertiaryLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.onTertiaryLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.outlineDark
import com.chatgpt.ai.thousandphrases.ui.theme.outlineDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.outlineDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.outlineLight
import com.chatgpt.ai.thousandphrases.ui.theme.outlineLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.outlineLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.outlineVariantDark
import com.chatgpt.ai.thousandphrases.ui.theme.outlineVariantDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.outlineVariantDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.outlineVariantLight
import com.chatgpt.ai.thousandphrases.ui.theme.outlineVariantLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.outlineVariantLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.primaryContainerDark
import com.chatgpt.ai.thousandphrases.ui.theme.primaryContainerDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.primaryContainerDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.primaryContainerLight
import com.chatgpt.ai.thousandphrases.ui.theme.primaryContainerLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.primaryContainerLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.primaryDark
import com.chatgpt.ai.thousandphrases.ui.theme.primaryDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.primaryDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.primaryLight
import com.chatgpt.ai.thousandphrases.ui.theme.primaryLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.primaryLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.scrimDark
import com.chatgpt.ai.thousandphrases.ui.theme.scrimDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.scrimDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.scrimLight
import com.chatgpt.ai.thousandphrases.ui.theme.scrimLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.scrimLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.secondaryContainerDark
import com.chatgpt.ai.thousandphrases.ui.theme.secondaryContainerDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.secondaryContainerDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.secondaryContainerLight
import com.chatgpt.ai.thousandphrases.ui.theme.secondaryContainerLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.secondaryContainerLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.secondaryDark
import com.chatgpt.ai.thousandphrases.ui.theme.secondaryDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.secondaryDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.secondaryLight
import com.chatgpt.ai.thousandphrases.ui.theme.secondaryLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.secondaryLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceBrightDark
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceBrightDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceBrightDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceBrightLight
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceBrightLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceBrightLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerDark
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerHighDark
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerHighDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerHighDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerHighLight
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerHighLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerHighLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerHighestDark
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerHighestDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerHighestLight
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerHighestLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerHighestLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLight
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLowDark
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLowDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLowDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLowLight
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLowLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLowLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLowestDark
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLowestDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLowestLight
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLowestLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceContainerLowestLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceDark
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceDimDark
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceDimDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceDimDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceDimLight
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceDimLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceDimLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceLight
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceVariantDark
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceVariantDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceVariantDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceVariantLight
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceVariantLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.surfaceVariantLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.tertiaryContainerDark
import com.chatgpt.ai.thousandphrases.ui.theme.tertiaryContainerDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.tertiaryContainerDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.tertiaryContainerLight
import com.chatgpt.ai.thousandphrases.ui.theme.tertiaryContainerLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.tertiaryContainerLightMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.tertiaryDark
import com.chatgpt.ai.thousandphrases.ui.theme.tertiaryDarkHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.tertiaryDarkMediumContrast
import com.chatgpt.ai.thousandphrases.ui.theme.tertiaryLight
import com.chatgpt.ai.thousandphrases.ui.theme.tertiaryLightHighContrast
import com.chatgpt.ai.thousandphrases.ui.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      /*dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }*/
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

