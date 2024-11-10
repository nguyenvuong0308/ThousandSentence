package com.data.response


import com.google.gson.annotations.SerializedName

data class SentenceItem(
    @SerializedName("en")
    val en: String,
    @SerializedName("vi")
    val vi: String
)