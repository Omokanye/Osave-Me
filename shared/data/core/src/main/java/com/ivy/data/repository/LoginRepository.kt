package com.ivy.data.repository

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.http.isSuccess
import io.ktor.http.parameters
import io.ktor.util.InternalAPI
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val httpClient: HttpClient,
) {

    @OptIn(InternalAPI::class)
    suspend fun register(
        name: String,
        lastname: String,
        email: String,
        password: String,
        userType: String
    ): Boolean {
        val response = httpClient.post(
            urlString = "https://osavebackend.web.app/api/signup",
        ){
            body = io.ktor.client.request.forms.FormDataContent(
                parameters {
                    append("firstName", name)
                    append("lastName", lastname)
                    append("email", email)
                    append("password", password)
                    append("accountType", userType)
                }
            )
        }
        return response.status.isSuccess()
    }
}