package com.example.dogapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogapp.auth.AuthActivity
import com.example.dogapp.databinding.ActivityMainBinding
import com.example.dogapp.doglist.DogListActivity
import com.example.dogapp.interfaces.User
import com.example.dogapp.setting.SettingActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = User.getLoggedInUser(this)
        if (user == null) {
            openLoginActivity()
            return
        }
        binding.takeOffFab.setOnClickListener {
            openSettinActivity()
        }
        binding.takeListFab.setOnClickListener {
            openDogListActivity()
        }
    }

    private fun openDogListActivity() {
        startActivity(Intent(this, DogListActivity::class.java))
    }

    private fun openSettinActivity() {
        startActivity(Intent(this, SettingActivity::class.java))
        finish()
    }

    private fun openLoginActivity() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }
}