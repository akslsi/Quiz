package com.example.chenjutsu.quiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.CheckBox;
public class QuizActivity extends AppCompatActivity {
//    EditText mEdit;
//    CheckBox check;
//    private String correct1;
//    private String correct2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container,QuizFragment.newInstance(null,null))
                .addToBackStack(null)
                .commit();
//        check = (CheckBox)findViewById(R.id.checkBox2);
//        correct1 = "animal";
//        correct2 = check.getText().toString();
//        mEdit = (EditText)findViewById(R.id.input);



       //String userAnswer =  mEdit.getText().toString();
        //if(userAnswer == correct1){
//            int num = 1;
//            //call the fragment
//            TextFragment fragment = (TextFragment)getFragmentManager().findFragmentById(R.id.text_fragment);
//            fragment.displayScore(num);
//            System.out.println("hello");
        //}


    }





}
