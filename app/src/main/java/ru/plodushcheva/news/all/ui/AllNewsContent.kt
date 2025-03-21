package ru.plodushcheva.news.all.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.plodushcheva.news.all.presentation.AllNewsScreenState

@Composable
fun AllNewsContent(
	uiState: AllNewsScreenState.Content
) {
	Text(text = "Content")
}