package com.bihteryalcin.bihteryalcin_quizapp

object QuestionList {
// I created object class.This class have only one instance which is my list that holds QuizQuestionsModel Objects.

    fun getQuestionList(): ArrayList<QuizQuestionModel> {
        val questionList = ArrayList<QuizQuestionModel>()

        val question1 = QuizQuestionModel(
            1,"For which of the following disciplines is Nobel Prize awarded?", "Literature, Peace and Economics", "Physics and Chemistry","Physiology or Medicine","All of the above", 4
        )

        val question2 = QuizQuestionModel(
            2,"Hitler party which came into power in 1933 is known as", "Labour Party", "Nazi Party","Ku-Klux-Klan","Democratic Party", 2
        )

        val question3 = QuizQuestionModel(
            3,"Golf player Vijay Singh belongs to which country?", "USA", "Fiji","India","UK", 2
        )

        val question4 = QuizQuestionModel(
            4,"First Afghan War took place in", "1839", "1843","1833","1848", 1
        )

        val question5 = QuizQuestionModel(
            5,"First China War was fought between", "China and Britain", "China and France","China and Egypt","China and Greek", 1
        )


        val question6 = QuizQuestionModel(
            6,"During eleventh Antarctic Expedition in Nov. 1991/March 1992 ____ was installed.", "First permanent station 'Dakshin Gangotri'", "Second Permanent Station 'Maitree'","SODAR (Sonic Detection And Ranging)","None of the above",3
        )

        val question7 = QuizQuestionModel(
            7,"In which year of First World War Germany declared war on Russia and France?", "1914", "1915","1916","1917",1
        )

        val question8 = QuizQuestionModel(
            8,"How many times has Brazil won the World Cup Football Championship?", "Four times", "Twice","Five times","Once", 3
        )

        val question9 = QuizQuestionModel(
            9,"Logarithm tables were invented by", "John Napier", "John Doe","John Harrison","John Douglas", 1
        )

        val question10 = QuizQuestionModel(
            10,"Richter scale is used for measuring", "Density of liquid", "Intensity of earthquakes","Velocity of wind","Humidity of air", 2
        )


        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)
        questionList.add(question5)
        questionList.add(question6)
        questionList.add(question7)
        questionList.add(question8)
        questionList.add(question9)
        questionList.add(question10)

        return questionList

    }
}