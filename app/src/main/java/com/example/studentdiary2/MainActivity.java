package com.example.studentdiary2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Thread t;
    FirebaseAuth fba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fba=FirebaseAuth.getInstance();
        final FirebaseUser fbu=fba.getCurrentUser();

        t=new Thread(){

            @Override
            public void run() {
                super.run();

                try{
                    Thread.sleep(1000);
                    if(fbu==null) {


                        Intent in = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(in);
                    }
                    else{
                        Intent in = new Intent(MainActivity.this, drawerac.class);
                        startActivity(in);
                    }
                    finish();


                }
                catch (Exception e){

                }

            }
        };
        t.start();

    }
}
