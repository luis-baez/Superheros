package com.superheros.ui.di.superheros

import com.superheros.core.data.repository.superheros.SuperherosRepository
import com.superheros.core.data.repository.superheros.SuperherosRepositoryImpl
import com.superheros.core.data.sources.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class SuperherosRepositoryModule {

    @ActivityScoped
    @Provides
    fun provideSuperherosRepository(remoteDataSource: RemoteDataSource): SuperherosRepository =
        SuperherosRepositoryImpl(remoteDataSource)

}