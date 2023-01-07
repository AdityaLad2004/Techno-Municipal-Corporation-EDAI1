package com.example.snapsolve;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fName,eMail,mobNum;
    Button login;
    TextView appName;
    ImageView loginImg;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fName=findViewById(R.id.fullName);
        eMail=findViewById(R.id.eMail);
        mobNum=findViewById(R.id.mobNum);
        login=findViewById(R.id.login);
        appName=findViewById(R.id.snapSolve);
        loginImg=findViewById(R.id.loginImage);

       

    }
    public void problemCatagory(View v){
        Toast.makeText(this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, ProblemCatagory.class);
        startActivity(intent);


    }
}