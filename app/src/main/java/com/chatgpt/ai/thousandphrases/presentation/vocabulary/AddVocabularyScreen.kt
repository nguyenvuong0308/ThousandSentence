package com.chatgpt.ai.thousandphrases.presentation.vocabulary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chatgpt.ai.thousandphrases.presentation.component.InputItem
import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import java.util.UUID

@Composable
fun AddVocabularyScreen(navController: NavController) {
    var rootVocabulary by remember { mutableStateOf(VocabularyUIModel( id = UUID.randomUUID().toString(), "", "")) }
    var listVeb by remember { mutableStateOf(listOf<VocabularyUIModel>()) }
    var listNoun by remember { mutableStateOf(listOf<VocabularyUIModel>()) }
    var listAdverb by remember { mutableStateOf(listOf<VocabularyUIModel>()) }
    val scrollState = rememberScrollState()

    Scaffold { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.padding(16.dp).verticalScroll(scrollState)) {
                Text(
                    text = "Từ gốc",
                    modifier = Modifier,
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                VocabularyItem(vocabulary = rootVocabulary)

                Text(
                    text = "Động từ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )
                
                LazyColumn(modifier = Modifier.heightIn(max = 5000.dp)) {
                    itemsIndexed(listVeb) { index, item ->
                        VocabularyItem(item)
                    }
                }

                Button(modifier = Modifier.padding(top = 16.dp).align(Alignment.End), onClick = {
                    // Thêm một VocabularyUIModel mới với id ngẫu nhiên
                    listVeb = listVeb + VocabularyUIModel(
                        id = UUID.randomUUID().toString(),
                        vi = "",
                        en = ""
                    )
                }) {
                    Text("Add")
                }


                Text(
                    text = "Danh từ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                LazyColumn (modifier = Modifier.heightIn(max = 5000.dp)){
                    itemsIndexed(listNoun) { index, item ->
                        VocabularyItem(item)
                    }
                }

                Button(modifier = Modifier.padding(top = 16.dp).align(Alignment.End), onClick = {
                    // Thêm một VocabularyUIModel mới với id ngẫu nhiên
                    listNoun = listNoun + VocabularyUIModel(
                        id = UUID.randomUUID().toString(),
                        vi = "",
                        en = ""
                    )
                }) {
                    Text("Add")
                }

                Text(
                    text = "Tính từ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                LazyColumn(modifier = Modifier.heightIn(max = 5000.dp)) {
                    itemsIndexed(listAdverb) { index, item ->
                        VocabularyItem(item)
                    }
                }

                Button(modifier = Modifier.padding(top = 16.dp).align(Alignment.End), onClick = {
                    // Thêm một VocabularyUIModel mới với id ngẫu nhiên
                    listAdverb = listAdverb + VocabularyUIModel(
                        id = UUID.randomUUID().toString(),
                        vi = "",
                        en = ""
                    )
                }) {
                    Text("Add")
                }

                Text(
                    text = "Câu ví dụ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                LazyColumn(modifier = Modifier.heightIn(max = 5000.dp)) {
                    itemsIndexed(listAdverb) { index, item ->
                        VocabularyItem(item)
                    }
                }

                Button(modifier = Modifier.padding(top = 16.dp).align(Alignment.End), onClick = {
                    // Thêm một VocabularyUIModel mới với id ngẫu nhiên
                    listAdverb = listAdverb + VocabularyUIModel(
                        id = UUID.randomUUID().toString(),
                        vi = "",
                        en = ""
                    )
                }) {
                    Text("Add")
                }

                Button(modifier = Modifier.fillMaxWidth().padding(top = 30.dp).align(Alignment.End), onClick = {
                    // Thêm một VocabularyUIModel mới với id ngẫu nhiên

                }) {
                    Text("Save")
                }
            }
        }
    }
}

@Composable
fun VocabularyItem(vocabulary: VocabularyUIModel) {
    var viText by remember { mutableStateOf(vocabulary.vi) }
    var enText by remember { mutableStateOf(vocabulary.en) }

    Spacer(modifier = Modifier.height(15.dp))

    Column {
        InputItem(
            value = viText,
            onValueChange = {
                viText = it
                vocabulary.vi = it
            },
            modifier = Modifier,
            placeHolder = "Vi"
        )

        Spacer(modifier = Modifier.height(10.dp))

        InputItem(
            value = enText,
            onValueChange = {
                enText = it
                vocabulary.en = it
            },
            modifier = Modifier,
            placeHolder = "En"
        )
    }
}

@Preview
@Composable
fun AddVocabularyScreenPreview() {
    AddVocabularyScreen(navController = NavController(LocalContext.current))
}