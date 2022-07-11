package com.example.dogapp.auth

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dogapp.R
import com.example.dogapp.databinding.FragmentLoginBinding
import com.example.dogapp.utils.isEmail
import com.example.dogapp.utils.isPassword
import java.lang.ClassCastException


class LoginFragment : Fragment() {


    interface LoginFragmentAction {
        fun onRegisterBtnClick()
        fun onLoginFieldsValidate(email:String, password: String)
    }

    private lateinit var loginFragmentActions:LoginFragmentAction
    private lateinit var binding: FragmentLoginBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loginFragmentActions = try {
            context as LoginFragmentAction
        }catch(e:Exception) {
            throw ClassCastException("$context must implements LoginFragmentAction")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.loginRegisterButton.setOnClickListener {
            loginFragmentActions.onRegisterBtnClick()
        }

        binding.loginButton.setOnClickListener {
            validateField()
        }
        return  binding.root

    }
    fun validateField() {
        binding.emailInput.error = ""
        binding.passwordInput.error = ""
        val email = binding.emailEdit.text.toString()
        val pass = binding.passwordEdit.text.toString()
        if (!isEmail(email)) {
            binding.emailInput.error = getString(R.string.email_is_no_valid)
            return
        }
        if (isPassword(pass)) {
            binding.passwordInput.error = getString(R.string.password_is_not_empty)
            return
        }
        loginFragmentActions.onLoginFieldsValidate(email, pass)
    }



}