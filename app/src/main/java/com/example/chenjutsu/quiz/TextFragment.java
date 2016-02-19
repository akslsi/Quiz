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
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button resultButton;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Boolean isRight;
    private Boolean isRight1;
    private int num;




    //private OnFragmentInteractionListener mListener;

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
        num = 0;


         final CheckBox checkBox2 = (CheckBox)view.findViewById(R.id.checkBox2);
         final CheckBox checkBox = (CheckBox)view.findViewById(R.id.checkBox);
         final CheckBox checkBox3 = (CheckBox)view.findViewById(R.id.checkBox3);
         final CheckBox checkBox4 = (CheckBox)view.findViewById(R.id.checkBox4);
         final CheckBox checkBox5 = (CheckBox)view.findViewById(R.id.checkBox5);
      //check whether the right checkBox is being checked
        if(checkBox2.isChecked() && !checkBox.isChecked() && !checkBox3.isChecked()&&
                checkBox4.isChecked()&&checkBox5.isChecked()){
            isRight = true;
        }else{
            isRight = false;
        }
//        if(checkBox2.isChecked()){
//              num = 0;
//        }
//        if(checkBox.isChecked()){
//              num++;
//        }
//        if(checkBox3.isChecked()){
//              num++;
//         }
//        if(checkBox4.isChecked()){
//              num++;
//         }
//        if(checkBox5.isChecked()){
//              num++;
//        }
//        if(num > 0){
//            isRight = false;
//        }
//        if(num == 0){
//            isRight = true;
//        }

        resultButton = (Button)view.findViewById(R.id.resultButton);

        return view;

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       if(QuizActivity.InputString.equals("animal")){
           isRight1 = true;
       }
        if(QuizActivity.InputString.equals(" ")|| !QuizActivity.InputString.equals("animal")){
            isRight1 = false;
        }

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    displayScore();





            }
        });



    }









    public void displayScore(){

        //TODO finish implementing this AlertDialog

        Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setCancelable(true);
        dialog.setTitle("Number of questions get right:");
//        if(num == 0){
//            isRight = true;
//        }else{
//            isRight = false;
//        }

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
                //TODO start a rematch!
                getFragmentManager().popBackStack();

            }
        });
        dialog.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //TODO back out the the start screen
                getActivity().finish();

            }
        });
        dialog.show();
//        //do a prompt about the winner
//        new AlertDialog.Builder(getActivity())
//                .setCancelable(true)
//                .setTitle("number get right:")
//
//                    .setMessage("you get 1 right")
//
//                .setPositiveButton("Replay", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //TODO start a rematch!
//                        getFragmentManager().popBackStack();
//
//                    }
//                })
//                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //TODO back out the the start screen
//                        getActivity().finish();
//
//                    }
//                })
//                .show();

    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    //@Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
//    public interface OnFragmentInteractionListener{
//        void onFragmentInteraction(Uri uri);
//    }
}
