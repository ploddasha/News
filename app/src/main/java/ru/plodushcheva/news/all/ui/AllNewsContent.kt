package ru.plodushcheva.news.all.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.plodushcheva.news.R
import ru.plodushcheva.news.all.data.model.ArticleModel
import ru.plodushcheva.news.all.presentation.AllNewsScreenState

@Composable
fun AllNewsContent(
	uiState: AllNewsScreenState.Content
) {
	LazyColumn(
		modifier = Modifier.padding(8.dp)
	) {
		item { Text(text = stringResource(id = R.string.news)) }
		items(uiState.articles) { article ->
			ArticleCard(
				article = article
			)
		}
	}
}

@Composable
fun ArticleCard(
	article: ArticleModel
) {
	Card(
		modifier = Modifier.padding(8.dp)
	) {
		AsyncImage(
			model = ImageRequest.Builder(context = LocalContext.current).data(article.urlToImage)
				.crossfade(true).build(),
			contentDescription = stringResource(R.string.article_photo),
			contentScale = ContentScale.Crop,
			modifier = Modifier.fillMaxWidth()
		)
		Column(
			modifier = Modifier.padding(8.dp)
		) {
			Text(text = article.title)
			Text(text = article.description)
		}


	}

}