package com.example.studentdiary2;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
* create an instance of this fragment.
 */
public class Profile extends Fragment {

    private EditText name,idno,mobileno,branch,degree,semester,fathername,mothername,hostel,hostelroom,gender,dob,category;
 Button b1;
    FirebaseAuth fa;
    FirebaseUser fu;
     private FirebaseFirestore firebaseFirestore;

    public Profile() {
        // Required empty public constructor



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);







    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        fa=FirebaseAuth.getInstance();
        fu=fa.getCurrentUser();

        name=view.findViewById(R.id.name);


        idno=view.findViewById(R.id.idno);
        mobileno=view.findViewById(R.id.mobileno);
        branch=view.findViewById(R.id.branch);
        degree=view.findViewById(R.id.degree);
        semester=view.findViewById(R.id.semester);
        fathername=view.findViewById(R.id.fathername);
        mothername=view.findViewById(R.id.mothername);
        hostel=view.findViewById(R.id.hostelname);
        hostelroom=view.findViewById(R.id.hostelroom);
        gender=view.findViewById(R.id.gender);
        dob=view.findViewById(R.id.dob);
        category=view.findViewById(R.id.category);
        b1=view.findViewById(R.id.b1);


        firebaseFirestore=FirebaseFirestore.getInstance();



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String,Object> hashMap=new HashMap<>();

             String name1=name.getText().toString();
                String idno1=idno.getText().toString();
                String mobileno1=mobileno.getText().toString();
                String branch1=branch.getText().toString();
                String degree1=degree.getText().toString();
                String semester1=semester.getText().toString();
                String fathername1=fathername.getText().toString();
                String mothername1=mothername.getText().toString();
                String hostel1=hostel.getText().toString();
                String hostelroom1=hostelroom.getText().toString();
                String gender1=gender.getText().toString();
                String dob1=dob.getText().toString();
                String category1=category.getText().toString();

                String s=fu.getUid().toString();


          if(name1.isEmpty()){

                name.setError("Please enter your name");
          }
          else if(idno1.isEmpty()){
              idno.setError("Please enter your ID.No");


          }
          else if(mobileno1.isEmpty()){
              mobileno.setError("Please enter your Mobile no.");


          }  else if(branch1.isEmpty()){
              branch.setError("Please enter your Branch");


          }  else if(degree1.isEmpty()){
              degree.setError("Please enter your Degree");


          }  else if(semester1.isEmpty()){
              semester.setError("Please enter your semester");


          }  else if(fathername1.isEmpty()){
              fathername.setError("Please enter your fathername");


          }  else if(mothername1.isEmpty()){
              mothername.setError("Please enter your Mothername");


          }  else if(hostel1.isEmpty()){
              hostel.setError("Please enter your Hostel name");


          }  else if(hostelroom1.isEmpty()){
              hostelroom.setError("Please enter your Hostel room no.");


          }  else if(gender1.isEmpty()){
              gender.setError("Please enter your gender");


          }  else if(dob1.isEmpty()){
              dob.setError("Please enter your Date of birth");


          }
          else if(category1.isEmpty()){
              category.setError("Please enter your category");


          }
          else {

              hashMap.put("name",name1);
              hashMap.put("idno",idno1);
              hashMap.put("mobileno",mobileno1);
              hashMap.put("branch",branch1);
              hashMap.put("degree",degree1);
              hashMap.put("semester",semester1);
              hashMap.put("fathername",fathername1);
              hashMap.put("mothername",mothername1);
              hashMap.put("hostel",hostel1);
              hashMap.put("hostelroom",hostelroom1);
              hashMap.put("gender",gender1);
              hashMap.put("dob",dob1);
              hashMap.put("category",category1);


              firebaseFirestore.collection("user").document(s).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                  @Override
                  public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                      String id=task.getResult().get("idno").toString();
                      HashMap<String,Object> hashMap2=new HashMap<>();

                      hashMap2.put("cy1","-");
                      hashMap2.put("ct1","-");
                      hashMap2.put("my1","-");
                      hashMap2.put("mt1","-");
                      hashMap2.put("fy1","-");
                      hashMap2.put("ft1","-");
                      hashMap2.put("ey1","-");
                      hashMap2.put("et1","-");
                      hashMap2.put("eny1","-");
                      hashMap2.put("ent1","-");

                      HashMap<String,Object> hashMap3=new HashMap<>();

                      hashMap3.put("e11","-");
                      hashMap3.put("e21","-");
                      hashMap3.put("e31","-");
                      hashMap3.put("e41","-");
                      hashMap3.put("e51","-");

                      firebaseFirestore.collection("meet").document("svnit").collection(id).
                              document( id+"feespaid").collection("yashu").document("yashures").set(hashMap3).addOnCompleteListener(new OnCompleteListener<Void>() {
                          @Override
                          public void onComplete(@NonNull Task<Void> task) {

                              if(task.isSuccessful()){

                              }else {


                              }


                          }
                      });

                      HashMap<String,Object> hashMap1=new HashMap<>();
                      hashMap1.put("engo1","-");
                      hashMap1.put("enc1","-");
                      hashMap1.put("mgo1","-");
                      hashMap1.put("mc1","-");
                      hashMap1.put("ego1","-");
                      hashMap1.put("ec1","-");
                      hashMap1.put("phgo1","-");
                      hashMap1.put("phc1","-");
                      hashMap1.put("phpgo1","-");
                      hashMap1.put("phpc1","-");
                      hashMap1.put("chgo1","-");
                      hashMap1.put("chc1","-");
                      hashMap1.put("chpgo1","-");
                      hashMap1.put("chpc1","-");


                      HashMap<String,Object> hashMap4=new HashMap<>();
                      hashMap4.put("pt4","-");
                      hashMap4.put("pt9","-");
                      hashMap4.put("pt10","-");
                      hashMap4.put("pt11","-");

                      hashMap4.put("pat4","-");
                      hashMap4.put("pat9","-");
                      hashMap4.put("pat10","-");
                      hashMap4.put("pat11","-");

                      hashMap4.put("pbt4","-");
                      hashMap4.put("pbt9","-");
                      hashMap4.put("pbt10","-");
                      hashMap4.put("pbt11","-");

                      hashMap4.put("pct4","-");
                      hashMap4.put("pct9","-");
                      hashMap4.put("pct10","-");
                      hashMap4.put("pct11","-");

                      hashMap4.put("pdt4","-");
                      hashMap4.put("pdt9","-");
                      hashMap4.put("pdt10","-");
                      hashMap4.put("pdt11","-");

                      hashMap4.put("pet4","-");
                      hashMap4.put("pet9","-");
                      hashMap4.put("pet10","-");
                      hashMap4.put("pet11","-");

                      hashMap4.put("pft4","-");
                      hashMap4.put("pft9","-");
                      hashMap4.put("pft10","-");
                      hashMap4.put("pft11","-");

                      firebaseFirestore.collection("meet").document("svnit").collection(id).
                              document( id+"internalmarks").set(hashMap4).addOnCompleteListener(new OnCompleteListener<Void>() {
                          @Override
                          public void onComplete(@NonNull Task<Void> task) {
                              if(task.isSuccessful()){

                              }else {


                              }

                          }
                      });


                      firebaseFirestore.collection("meet").document("svnit").collection(id).
                              document( id+"result").set(hashMap1).addOnCompleteListener(new OnCompleteListener<Void>() {
                          @Override
                          public void onComplete(@NonNull Task<Void> task) {

                              if(task.isSuccessful()){

                              }else {


                              }

                          }
                      });

                      firebaseFirestore.collection("meet").document("svnit").
                              collection(id+"").
                              document(id+"attendance").set(hashMap2).addOnCompleteListener(new OnCompleteListener<Void>() {
                          @Override
                          public void onComplete(@NonNull Task<Void> task) {

                              if(task.isSuccessful()){

                              }else {


                              }
                          }
                      });

                  }
              });






              firebaseFirestore.collection("user").document(s).set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
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

              Intent in=new Intent(getActivity(),drawerac.class);
              startActivity(in);
              getActivity().finish();

          }






            }
        });


    }
}
