package com.example.studentdiary2;


import android.graphics.ColorSpace;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Feespaid extends Fragment {

    RecyclerView rv;
    FirebaseAuth fa;
    FirebaseUser fu;
    FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();


    public Feespaid() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feespaid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fa = FirebaseAuth.getInstance();
        fu = fa.getCurrentUser();
        String u = fu.getUid();

        rv=view.findViewById(R.id.rv);


        firebaseFirestore.collection("user").document(u).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                String s = task.getResult().get("idno").toString();



                firebaseFirestore.collection("meet").document("svnit").collection(s).
                        document(s + "feedpaid").collection("yashu").addSnapshotListener(getActivity(),new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {


                        feespaidadeptor adeptorforrecycle = new feespaidadeptor();


                        for(DocumentChange documentChange: queryDocumentSnapshots.getDocumentChanges()){

                            //    String name = documentChange.getDocument().getData().get("name").toString();


                            Model mfr= documentChange.getDocument().toObject(Model.class);
                            adeptorforrecycle.add(mfr);



                        }
                        rv.setLayoutManager(new LinearLayoutManager(getActivity()));


                        rv.setHasFixedSize(true);
                        rv.setAdapter(adeptorforrecycle);



                    }
                });

            }
        });

    }
}
