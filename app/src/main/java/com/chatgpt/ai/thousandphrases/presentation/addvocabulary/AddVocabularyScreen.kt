package com.chatgpt.ai.thousandphrases.presentation.addvocabulary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chatgpt.ai.thousandphrases.presentation.component.InputItem
import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import com.chatgpt.ai.thousandphrases.presentation.addvocabulary.viewmodel.AddVocabularyViewModel
import com.chatgpt.ai.thousandphrases.presentation.addvocabulary.viewmodel.AddVocabularyViewModelInterface
import com.data.VocabularyType

@Composable
fun AddVocabularyScreen(navController: NavController, viewModel: AddVocabularyViewModelInterface = hiltViewModel<AddVocabularyViewModel>()) {
    val rootVocabulary = viewModel.getRootVocabulary().collectAsState()
    val listVeb = viewModel.getVerbs().collectAsState()
    val listNoun = viewModel.getNouns().collectAsState()
    val listAdverb = viewModel.getAdjectives().collectAsState()
    val sentences = viewModel.getSentences().collectAsState()
    val saveState = viewModel.getSaveState().collectAsState()

    LaunchedEffect(saveState.value) {
        if (saveState.value.data == true) {
            navController.popBackStack()
        }
    }
    val scrollState = rememberScrollState()

    Scaffold { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.padding(16.dp).verticalScroll(scrollState)) {
                Text(
                    text = "Từ gốc",
                    modifier = Modifier,
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                VocabularyInputItem(vocabulary = rootVocabulary.value)

                Text(
                    text = "Động từ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )
                
                LazyColumn(modifier = Modifier.heightIn(max = 5000.dp)) {
                    itemsIndexed(listVeb.value) { index, item ->
                        VocabularyInputItem(item)
                    }
                }

                Button(modifier = Modifier.padding(top = 16.dp).align(Alignment.End), onClick = {
                    // Thêm một VocabularyUIModel mới với id ngẫu nhiên
                    viewModel.addVerb(VocabularyUIModel(
                        id = 0,
                        vi = "",
                        en = "",
                        type = VocabularyType.VERB
                    ))
                }) {
                    Text("Add")
                }


                Text(
                    text = "Danh từ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                LazyColumn (modifier = Modifier.heightIn(max = 5000.dp)){
                    itemsIndexed(listNoun.value) { index, item ->
                        VocabularyInputItem(item)
                    }
                }

                Button(modifier = Modifier.padding(top = 16.dp).align(Alignment.End), onClick = {
                    // Thêm một VocabularyUIModel mới với id ngẫu nhiên
                    viewModel.addNoun(VocabularyUIModel(
                        id = 0,
                        vi = "",
                        en = "",
                        type = VocabularyType.NOUN
                    ))
                }) {
                    Text("Add")
                }

                Text(
                    text = "Tính từ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                LazyColumn(modifier = Modifier.heightIn(max = 5000.dp)) {
                    itemsIndexed(listAdverb.value) { index, item ->
                        VocabularyInputItem(item)
                    }
                }

                Button(modifier = Modifier.padding(top = 16.dp).align(Alignment.End), onClick = {
                    // Thêm một VocabularyUIModel mới với id ngẫu nhiên
                    viewModel.addAdjective(VocabularyUIModel(
                        id = 0,
                        vi = "",
                        en = "",
                        type = VocabularyType.ADJECTIVE
                    ))
                }) {
                    Text("Add")
                }

                Text(
                    text = "Câu ví dụ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                LazyColumn(modifier = Modifier.heightIn(max = 5000.dp)) {
                    itemsIndexed(sentences.value) { index, item ->
                        VocabularyInputItem(item)
                    }
                }

                Button(modifier = Modifier.padding(top = 16.dp).align(Alignment.End), onClick = {
                    // Thêm một VocabularyUIModel mới với id ngẫu nhiên
                    viewModel.addSentence(VocabularyUIModel(
                        id = 0,
                        vi = "",
                        en = "",
                        type = VocabularyType.SENTENCE
                    ))
                }) {
                    Text("Add")
                }

                Button(modifier = Modifier.fillMaxWidth().padding(top = 30.dp).align(Alignment.End), onClick = {
                    // Thêm một VocabularyUIModel mới với id ngẫu nhiên
                    viewModel.save()
                }) {
                    Text("Save")
                }
            }
        }
    }
}

@Composable
fun VocabularyInputItem(vocabulary: VocabularyUIModel) {
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