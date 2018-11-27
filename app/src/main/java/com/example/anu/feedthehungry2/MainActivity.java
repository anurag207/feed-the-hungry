package com.example.anu.feedthehungry2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    EditText user1;

    EditText pass;

    Button register;

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user1=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        register=findViewById(R.id.regbutton);
        login=findViewById(R.id.regbutton);

    }

    public void gosign(View view) {

        String s1= user1.getText().toString();
        String passwrd=pass.getText().toString();

        Log.d("er",s1+' '+passwrd);
        FirebaseDatabase mainref=FirebaseDatabase.getInstance();

        Users u1=new Users();
        u1.setPassword(passwrd);
        u1.setUsername(s1);
        if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(passwrd)){
            Toast.makeText(this, "Empty field is not allowed..", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity.class));
        }
       else{
            mainref.getReference().child("Users/"+s1).setValue(u1).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    //move to next activity
                    startActivity(new Intent(MainActivity.this,NGO.class));
                }
            });

        }


    }

    public void login(View view) {
         FirebaseDatabase userdb=FirebaseDatabase.getInstance();

         userdb.getReference().child("Users").child(user1.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 int count=0;
                     Users user=(Users)dataSnapshot.getValue(Users.class);
                     if(user.getUsername()!=""){
                         Toast.makeText(MainActivity.this, "Error Username not registered", Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(getApplicationContext(),MainActivity.class));
                     }
                     else if(user.getUsername().equals(user1.getText().toString()))
                     {
                         if(user.getPassword().equals(pass.getText().toString()))
                         {
                             startActivity(new Intent(MainActivity.this,NGO.class));
                         }
                         else{
                             Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                         }
                     }
                     else{
                         Toast.makeText(MainActivity.this, "not registered", Toast.LENGTH_SHORT).show();
                     }


             }

             @Override
             public void onCancelled(DatabaseError databaseError) {

             }
         });

    }
}