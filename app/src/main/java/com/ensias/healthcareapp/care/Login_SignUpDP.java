package com.ensias.healthcareapp.care;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ensias.healthcareapp.FirstSigninActivity;
import com.ensias.healthcareapp.MainActivity;
import com.ensias.healthcareapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Login_SignUpDP extends AppCompatActivity {
    EditText cName, cEmail, cPassword, cAge, cMobileNo;
    String Email, Password, male, female;
    CheckBox malechk, femalechk;
    TextView haveAccountSignin;
    FirebaseAuth mAuth;
    Button Bregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up_dp);

        haveAccountSignin = (TextView) findViewById(R.id.haveaccountSignin);
        malechk = (CheckBox) findViewById(R.id.checkBox3male);
        femalechk = (CheckBox) findViewById(R.id.checkBox4Female);


        cName = (EditText) findViewById(R.id.ACName1);
        cEmail = (EditText) findViewById(R.id.ACEmail);
        cPassword = (EditText) findViewById(R.id.ACPassword);
        cAge = (EditText) findViewById(R.id.ACAge);
        cMobileNo = (EditText) findViewById(R.id.ACMobieNO);

        Bregister = (Button) findViewById(R.id.ButtonAcRegister);
        mAuth = FirebaseAuth.getInstance();
//        String Name=cName.getText().toString();
//        String Email=cEmail.getText().toString();


        Bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = cName.getText().toString();
                String Email = cEmail.getText().toString();
                String Password = cPassword.getText().toString().trim();
                String Age = cAge.getText().toString();
                String MobileNo = cMobileNo.getText().toString();

                HashMap<String, Object> m = new HashMap<String, Object>();
                m.put("Name :", Name);
                m.put("Email :", Email);
                m.put("Password :", Password);
                m.put("Age :", Age);
                m.put("Mobile NO ", MobileNo);

                ;

                if (malechk.isChecked()) {
                    male = malechk.getText().toString();
                    m.put("Gender ", male);

                } else {
                    female = femalechk.getText().toString();
                    m.put("Gender ", female);


                }

//                Intent intent=new Intent(getApplicationContext(),FirstSigninActivity.class);
//                intent.putExtra("key_name",Name);
//
//
//                startActivity(intent);
                FirebaseDatabase.getInstance().getReference().child("Users Doctors  Data :").push().setValue(m);

                Toast.makeText(Login_SignUpDP.this, "Data Submitted", Toast.LENGTH_SHORT).show();
                createUser();
                Intent intent1 = new Intent(getApplicationContext(), FirstSigninActivity.class);
                startActivity(intent1);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
//                Intent intent=new Intent(getApplicationContext(),FirstSigninActivity.class);
//                intent.putExtra("key_name",Name);
//

            }
        });
    }


    public void registertoLoginDirectpage(View view) {

        haveAccountSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                finish();


            }
        });

    }

    public void onCheckboxClicked(View view) {

//
        switch (view.getId()) {

            case R.id.checkBox3male:

                femalechk.setChecked(false);

                break;

            case R.id.checkBox4Female:

                malechk.setChecked(false);
                break;


        }
//            if (femalechk.isChecked())
//        {
//            malechk.setChecked(false);
//            return;
//        }
//            else if (malechk.isChecked())
//            {
//                femalechk.setChecked(false);
//
//            }


    }


    private void createUser() {
        String email = cEmail.getText().toString();
        String password = cPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            cEmail.setError("Email cannot be empty");
            cPassword.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            cPassword.setError("Password cannot be empty");
            cPassword.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Login_SignUpDP.this, "registered successfully", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(Login_SignUpDP.this, MainActivity.class));
                    } else {
                        Toast.makeText(Login_SignUpDP.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getIntent().getBooleanExtra("ForPatient", false)) {
            startActivity(new Intent(Login_SignUpDP.this, FirstSigninActivity.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            finish();
        } else {
            startActivity(new Intent(Login_SignUpDP.this, MainActivity.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            finish();


        }
    }}