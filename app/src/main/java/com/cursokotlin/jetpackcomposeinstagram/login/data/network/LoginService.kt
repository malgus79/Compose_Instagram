package com.cursokotlin.jetpackcomposeinstagram.login.data.network

import com.cursokotlin.jetpackcomposeinstagram.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

/*
clase servicio para consumir ese cliente
se encargara de llamar a todos los endpoints que tuviera ese cliente y
tendra el objeto de retrofit
 */

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user:String, password:String):Boolean {
        //aca crear una corrutina
        return withContext(Dispatchers.IO) {
         val responde =  retrofit.create(LoginClient::class.java).doLogin()
            responde.body()?.success ?: false
        }
    }
}