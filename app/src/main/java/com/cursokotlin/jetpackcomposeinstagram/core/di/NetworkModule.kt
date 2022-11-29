package com.cursokotlin.jetpackcomposeinstagram.core.di

import com.cursokotlin.jetpackcomposeinstagram.login.data.network.LoginClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)  //aca se indica el alcance/scope de ésta clase
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create()) //convierte el gson que viene en nuestra data class
            .build() //crear el objeto retrofit
    }

    @Singleton
    @Provides
    fun provideLoginClient(retrofit: Retrofit) : LoginClient{
        return retrofit.create(LoginClient::class.java)
    }
}