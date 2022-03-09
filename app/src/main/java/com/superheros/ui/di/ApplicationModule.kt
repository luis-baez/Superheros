package com.superheros.ui.di

import android.content.Context
import com.superheros.core.data.sources.RemoteDataSource
import com.superheros.data.api.SuperherosService
import com.superheros.data.model.RemoteDataSourceImpl
import com.superheros.ui.utils.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideUiDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @Singleton
    fun provideRetrofit():
            Retrofit = RetrofitService.getInstance()

    @Provides
    @Singleton
    fun provideSuperherosService(retrofit: Retrofit): SuperherosService =
        retrofit.create(SuperherosService::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(service: SuperherosService):
            RemoteDataSource = RemoteDataSourceImpl(service)

}