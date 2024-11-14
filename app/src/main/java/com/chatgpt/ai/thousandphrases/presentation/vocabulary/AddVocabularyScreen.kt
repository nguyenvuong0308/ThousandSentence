package com.chatgpt.ai.thousandphrases.presentation.vocabulary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chatgpt.ai.thousandphrases.presentation.component.InputItem
import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel

@Composable
fun AddVocabularyScreen(navController: NavController) {
    val listVeb = arrayListOf(VocabularyUIModel("1", "vi", "en"))
    Scaffold { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            Column {
                Text(
                    text = "Từ gốc",
                    modifier = Modifier,
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )



                LazyColumn {
                    itemsIndexed(listVeb) { index, item ->
                        InputItem(
                            index = index,
                            modifier = Modifier.padding(top = 10.dp),
                            textFieldValue = textFields[index],
                            onValueChange = { i, text ->
                                textFields[i] = text
                            })
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AddVocabularyScreenPreview() {
    AddVocabularyScreen(navController = NavController(LocalContext.current))
}