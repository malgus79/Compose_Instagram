package com.cursokotlin.jetpackcomposeinstagram.login.data.network

import com.cursokotlin.jetpackcomposeinstagram.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

/*
 interface que va a consumir los endpoints (cliente de retrofit)
*/

interface LoginClient {
    @GET("/v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
    suspend fun doLogin(): Response<LoginResponse>
    //entre "< >" va la respuesta del endpoint

    /*
    cuando se llame a la fun doLogin, va al endpoint, y recuperar un objeto
    de tipo LoginResponse
     */
}