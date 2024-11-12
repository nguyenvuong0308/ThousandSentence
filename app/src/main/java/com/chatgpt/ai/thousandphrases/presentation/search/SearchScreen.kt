package com.chatgpt.ai.thousandphrases.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chatgpt.ai.thousandphrases.R
import com.chatgpt.ai.thousandphrases.presentation.component.SentenceItem
import com.chatgpt.ai.thousandphrases.presentation.search.viewmodel.SearchViewModel
import com.chatgpt.ai.thousandphrases.presentation.search.viewmodel.SearchViewModelInterface
import com.chatgpt.ai.thousandphrases.presentation.search.viewmodel.SearchViewModelMock

@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModelInterface: SearchViewModelInterface = hiltViewModel<SearchViewModel>(),
) {

    val searchResult = searchViewModelInterface.searchResult.collectAsState()
    var textInput by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.fillMaxSize()) {
                BoxSearch(
                    onBackPress = {
                        navController.popBackStack()
                    },
                    onValueChange = { textFieldValue ->
                        textInput = textFieldValue
                        searchViewModelInterface.query(textFieldValue.text)
                    },
                    textFieldValue = textInput
                )

                LazyColumn(modifier = Modifier.weight(1f).fillMaxWidth()) {
                    items(searchResult.value) { sentence ->
                        SentenceItem(
                            sentence = sentence,
                            onSpeak = {
                                searchViewModelInterface.speak(sentence.en)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BoxSearch(
    onBackPress: () -> Unit,
    textFieldValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
) {
    Row(
        modifier = Modifier.padding(top = 10.dp).fillMaxWidth().height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_back),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = null,
            modifier = Modifier.size(32.dp).padding(4.dp).clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple()
            ) {
                onBackPress()
            }
        )

        Box(
            modifier = Modifier.weight(1f).background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(20.dp)
            ),
            contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                value = textFieldValue,
                textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSecondaryContainer),
                onValueChange = {
                    onValueChange(it)
                },
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 20.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            )

            if (textFieldValue.text.isEmpty()) {
                Text(
                    text = "Enter text...",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.5f),
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen(navController = rememberNavController(), searchViewModelInterface = SearchViewModelMock())
}