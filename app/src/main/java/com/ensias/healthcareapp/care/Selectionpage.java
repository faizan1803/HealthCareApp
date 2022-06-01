package com.ensias.healthcareapp.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import com.ensias.healthcareapp.DoctorHomeActivity;
import com.ensias.healthcareapp.FirstSigninActivity;
import com.ensias.healthcareapp.MainActivity;
import com.ensias.healthcareapp.R;
import com.ensias.healthcareapp.patient_loginclass;

public class Selectionpage extends AppCompatActivity {
    Button btdoc,btpat;
    Animation anim1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectionpage);


        btdoc=(Button) findViewById(R.id.doctor12);
        btpat=(Button) findViewById(R.id.patient12);




        btdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);


            }
        });

        btpat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent12=new Intent(getApplicationContext(), patient_loginclass.class);

                startActivity(intent12);
//                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);



            }
        });

    }


}