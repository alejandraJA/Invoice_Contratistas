package com.invoice.contratista.ui.fragment.sing.`in`

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.R
import com.invoice.contratista.data.source.api.models.request.SingRequest
import com.invoice.contratista.data.source.api.models.request.UpdateTokenRequest
import com.invoice.contratista.data.source.shared_preferences.User
import com.invoice.contratista.data.source.shared_preferences.UserManager
import com.invoice.contratista.sys.domain.repository.SingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val singRepository: SingRepository,
    private val userManager: UserManager
) : ViewModel() {

    val error = MutableLiveData<Int>()
    val isLogged = userManager.isUserLogged()

    fun login(email: String, password: String, function: () -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val singIn = singRepository.singIn(SingRequest(email, password))
                if (singIn.code() == 200) {
                    val response = singIn.body()!!
                    if (response.status) {
                        userManager.setUserLogged(User(email, password, response.data!!.token))
                        function.invoke()
                    } else {
                        if (response.message.contains("does not exist"))
                            error.postValue(R.string.please_check_email)
                        if (response.message.contains("Password incorrect"))
                            error.postValue(R.string.password_incorrect)
                    }
                } else error.postValue(R.string.unexpected_error)
            }
        }
    }

    fun updateToken(email: String, password: String, function: () -> Unit) {
        val loginStatus = userManager.login(email, password)
        if (loginStatus == R.string.login) {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    val updateToken = singRepository.updateToken(
                        UpdateTokenRequest(
                            email,
                            userManager.getToken(email)
                        )
                    )
                    if (updateToken.code() == 200) {
                        val response = updateToken.body()!!
                        if (response.status) {
                            userManager.setToken(response.data!!.token, email)
                            function.invoke()
                        } else {
                            val message = response.message
                            if (message.contains("The token does not correspond to the user."))
                                error.postValue(R.string.please_check_email)
                            if (message.contains("does not exist in database"))
                                error.postValue(R.string.please_check_email)
                            if (message.contains("Token Invalid"))
                                error.postValue(R.string.unexpected_error)
                        }
                    } else error.postValue(R.string.unexpected_error)
                }
            }
        } else error.postValue(loginStatus)
    }

}