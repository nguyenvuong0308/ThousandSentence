package com.data.repositoryimpl

import android.content.Context
import com.data.response.Categories
import com.domain.ResultData
import com.domain.model.CategoryModel
import com.domain.model.SentenceModel
import com.domain.repository.SentenceRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.text.Normalizer
import javax.inject.Inject

class SentenceRepositoryImpl @Inject constructor(@ApplicationContext var context: Context) :
    SentenceRepository {
    private val sentences = arrayListOf<SentenceModel>()

    init {
        val json = context.assets.open("thousand.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val categories = gson.fromJson(json, Categories::class.java)

        categories.forEach {
            sentences.addAll(it.items.map {
                SentenceModel(
                    id = it.vi,
                    vi = it.vi,
                    en = it.en
                )
            })
        }

        sentences.sortBy { it.en }
    }

    override fun getCategoriesSentence(): Flow<ResultData<List<CategoryModel>>> = flow {
        val json = context.assets.open("thousand.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val categories = gson.fromJson(json, Categories::class.java)

        val categoriesModel = categories.map {
            CategoryModel(
                id = it.name,
                name = it.name,
                sentenceItems = it.items.map { item ->
                    SentenceModel(
                        id = item.vi,
                        vi = item.vi,
                        en = item.en
                    )
                })
        }

        emit(ResultData.Success(categoriesModel))
    }

    override fun querySentence(query: String): Flow<ResultData<List<SentenceModel>>> = flow {
        if (query.isEmpty()) {
            emit(ResultData.Success(sentences))
            return@flow
        }
        val lQuery = removeAccents(query)
        emit(ResultData.Success(sentences.filter {
            removeAccents(it.vi).contains(
                lQuery,
                ignoreCase = true
            ) || removeAccents(it.en).contains(lQuery, ignoreCase = true)
        }))
    }

    // Function to remove accents from a string
    fun removeAccents(input: String): String {
        val normalized = Normalizer.normalize(input, Normalizer.Form.NFD)
        val noDiacritics =  normalized.replace(Regex("\\p{InCombiningDiacriticalMarks}+"), "")

        return noDiacritics
            .replace("Đ", "D").replace("đ", "d")
    }
}