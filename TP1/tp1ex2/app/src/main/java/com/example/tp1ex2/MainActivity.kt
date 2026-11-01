package com.example.tp1ex2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var showButton: Button
    private lateinit var welcomeText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        showButton = findViewById(R.id.showButton)
        welcomeText = findViewById(R.id.welcomeText)

        showButton.setOnClickListener {
            val name = nameEditText.text.toString()
            welcomeText.text = "Bienvenue $name !"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("NAME", nameEditText.text.toString())
        outState.putString("MESSAGE", welcomeText.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val name = savedInstanceState.getString("NAME", "")
        val message = savedInstanceState.getString("MESSAGE", "")

        nameEditText.setText(name)
        welcomeText.text = message
    }
}