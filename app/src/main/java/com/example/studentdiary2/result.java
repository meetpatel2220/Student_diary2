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
public class result extends Fragment {
    TextView engo, enc, mgo, mc, ego, ec, phgo, phc, phpgo, phpc, chgo, chc, chpgo, chpc, t1;
    private FirebaseFirestore firebaseFirestore;
    FirebaseAuth fa;
    FirebaseUser fu;
    FrameLayout fl;
    CardView c1,c2,c3,c4,c5,c6,c7,c8;

    SharedPreferences sp;
    public static final String mypreference = "mypreference";
    public static final String Name = "nameKey";


    public result() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fl=view.findViewById(R.id.fl);
        engo = view.findViewById(R.id.engo);
        enc = view.findViewById(R.id.enc);
        mgo = view.findViewById(R.id.mgo);
        mc = view.findViewById(R.id.mc);
        ego = view.findViewById(R.id.ego);
        ec = view.findViewById(R.id.ec);
        phgo = view.findViewById(R.id.phgo);
        phc = view.findViewById(R.id.phc);
        phpgo = view.findViewById(R.id.phpgo);
        phpc = view.findViewById(R.id.phpc);
        chgo = view.findViewById(R.id.chgo);
        chc = view.findViewById(R.id.chc);
        chpgo = view.findViewById(R.id.chpgo);
        chpc = view.findViewById(R.id.chpc);
        firebaseFirestore = FirebaseFirestore.getInstance();
        fa = FirebaseAuth.getInstance();
        fu = fa.getCurrentUser();
        t1 = view.findViewById(R.id.t1);
        c1=view.findViewById(R.id.c1);
        c2=view.findViewById(R.id.c2);
        c3=view.findViewById(R.id.c3);
        c4=view.findViewById(R.id.c4);
        c5=view.findViewById(R.id.c5);
        c6=view.findViewById(R.id.c6);
        c7=view.findViewById(R.id.c7);


        String u = fu.getUid();



        sp = getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        String x=sp.getString(Name,"");

        if(x=="yes"){

            fl.setBackgroundColor(Color.BLACK);
            engo.setTextColor(Color.WHITE);
            enc.setTextColor(Color.WHITE);
            mgo.setTextColor(Color.WHITE);
            mc.setTextColor(Color.WHITE);
            ego.setTextColor(Color.WHITE);
            ec.setTextColor(Color.WHITE);
            phgo.setTextColor(Color.WHITE);
            phc.setTextColor(Color.WHITE);
            phpgo.setTextColor(Color.WHITE);
            phpc.setTextColor(Color.WHITE);
            chgo.setTextColor(Color.WHITE);
            chc.setTextColor(Color.WHITE);
            chpgo.setTextColor(Color.WHITE);
            chpc.setTextColor(Color.WHITE);
            t1.setTextColor(Color.WHITE);

            c1.setBackgroundColor(getResources().getColor(R.color.nightm));
            c2.setBackgroundColor(getResources().getColor(R.color.nightm));
            c3.setBackgroundColor(getResources().getColor(R.color.nightm));
            c4.setBackgroundColor(getResources().getColor(R.color.nightm));
            c5.setBackgroundColor(getResources().getColor(R.color.nightm));
            c6.setBackgroundColor(getResources().getColor(R.color.nightm));
            c7.setBackgroundColor(getResources().getColor(R.color.nightm));




        }

        firebaseFirestore.collection("user").document(u).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String s = task.getResult().get("idno").toString();
                String p = task.getResult().get("name").toString();
                t1.setText(p);



                firebaseFirestore.collection("meet").document("svnit").collection(s).
                        document(s + "result").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {


                        String engo1 = task.getResult().get("engo1").toString();
                        String enc1 = task.getResult().get("enc1").toString();
                        String mgo1 = task.getResult().get("mgo1").toString();
                        String mc1 = task.getResult().get("mc1").toString();
                        String ego1 = task.getResult().get("ego1").toString();
                        String ec1 = task.getResult().get("ec1").toString();
                        String phgo1 = task.getResult().get("phgo1").toString();
                        String phc1 = task.getResult().get("phc1").toString();
                        String phpgo1 = task.getResult().get("phpgo1").toString();
                        String phpc1 = task.getResult().get("phpc1").toString();
                        String chgo1 = task.getResult().get("chgo1").toString();
                        String chc1 = task.getResult().get("chc1").toString();
                        String chpgo1 = task.getResult().get("chpgo1").toString();
                        String chpc1 = task.getResult().get("chpc1").toString();


                        engo.setText(engo1);
                        enc.setText(enc1);
                        mgo.setText(mgo1);
                        mc.setText(mc1);
                        ego.setText(ego1);
                        ec.setText(ec1);
                        phgo.setText(phgo1);
                        phc.setText(phc1);
                        phpgo.setText(phpgo1);
                        phpc.setText(phpc1);
                        chgo.setText(chgo1);
                        chc.setText(chc1);
                        chpgo.setText(chpgo1);
                        chpc.setText(chpc1);

                    }
                });


            }
        });


    }
}
