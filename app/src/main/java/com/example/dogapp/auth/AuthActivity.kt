package com.example.dogapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import com.example.dogapp.MainActivity
import com.example.dogapp.R
import com.example.dogapp.api.ApiResponseStatus
import com.example.dogapp.databinding.ActivityAuthBinding
import com.example.dogapp.interfaces.User

class AuthActivity : AppCompatActivity(),LoginFragment.LoginFragmentAction,SignUpFragment.SignUpFragmentAction {
    private val viewModel:AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.status.observe(this) {
            status ->
            when (status) {
                is ApiResponseStatus.Error -> {
                    binding.loadingWheel.visibility = View.GONE
                    showMethodDialog(status.messageId)

                }
                is ApiResponseStatus.Loading -> binding.loadingWheel.visibility = View.VISIBLE
                is ApiResponseStatus.Success -> binding.loadingWheel.visibility = View.GONE
            }
        }
        viewModel.user.observe(this) {
            user ->
            if(user != null) {
                User.setLoggedInUser(this, user)
                startMainActivity()
            }
        }
    }

    private fun startMainActivity() {
       startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    override fun onRegisterBtnClick() {
        findNavController(R.id.nav_host_fragment)
            .navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
    }

    override fun onLoginFieldsValidate(email: String, password: String) {
        viewModel.logIn(email,password)

    }

    override fun onSignUpFieldsValidated(email: String, pass: String, confirm_pass: String) {
        viewModel.signUp(email,pass,confirm_pass)
    }
   private fun showMethodDialog(messageId: Int) {
       AlertDialog.Builder(this)
           .setTitle(R.string.there_was_an_error)
           .setMessage(messageId)
           .setPositiveButton(android.R.string.ok) { _,_ ->/**Dismiss dialog **/}
           .create()
           .show()


   }
}