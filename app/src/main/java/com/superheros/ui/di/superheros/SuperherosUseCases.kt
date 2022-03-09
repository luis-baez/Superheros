package com.superheros.ui.di.superheros

import com.superheros.core.data.repository.superheros.SuperherosRepository
import com.superheros.core.usecases.superheros.GetSuperheros
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class SuperherosUseCases {

    @Provides
    @FragmentScoped
    fun provideRemoteGetSuperherosUseCase(repository: SuperherosRepository): GetSuperheros =
        GetSuperheros(repository)
}