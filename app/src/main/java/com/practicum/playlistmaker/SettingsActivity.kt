package com.practicum.playlistmaker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val arrowBackTextView = findViewById<TextView>(R.id.arrow_back)

        arrowBackTextView.setOnClickListener {startActivity(Intent(this@SettingsActivity, MainActivity::class.java))}
    }
}