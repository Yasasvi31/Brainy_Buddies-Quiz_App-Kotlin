package com.example.brainybuddies

import android.annotation.SuppressLint


object Constants {

    @SuppressLint("SuspiciousIndentation")
    fun getQuestions():ArrayList<QuestionClass> {

      val questionList = ArrayList<QuestionClass>()
      val que1 = QuestionClass(
          id = 1,
          question = "What shape has three sides?",
          R.drawable.shapeq1,
          answer1 = "Circle",
          answer2 = "Triangle",
          answer3 = "Rectangle",
          answer4 = "Oval",
          correctAnswer = 2

      )
        questionList.add(que1)

        val que2 = QuestionClass(
            id = 2,
            question = "Who is the largest land animal?",
            R.drawable.animal,
            answer1 = "Bear",
            answer2 = "Lion",
            answer3 = "Elephant",
            answer4 = "Giraffe",
            correctAnswer = 3

        )
        questionList.add(que2)
        val que3 = QuestionClass(
            id = 3,
            question = "How many trees are cut in this picture?",
            R.drawable.trees,
            answer1 = "5",
            answer2 = "6",
            answer3 = "2",
            answer4 = "10",
            correctAnswer = 1

        )

        questionList.add(que3)
        val que4 = QuestionClass(
            id = 4,
            question = "Who invented the light bulb?",
            R.drawable.light,
            answer1 = " Isaac Newton",
            answer2 = "John logie beard",
            answer3 = "Ryte brothers",
            answer4 = "Thomas Edison",
            correctAnswer = 4

        )

        questionList.add(que4)
        val que5 = QuestionClass(
            id = 5,
            question = "What planet is known as Red planet?",
            R.drawable.solar,
            answer1 = "Venus",
            answer2 = "Mars",
            answer3 = "Earth",
            answer4 = "Neptune",
            correctAnswer = 2

        )

        questionList.add(que5)
        val que6 = QuestionClass(
            id = 6,
            question = "What is the most popular sport in the world?",
            R.drawable.winner,
            answer1 = "Swimming",
            answer2 = "Football",
            answer3 = "Cricket",
            answer4 = "BasketBall",
            correctAnswer = 2

        )

         questionList.add(que6)
        val que7 = QuestionClass(
            id = 7,
            question = "What does a thermometer measure?",
            R.drawable.temp,
            answer1 = "Time",
            answer2 = "Length",
            answer3 = "Temperature",
            answer4 = "Energy",
            correctAnswer = 3

        )

        questionList.add(que7)
        val que8 = QuestionClass(
            id = 8,
            question = "Who wrote the Harry Potter?",
            R.drawable.books,
            answer1 = "J.K. Rowling",
            answer2 = "Enid Blyton",
            answer3 = "Stephan King",
            answer4 = "Charles Dickens",
            correctAnswer = 1

        )
        questionList.add(que8)
        val que9 = QuestionClass(
            id = 9,
            question = "What country is famous for sushi?",
            R.drawable.sushi,
            answer1 = "Thailand",
            answer2 = "China",
            answer3 = "Korea",
            answer4 = "Japan",
            correctAnswer = 4

        )
        questionList.add(que9)
        val que10 = QuestionClass(
            id = 10,
            question = "Which color is a mix of blue and yellow?",
            R.drawable.colors,
            answer1 = "Black",
            answer2 = "Grey",
            answer3 = "Green",
            answer4 = "Yellow",
            correctAnswer = 3

        )
        questionList.add(que10)
        return questionList
    }
}
