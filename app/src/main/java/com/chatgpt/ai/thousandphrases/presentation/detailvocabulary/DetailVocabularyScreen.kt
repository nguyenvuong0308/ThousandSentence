package com.chatgpt.ai.thousandphrases.presentation.detailvocabulary

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chatgpt.ai.thousandphrases.presentation.addvocabulary.VocabularyInputItem
import com.chatgpt.ai.thousandphrases.presentation.component.VocabularyReadItem
import com.chatgpt.ai.thousandphrases.presentation.detailvocabulary.viewmodel.DetailVocabularyViewModel
import com.chatgpt.ai.thousandphrases.presentation.detailvocabulary.viewmodel.DetailVocabularyViewModelInterface
import com.chatgpt.ai.thousandphrases.presentation.detailvocabulary.viewmodel.DetailVocabularyViewModelMock
import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import com.domain.VocabularyType

@Composable
fun DetailVocabularyScreen(
    navController: NavController,
    rootId: Int,
    viewModel: DetailVocabularyViewModelInterface = hiltViewModel<DetailVocabularyViewModel>(),
) {
    val rootVocabulary = viewModel.getRootVocabulary().collectAsState()
    val listVeb = viewModel.getVerbs().collectAsState()
    val listNoun = viewModel.getNouns().collectAsState()
    val listAdverb = viewModel.getAdjectives().collectAsState()
    val sentences = viewModel.getSentences().collectAsState()

    LaunchedEffect(Unit) {
        viewModel.setRootId(rootId)
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

                rootVocabulary.value?.let {
                    VocabularyReadItem(it, onSpeak = {
                        viewModel.speak(it.en)
                    })
                }

                Text(
                    text = "Động từ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                ListVocabulary(list = listVeb.value, onSpeak = {
                    viewModel.speak(it.en)
                })

                Button(modifier = Modifier.padding(top = 16.dp).align(Alignment.End), onClick = {
                    // Thêm một VocabularyUIModel mới với id ngẫu nhiên
                    viewModel.addVerb(
                        VocabularyUIModel(
                        id = 0,
                        vi = "",
                        en = "",
                        type = VocabularyType.VERB
                    )
                    )
                }) {
                    Text("Add")
                }


                Text(
                    text = "Danh từ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                ListVocabulary(list = listNoun.value, onSpeak = {
                    viewModel.speak(it.en)
                })

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

                ListVocabulary(list = listAdverb.value, onSpeak = {
                    viewModel.speak(it.en)
                })

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
                ListVocabulary(list = sentences.value, onSpeak = {
                    viewModel.speak(it.en)
                })

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

                Spacer(modifier = Modifier.height(500.dp))
            }
        }
    }
}

@Composable
fun ListVocabulary(list: List<VocabularyUIModel>, onSpeak: (VocabularyUIModel) -> Unit) {
    LazyColumn(modifier = Modifier.heightIn(max = 5000.dp)) {
        itemsIndexed(list) { index, item ->
            if(item.id != 0) {
                VocabularyReadItem(item, onSpeak = {
                    onSpeak(it)
                })
            } else {
                VocabularyInputItem(item)
            }
        }
    }
}


@Preview
@Composable
fun DetailVocabularyScreenPreview() {
    DetailVocabularyScreen(navController = NavController(LocalContext.current), rootId = 0, viewModel = DetailVocabularyViewModelMock())
}