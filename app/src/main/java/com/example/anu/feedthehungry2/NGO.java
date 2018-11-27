package com.example.anu.feedthehungry2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.anu.feedthehungry2.MessDetails;

import java.util.ArrayList;
import java.util.List;

public class NGO extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo);

        ListView listView = findViewById(R.id.ListView);

        final ArrayList<String> myNgo = new ArrayList<String>();
        myNgo.add("anuragkamboj20@gmail.com");
        myNgo.add("iiiengineer786786@gmail.com");
        myNgo.add("kgupta_be16@thapar.edu");
        myNgo.add("akamboj1_be16@thapar.edu");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myNgo);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(NGO.this,MessDetails.class);
                intent.putExtra("uname",myNgo.get(position));
                startActivity(intent);
            }
        });
    }

}