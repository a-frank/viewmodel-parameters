package de.gnarly.viewmodel.argument.details

import androidx.lifecycle.SavedStateHandle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DetailsModule {
	@Provides
	@RandomNumber
	@ViewModelScoped
	fun provideRandomNumber(savedStateHandle: SavedStateHandle): Int =
		savedStateHandle.randomNumber
}
