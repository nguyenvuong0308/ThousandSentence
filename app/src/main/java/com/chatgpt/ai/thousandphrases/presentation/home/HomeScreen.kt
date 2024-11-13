package com.chatgpt.ai.thousandphrases.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chatgpt.ai.thousandphrases.R
import com.chatgpt.ai.thousandphrases.presentation.component.SentenceItem
import com.chatgpt.ai.thousandphrases.presentation.main.viewmodel.MainViewModel
import com.chatgpt.ai.thousandphrases.presentation.main.viewmodel.MainViewModelInterface
import com.chatgpt.ai.thousandphrases.presentation.main.viewmodel.MainViewModelMock
import com.chatgpt.ai.thousandphrases.presentation.navigateSearch
import com.example.compose.AppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModelInterface: MainViewModelInterface = hiltViewModel<MainViewModel>(),
) {
    val categories = viewModelInterface.getCategories().collectAsState()
    val sentences = viewModelInterface.getSentenceItems().collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Surface(modifier = modifier.padding(innerPadding)) {
            Column {

                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(sentences.value) { sentence ->
                        SentenceItem(
                            sentence = sentence,
                            onSpeak = {
                                viewModelInterface.speak(sentence.en)
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                LazyRow(modifier = Modifier.padding(horizontal = 8.dp)) {
                    items(categories.value) { category ->
                        Text(
                            text = category.name,
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .background(
                                    color = if (category.isSelected) MaterialTheme.colorScheme.primaryContainer else Color.Transparent,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clip(RoundedCornerShape(8.dp))
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = ripple()
                                ) {
                                    viewModelInterface.selectCategory(category)
                                }
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.titleMedium,
                            color = if (category.isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                HomeActionBar(
                    onBack = {
                        navController.popBackStack()
                    },
                    onSearch = {
                        navController.navigateSearch()
                    }
                )
            }
        }
    }
}

@Composable
fun HomeActionBar(onBack: () -> Unit, onSearch: () -> Unit) {
    Row(
        modifier = Modifier.padding(10.dp).fillMaxWidth().height(56.dp).padding(0.dp),
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
                onBack()
            }
        )

        Box(modifier = Modifier.fillMaxWidth().background(
            color = MaterialTheme.colorScheme.secondaryContainer,
            shape = RoundedCornerShape(30.dp)
        ).clip(RoundedCornerShape(30.dp)).clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = ripple()
        ) {
            onSearch()
        }) {
            Text(
                text = "Tìm kiếm",
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 8.dp),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Preview(name = "Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "Light Mode", showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        HomeScreen(
            navController = rememberNavController(),
            viewModelInterface = MainViewModelMock()
        )
    }
}