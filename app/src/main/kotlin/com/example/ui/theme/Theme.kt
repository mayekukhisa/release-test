package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val darkColorScheme = darkColorScheme(
   primary = purple80,
   secondary = purpleGrey80,
   tertiary = pink80,
)

private val lightColorScheme = lightColorScheme(
   primary = purple40,
   secondary = purpleGrey40,
   tertiary = pink40,
   /*
    Other default colors to override:

    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun AppTheme(
   isDarkTheme: Boolean = isSystemInDarkTheme(),
   isDynamicColor: Boolean = true, // Available on Android 12+
   content: @Composable () -> Unit,
) {
   val systemUiController = rememberSystemUiController()
   val colorScheme = when {
      isDynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
         val context = LocalContext.current
         if (isDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }

      isDarkTheme -> darkColorScheme
      else -> lightColorScheme
   }

   SideEffect {
      systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = !isDarkTheme)
   }

   MaterialTheme(colorScheme = colorScheme, typography = typography, content = content)
}
