package ru.plodushcheva.news.all.data.model

import kotlinx.serialization.Serializable

@Serializable
data class EverythingModel(
	val status: String,
	val totalResult: Int,
	val articles: List<ArticleModel>, //TODO message
)

@Serializable
data class ArticleModel(
	val source: SourceModel,
	val author: String,
	val title: String,
	val description: String,
	val url: String,
	val urlToImage: String,
	val publishedAt: String,
	val content: String,
)

data class SourceModel(
	val id: String,
	val name: String,
)
