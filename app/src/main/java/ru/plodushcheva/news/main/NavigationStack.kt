package ru.plodushcheva.news.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.plodushcheva.news.all.ui.AllNewsScreen

import org.koin.androidx.compose.koinViewModel


@Composable
fun NavigationStack() {
	val navController = rememberNavController()

	NavHost(navController = navController, startDestination = Screen.Main.route) {
		composable(route = Screen.Main.route) {
			AllNewsScreen(
				allNewsScreenViewModel = koinViewModel(),
				navController = navController,
			)
		}

		/*composable(
			route = Screen.Detail.route + "?text={text}",
			arguments = listOf(
				navArgument("text") {
					type = NavType.StringType
					nullable = true
				}
			)
		) {
			DetailScreen(text = it.arguments?.getString("text"))
		}*/
	}
}