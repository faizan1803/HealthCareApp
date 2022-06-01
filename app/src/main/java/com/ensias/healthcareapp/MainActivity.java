package com.ensias.healthcareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.ensias.healthcareapp.care.Login_SignUpDP;
import com.ensias.healthcareapp.care.Selectionpage;
import com.ensias.healthcareapp.model.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lotie1;

    EditText email1,pass1;
    String Email,Password;
    Button login;
    TextView tvLogin,tvforgotpas,tvCreateAcc,tvOr;

    FirebaseAuth mAuth;
    FirebaseFirestore  db = FirebaseFirestore.getInstance();
    private CollectionReference UsersRef = db.collection("User");


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lotie1=(LottieAnimationView) findViewById(R.id.lottieAnimationViewLoginPage);

        email1=(EditText) findViewById(R.id.username_input);
        pass1=(EditText) findViewById(R.id.pass);

        tvLogin=(TextView) findViewById(R.id.textViewlogin);
        login=(Button)findViewById(R.id.loginbutton);
//        tvforgotpas=(TextView) findViewById(R.id.forgotpassword);
        tvCreateAcc=(TextView) findViewById(R.id.textcerateaccountonCLick);
        tvOr=(TextView) findViewById(R.id.textviewOR);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email = email1.getText().toString();
                Password = pass1.getText().toString().trim();
                if (TextUtils.isEmpty(Email) ||TextUtils.isEmpty(Password)) {
                    Toast.makeText(MainActivity.this, "Enter Email & Password", Toast.LENGTH_SHORT).show();

                } else

                    //                    progressDialog=new ProgressDialog(doctor_loginsignup.this);
                    //                progressDialog.show();
                    login3(Email, Password);
            }


        });




    }


    public void createaccountpatient(View view) {
        tvCreateAcc.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(), Login_SignUpDP.class);
                startActivity(intent);
//                overridePendingTransition( R.anim.slide_in_right,R.anim.slide_out_left);





            }
        });


    }
    private void login3(String email1,String pass1)
    {
        mAuth.signInWithEmailAndPassword(email1, pass1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {



                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "Login SuccessFull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), DoctorHomeActivity.class);

                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();


                        }
                    }
                });




        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(MainActivity.this, Selectionpage.class));
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


    }
}

