package com.chatgpt.ai.thousandphrases.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InputItem(
    modifier: Modifier,
    value: String,
    placeHolder: String?= null,
    onValueChange: (String) -> Unit,
) {
    Box(modifier, contentAlignment = Alignment.CenterStart) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(horizontal = 15.dp, vertical = 8.dp),
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            cursorBrush = SolidColor(LocalContentColor.current),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSecondaryContainer),
        )
        if (value.isEmpty()) {
            Text(
                text = placeHolder?: "Enter text",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.5f)
                ),
                modifier = Modifier.padding(start = 15.dp)
            )
        }
    }

}

@Preview
@Composable
fun InputItemPreview() {
    InputItem(modifier = Modifier.fillMaxWidth(), value = "", onValueChange = {})
}