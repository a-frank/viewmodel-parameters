package de.gnarly.viewmodel.argument.details

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val DETAILS_SCREEN = "details"
const val RANDOM_NUMBER = "randomNumber"

const val DETAILS_ROUTE = "$DETAILS_SCREEN/{$RANDOM_NUMBER}"

fun Int.toNavigationRoute(): String = "$DETAILS_SCREEN/$this"

val SavedStateHandle.randomNumberFlow: Flow<Int>
	get() = getStateFlow<String?>(RANDOM_NUMBER, null)
		.map {
			it.toRandomNumber()
		}

val SavedStateHandle.randomNumber: Int
	get() = get<String>(RANDOM_NUMBER).toRandomNumber()

private fun String?.toRandomNumber(): Int =
	this?.toIntOrNull() ?: throw IllegalArgumentException("You have to provide $RANDOM_NUMBER as parameter with type Int when navigating to $DETAILS_SCREEN")