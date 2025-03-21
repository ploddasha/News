package ru.plodushcheva.news

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.plodushcheva.news.all.di.allNewsModule

class NewsApplication : Application() {
	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidLogger()
			androidContext(this@NewsApplication)

			modules(
				networkModule,
				allNewsModule,
			)
		}
	}
}