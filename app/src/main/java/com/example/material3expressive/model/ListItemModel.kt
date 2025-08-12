package com.example.material3expressive.model

data class ListItemModel(
    val itemId: Int,
    val itemTitle: String,
    val itemDescription: String,
)

val dummyItems = List(100) {
    ListItemModel(
        itemId = it,
        itemTitle = "Title ${it + 1}",
        itemDescription = "This is the description of item ${it + 1}"
    )
}
