package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.components.CountryISO

@Composable
fun DetailScreen(
    navController: NavController,
    countryISO: CountryISO
) {
    Column {
        Text(
            text = "Product from: ${countryISO.iso}",
            style = MaterialTheme.typography.body2
        )
        Button(
            onClick = {
                navController.navigate("Feed") {
                    popUpTo("Feed")
                }
            }
        ) {
             Text(text = "Back")            
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun DetailScreenPreview() {
    val navController = rememberNavController()
    DetailScreen(
        navController = navController,
        countryISO = CountryISO.BRA
    )
}