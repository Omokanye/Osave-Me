package com.ivy.login

enum class UserType(
    val type: String
) {
    Investor("investor"),
    Business("business"),
    Individual("individual"),
    Lawyer("lawyer")
}