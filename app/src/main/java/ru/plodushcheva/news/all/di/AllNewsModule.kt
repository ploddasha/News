package ru.plodushcheva.news.all.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.plodushcheva.news.all.data.repository.AllNewsRepositoryImpl
import ru.plodushcheva.news.all.domain.repository.AllNewsRepository
import ru.plodushcheva.news.all.domain.usecase.GetAllNewsUseCase
import ru.plodushcheva.news.all.presentation.AllNewsScreenViewModel

val allNewsModule = module {

	factory<AllNewsRepository> { AllNewsRepositoryImpl( get() ) } // api

	factory { GetAllNewsUseCase(get()) } // repository

	viewModel  { AllNewsScreenViewModel(get()) } // usecase
}