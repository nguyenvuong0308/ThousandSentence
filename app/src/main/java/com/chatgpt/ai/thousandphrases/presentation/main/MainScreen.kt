package com.chatgpt.ai.thousandphrases.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chatgpt.ai.thousandphrases.presentation.navigateHome
import com.chatgpt.ai.thousandphrases.presentation.navigateVocabulary

@Composable
fun MainScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {

            Column(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp)) {

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier.padding(bottom = 20.dp).fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(20.dp)
                        ).clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = ripple()
                        ) {
                            navController.navigateHome()
                        }.clip(RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "1000 Câu",
                        style = MaterialTheme.typography.displayMedium.copy(color = MaterialTheme.colorScheme.onPrimaryContainer),
                        modifier = Modifier.padding(20.dp)
                    )
                }

                Box(
                    modifier = Modifier.padding(bottom = 20.dp).fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(20.dp)
                        ).clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = ripple()
                        ) {
                            navController.navigateVocabulary()
                        }.clip(RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Từ Vựng",
                        style = MaterialTheme.typography.displayMedium.copy(color = MaterialTheme.colorScheme.onPrimaryContainer),
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(navController = NavController(LocalContext.current))
}