package com.example.brainybuddies

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class GameEnd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game_end)

        val playerName = intent.getStringExtra("playerName")
        val congratsMessage = "Hey $playerName, Congratulations!"
        val scoreString = intent.getStringExtra("score")

        val messageTextView = findViewById<TextView>(R.id.message)
        val scoreTextView = findViewById<TextView>(R.id.textView13)

        messageTextView.text = congratsMessage
        scoreTextView.text = scoreString


        val fbtn: Button = findViewById(R.id.button6)

        fbtn.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}