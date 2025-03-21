package ru.plodushcheva.news.all.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.plodushcheva.news.all.data.model.EverythingModel

interface EverythingApi {

	@GET("/v2/everything")
	suspend fun getEverything(
		@Query("apiKey") apiKey: String,
		@Query("q") q: String,
	): EverythingModel
}