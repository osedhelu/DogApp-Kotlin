package com.example.dogapp.auth

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dogapp.R
import com.example.dogapp.databinding.FragmentSignUpBinding
import com.example.dogapp.utils.isEmail
import com.example.dogapp.utils.isEqualPassword
import com.example.dogapp.utils.isPassword

class SignUpFragment : Fragment() {
    interface SignUpFragmentAction {
        fun onSignUpFieldsValidated(email: String, pass: String, confirm_pass: String)

    }

    private lateinit var signupFragmentActions: SignUpFragmentAction
    override fun onAttach(context: Context) {
        super.onAttach(context)
        signupFragmentActions = try {
            context as SignUpFragmentAction
        } catch (e: Exception) {
            throw ClassCastException("$context must implement SignUpFragmentAction")
        }
    }

    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        setupSignUpButton()
        return binding.root
    }

    private fun setupSignUpButton() {
        binding.signUpButton.setOnClickListener {
            validateFields()
        }
    }

    private fun validateFields() {
        binding.emailInput.error = ""
        binding.passwordInput.error = ""
        binding.confirmPasswordInput.error = ""
        val email = binding.emailEdit.text.toString()
        val pass = binding.passwordEdit.text.toString()
        val passConfirmation = binding.confirmPasswordEdit.text.toString()
        if (!isEmail(email)) {
            binding.emailInput.error = getString(R.string.email_is_no_valid)
            return
        }
        if (isPassword(pass)) {
            binding.passwordInput.error = getString(R.string.password_is_not_empty)
            return
        }
        if (isEqualPassword(passConfirmation, pass)) {
            binding.confirmPasswordEdit.error = getString(R.string.password_is_not_equal)
            return
        }
        signupFragmentActions.onSignUpFieldsValidated(email,pass,passConfirmation)
    }


}