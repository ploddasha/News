package ru.plodushcheva.news.all.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.plodushcheva.news.all.domain.usecase.GetAllNewsUseCase

class AllNewsScreenViewModel(
	private val getAllNewsUseCase: GetAllNewsUseCase,
): ViewModel() {


	private var _uiState = MutableStateFlow<AllNewsScreenState>(AllNewsScreenState.Initial)
	val uiState: StateFlow<AllNewsScreenState> = _uiState.asStateFlow()

	init {
		loadNews()
	}

	private fun loadNews() {

		_uiState.update { AllNewsScreenState.Loading }

		viewModelScope.launch {
			try {
				val result = getAllNewsUseCase.getAllNews()

				_uiState.update { AllNewsScreenState.Content(articles = result) }

				Log.d("news", result.toString())

			} catch (e: Error) {
				Log.e("News", e.toString())

				_uiState.update { AllNewsScreenState.Error }
			}
		}
	}


}