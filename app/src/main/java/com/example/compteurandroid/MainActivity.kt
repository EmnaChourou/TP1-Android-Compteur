package com.example.compteurandroid

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var compteur = 0
    private lateinit var textViewCompteur: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewCompteur = findViewById(R.id.textViewCompteur)

        val buttonIncrementer = findViewById<Button>(R.id.buttonIncrementer)
        val buttonDecrementer = findViewById<Button>(R.id.buttonDecrementer)
        val buttonIncrementerCinq = findViewById<Button>(R.id.buttonIncrementerCinq)
        val buttonDecrementerCinq = findViewById<Button>(R.id.buttonDecrementerCinq)
        val buttonReinitialiser = findViewById<Button>(R.id.buttonReinitialiser)

        buttonIncrementer.setOnClickListener {
            compteur++
            actualiserCompteur()
        }

        buttonDecrementer.setOnClickListener {
            if (compteur > 0) {
                compteur--
                actualiserCompteur()
            }
        }

        buttonIncrementerCinq.setOnClickListener {
            compteur += 5
            actualiserCompteur()
        }

        buttonDecrementerCinq.setOnClickListener {
            if (compteur >= 5) {
                compteur -= 5
            } else {
                compteur = 0
            }
            actualiserCompteur()
        }

        buttonReinitialiser.setOnClickListener {
            compteur = 0
            actualiserCompteur()

            Toast.makeText(
                this,
                R.string.message_reinitialisation,
                Toast.LENGTH_SHORT
            ).show()
        }

        actualiserCompteur()
    }

    private fun actualiserCompteur() {
        textViewCompteur.text = compteur.toString()

        val couleur = when {
            compteur > 0 -> Color.GREEN
            compteur < 0 -> Color.RED
            else -> Color.BLACK
        }

        textViewCompteur.setTextColor(couleur)
    }
}