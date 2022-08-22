package de.gnarly.viewmodel.argument

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import de.gnarly.viewmodel.argument.details.DETAILS_ROUTE
import de.gnarly.viewmodel.argument.details.DetailsHiltViewModel
import de.gnarly.viewmodel.argument.details.DetailsScreen
import de.gnarly.viewmodel.argument.details.toNavigationRoute
import de.gnarly.viewmodel.argument.home.HOME_ROUTE
import de.gnarly.viewmodel.argument.home.HomeScreen
import de.gnarly.viewmodel.argument.ui.theme.ViewModelArgumentTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ViewModelArgumentTheme {
				Box(modifier = Modifier.padding(16.dp)) {
					val navController = rememberNavController()
					NavHost(
						navController = navController,
						startDestination = HOME_ROUTE
					) {
						composable(route = HOME_ROUTE) {
							HomeScreen {
								navController.navigate(it.toNavigationRoute())
								// DetailsActivity.start(this@MainActivity, it)
							}
						}
						composable(route = DETAILS_ROUTE) {
							DetailsScreen(viewModel = hiltViewModel<DetailsHiltViewModel>())
							// DetailsScreen(viewModel = viewModel<DetailsFlowViewModel>())
						}
					}
				}
			}
		}
	}
}
