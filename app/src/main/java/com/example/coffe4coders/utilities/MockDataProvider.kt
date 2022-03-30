package com.example.coffe4coders.utilities

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.coffe4coders.models.Product

class MockDataProvider {
    companion object {
        fun listOfProduct(): List<Product>{
            return listOf(
                Product(
                    id = 0,
                    name = "Coffee from Colombia",
                    summary = LoremIpsum(10).values.joinToString(" "),
                    description = LoremIpsum(20).values.joinToString(" "),
                    price = 35.0,
                    currency = "USD",
                    countryISO = "COL"
                ),
                Product(
                    id = 1,
                    name = "Coffee from Costa Rica",
                    summary = LoremIpsum(10).values.joinToString(" "),
                    description = LoremIpsum(20).values.joinToString(" "),
                    price = 35.0,
                    currency = "USD",
                    countryISO = "CRI"
                ),
                Product(
                    id = 2,
                    name = "Coffee from Nicaragua",
                    summary = LoremIpsum(10).values.joinToString(" "),
                    description = LoremIpsum(20).values.joinToString(" "),
                    price = 25.0,
                    currency = "USD",
                    countryISO = "NIC"
                ),
                Product(
                    id = 3,
                    name = "Coffee from Brazil",
                    summary = LoremIpsum(10).values.joinToString(" "),
                    description = LoremIpsum(20).values.joinToString(" "),
                    price = 38.0,
                    currency = "USD",
                    countryISO = "BRA"
                )
            )
        }

        fun listOfCities(): List<String>{
            return listOf(
                "Ciudad de Mexico, Mexico",
                "La Havana, Cuba",
                "Medellin, Colombia",
                "Buenos Aires, Argentina",
                "Sao Pablo, Brazil",
                "Lima, Peru",
                "Montevideo, Uruguay",
                "Ciudad de Panama, Panama"
            )
        }

        fun getProductById(id: Int): Product? {
            return listOfProduct().find { it.id == id }
        }
    }
}