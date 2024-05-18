package com.example.brainybuddies

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuestonssActivity : AppCompatActivity(),View.OnClickListener {

    private var currentPosition = 1
    private lateinit var questionList: ArrayList<QuestionClass>
    private var selectedOptionPosition = 0
    private var correctAnswer = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questonss)

        //create new arraylist and store all questions and answers
        questionList = Constants.getQuestions()

        val answer1: TextView = findViewById(R.id.textView9)
        val answer2: TextView = findViewById(R.id.textView10)
        val answer3: TextView = findViewById(R.id.textView11)
        val answer4: TextView = findViewById(R.id.textView12)
        val sbtButton: Button = findViewById(R.id.button8)

        answer1.setOnClickListener(this)
        answer2.setOnClickListener(this)
        answer3.setOnClickListener(this)
        answer4.setOnClickListener(this)
        sbtButton.setOnClickListener(this)


        setQuestions()


    }

    private fun setQuestions() {


        val currentQuestion: QuestionClass? = questionList!![currentPosition - 1]

        val textView1: TextView = findViewById(R.id.textView6)
        textView1.text = currentQuestion!!.question

        val imageView: ImageView = findViewById(R.id.imageView5)
        imageView.setImageResource(currentQuestion.image)

        val answer1: TextView = findViewById(R.id.textView9)
        answer1.text = currentQuestion.answer1

        val answer2: TextView = findViewById(R.id.textView10)
        answer2.text = currentQuestion.answer2

        val answer3: TextView = findViewById(R.id.textView11)
        answer3.text = currentQuestion.answer3

        val answer4: TextView = findViewById(R.id.textView12)
        answer4.text = currentQuestion.answer4

        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        progressBar.max = questionList!!.size
        progressBar.progress = currentPosition

        val textView: TextView = findViewById(R.id.textView8)
        textView.text = "$currentPosition/${questionList!!.size}"

        //reset the appearance for everytime a new question comes up
        defaultOptionView()

        val sbtButton: Button = findViewById(R.id.button8)
        //if all the questions in the lists are used
        if (currentPosition == questionList!!.size) {
            sbtButton.text = "Quiz finished"


        } else {
            sbtButton.text = "Submit"
        }


    }

    private fun defaultOptionView() {

        val answer1: TextView = findViewById(R.id.textView9)
        val answer2: TextView = findViewById(R.id.textView10)
        val answer3: TextView = findViewById(R.id.textView11)
        val answer4: TextView = findViewById(R.id.textView12)

        //controlling textview that share same behavior
        val options = ArrayList<TextView>()

        options.add(0, answer1)
        options.add(1, answer2)
        options.add(2, answer3)
        options.add(3, answer4)

        for (option in options) {
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.buuton)
        }
    }

    override fun onClick(v: View?) {


        val answer1: TextView = findViewById(R.id.textView9)
        val answer2: TextView = findViewById(R.id.textView10)
        val answer3: TextView = findViewById(R.id.textView11)
        val answer4: TextView = findViewById(R.id.textView12)

        when (v?.id) {
            R.id.textView9 -> {
                selectedOptionView(answer1, 1)
            }

            R.id.textView10 -> {
                selectedOptionView(answer2, 2)
            }

            R.id.textView11 -> {
                selectedOptionView(answer3, 3)
            }

            R.id.textView12 -> {
                selectedOptionView(answer4, 4)
            }

            R.id.button8 -> {

                if (selectedOptionPosition == 0) {
                    currentPosition++    //current position increasing means index is increasing
                    //if index is increasing means we will get a new question from the question list

                    when {
                        currentPosition <= questionList!!.size -> {
                            setQuestions()
                        }

                        else -> {

                            Toast.makeText(this, "Quiz Finished", Toast.LENGTH_SHORT).show()

                            // Inside onClick() method where you navigate to GameEnd activity
                            val playerName = intent.getStringExtra("playerName")
                            val totalQuestions = questionList.size
                            val scorePercentage =
                                (correctAnswer.toDouble() / totalQuestions.toDouble()) * 100
                            val scoreString = "$correctAnswer out of $totalQuestions"

                            //Store the score
                            saveHighScore(playerName, scoreString)

                            val intent = Intent(this, GameEnd::class.java)
                            intent.putExtra("score", scoreString)
                            intent.putExtra("playerName", playerName)
                            startActivity(intent)
                        }
                    }
                } else {
                    //if user selected on option
                    //we will check if its correct or incorrect
                    val question = questionList!![currentPosition - 1]

                    //correct answer values are 1..4 if the value matches or not matches
                    if (question.correctAnswer != selectedOptionPosition) {

                        answerView(selectedOptionPosition, R.drawable.wronganswer)
                    } else {
                        correctAnswer++

                        answerView(question.correctAnswer, R.drawable.correctanswer)

                        val sbtButton: Button = findViewById(R.id.button8)
                        if (currentPosition == questionList!!.size) {


                            sbtButton.text = "Finished"
                        } else {

                            sbtButton.text = "Next"
                        }
                    }

                    selectedOptionPosition = 0 //next question options positions should be 0

                }
            }

        }


    }

    private fun selectedOptionView(tv: TextView, selectedPosition1: Int) {

        //reset text views
        defaultOptionView()
        selectedOptionPosition = selectedPosition1

        tv.setTextColor(Color.parseColor("#363A43"))

        //default option view
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selectedbuuton)

    }

    private fun answerView(selectedOptionPosition: Int, drawableView: Int) {

        val answer1: TextView = findViewById(R.id.textView9)
        val answer2: TextView = findViewById(R.id.textView10)
        val answer3: TextView = findViewById(R.id.textView11)
        val answer4: TextView = findViewById(R.id.textView12)

        when (selectedOptionPosition) {

            1 -> {
                answer1.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                answer2.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                answer3.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 -> {
                answer4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    //save high score
    @SuppressLint("MutatingSharedPrefs")
    private fun saveHighScore(playerName: String?, score: String) {
        val sharedPreferences = getSharedPreferences("HighScores", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val currentScores = sharedPreferences.getStringSet("scores", HashSet()) as HashSet<String>
        currentScores.add("$playerName: $score")
        editor.putStringSet("scores", currentScores)
        editor.apply()

    }

}