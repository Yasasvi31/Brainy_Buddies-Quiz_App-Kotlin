package com.example.brainybuddies

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        displayHighScores()
    }

    private fun displayHighScores() {
        val sharedPreferences = getSharedPreferences("HighScores", Context.MODE_PRIVATE)
        val scores = sharedPreferences.getStringSet("scores", HashSet())

        // Display the scores in a TextView or RecyclerView
        val textView = findViewById<TextView>(R.id.textView15)
        if (scores != null) {
            textView.text = scores.joinToString("\n")
        }
    }
}