package com.example.dogapp.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.dogapp.R
import com.example.dogapp.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity(),LoginFragment.LoginFragmentAction,SignUpFragment.SignUpFragmentAction {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onRegisterBtnClick() {
        findNavController(R.id.nav_host_fragment)
            .navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
    }

    override fun onSignUpFieldsValidated(email: String, pass: String, confirm_pass: String) {

    }
}