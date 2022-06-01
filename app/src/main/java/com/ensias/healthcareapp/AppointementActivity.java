package com.ensias.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.widget.LinearLayout;



import com.google.firebase.firestore.FirebaseFirestore;



public class AppointementActivity extends AppCompatActivity {


    static FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointement);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(140, 398);
        layoutParams.setMargins(200, 0, 300, 0);


        }

    }


