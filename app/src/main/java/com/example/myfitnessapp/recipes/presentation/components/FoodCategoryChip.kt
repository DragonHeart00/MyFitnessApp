package com.example.myfitnessapp.recipes.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp


@Composable
fun FoodCategoryChip(
    category: String,
    isSelected: Boolean = false,
    onExecuteSearch: () -> Unit,
    onSelectedCategoryChanged: (String) -> Unit
) {
    Surface(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.large,
        color = if (isSelected) Color.Cyan else Color.Blue
    ) {
        Row(
            modifier = Modifier
                .toggleable(
                    value = isSelected,
                    onValueChange = {
                        onSelectedCategoryChanged(category)
                        onExecuteSearch()
                    }
                )
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.button,
                color = if (isSelected) Black else MaterialTheme.colors.onPrimary,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}