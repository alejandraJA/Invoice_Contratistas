package com.invoice.contratista.data.source.shared_preferences

import android.content.Context
import com.invoice.contratista.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UserManager @Inject constructor(@ApplicationContext context: Context) {
    private val sharedPreferences =
        context.getSharedPreferences(UserConstants.NAME, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun setUserLogged(user: User) {
        user.apply {
            username.setString(UserConstants.USERNAME)
            password.setString("$username.${UserConstants.PASSWORD}")
            token.setString("$username.${UserConstants.TOKEN}")
        }
    }

    fun getToken(username: String) = "$username.${UserConstants.TOKEN}".getString()
    fun setToken(token: String, username: String) =
        token.setString("$username.${UserConstants.TOKEN}")

    fun getUsername() = UserConstants.USERNAME.getString()

    fun isUserLogged(): Boolean {
        val username = UserConstants.USERNAME.getString()
        return username.isNotEmpty() && "$username.${UserConstants.PASSWORD}".getString()
            .isNotEmpty()
    }

    fun login(username: String, password: String): Int {
        return if (username != UserConstants.USERNAME.getString()) {
            R.string.invalid_username
        } else if (password != "$username.${UserConstants.PASSWORD}") {
            R.string.password_incorrect
        } else R.string.login
    }

    private fun String.setString(key: String) = editor.putString(key, this).apply()
    private fun String.getString() = sharedPreferences.getString(this, "")!!

}

data class User(
    val username: String,
    val password: String,
    val token: String,
)

object UserConstants {
    const val NAME = "user"
    const val USERNAME = "username"
    const val PASSWORD = "password"
    const val TOKEN = "token"
}
