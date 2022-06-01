package com.ensias.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ensias.healthcareapp.care.Login_SignUpDP;
import com.ensias.healthcareapp.care.Selectionpage;
import com.ensias.healthcareapp.fireStoreApi.DoctorHelper;
import com.ensias.healthcareapp.fireStoreApi.PatientHelper;
import com.ensias.healthcareapp.fireStoreApi.UserHelper;

import static android.widget.AdapterView.*;

public class FirstSigninActivity extends AppCompatActivity {
    private static final String TAG = "FirstSigninActivity";
    private EditText fullName;
    private EditText birthday;
    private EditText teL;
    TextView haveAccountSignin;
    private Button btn;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_signin);


        haveAccountSignin = (TextView) findViewById(R.id.haveaccountSignin);
        btn = (Button) findViewById(R.id.confirmeBtn);
        fullName = (EditText) findViewById(R.id.firstSignFullName);
        birthday = (EditText) findViewById(R.id.firstSignBirthDay);
        teL = (EditText) findViewById(R.id.firstSignTel);

//
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        final Spinner specialiteList = (Spinner) findViewById(R.id.specialite_spinner);
        ArrayAdapter<CharSequence> adapterSpecialiteList = ArrayAdapter.createFromResource(this,
                R.array.specialite_spinner, android.R.layout.simple_spinner_item);
        adapterSpecialiteList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        specialiteList.setAdapter(adapterSpecialiteList);
        String newAccountType = spinner.getSelectedItem().toString();

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = spinner.getSelectedItem().toString();
                Log.e(TAG, "onItemSelected:" + selected);
                if (selected.equals("Doctor")) {
                    specialiteList.setVisibility(View.VISIBLE);
                } else {
                    specialiteList.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                specialiteList.setVisibility(View.GONE);
            }
        });

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullname, birtDay, tel, type, specialite;
                fullname = fullName.getText().toString();
                birtDay = birthday.getText().toString();
                tel = teL.getText().toString();
                type = spinner.getSelectedItem().toString();
                specialite = specialiteList.getSelectedItem().toString();
                UserHelper.addUser(fullname, tel, type);
                if (type.equals("Patient")) {
                    PatientHelper.addPatient(fullname, tel);
                    System.out.println("Add patient " + fullname + " to patient collection");

                } else {
                    DoctorHelper.addDoctor(fullname, tel, specialite);
                }
                Intent k = new Intent(FirstSigninActivity.this, Selectionpage.class);
                Toast.makeText(FirstSigninActivity.this, "Done ", Toast.LENGTH_SHORT).show();
                startActivity(k);
//                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }


        });
    }


//
//    public void registertoLoginDirectpage(View view) {
//
//        haveAccountSignin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
//               overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
//
//
//            }
//        });
//
//    }
}