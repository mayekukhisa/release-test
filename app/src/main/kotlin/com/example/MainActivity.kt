package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      WindowCompat.setDecorFitsSystemWindows(window, /* decorFitsSystemWindows = */ false)

      setContent {
         AppTheme {
            MainScreen()
         }
      }
   }
}

@Composable
fun MainScreen() {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .background(color = MaterialTheme.colorScheme.background),
      contentAlignment = Alignment.Center,
   ) {
      Text(
         text = "Catchphrase 😎",
         color = MaterialTheme.colorScheme.onBackground,
         style = MaterialTheme.typography.headlineMedium,
      )
   }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
   AppTheme {
      MainScreen()
   }
}
