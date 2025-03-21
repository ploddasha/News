package ru.plodushcheva.news.all.domain.repository

import ru.plodushcheva.news.all.data.model.ArticleModel

interface AllNewsRepository {

	suspend fun getAllNews(apiKey: String): List<ArticleModel> //TODO model to entity
}