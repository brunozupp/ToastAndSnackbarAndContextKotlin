package com.novelitech.toastandcontextkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.novelitech.toastandcontextkotlin.databinding.ActivityMainBinding
import com.novelitech.toastandcontextkotlin.databinding.CustomToastBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingToast: CustomToastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        showSnackbarStyled()
    }

    // It's deprecated the attribute used to do a Custom Toast
    private fun showDefaultToast() {
        binding.btnShowToast.setOnClickListener {

            // This is a reference to the context from the whole app
            // Toast.makeText(this.applicationContext, "Hi, I'm a toast!", Toast.LENGTH_LONG).show()

            // This is a reference to the context from the current activity
            Toast.makeText(this, "Hi, I'm a toast!", Toast.LENGTH_LONG).show()
        }
    }

    private fun showSnackbar() {

        binding.btnShowToast.setOnClickListener {

            Snackbar.make(binding.root, "Mensagem aqui", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun showSnackbarStyled() {

        binding.btnShowToast.setOnClickListener {

            val snackbar = Snackbar.make(binding.root, "Mensagem aqui", Snackbar.LENGTH_LONG)

            snackbar.setBackgroundTint(Color.BLUE)
            snackbar.setTextColor(Color.WHITE)

            snackbar.setAction("OK") {
                // Do something
                snackbar.dismiss()
            }

            snackbar.setActionTextColor(Color.GREEN)

            snackbar.show()
        }
    }
}