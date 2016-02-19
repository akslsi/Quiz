package com.example.chenjutsu.quiz;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class QuizActivity extends AppCompatActivity  {

    public static String InputString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, QuizFragment.newInstance(null, null))
                .addToBackStack(null)
                .commit();


    }







}
