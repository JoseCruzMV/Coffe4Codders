package com.example.coffe4coders.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun BodyText(body: String) {
    Text(
        text = body,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Justify,
    )
}

@Preview(
    showBackground = true
)
@Composable
fun BodyTextPreview() {
    Coffe4CodersTheme {
        BodyText(body = LoremIpsum(20).values.joinToString(" "))
    }
}