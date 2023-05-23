package com.example.studentapp.ui.activity.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.studentapp.R
import com.example.studentapp.databinding.ActivityLoginBinding
import com.example.studentapp.ui.activity.main.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.checkProfileExist()

        viewModel.profileExist.observe(this) {
            if (it) startMainActivity()
        }

        viewModel.message.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        binding.btnLogin.setOnClickListener {
            val login = binding.etLogin.text
            val password = binding.etPassword.text

            val loginError = login.isEmpty()
            val passwordError = password.length < MINIMUM_PASSWORD_SIZE

            if (loginError) {
                binding.etLogin.error = getString(R.string.login_error)
            }

            if (passwordError) {
                binding.etPassword.error = getString(R.string.password_error, MINIMUM_PASSWORD_SIZE)
            }

            if (!loginError && !passwordError) {
                viewModel.setUser(login.toString(), password.toString())
            }
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    companion object {
        private const val MINIMUM_PASSWORD_SIZE = 8
    }
}