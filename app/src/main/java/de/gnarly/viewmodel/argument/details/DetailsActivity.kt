package de.gnarly.viewmodel.argument.details

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			DetailsScreen(viewModel = hiltViewModel<DetailsHiltViewModel>())
		}
	}

	companion object {
		fun start(activity: Activity, randomNumber: Int) {
			activity.startActivity(Intent(activity, DetailsActivity::class.java).apply {
				putExtra(RANDOM_NUMBER, randomNumber.toString())
			})
		}
	}
}