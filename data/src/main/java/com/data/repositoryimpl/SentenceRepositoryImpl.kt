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
import javax.inject.Inject

class SentenceRepositoryImpl @Inject constructor(@ApplicationContext var context: Context) :
    SentenceRepository {
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
}