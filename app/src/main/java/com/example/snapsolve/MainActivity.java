package com.example.snapsolve;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    EditText username,mobNum,dob,password;
    Button login;
    TextView appName;
    ImageView loginImg;
    TextView registration;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mobNum = findViewById(R.id.mobNum);
        password = findViewById(R.id.loginpassword);
        registration=findViewById(R.id.notregistered);
        login = findViewById(R.id.login);
        appName = findViewById(R.id.snapSolve);
        loginImg = findViewById(R.id.loginImage);


        checkCredentials();
    }


    private boolean checkCredentials(){

        String _MobileNo=mobNum.getText().toString();
        String _UserPassword=password.getText().toString();

        boolean result=true;


         if(_MobileNo.trim().length()!=10){
            mobNum.setError("Invalid Mobile Number");
            result=false;
        }

        else if(_UserPassword.isEmpty()){
            password.setError("Invalid Password");
            result=false;

        }

        return result;

    }

    public void problemCatagory(View v) throws IOException, JSONException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");

        //RequestBody body = RequestBody.create(mediaType, "{\"MobileNo\": \"9579318602\",\"UserPassword\": \"Aditya.lad\"}");
        JSONObject json = new JSONObject();
        Log.e("mob",mobNum.getText().toString());
        Log.e("pwd",password.getText().toString());
        json.put("MobileNo",mobNum.getText().toString());
        json.put("UserPassword",password.getText().toString());

        RequestBody body = RequestBody.create(mediaType, json.toString());
       Log.e("body",body.toString());
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url("http://20.235.78.253:8080/member/login")
                .method("POST", body)
                //.addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String resStr = response.body().string();
        Log.e("rese",resStr);
        //JSONObject result=new JSONObject(response.body().string());
        if(resStr.contains("true")) {
            Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, ProblemCatagory.class);
            startActivity(i);
        }

        else{
            Toast.makeText(this, "User Not Found!!", Toast.LENGTH_SHORT).show();
        }

        }

        public void register(View v){
        Intent intent=new Intent(this, Registration.class);
        startActivity(intent);
        }
    }
