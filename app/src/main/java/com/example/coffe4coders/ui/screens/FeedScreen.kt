package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.example.coffe4coders.R
import com.example.coffe4coders.ui.components.BodyText
import com.example.coffe4coders.ui.components.CountryISO
import com.example.coffe4coders.ui.components.ProductCard
import com.example.coffe4coders.ui.components.TitleText
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun FeedScreen() {
    val list = listOf(
        CountryISO.COL, CountryISO.BRA, CountryISO.NIC, CountryISO.CRI
    )

    Coffe4CodersTheme {
        Surface(
            color = MaterialTheme.colors.background,
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                item { 
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        TitleText(title = "Bienvenido")
                        BodyText(body = LoremIpsum(20).values.joinToString(""))
                    }
                }
                items(list) { country ->
                    ProductCard(
                        name = stringResource(id = R.string.card_title),
                        summary = stringResource(id = R.string.card_description),
                        price = 35.0,
                        currency = "USD",
                        country = country
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun FeedScreenPreview() {
    FeedScreen()
}