package com.domain.model.importvocabulary


import com.domain.model.VocabularyItem
import com.domain.model.WrapVocabularyItem
import com.google.gson.annotations.SerializedName

data class VocabularyFromImport(
    @SerializedName("adj")
    val adj: List<VocabularyJson>,
    @SerializedName("noun")
    val noun: List<VocabularyJson>,
    @SerializedName("sentence")
    val sentence: List<VocabularyJson>,
    @SerializedName("verb")
    val verb: List<VocabularyJson>
)

fun VocabularyJson.mapToDomain(type: Int) = VocabularyItem(
    id = 0,
    vi = vi,
    en = en,
    type = type
)
