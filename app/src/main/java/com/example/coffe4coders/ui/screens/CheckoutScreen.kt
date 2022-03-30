package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.components.*
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun CheckoutScreen(
    navController: NavController,
    countryISO: CountryISO,
) {
    val cities = listOf(
        "Mexico City, Mexico",
        "The Havana, Cuba",
        "Cancun, Mexico"
    )
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CustomAppBar(
                navigationIcon = Icons.Filled.ArrowBack,
                navigationAction = {
                    navController.navigate("Detail/${countryISO.iso}")
                }
            )
        },
        content = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                ProductCard(
                    name = "Coffee",
                    summary = LoremIpsum(10).values.joinToString(" "),
                    price = 35.0,
                    currency = "USD",
                    country = countryISO,
                    selected = {}
                )
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    CustomTextField(
                        value = name,
                        placeholder = "Your name",
                        onValueChange = { name = it }
                    )
                    CustomTextField(
                        value = email,
                        placeholder = "Email",
                        onValueChange = { email = it }
                    )
                    CustomTextField(
                        value = phone,
                        placeholder = "Phone",
                        onValueChange = { phone = it }
                    )
                    CustomTextField(
                        value = address,
                        placeholder = "Address",
                        onValueChange = { address = it }
                    )
                    DropdownTextView(
                        suggestions = cities,
                        value = city,
                        placeholder = "City",
                        onChanceValue = {
                            city = it
                        }
                    )
                    
                    Column {
                        Row {
                            Text(
                                text = "Subtotal",
                                style = MaterialTheme.typography.caption
                            )
                            Text(
                                text = "$35.0 USD",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth(),
                            )
                        }
                        Row {
                            Text(
                                text = "Shipping",
                                style = MaterialTheme.typography.caption
                            )
                            Text(
                                text = "$10.0 USD",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth(),
                            )
                        }
                    }
                    
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "$45.0 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.Start
                        )
                        CustomButton(
                            label = "Complete deal"
                        ) {

                        }
                    }
                }
            }
        }
    )
}

@Preview(
    showBackground = true
)
@Composable
fun CheckoutScreenPreview() {
    val navController = rememberNavController()
    Coffe4CodersTheme {
        CheckoutScreen(
            navController = navController,
            countryISO = CountryISO.BRA
        )
    }
}