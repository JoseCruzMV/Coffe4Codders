package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.components.*
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme
import com.example.coffe4coders.utilities.MockDataProvider

@Composable
fun FeedScreen(navController: NavController) {
    val list = MockDataProvider.listOfProduct()
    Coffe4CodersTheme {
        Scaffold(
            topBar = {
                CustomAppBar(title = "Coffee4Coders")
            },
            content = {
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
                        items(list) { product ->
                            ProductCard(
                                product = product
                            ) {
                                navController.navigate(route = "Detail/${product.id}") {
                                    launchSingleTop = true
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    FeedScreen(navController = navController)
}