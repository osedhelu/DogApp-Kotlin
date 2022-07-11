package com.example.dogapp.interfaces

import android.app.Activity
import android.content.Context

class User (
    val id: Long,
    val email: String,
    val authenticationToken: String
) {
    //este companion object nos va a plermitie guardar una session y tomar una secion
    companion object {
        private const val AUTH_PREFS = "auth_prefs"
        private const val ID_KEY = "id_key"
        private const val EMAIL_KEY = "email_key"
        private const val AUTH_TOKEN_KEY = "auth_token_key"
        fun setLoggedInUser(activity:Activity, user: User) {
            activity.getSharedPreferences(AUTH_PREFS,Context.MODE_PRIVATE).also {
                it.edit()
                    .putLong(ID_KEY, user.id)
                    .putString(EMAIL_KEY, user.email)
                    .putString(AUTH_TOKEN_KEY, user.authenticationToken)
                    .apply()
            }

        }
        fun getLoggedInUser(activity:Activity): User? {
            val prefs = activity.getSharedPreferences(AUTH_PREFS, Context.MODE_PRIVATE)?: return null
            val userId = prefs.getLong(ID_KEY, 0)
            if(userId == 0L) {
               return null
            }
            return User(
                prefs.getLong(ID_KEY, 0),
                prefs.getString(EMAIL_KEY,"") ?: "",
                prefs.getString(AUTH_TOKEN_KEY, "")?: ""
            )
        }
    }
}