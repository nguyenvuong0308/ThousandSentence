package com.chatgpt.ai.thousandphrases.presentation.detailvocabulary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chatgpt.ai.thousandphrases.presentation.component.VocabularyReadItem
import com.chatgpt.ai.thousandphrases.presentation.detailvocabulary.viewmodel.DetailVocabularyViewModel
import com.chatgpt.ai.thousandphrases.presentation.detailvocabulary.viewmodel.DetailVocabularyViewModelInterface
import com.chatgpt.ai.thousandphrases.presentation.detailvocabulary.viewmodel.DetailVocabularyViewModelMock

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
                    VocabularyReadItem(it) {

                    }
                }

                Text(
                    text = "Động từ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                LazyColumn(modifier = Modifier.heightIn(max = 5000.dp)) {
                    itemsIndexed(listVeb.value) { index, item ->
                        VocabularyReadItem(item) {

                        }
                    }
                }


                Text(
                    text = "Danh từ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                LazyColumn(modifier = Modifier.heightIn(max = 5000.dp)) {
                    itemsIndexed(listNoun.value) { index, item ->
                        VocabularyReadItem(item) {

                        }
                    }
                }

                Text(
                    text = "Tính từ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                LazyColumn(modifier = Modifier.heightIn(max = 5000.dp)) {
                    itemsIndexed(listAdverb.value) { index, item ->
                        VocabularyReadItem(item) {

                        }
                    }
                }

                Text(
                    text = "Câu ví dụ",
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                LazyColumn(modifier = Modifier.heightIn(max = 5000.dp)) {
                    itemsIndexed(sentences.value) { index, item ->
                        VocabularyReadItem(item) {

                        }
                    }
                }

            }
        }
    }
}


@Preview
@Composable
fun DetailVocabularyScreenPreview() {
    DetailVocabularyScreen(navController = NavController(LocalContext.current), rootId = 0, viewModel = DetailVocabularyViewModelMock())
}