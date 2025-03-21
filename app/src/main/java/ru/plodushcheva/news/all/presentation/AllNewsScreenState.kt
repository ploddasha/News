package ru.plodushcheva.news.all.presentation

import ru.plodushcheva.news.all.data.model.ArticleModel

sealed class AllNewsScreenState {

	data object Initial : AllNewsScreenState()

	data object Loading : AllNewsScreenState()

	data object Error : AllNewsScreenState()

	data class Content(
		val articles : List<ArticleModel>
	) : AllNewsScreenState()
}