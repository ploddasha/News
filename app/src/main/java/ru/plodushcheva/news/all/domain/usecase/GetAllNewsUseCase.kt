package ru.plodushcheva.news.all.domain.usecase

import android.util.Log
import ru.plodushcheva.news.BuildConfig
import ru.plodushcheva.news.all.data.model.ArticleModel
import ru.plodushcheva.news.all.domain.repository.AllNewsRepository

class GetAllNewsUseCase(
	val allNewsRepository: AllNewsRepository
) {

	suspend fun getAllNews(): List<ArticleModel> {
		return allNewsRepository.getAllNews(apiKey = BuildConfig.NEWS_API_KEY)
	}

}