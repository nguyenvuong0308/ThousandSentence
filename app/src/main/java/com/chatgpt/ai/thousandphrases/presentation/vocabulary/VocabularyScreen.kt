package com.chatgpt.ai.thousandphrases.presentation.vocabulary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chatgpt.ai.thousandphrases.R
import com.chatgpt.ai.thousandphrases.presentation.component.VocabularyReadItem
import com.chatgpt.ai.thousandphrases.presentation.navigateAddVocabulary
import com.chatgpt.ai.thousandphrases.presentation.navigateDetailVocabulary
import com.chatgpt.ai.thousandphrases.presentation.vocabulary.vocabulary.VocabularyViewModel
import com.chatgpt.ai.thousandphrases.presentation.vocabulary.vocabulary.VocabularyViewModelInterface
import com.chatgpt.ai.thousandphrases.presentation.vocabulary.vocabulary.VocabularyViewModelMock


@Composable
fun VocabularyScreen(
    navController: NavController,
    viewModel: VocabularyViewModelInterface = hiltViewModel<VocabularyViewModel>()
) {
    val vocabularies = viewModel.getVocabularies().collectAsState()

    Scaffold { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            Box(modifier = Modifier.fillMaxSize()) {

                Column(modifier = Modifier.fillMaxSize()) {
                    LazyColumn {
                        items(vocabularies.value) {
                            VocabularyReadItem(vocabulary = it, onSpeak = {
                                viewModel.speak(it.en)
                            }, onClickItem = {
                                navController.navigateDetailVocabulary(it.id)
                            })
                        }
                    }
                }

                Row(
                    modifier = Modifier.padding(20.dp).background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(10.dp)
                    ).clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple()
                    ) {
                        navController.navigateAddVocabulary()
                    }.clip(RoundedCornerShape(10.dp)).padding(horizontal = 10.dp, vertical = 5.dp)
                        .align(Alignment.BottomEnd),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onTertiaryContainer),
                        painter = painterResource(R.drawable.ic_add),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )

                    Text(
                        text = "Add New",
                        Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onTertiaryContainer)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun VocabularyScreenPreview() {
    VocabularyScreen(navController = NavController(LocalContext.current), viewModel = VocabularyViewModelMock())
}