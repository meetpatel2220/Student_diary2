package com.example.studentdiary2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button b1;
    EditText e1,e2;
    FirebaseAuth fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

b1=findViewById(R.id.b1);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        fa=FirebaseAuth.getInstance();


b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        String s1=e1.getText().toString();
        String s2=e2.getText().toString();

        if(s1.equals("meet")){

            if(s2.equals("meet")){
                Intent in=new Intent(Login.this,sirdrawerac.class);
                startActivity(in);
                finish();




            }


        }
        else {

            if(s1.isEmpty()){
                Toast.makeText(Login.this, "Please enter E-mail", Toast.LENGTH_SHORT).show();

            }
            else if(s2.isEmpty()){
                Toast.makeText(Login.this, "Please enter Your Password", Toast.LENGTH_SHORT).show();


            }
            else {

                fa.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){

                            Intent in=new Intent(Login.this,drawerac.class);
                            startActivity(in);
                            finish();

                        }

                        else {
                            Toast.makeText(Login.this, "Connection Error", Toast.LENGTH_SHORT).show();
                        }


                    }
                });

            }





        }


    }
});


    }
}

