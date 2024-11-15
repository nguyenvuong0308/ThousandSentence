package com.chatgpt.ai.thousandphrases.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chatgpt.ai.thousandphrases.R
import com.chatgpt.ai.thousandphrases.Utils
import com.chatgpt.ai.thousandphrases.presentation.model.RootVocabularyUIModel
import com.chatgpt.ai.thousandphrases.presentation.model.SentenceUIModel
import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import com.data.VocabularyType

@Composable
fun VocabularyReadItem(vocabulary: VocabularyUIModel,  onSpeak: (VocabularyUIModel) -> Unit = {}, onClickItem: (VocabularyUIModel) -> Unit = {}) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple()
            ) {
                onClickItem(vocabulary)
            }
            .fillMaxWidth()
            .padding(5.dp)
    ) {

        if(vocabulary is RootVocabularyUIModel) {
            val dayAgo = Utils.subDay(vocabulary.modifier)
            val colorContainer = if(dayAgo > 7) {
                MaterialTheme.colorScheme.errorContainer
            } else {
                MaterialTheme.colorScheme.primaryContainer
            }

            val color = if(dayAgo > 7) {
                MaterialTheme.colorScheme.onErrorContainer
            } else {
                MaterialTheme.colorScheme.onPrimaryContainer
            }
            Text(
                text = Utils.formatDate(vocabulary.modifier),
                modifier = Modifier.background(color = colorContainer).padding(8.dp),
                style = MaterialTheme.typography.bodySmall,
                color = color,
            )
        }

        Text(
            text = vocabulary.vi,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = vocabulary.en,
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )

            Box(modifier = Modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple()
            ) {
                onSpeak(vocabulary)
            }) {
                Image(
                    painter = painterResource(R.drawable.ic_speak),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onTertiaryContainer)
                )
            }
        }
    }
}

@Preview
@Composable
fun VocabularyReadItemPreview() {
    VocabularyReadItem(
        vocabulary = RootVocabularyUIModel(
            id = 1,
            vi = "Xin chào",
            en = "Hello",
            type = VocabularyType.NOUN,
            modifier = System.currentTimeMillis()
        ),
        onSpeak = {}
    )
}