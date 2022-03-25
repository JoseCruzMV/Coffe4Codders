package com.example.coffe4coders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffe4coders.R
import com.example.coffe4coders.ui.theme.PlatziBlue

@Composable
fun ProductCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {}
            .size(480.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.small,
    ) {
        Image(
            painter = painterResource(id = R.drawable.co),
            contentDescription = stringResource(id = R.string.card_title)
        )
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = PlatziBlue.copy(alpha = 0.2F)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = stringResource(id = R.string.card_title))
                Text(text = stringResource(id = R.string.card_description))
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.flagco),
                            contentDescription = stringResource(id = R.string.card_image_description),
                        )
                        Text(
                            text = "$ 35 USD",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun ProductCardPreview() {
    ProductCard()
}
