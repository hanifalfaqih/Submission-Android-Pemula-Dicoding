package com.allana.booksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Tentang"
        }

    }
}
