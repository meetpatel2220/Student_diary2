package com.example.studentdiary2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class Sirattendance extends Fragment {

    EditText cy,ct,my,mt,fy,ft,ey,et,eny,ent,id;
    Button b1;
    private FirebaseFirestore firebaseFirestore;


    public Sirattendance() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sirattendance, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        b1=view.findViewById(R.id.b1);
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
        id=view.findViewById(R.id.id);
        firebaseFirestore=FirebaseFirestore.getInstance();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> hashMap=new HashMap<>();

                String cy1=cy.getText().toString();
                String ct1=ct.getText().toString();
                String my1=my.getText().toString();
                String mt1=mt.getText().toString();
                String fy1=fy.getText().toString();
                String ft1=ft.getText().toString();
                String ey1=ey.getText().toString();
                String et1=et.getText().toString();
                String eny1=eny.getText().toString();
                String ent1=ent.getText().toString();
String s=id.getText().toString();

                hashMap.put("cy1",cy1);
                hashMap.put("ct1",ct1);
                hashMap.put("my1",my1);
                hashMap.put("mt1",mt1);
                hashMap.put("fy1",fy1);
                hashMap.put("ft1",ft1);
                hashMap.put("ey1",ey1);
                hashMap.put("et1",et1);
                 hashMap.put("eny1",eny1);
                hashMap.put("ent1",ent1);


   firebaseFirestore.collection("meet").document("svnit").collection(s+"").
        document(s+"attendance").set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
    @Override
    public void onComplete(@NonNull Task<Void> task) {
        if(task.isSuccessful()){
            //  Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
        }
        else{

            //   Toast.makeText(getContext(), "Connection Error", Toast.LENGTH_SHORT).show();
        }

    }
});




            }
        });


    }
}


