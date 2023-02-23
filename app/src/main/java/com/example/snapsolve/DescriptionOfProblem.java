package com.example.snapsolve;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DescriptionOfProblem extends AppCompatActivity {

TextView t;
EditText e;
Button b;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_of_problem);

        t=findViewById(R.id.textinfo);
        e=findViewById(R.id.textbox);
        b=findViewById(R.id.button2);
    }

    public void googlemap(View v){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
}