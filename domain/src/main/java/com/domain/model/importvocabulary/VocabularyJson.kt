package com.domain.model.importvocabulary


import com.google.gson.annotations.SerializedName

data class VocabularyJson(
    @SerializedName("en")
    val en: String,
    @SerializedName("vi")
    val vi: String
)