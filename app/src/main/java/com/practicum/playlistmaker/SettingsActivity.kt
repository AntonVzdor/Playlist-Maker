package com.example.playlistmaker

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar

class SettingsActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val backButton = findViewById<Toolbar>(R.id.settings_toolbar)
        backButton.setOnClickListener { super.finish() }

        val themeSwitch = findViewById<Switch>(R.id.switch1)

        val darkModeFlags = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK// Retrieve the Mode of the App.
        val isDarkModeOn = darkModeFlags == Configuration.UI_MODE_NIGHT_YES//Check if the Dark Mode is On
        if (isDarkModeOn) {
            themeSwitch.isChecked = true
        }

        themeSwitch.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        val supportButton = findViewById<TextView>(R.id.callTextView)
        val selectorIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse(
                "mailto:" + Uri.encode(getString(R.string.my_email)) + "?subject=" + Uri.encode(
                    getString(R.string.theme_support)
                ) + "&body=" + Uri.encode(getString(R.string.body_support))
            )
        }

        supportButton.setOnClickListener {
            startActivity(Intent.createChooser(selectorIntent, "Send email..."))
        }


        val shareButton = findViewById<TextView>(R.id.shareTextView)
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, getString(R.string.app_link))
        }
        shareButton.setOnClickListener {
            startActivity(
                Intent.createChooser(
                    shareIntent,
                    getString(R.string.app_link_share_title)
                )
            )
        }


        val userAggreementButton = findViewById<TextView>(R.id.agreementTextView)

        val internetIntent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(getString(R.string.user_aggreement_link))
        }
        userAggreementButton.setOnClickListener {

            startActivity(internetIntent)
        }
    }
}
