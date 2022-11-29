package com.cursokotlin.jetpackcomposeinstagram.login.data

import com.cursokotlin.jetpackcomposeinstagram.login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginService){
//    //api = servicio
//    private val api = LoginService()

    suspend fun doLogin(user:String, password:String):Boolean {
        //aca se pueden hacer todas las comprobaciones de user pass

        return api.doLogin(user, password)
    }
}