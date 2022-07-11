package com.example.dogapp.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapp.api.ApiResponseStatus
import com.example.dogapp.interfaces.User
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user
    private val _status = MutableLiveData<ApiResponseStatus<User>>()
    val status: LiveData<ApiResponseStatus<User>>
        get() = _status
    private val authRepository = AuthRepository()
    fun signUp(email: String, password: String, ConfirmationPassword: String) {
        viewModelScope.launch {
            _status.value =ApiResponseStatus.Loading()
            handleResponseStatus(
                authRepository.signup(email, password, passConfirmation = ConfirmationPassword)
            )
        }
    }
    fun logIn(email: String, password: String) {
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
            handleResponseStatus(authRepository.login(email, password))
        }
    }
    private fun handleResponseStatus(apiResponseStatus: ApiResponseStatus<User>) {
        if (apiResponseStatus is ApiResponseStatus.Success) {
            _user.value = apiResponseStatus.data
        }
        _status.value = apiResponseStatus
    }

//    private val _signup = MutableLiveData<List<Dog>>()
//    val SignUp: LiveData<List<Dog>>
//        get() = _signup
}