package com.data.response


import com.google.gson.annotations.SerializedName

data class CategoriesItem(
    @SerializedName("items")
    val items: List<SentenceItem>,
    @SerializedName("name")
    val name: String
)