package ru.plodushcheva.news.all.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.plodushcheva.news.all.presentation.AllNewsScreenState
import ru.plodushcheva.news.all.presentation.AllNewsScreenViewModel



@Composable
fun AllNewsScreen(
	allNewsScreenViewModel: AllNewsScreenViewModel,
	navController: NavController,
) {
	val uiState by allNewsScreenViewModel.uiState.collectAsState()

	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		when(uiState) {
			is AllNewsScreenState.Content -> AllNewsContent(
				uiState = uiState as AllNewsScreenState.Content
			)
			AllNewsScreenState.Error      -> ErrorComponent()
			AllNewsScreenState.Initial    -> TODO()
			AllNewsScreenState.Loading    -> CircularProgressIndicator()
		}
	}

}