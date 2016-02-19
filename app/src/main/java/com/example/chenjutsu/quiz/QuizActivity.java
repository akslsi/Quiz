package com.example.chenjutsu.quiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.net.Uri;


public class QuizActivity extends AppCompatActivity  {
    private EditText text;
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
          //text = (EditText)findViewById(R.id.input);

    }
//    public String findInputString(){
//
//        return  text.getText().toString();
//    }


//    public void onFragmentInteraction(String string){
//        //InputString = text.getText().toString();
//           findInputString();
//
//    }






}
