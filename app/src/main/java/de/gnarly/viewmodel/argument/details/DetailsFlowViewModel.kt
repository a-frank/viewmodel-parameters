package de.gnarly.viewmodel.argument.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DetailsFlowViewModel(
	savedStateHandle: SavedStateHandle
) : ViewModel(), DetailsViewModel {
	override val state: Flow<DetailsState> = savedStateHandle
		.randomNumberFlow
		.map {
			val result = "Fancy processing: $it"
			DetailsState(result)
		}
}