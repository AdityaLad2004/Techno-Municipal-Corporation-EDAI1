package com.example.snapsolve;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class imageAndDescriptionstray extends AppCompatActivity {
    private final int CAMERA_REQ_CODE=100;
    ImageView imgcamera;
    Button btn,nxtbtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_and_descriptionstray);
        imgcamera = findViewById(R.id.probImg);
        btn = findViewById(R.id.camera);
        nxtbtn=findViewById(R.id.nxtbtnstray);

    }

    public void openCamera(View v){

        Toast.makeText(this, "Opening Camera", Toast.LENGTH_SHORT).show();
        Intent icamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(icamera,CAMERA_REQ_CODE);
        
    }

    public void stray(View c){
        Toast.makeText(this, "Opening", Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(this,DescriptionOfProblem.class);
        startActivity(intent);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==CAMERA_REQ_CODE){
                Bitmap img=(Bitmap) (data.getExtras().get("data"));
                imgcamera.setImageBitmap(img);
            }
        }


    }




}

