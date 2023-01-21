package com.example.snapsolve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ProblemCatagory extends AppCompatActivity {
    CardView garbageReport,deadAnimalReport,strayAnimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_catagory);
        garbageReport=(CardView) findViewById(R.id.garbageReport);
        deadAnimalReport=(CardView) findViewById(R.id.deadAnimalReport);
        strayAnimal = (CardView) findViewById(R.id.strayAnimals);

        }

        public void nextgarbageReport(View v){
            Toast.makeText(this, "Opening Garbage Report Section", Toast.LENGTH_SHORT).show();
            Intent garbage=new Intent(this, imageAndDescriptionGarbage.class);
            startActivity(garbage);
        }

        public void nextStrayAnimal(View v){
        Toast.makeText(this, "Opening Stray Animal Section", Toast.LENGTH_SHORT).show();
        Intent stray=new Intent(this, imageAndDescriptionstray.class);
        startActivity(stray);
    }

        public void nextDeadAnimalReport(View v){
        Toast.makeText(this, "Opening Dead Animal Report Section", Toast.LENGTH_SHORT).show();
        Intent dead=new Intent(this, imageAndDescriptiondead.class);
        startActivity(dead);

    }

}