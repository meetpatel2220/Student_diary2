package com.example.studentdiary2;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class Attendance extends Fragment {

    TextView cy,ct,my,mt,fy,ft,ey,et,eny,ent,t1,tx,textv;
    private FirebaseFirestore firebaseFirestore;
    FirebaseAuth fa;
    FirebaseUser fu;
FrameLayout fl;
    SharedPreferences sp;
    public static final String mypreference = "mypreference";
    public static final String Name = "nameKey";



    public Attendance() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attendance, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fl=view.findViewById(R.id.fl);
        cy=view.findViewById(R.id.cy);
        ct=view.findViewById(R.id.ct);
        my=view.findViewById(R.id.my);
        mt=view.findViewById(R.id.mt);
        fy=view.findViewById(R.id.fy);
        ft=view.findViewById(R.id.ft);
        ey=view.findViewById(R.id.ey);
        et=view.findViewById(R.id.et);
        eny=view.findViewById(R.id.eny);
        ent=view.findViewById(R.id.ent);
t1=view.findViewById(R.id.t1);
textv=view.findViewById(R.id.textv);
        firebaseFirestore=FirebaseFirestore.getInstance();
        fa=FirebaseAuth.getInstance();
        fu=fa.getCurrentUser();
        sp = getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
String x=sp.getString(Name,"");
if(x=="yes"){

    fl.setBackgroundColor(Color.BLACK);
    cy.setTextColor(Color.WHITE);
    ct.setTextColor(Color.WHITE);
    my.setTextColor(Color.WHITE);
    mt.setTextColor(Color.WHITE);
    fy.setTextColor(Color.WHITE);
    ft.setTextColor(Color.WHITE);
    ey.setTextColor(Color.WHITE);
    et.setTextColor(Color.WHITE);
    eny.setTextColor(Color.WHITE);
    ent.setTextColor(Color.WHITE);
    t1.setTextColor(Color.WHITE);
}


        String u=fu.getUid();




        firebaseFirestore.collection("user").document(u).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                String s=task.getResult().get("idno").toString();
                String p = task.getResult().get("name").toString();
                t1.setText(p);


                firebaseFirestore.collection("meet").document("svnit").collection(s).
                        document( s+"attendance").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        String ct1=task.getResult().get("ct1").toString();
                        String my1=task.getResult().get("my1").toString();
                        String mt1=task.getResult().get("mt1").toString();
                        String fy1=task.getResult().get("fy1").toString();
                        String ft1=task.getResult().get("ft1").toString();
                        String ey1=task.getResult().get("ey1").toString();
                        String et1=task.getResult().get("et1").toString();
                        String eny1=task.getResult().get("eny1").toString();
                        String ent1=task.getResult().get("ent1").toString();
                        String cy1=task.getResult().get("cy1").toString();


                        cy.setText(cy1);
                        ct.setText(ct1);
                        my.setText(my1);
                        mt.setText(mt1);
                        fy.setText(fy1);
                        ft.setText(ft1);
                        ey.setText(ey1);
                        et.setText(et1);
                        eny.setText(eny1);
                        ent.setText(ent1);

                    }
                });


            }
         });



    }
}
