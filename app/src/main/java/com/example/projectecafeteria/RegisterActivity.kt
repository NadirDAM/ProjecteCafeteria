package com.example.projectecafeteria

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.projectecafeteria.databinding.ActivityMainBinding
import com.example.projectecafeteria.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val binding : ActivityRegisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        binding.outlinedButtonRegister.setOnClickListener {
            val response = viewModel.createUser(binding.editTextUser.text.toString(), binding.editTextPassword.text.toString())
            if (response.isEmpty()) {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
            }
            else {
                binding.textViewMessage.text = response
            }
        }

        binding.outlinedButtonGoToLogin.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
}