package com.example.material3expressive.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.material3expressive.model.dummyItems

@Composable
fun Screen1Ui(modifier: Modifier = Modifier, onNextClicked: (Int) -> Unit) {

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = dummyItems,
            key = { item -> item.itemId }
        ) { item ->
            Row(
                modifier = Modifier.clickable { onNextClicked(item.itemId) }
            ) {
                Text(
                    modifier = Modifier.weight(0.3f),
                    fontWeight = FontWeight.SemiBold,
                    text = "${item.itemId + 1}"
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.itemTitle
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.itemDescription,
                )
            }
        }
    }
}
