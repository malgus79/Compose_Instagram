package com.cursokotlin.jetpackcomposeinstagram.login.data.network.response

import com.google.gson.annotations.SerializedName

class LoginResponse(
    @SerializedName("success") val success: Boolean)