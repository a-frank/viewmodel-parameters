package de.gnarly.viewmodel.argument.details

import kotlinx.coroutines.flow.Flow

interface DetailsViewModel {
	val state: Flow<DetailsState>
}