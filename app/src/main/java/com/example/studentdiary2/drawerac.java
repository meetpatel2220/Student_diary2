package com.example.studentdiary2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class drawerac extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentTransaction fragmentTransaction;
     int i=0;
    private FirebaseFirestore firebaseFirestore;
    FirebaseAuth fa;
    FirebaseUser fu;
    SharedPreferences sp;
    public static final String mypreference = "mypreference";
    public static final String Name = "nameKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_drawerac);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseFirestore = FirebaseFirestore.getInstance();
        fa = FirebaseAuth.getInstance();
        fu = fa.getCurrentUser();
        sp =getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);



        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framlayout, new Homefragment());
        fragmentTransaction.commit();



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if(i==1){
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new Homefragment());
            fragmentTransaction.commit();
           i=0;
        }

        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawerac, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            FirebaseAuth.getInstance().signOut();
            Intent in=new Intent(drawerac.this,Main2Activity.class);
            startActivity(in);
            finish();

            return true;
        }

        if (id == R.id.action_daymode) {
            SharedPreferences.Editor editor=sp.edit();
            editor.putString(Name,"no");
            editor.apply();


            return true;
        }


        if(id==R.id.action_nightmode){

         SharedPreferences.Editor editor=sp.edit();
         editor.putString(Name,"yes");
         editor.apply();



            return true;


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if(id==R.id.home){
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new Homefragment());
            fragmentTransaction.commit();



        }
        else if(id==R.id.attendance){
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new Attendance());
            fragmentTransaction.commit();
             i=1;

        }
        else if(id==R.id.notification){
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new Notification());
            fragmentTransaction.commit();
            i=1;


        }else if(id==R.id.result){
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new result());
            fragmentTransaction.commit();
            i=1;


        }else if(id==R.id.internalmarks){
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new Internalmarks());
            fragmentTransaction.commit();
            i=1;


        }else if(id==R.id.feespaid){
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new Feespaid());
            fragmentTransaction.commit();
            i=1;


        }else if(id==R.id.classschedule){
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new classschedule());
            fragmentTransaction.commit();


        }
        else if(id==R.id.changepassword){
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new changepassword());
            fragmentTransaction.commit();
            i=1;


        }



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
