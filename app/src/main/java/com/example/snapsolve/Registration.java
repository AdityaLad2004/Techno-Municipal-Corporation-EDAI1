package com.example.snapsolve;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Registration extends AppCompatActivity {
    ImageView registrationimage;
    Button register;
    TextView appname;
    EditText password,mobilenumber,firstname,lastname;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        register=findViewById(R.id.button);

        firstname=findViewById(R.id.fname);
        lastname=findViewById(R.id.lname);
        password=findViewById(R.id.loginpassword);
        mobilenumber=findViewById(R.id.mobNum);
        checkCredentials();

    }

    private boolean checkCredentials() {

        String _FirstName=firstname.getText().toString();
        String _LastName=lastname.getText().toString();
        String _MobileNo=mobilenumber.getText().toString();
        String _UserPassword=password.getText().toString();

        boolean result=true;
        if(_FirstName.isEmpty()){

            firstname.setError("Invalid First Name");
            result=false;

        }

        else if(_LastName.isEmpty()) {

            lastname.setError("Invalid Last Name");
            result=false;

        }

        else if(_MobileNo.trim().length()!=10){

            mobilenumber.setError("Invalid Mobile Number");
            result=false;

        }

        else if(_UserPassword.trim().length()<5) {

            password.setError("Invalid Password");
            result=false;

        }

        return result;

    }

    public void registerbtn(View v) throws JSONException, IOException {

        if(!checkCredentials()) {

            Toast.makeText(this, "Something Went Wrong. Try Again!!", Toast.LENGTH_SHORT).show();
            return ;

        }

        String _FirstName=firstname.getText().toString();
        String _LastName=lastname.getText().toString();
        String _MobileNo=mobilenumber.getText().toString();
        String _UserPassword=password.getText().toString();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");

        JSONObject json = new JSONObject();
        Log.e("mob",mobilenumber.getText().toString());
        Log.e("pwd",password.getText().toString());
        json.put("FirstName",firstname.getText().toString());
        json.put("LastName",lastname.getText().toString());
        json.put("MobileNo",mobilenumber.getText().toString());
        json.put("UserPassword",password.getText().toString());

        RequestBody body = RequestBody.create(mediaType, json.toString());
        Log.e("body",body.toString());
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url("http://20.235.78.253:8080/member/create")
                .method("POST", body)
                //.addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String resStr = response.body().string();
        Log.e("rese",resStr);

        if(resStr.contains("true")) {

            Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, otp1.class);
            startActivity(intent);

        }

        else{

            Toast.makeText(this, "Something Went Wrong. Try Again!!", Toast.LENGTH_SHORT).show();

        }
    }
}



