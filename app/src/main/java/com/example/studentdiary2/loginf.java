package com.example.studentdiary2;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class loginf extends Fragment {
private Button b1;
private EditText e1,p1;
    private FragmentTransaction fragmentTransaction;
    public loginf() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loginf, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        b1=view.findViewById(R.id.b1);
        e1=view.findViewById(R.id.e1);
        p1=view.findViewById(R.id.p1);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1=e1.getText().toString();
                String s2=p1.getText().toString();

                if(s1.isEmpty()){

                    Toast.makeText(getActivity(), "Please enter your email", Toast.LENGTH_SHORT).show();

         }
                else if(s2.isEmpty()){

                    Toast.makeText(getActivity(), "Please enter your Password", Toast.LENGTH_SHORT).show();


                }
                else {


                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                 fragmentTransaction = getFragmentManager().beginTransaction();
                                 Fragment fragment=new Profile();
                                fragmentTransaction.replace(R.id.framlayout, fragment);
                                fragmentTransaction.commit();

                            }
                            else {
                                Toast.makeText(getActivity(), "Connection Error", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }



            }
        });

    }
}
