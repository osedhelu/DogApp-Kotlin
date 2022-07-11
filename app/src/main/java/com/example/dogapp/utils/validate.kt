package com.example.dogapp.utils

import android.util.Patterns

fun isEmail(email: String?): Boolean {
    return !email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isPassword(pass: String?): Boolean {
    return pass.isNullOrEmpty() || pass.isEmpty()
}

fun isEqualPassword(pass1_confirm: String?, pass2: String?): Boolean {
    return pass1_confirm != pass2
}