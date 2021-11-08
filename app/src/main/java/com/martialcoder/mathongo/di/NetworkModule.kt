package com.martialcoder.mathongo.di

import com.martialcoder.mathongo.api.NetworkService
import com.martialcoder.mathongo.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    operator fun invoke() : NetworkService {
        val clientBuilder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(loggingInterceptor)

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }
}