package com.example.snapsolve;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class LastScreen extends AppCompatActivity {
    TextView t;
    ImageView i;
    Button b1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_screen);
        t=findViewById(R.id.t);
        i=findViewById(R.id.i);
        b1=findViewById(R.id.add);



    }
    
    public void add(View v){
        Intent intent=new Intent(this,ProblemCatagory.class);
        startActivity(intent);
    }


}