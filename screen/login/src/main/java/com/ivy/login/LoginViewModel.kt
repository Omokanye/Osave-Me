package com.ivy.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivy.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,

): ViewModel(){

    var state by mutableStateOf(UiState())
        private set
    var validRegistration by mutableStateOf(false)
    var isPasswordVisible by mutableStateOf(false)
        private set

    fun register(
        name: String,
        lastname: String,
        email: String,
        password: String,
        userType: UserType

    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state = state.copy(isLoading = true)
            val isSuccess = loginRepository.register(
                name = name,
                password = password,
                lastname = lastname,
                email = email,
                userType = userType.type
            )
            state = state.copy(isLoading = false)
            validRegistration = isSuccess
        }

    }

    fun togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible
    }

}
