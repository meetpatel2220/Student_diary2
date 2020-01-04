package com.example.studentdiary2;


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
 */
public class Sirinternalmarks extends Fragment {

EditText t4,t9,t10,t11,
        at4,at9,at10,at11,
        bt4,bt9,bt10,bt11,
       ct4,ct9,ct10,ct11,
        dt4,dt9,dt10,dt11,
        et4,et9,et10,et11,
        ft4,ft9,ft10,ft11,id;
    Button b1;
    private FirebaseFirestore firebaseFirestore;



    public Sirinternalmarks() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sirinternalmarks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseFirestore=FirebaseFirestore.getInstance();

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

        id=view.findViewById(R.id.id);

        b1=view.findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String,Object> hashMap=new HashMap<>();

                String pt4=t4.getText().toString();
                String pt9=t9.getText().toString();
                String pt10=t10.getText().toString();
                String pt11=t11.getText().toString();

                String pat4=at4.getText().toString();
                String pat9=at9.getText().toString();
                String pat10=at10.getText().toString();
                String pat11=at11.getText().toString();

                String pbt4=bt4.getText().toString();
                String pbt9=bt9.getText().toString();
                String pbt10=bt10.getText().toString();
                String pbt11=bt11.getText().toString();

                String pct4=ct4.getText().toString();
                String pct9=ct9.getText().toString();
                String pct10=ct10.getText().toString();
                String pct11=ct11.getText().toString();

                String pdt4=dt4.getText().toString();
                String pdt9=dt9.getText().toString();
                String pdt10=dt10.getText().toString();
                String pdt11=dt11.getText().toString();

                String pet4=et4.getText().toString();
                String pet9=et9.getText().toString();
                String pet10=et10.getText().toString();
                String pet11=et11.getText().toString();

                String pft4=ft4.getText().toString();
                String pft9=ft9.getText().toString();
                String pft10=ft10.getText().toString();
                String pft11=ft11.getText().toString();



                hashMap.put("pt4",pt4);
                hashMap.put("pt9",pt9);
                hashMap.put("pt10",pt10);
                hashMap.put("pt11",pt11);

                hashMap.put("pat4",pat4);
                hashMap.put("pat9",pat9);
                hashMap.put("pat10",pat10);
                hashMap.put("pat11",pat11);

                hashMap.put("pbt4",pbt4);
                hashMap.put("pbt9",pbt9);
                hashMap.put("pbt10",pbt10);
                hashMap.put("pbt11",pbt11);

                hashMap.put("pct4",pct4);
                hashMap.put("pct9",pct9);
                hashMap.put("pct10",pct10);
                hashMap.put("pct11",pct11);

                hashMap.put("pdt4",pdt4);
                hashMap.put("pdt9",pdt9);
                hashMap.put("pdt10",pdt10);
                hashMap.put("pdt11",pdt11);

                hashMap.put("pet4",pet4);
                hashMap.put("pet9",pet9);
                hashMap.put("pet10",pet10);
                hashMap.put("pet11",pet11);

                hashMap.put("pft4",pft4);
                hashMap.put("pft9",pft9);
                hashMap.put("pft10",pft10);
                hashMap.put("pft11",pft11);

                String id1=id.getText().toString();



                firebaseFirestore.collection("meet").document("svnit").collection(id1).
                        document( id1+"internalmarks").set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
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
