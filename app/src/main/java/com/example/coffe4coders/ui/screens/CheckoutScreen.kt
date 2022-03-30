package com.example.coffe4coders.ui.screens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffe4coders.ui.components.CustomTextField
import com.example.coffe4coders.ui.components.DropdownTextView
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun CheckoutScreen() {
    val cities = listOf(
        "Mexico City, Mexico",
        "The Havana, Cuba",
        "Cancun, Mexico"
    )
    var city by remember { mutableStateOf("") }

    DropdownTextView(
        suggestions = cities,
        value = city,
        placeholder = "City",
        onChanceValue = {
            city = it
        }
    )
}

@Preview(
    showBackground = true
)
@Composable
fun CheckoutScreenPreview() {
    Coffe4CodersTheme {
        CheckoutScreen()
    }
}