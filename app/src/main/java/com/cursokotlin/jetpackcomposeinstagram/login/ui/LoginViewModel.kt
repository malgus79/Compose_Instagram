package com.cursokotlin.jetpackcomposeinstagram.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursokotlin.jetpackcomposeinstagram.login.domain.LoginUseCase
import kotlinx.coroutines.launch

/*
aca va toda la logica (no debe ir en ninguna activity o fragments)

.value = se usa para acceder al LiveData
*/
class LoginViewModel:ViewModel() {

    val loginUseCase = LoginUseCase()

    private val _email = MutableLiveData<String>()  //es mutable porque SOLO se va a poder modificar internamente
    val email : LiveData<String> = _email  //este NO se va a poder modificar -> las vistas solo pueden leer y no modificar

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()  //esta val SIEMPRE va a tiene el estado real (si tiene enable/disable el boton)
    val isLoginEnable:LiveData<Boolean> = _isLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading:LiveData<Boolean> = _isLoading

    fun onLoginChanged(email:String, password:String){
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

    fun onLoginSelected() {
        //para llamar a la corrutina y al use case desde aqui -> viewModelScope.launch
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(email.value!!, password.value!!)
            if (result) {
                //navegar a la siguiente pantalla
                Log.i("aris", "result OK")
            }
            _isLoading.value = false
        }
    }
}