package com.example.studentdiary2;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


/**
 * A simple {@link Fragment} subclass.
 */
public class Internalmarks extends Fragment {

TextView t1;
CardView c1,c2,c3,c4,c5,c6,c7,c8;
    FirebaseAuth fa;
    FirebaseUser fu;
    TextView t4,t9,t10,t11,
            at4,at9,at10,at11,
            bt4,bt9,bt10,bt11,
            ct4,ct9,ct10,ct11,
            dt4,dt9,dt10,dt11,
            et4,et9,et10,et11,
            ft4,ft9,ft10,ft11;
    FrameLayout fl;
    SharedPreferences sp;
    public static final String mypreference = "mypreference";
    public static final String Name = "nameKey";

    private FirebaseFirestore firebaseFirestore;

    public Internalmarks() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_internalmarks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    t1=view.findViewById(R.id.t1);
fl=view.findViewById(R.id.fl);
        t4=view.findViewById(R.id.t4);
        t9=view.findViewById(R.id.t9);
        t10=view.findViewById(R.id.t10);
        t11=view.findViewById(R.id.t11);

        at4=view.findViewById(R.id.at4);
        at9=view.findViewById(R.id.at9);
        at10=view.findViewById(R.id.at10);
        at11=view.findViewById(R.id.at11);

        bt4=view.findViewById(R.id.bt4);
        bt9=view.findViewById(R.id.bt9);
        bt10=view.findViewById(R.id.bt10);
        bt11=view.findViewById(R.id.bt11);

        ct4=view.findViewById(R.id.ct4);
        ct9=view.findViewById(R.id.ct9);
        ct10=view.findViewById(R.id.ct10);
        ct11=view.findViewById(R.id.ct11);

        dt4=view.findViewById(R.id.dt4);
        dt9=view.findViewById(R.id.dt9);
        dt10=view.findViewById(R.id.dt10);
        dt11=view.findViewById(R.id.dt11);

        et4=view.findViewById(R.id.et4);
        et9=view.findViewById(R.id.et9);
        et10=view.findViewById(R.id.et10);
        et11=view.findViewById(R.id.et11);

        ft4=view.findViewById(R.id.ft4);
        ft9=view.findViewById(R.id.ft9);
        ft10=view.findViewById(R.id.ft10);
        ft11=view.findViewById(R.id.ft11);

        c1=view.findViewById(R.id.c1);
        c2=view.findViewById(R.id.c2);
        c3=view.findViewById(R.id.c3);
        c4=view.findViewById(R.id.c4);
        c5=view.findViewById(R.id.c5);
        c6=view.findViewById(R.id.c6);
        c7=view.findViewById(R.id.c7);


        fa = FirebaseAuth.getInstance();
        fu = fa.getCurrentUser();
        String u = fu.getUid().toString();
        firebaseFirestore=FirebaseFirestore.getInstance();

        sp = getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        String x=sp.getString(Name,"");
        if(x=="yes"){

            fl.setBackgroundColor(Color.BLACK);

            c1.setBackgroundColor(getResources().getColor(R.color.nightm));
            c2.setBackgroundColor(getResources().getColor(R.color.nightm));
            c3.setBackgroundColor(getResources().getColor(R.color.nightm));
            c4.setBackgroundColor(getResources().getColor(R.color.nightm));
            c5.setBackgroundColor(getResources().getColor(R.color.nightm));
            c6.setBackgroundColor(getResources().getColor(R.color.nightm));
            c7.setBackgroundColor(getResources().getColor(R.color.nightm));


            t4.setTextColor(Color.WHITE);
            t9.setTextColor(Color.WHITE);
            t10.setTextColor(Color.WHITE);
            t11.setTextColor(Color.WHITE);
            at4.setTextColor(Color.WHITE);
            at9.setTextColor(Color.WHITE);
            at10.setTextColor(Color.WHITE);
            at11.setTextColor(Color.WHITE);
            bt4.setTextColor(Color.WHITE);
            bt9.setTextColor(Color.WHITE);
            bt10.setTextColor(Color.WHITE);
            bt11.setTextColor(Color.WHITE);
            ct4.setTextColor(Color.WHITE);
            ct9.setTextColor(Color.WHITE);
            ct10.setTextColor(Color.WHITE);
            ct11.setTextColor(Color.WHITE);
            dt4.setTextColor(Color.WHITE);
            dt9.setTextColor(Color.WHITE);
            dt10.setTextColor(Color.WHITE);
            dt11.setTextColor(Color.WHITE);
            et4.setTextColor(Color.WHITE);
            et9.setTextColor(Color.WHITE);
            et10.setTextColor(Color.WHITE);
            et11.setTextColor(Color.WHITE);
            ft4.setTextColor(Color.WHITE);
            ft9.setTextColor(Color.WHITE);
            ft10.setTextColor(Color.WHITE);
            ft11.setTextColor(Color.WHITE);
            t1.setTextColor(Color.WHITE);

        }



        firebaseFirestore.collection("user").document(u).get().
                addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String s = task.getResult().get("name").toString();
                String s1 = task.getResult().get("idno").toString();

                t1.setText(s);

                firebaseFirestore.collection("meet").document("svnit").collection(s1).
                        document(s1 + "internalmarks").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        String pt4 = task.getResult().get("pt4").toString();
                        String pt9 = task.getResult().get("pt9").toString();
                        String pt10 = task.getResult().get("pt10").toString();
                        String pt11 = task.getResult().get("pt11").toString();

                        String pat4 = task.getResult().get("pat4").toString();
                        String pat9 = task.getResult().get("pat9").toString();
                        String pat10 = task.getResult().get("pat10").toString();
                        String pat11 = task.getResult().get("pat11").toString();

                        String pbt4 = task.getResult().get("pbt4").toString();
                        String pbt9 = task.getResult().get("pbt9").toString();
                        String pbt10 = task.getResult().get("pbt10").toString();
                        String pbt11 = task.getResult().get("pbt11").toString();

                        String pct4 = task.getResult().get("pct4").toString();
                        String pct9 = task.getResult().get("pct9").toString();
                        String pct10 = task.getResult().get("pct10").toString();
                        String pct11 = task.getResult().get("pct11").toString();

                        String pdt4 = task.getResult().get("pdt4").toString();
                        String pdt9 = task.getResult().get("pdt9").toString();
                        String pdt10 = task.getResult().get("pdt10").toString();
                        String pdt11 = task.getResult().get("pdt11").toString();

                        String pet4 = task.getResult().get("pet4").toString();
                        String pet9 = task.getResult().get("pet9").toString();
                        String pet10 = task.getResult().get("pet10").toString();
                        String pet11 = task.getResult().get("pet11").toString();

                        String pft4 = task.getResult().get("pft4").toString();
                        String pft9 = task.getResult().get("pft9").toString();
                        String pft10 = task.getResult().get("pft10").toString();
                        String pft11 = task.getResult().get("pft11").toString();

                        t4.setText(pt4);
                        t9.setText(pt9);
                        t10.setText(pt10);
                        t11.setText(pt11);

                        at4.setText(pat4);
                        at9.setText(pat9);
                        at10.setText(pat10);
                        at11.setText(pat11);

                        bt4.setText(pbt4);
                        bt9.setText(pbt9);
                        bt10.setText(pbt10);
                        bt11.setText(pbt11);

                        ct4.setText(pct4);
                        ct9.setText(pct9);
                        ct10.setText(pct10);
                        ct11.setText(pct11);

                        dt4.setText(pdt4);
                        dt9.setText(pdt9);
                        dt10.setText(pdt10);
                        dt11.setText(pdt11);

                        et4.setText(pet4);
                        et9.setText(pet9);
                        et10.setText(pet10);
                        et11.setText(pet11);

                        ft4.setText(pft4);
                        ft9.setText(pft9);
                        ft10.setText(pft10);
                        ft11.setText(pft11);




                    }
                });


            }
        });

    }
}
