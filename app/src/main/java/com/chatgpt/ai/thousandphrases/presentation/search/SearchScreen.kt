package com.chatgpt.ai.thousandphrases.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chatgpt.ai.thousandphrases.R

@Composable
fun SearchScreen(navController: NavController) {
    var textInput by remember { mutableStateOf(TextFieldValue("Enter name")) }
    Scaffold { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            Row(modifier = Modifier.fillMaxWidth().height(56.dp)) {
                Image(
                    painter = painterResource(R.drawable.ic_back),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp).padding(4.dp).clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple()
                    ) {
                        navController.popBackStack()
                    }
                )

                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    BasicTextField(
                        value = textInput,
                        onValueChange = {
                            textInput = it
                        },
                        modifier = Modifier.fillMaxWidth().background(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            shape = RoundedCornerShape(20.dp)
                        ).padding(horizontal = 15.dp, vertical = 10.dp)
                    ) { innerTextField ->
                    }
                }
            }


        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen(navController = rememberNavController())
}