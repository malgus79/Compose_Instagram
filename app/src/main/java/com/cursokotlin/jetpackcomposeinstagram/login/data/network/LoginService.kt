package com.cursokotlin.jetpackcomposeinstagram.login.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

/*
clase servicio para consumir ese cliente
se encargara de llamar a todos los endpoints que tuviera ese cliente y
tendra el objeto de retrofit
 */

class LoginService @Inject constructor(private val loginClient: LoginClient) {
//    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user: String, password: String): Boolean {
        //aca crear una corrutina
        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin()
            response.body()?.success ?: false
        }
    }
}