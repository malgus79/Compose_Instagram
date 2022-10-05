package com.cursokotlin.jetpackcomposeinstagram.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
Este objeto permite crear una instancia de retrofit para el consumo de api
*/
/*
Lo ideal seria que fuese una clase singleton inyectada con inyeccion de dependencia
*/

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create()) //convierte el gson que viene en nuestra data class
            .build() //crear el objeto retrofit
    }
}