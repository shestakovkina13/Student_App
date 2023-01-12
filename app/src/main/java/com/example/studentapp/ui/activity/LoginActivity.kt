package com.example.studentapp.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentapp.R
import com.example.studentapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val loginError = binding.etLogin.text.isEmpty()
            val passwordError = binding.etPassword.text.length < 6

            if (loginError) {
                binding.etLogin.error = getString(R.string.login_error)
            }

            if (passwordError) {
                binding.etPassword.error = getString(R.string.password_error)
            }

            if (!loginError && !passwordError) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}