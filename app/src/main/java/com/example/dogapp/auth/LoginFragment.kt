package com.example.dogapp.auth

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dogapp.R
import com.example.dogapp.databinding.FragmentLoginBinding
import java.lang.ClassCastException


class LoginFragment : Fragment() {

    interface LoginFragmentAction {
        fun onRegisterBtnClick()
    }

    private lateinit var loginFragmentActions:LoginFragmentAction

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
        val binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.loginRegisterButton.setOnClickListener {
            loginFragmentActions.onRegisterBtnClick()
        }
        return  binding.root
    }
}