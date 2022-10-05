package com.cursokotlin.jetpackcomposeinstagram.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*
aca va toda la logica (no debe ir en ninguna activity o fragments)

.value = se usa para acceder al LiveData
*/
class LoginViewModel:ViewModel() {

    private val _email = MutableLiveData<String>()  //es mutable porque SOLO se va a poder modificar internamente
    val email : LiveData<String> = _email  //este NO se va a poder modificar -> las vistas solo pueden leer y no modificar

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()  //esta val SIEMPRE va a tiene el estado real (si tiene enable/disable el boton)
    val isLoginEnable:LiveData<Boolean> = _isLoginEnable

    fun onLoginChanged(email:String, password:String){
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
}