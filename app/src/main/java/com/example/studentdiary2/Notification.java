package com.example.studentdiary2;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class Notification extends Fragment {

    Button b1,b2,b3;
    TextView coin;
    SharedPreferences sp1;
    public static final String mypreference = "mypreference";
    public static final String Name = "nameKey";
    public static final String value = "0";
    public static final String q1 = "yes";
    public static final String q2 = "yes";
    public static final String q3 = "yes";



    public Notification() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        b1=view.findViewById(R.id.b1);
        b2=view.findViewById(R.id.b2);
        b3=view.findViewById(R.id.b3);
        coin=view.findViewById(R.id.coin);
        sp1 =getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(sp1.getString(q1,"")=="yes"){
                    SharedPreferences.Editor editor=sp1.edit();
                    int k= Integer.parseInt(value);
                    editor.putInt(value,k+2);
                    editor.putString(q1,"no");
                    editor.apply();

                }
              else {

                }

            }
        });


       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                   SharedPreferences.Editor editor=sp1.edit();
                   int k= Integer.parseInt(value);
                   editor.putInt(value,k+2);
                   editor.putString(q2,"no");
                   editor.apply();



           }
       });

    b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(sp1.getString(q3,"")=="yes"){
                SharedPreferences.Editor editor=sp1.edit();
                int k= Integer.parseInt(value);
                editor.putInt(value,k+2);
                editor.putString(q3,"no");
                editor.apply();

            }
            else {

            }
        }
    });

    }
}
