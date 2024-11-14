package com.chatgpt.ai.thousandphrases.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun InputItem(
    modifier: Modifier,
    index: Int,
    textFieldValue: TextFieldValue,
    onValueChange: (Int, TextFieldValue) -> Unit,
) {
    var reIndex by rememberSaveable { mutableStateOf(index) }
    BasicTextField(
        modifier = modifier.fillMaxWidth().background(
            color = MaterialTheme.colorScheme.secondaryContainer,
            shape = RoundedCornerShape(30.dp)
        ).padding(horizontal = 15.dp, vertical = 8.dp),
        value = textFieldValue,
        onValueChange = {
            onValueChange(reIndex, it)
        },
        cursorBrush = SolidColor(LocalContentColor.current),
        textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSecondaryContainer),
    )
}