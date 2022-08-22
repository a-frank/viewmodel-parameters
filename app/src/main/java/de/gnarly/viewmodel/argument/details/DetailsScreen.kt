package de.gnarly.viewmodel.argument.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight

@Composable
fun DetailsScreen(viewModel: DetailsViewModel) {

	val state by viewModel.state.collectAsState(initial = DetailsState(""))

	Column {
		Text(text = "The result is")
		Text(text = state.text, fontWeight = FontWeight.Bold)
	}
}