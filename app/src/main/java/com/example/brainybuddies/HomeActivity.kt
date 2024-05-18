package com.example.brainybuddies

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val button2: Button = findViewById(R.id.button2)

        button2.setOnClickListener {
            val intent = Intent(this,PlaygameActivity::class.java)
            startActivity(intent)
        }

        val setBtn: Button = findViewById(R.id.button3)

        setBtn.setOnClickListener {
            val intent = Intent(this,Settings::class.java)
            startActivity(intent)
        }

        val scoreBtn: Button = findViewById(R.id.button4)

        scoreBtn.setOnClickListener {
            val intent = Intent(this,Score::class.java)
            startActivity(intent)
        }

    }
}