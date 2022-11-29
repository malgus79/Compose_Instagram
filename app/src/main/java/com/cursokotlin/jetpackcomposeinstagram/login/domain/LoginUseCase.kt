package com.cursokotlin.jetpackcomposeinstagram.login.domain

import com.cursokotlin.jetpackcomposeinstagram.login.data.LoginRepository
import javax.inject.Inject

/*
sin DI, se tiene que meter el repositorio manualmente
 */

class LoginUseCase @Inject constructor(private val repository: LoginRepository){
//    private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }
}

/*
al usar operator/invoke se ahorra tener que crear una funcion a la que se
llamaria desde el viewmodel
 */