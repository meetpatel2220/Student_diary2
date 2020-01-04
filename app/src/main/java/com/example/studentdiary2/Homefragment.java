package com.example.studentdiary2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class Homefragment extends Fragment {

    FirebaseAuth fa;
    FirebaseUser fu;
    private FirebaseFirestore firebaseFirestore;
    TextView t1, t2, t3, t4;
    FrameLayout fl;
    Button b1,b2;
    SharedPreferences sp;
    public static final String mypreference = "mypreference";
    public static final String Name = "nameKey";

    public Homefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homefragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fl = view.findViewById(R.id.fl);
        t1 = view.findViewById(R.id.t1);
        t2 = view.findViewById(R.id.t2);
        t3 = view.findViewById(R.id.t3);
        t4 = view.findViewById(R.id.t4);
        b1=view.findViewById(R.id.b1);
        b2=view.findViewById(R.id.b2);


        firebaseFirestore = FirebaseFirestore.getInstance();
        sp = getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        fa = FirebaseAuth.getInstance();
        fu = fa.getCurrentUser();
        String u = fu.getUid().toString();






        firebaseFirestore.collection("user").document(u).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String s = task.getResult().get("name").toString();
                String a = task.getResult().get("semester").toString();
                String p = task.getResult().get("idno").toString();
                String q = task.getResult().get("branch").toString();

                t1.setText(s);
                t2.setText(a);
                t3.setText(p);
                t4.setText(q);
            }
        });

    }
}
