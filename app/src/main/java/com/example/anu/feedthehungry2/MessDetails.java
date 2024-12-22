package com.example.anu.feedthehungry2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MessDetails extends AppCompatActivity {
    EditText mtext1;
    EditText mtext2;
    EditText mtext3;
    EditText mtext4;

    Button notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess_details);
        mtext1=findViewById(R.id.editText);
        mtext2=findViewById(R.id.editText2);
        mtext3=findViewById(R.id.editText3);
        mtext4=findViewById(R.id.editText4);

        notify=findViewById(R.id.button3);

    }

    public void Notify(View view)
    {
        Intent intent=getIntent();
        String email=intent.getStringExtra("uname");

        Intent emailIntent=new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",email,null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"You Have New Food Donation Order");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"Details Are As Follows *****"+"\n"+"Food Quantity : "+mtext1.getText().toString()+"\n"+"Food Type : "+mtext2.getText().toString()+"\n"+"Hostel Address : "+mtext3.getText().toString()+"\n"+"Contact Number : "+mtext4.getText().toString());
        startActivity(Intent.createChooser(emailIntent,"NOTIFY NGO ..."));

    }
}
