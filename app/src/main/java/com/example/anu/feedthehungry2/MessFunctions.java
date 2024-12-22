package com.example.anu.feedthehungry2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MessFunctions extends AppCompatActivity {
    Button feedback;
    Button donate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess_functions);
        donate=findViewById(R.id.donate);
    }
           public void Donate(View view)
           {
               startActivity(new Intent(MessFunctions.this,NGO.class));
           }

}


