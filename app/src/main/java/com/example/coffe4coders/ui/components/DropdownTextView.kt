package com.example.coffe4coders.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun DropdownTextView(
    suggestions: List<String>,
    value : String,
    placeholder: String,
    onChanceValue: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = Icons.Filled.ArrowDropDown

    Column {
        CustomTextField(
            value = value,
            placeholder = placeholder,
            onValueChange = onChanceValue,
            enabled = false,
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        expanded = !expanded
                    }
                )
            },
            onGloballyPositioned = { coordinates ->
                textFieldSize = coordinates.size.toSize()
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current) {
                textFieldSize.width.toDp()
            })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                        expanded = !expanded
                        onChanceValue(label)
                    }
                ) {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.body2
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
fun DropdownTextViewPreview() {
    val cities = listOf(
        "Mexico City, Mexico",
        "The Havana, Cuba",
        "Cancun, Mexico"
    )
    Coffe4CodersTheme {
        DropdownTextView(
            suggestions = cities,
            value = "",
            placeholder = "Cities",
            onChanceValue = {}
        )
    }
}