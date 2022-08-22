package de.gnarly.viewmodel.argument.details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class DetailsHiltViewModel @Inject constructor(
	@RandomNumber randomNumber: Int
) : ViewModel(), DetailsViewModel {
	override val state: Flow<DetailsState> = flow {
		val result = "Fancy processing: $randomNumber"
		emit(DetailsState(result))
	}
}