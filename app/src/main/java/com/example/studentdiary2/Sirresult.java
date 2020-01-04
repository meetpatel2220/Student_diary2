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
public class Sirresult extends Fragment {
EditText engo,enc,mgo,mc,ego,ec,phgo,phc,phpgo,phpc,chgo,chc,chpgo,chpc,id;
Button b1;
    private FirebaseFirestore firebaseFirestore;


    public Sirresult() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sirresult, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        engo=view.findViewById(R.id.engo);
        enc=view.findViewById(R.id.enc);
        mgo=view.findViewById(R.id.mgo);
        mc=view.findViewById(R.id.mc);
        ego=view.findViewById(R.id.ego);
        ec=view.findViewById(R.id.ec);
        phgo=view.findViewById(R.id.phgo);
        phc=view.findViewById(R.id.phc);
        phpgo=view.findViewById(R.id.phpgo);
        phpc=view.findViewById(R.id.phpc);
        chgo=view.findViewById(R.id.chgo);
        chc=view.findViewById(R.id.chc);
        chpgo=view.findViewById(R.id.chpgo);
        chpc=view.findViewById(R.id.chpc);
        id=view.findViewById(R.id.id);
        b1=view.findViewById(R.id.b1);
        firebaseFirestore=FirebaseFirestore.getInstance();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> hashMap=new HashMap<>();

                String engo1=engo.getText().toString();
                String enc1=enc.getText().toString();
                String mgo1=mgo.getText().toString();
                String mc1=mc.getText().toString();
                String ego1=ego.getText().toString();
                String ec1=ec.getText().toString();
                String phgo1=phgo.getText().toString();
                String phc1=phc.getText().toString();
                String phpgo1=phpgo.getText().toString();
                String phpc1=phpc.getText().toString();
                String chgo1=chgo.getText().toString();
                String chc1=chc.getText().toString();
                String chpgo1=chpgo.getText().toString();
                String chpc1=chpc.getText().toString();
                String s=id.getText().toString();

                hashMap.put("engo1",engo1);
                hashMap.put("enc1",enc1);
                hashMap.put("mgo1",mgo1);
                hashMap.put("mc1",mc1);
                hashMap.put("ego1",ego1);
                hashMap.put("ec1",ec1);
                hashMap.put("phgo1",phgo1);
                hashMap.put("phc1",phc1);
                hashMap.put("phpgo1",phpgo1);
                hashMap.put("phpc1",phpc1);
                hashMap.put("chgo1",chgo1);
                hashMap.put("chc1",chc1);
                hashMap.put("chpgo1",chpgo1);
                hashMap.put("chpc1",chpc1);


                firebaseFirestore.collection("meet").document("svnit").collection(s).
                        document( s+"result").set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
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
