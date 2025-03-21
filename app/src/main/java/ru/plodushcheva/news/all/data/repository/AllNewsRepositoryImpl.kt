package ru.plodushcheva.news.all.data.repository

import ru.plodushcheva.news.all.data.api.EverythingApi
import ru.plodushcheva.news.all.data.model.ArticleModel
import ru.plodushcheva.news.all.domain.repository.AllNewsRepository

class AllNewsRepositoryImpl(
	private val everythingApi: EverythingApi,
): AllNewsRepository {

	override suspend fun getAllNews(apiKey: String): List<ArticleModel> {
		return everythingApi.getEverything(
			apiKey = apiKey,
			q = "bitcoin"
		).articles //TODO add converter
	}
}