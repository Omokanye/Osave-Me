package com.ivy.login


data class UiState(
    val isLoading: Boolean = false,
    val name: String = "",
    val lastname: String = "",
    val email: String = "",
    val password: String = "",
    val userType: UserType = UserType.Investor
)
