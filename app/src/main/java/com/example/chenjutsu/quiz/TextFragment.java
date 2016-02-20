package com.example.chenjutsu.quiz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.EditText;
import android.widget.Button;
import android.widget.CheckBox;
import android.app.AlertDialog.Builder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *  interface
 * to handle interaction events.
 * Use the {@link TextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button resultButton;


    private String mParam1;
    private String mParam2;
    private Boolean isRight;
    private Boolean isRight1;



    public TextFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TextFragment newInstance(String param1, String param2) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_text, container, false);

        resultButton = (Button)view.findViewById(R.id.resultButton);

        return view;

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CheckBox checkBox2 = (CheckBox)getActivity().findViewById(R.id.checkBox2);
                final CheckBox checkBox = (CheckBox)getActivity().findViewById(R.id.checkBox);
                final CheckBox checkBox3 = (CheckBox)getActivity().findViewById(R.id.checkBox3);
                final CheckBox checkBox4 = (CheckBox)getActivity().findViewById(R.id.checkBox4);
                final CheckBox checkBox5 = (CheckBox)getActivity().findViewById(R.id.checkBox5);

                //check whether the right checkBox is being checked
                if(checkBox2.isChecked()){
                    if(checkBox.isChecked()||checkBox3.isChecked()||checkBox4.isChecked()||checkBox5.isChecked()){
                        isRight = false;
                    }
                    else {
                        isRight = true;
                    }
                }
                else{
                    isRight = false;
                }
//                if(checkBox.isChecked() || checkBox3.isChecked() || checkBox4.isChecked() || checkBox5.isChecked() ){
//                    isRight = false;
//                }else if(checkBox2.isChecked()){
//                    isRight = true;
//                }else{
//                    isRight = false;
//                }

                if(QuizActivity.InputString.equalsIgnoreCase("squirrel")){
                    isRight1 = true;
                }
                if(QuizActivity.InputString.equals(" ")|| !QuizActivity.InputString.equalsIgnoreCase("squirrel")){
                    isRight1 = false;
                }

               //show the score
                displayScore();
            }
        });




    }
 /*
 show the score of the game
  */
    public void displayScore(){



        Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setCancelable(true);
        dialog.setTitle("Number of questions get right:");


        if(isRight1 && isRight){
            dialog.setMessage("get 2 questions right");
        }
        if(!isRight1 && isRight){
            dialog.setMessage("get second question right");
        }
        if(isRight1 && !isRight){
            dialog.setMessage("get first question right");
        }
        if(!isRight1 && !isRight){
            dialog.setMessage("get 0 question right");
        }



        dialog.setPositiveButton("Replay", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

                getFragmentManager().popBackStack();

            }
        });
        dialog.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                getActivity().finish();

            }
        });
        dialog.show();


    }






}
