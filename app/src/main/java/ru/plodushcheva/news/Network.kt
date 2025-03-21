package ru.plodushcheva.news

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.plodushcheva.news.all.data.api.EverythingApi
import java.util.concurrent.TimeUnit

var logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

fun provideHttpClient(): OkHttpClient {
	return OkHttpClient
		.Builder()
		.addInterceptor(logging)
		.readTimeout(60, TimeUnit.SECONDS)
		.connectTimeout(60, TimeUnit.SECONDS)
		.build()
}


fun provideConverterFactory(): GsonConverterFactory =
	GsonConverterFactory.create()


fun provideRetrofit(
	okHttpClient: OkHttpClient,
	gsonConverterFactory: GsonConverterFactory
): Retrofit {
	return Retrofit.Builder()
		.baseUrl("https://newsapi.org/")
		.client(okHttpClient)
		.addConverterFactory(gsonConverterFactory)
		.build()
}

fun provideService(retrofit: Retrofit): EverythingApi =
	retrofit.create(EverythingApi::class.java)

val networkModule = module {
	single { provideHttpClient() }
	single { provideConverterFactory() }
	single { provideRetrofit(get(),get()) }
	single { provideService(get()) }
}