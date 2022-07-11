package com.example.dogapp.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogapp.auth.AuthActivity
import com.example.dogapp.databinding.ActivitySettingBinding
import com.example.dogapp.interfaces.User

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySettingBinding.inflate(layoutInflater)
        binding.btnexitSession.setOnClickListener {
            loggout()
        }
        setContentView(binding.root)
    }

    private fun loggout() {
        User.setLoggout(this)
        val intent = Intent(this, AuthActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)

    }
}