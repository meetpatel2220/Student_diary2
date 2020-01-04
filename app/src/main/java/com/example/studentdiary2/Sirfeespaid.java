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
public class Sirfeespaid extends Fragment {

    EditText e1,e2,e3,e4,e5,id;
Button b1;
    private FirebaseFirestore firebaseFirestore;


    public Sirfeespaid() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sirfeespaid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseFirestore=FirebaseFirestore.getInstance();

        e1=view.findViewById(R.id.e1);
        e2=view.findViewById(R.id.e2);
        e3=view.findViewById(R.id.e3);
        e4=view.findViewById(R.id.e4);
        e5=view.findViewById(R.id.e5);
id=view.findViewById(R.id.id);

        b1=view.findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String,Object> hashMap=new HashMap<>();

                String e11=e1.getText().toString();
                String e21=e2.getText().toString();
                String e31=e3.getText().toString();
                String e41=e4.getText().toString();
                String e51=e5.getText().toString();
                String id1=id.getText().toString();

                hashMap.put("e11",e11);
                hashMap.put("e21",e21);
                hashMap.put("e31",e31);
                hashMap.put("e41",e41);
                hashMap.put("e51",e51);


                firebaseFirestore.collection("meet").document("svnit").collection(id1).
                        document( id1+"feespaid").set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){

                        }else {

                        }


                    }
                });


            }
        });


    }
}
