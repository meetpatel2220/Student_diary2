package com.example.studentdiary2;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class classschedule extends Fragment {
    SharedPreferences sp1;
    public static final String mypreference = "mypreference";
    public static final String Name = "nameKey";
    public static final String value = "value";
    public static final String q1 = "yes";
    public static final String q2 = "yes";
    public static final String q3 = "yes";


TextView t1;
    public classschedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classschedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        t1=view.findViewById(R.id.t1);


        sp1 = getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

         t1.setText(sp1.getString(value,""));




    }
}
