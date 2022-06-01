package com.ensias.healthcareapp.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.ensias.healthcareapp.boadingpage;
import com.airbnb.lottie.LottieAnimationView;
import com.ensias.healthcareapp.DoctorHomeActivity;
import com.ensias.healthcareapp.FirstSigninActivity;
import com.ensias.healthcareapp.HomeActivity;
import com.ensias.healthcareapp.R;

public class LauncherActivity extends AppCompatActivity {
    LottieAnimationView lotie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);


        lotie=(LottieAnimationView) findViewById(R.id.animationView);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(getApplicationContext(),boadingpage.class);
                startActivity(intent);

            }
        },  2500);

//        Intent intent=new Intent(getApplicationContext(), Selectionpage.class);
//        startActivity(intent);




    }
}