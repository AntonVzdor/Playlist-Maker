package com.practicum.playlistmaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val searchButton = findViewById<Button>(R.id.button_search)
        val mediaLibraryButton = findViewById<Button>(R.id.button_media_library)
        val settingsButton = findViewById<Button>(R.id.settings)

        val ButtonClickListener : View.OnClickListener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                when (p0?.id) {
                    R.id.button_search -> startActivity(Intent(this@MainActivity, SearchActivity::class.java))
                    R.id.settings -> startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
                }
            }
        }

        mediaLibraryButton.setOnClickListener { startActivity(Intent(this, MediaLibraryActivity::class.java))}
        searchButton.setOnClickListener(ButtonClickListener)
        settingsButton.setOnClickListener(ButtonClickListener)

    }
}