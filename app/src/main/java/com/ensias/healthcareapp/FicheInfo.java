package com.ensias.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FicheInfo extends AppCompatActivity {
    TextView t1 ,t2, t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_info);
        t2=findViewById(R.id.textView4);
        t3=findViewById(R.id.textView5);
        t4=findViewById(R.id.textView);
        t3.setText(getIntent().getStringExtra("description"));
        t4.setText(getIntent().getStringExtra("Traitment"));
    }
}
