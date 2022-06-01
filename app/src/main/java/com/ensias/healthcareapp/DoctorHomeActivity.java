package com.ensias.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.ensias.healthcareapp.Common.Common;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DoctorHomeActivity extends AppCompatActivity {
    static String doc;
  CardView SignOutBtn2;
    CardView BtnRequst;
    CardView listPatients;
    CardView appointementBtn;

//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home); //ici layout de page d'acceuil MEDECIN
//        unbinder = ButterKnife.bind(this,this);
//        Common.CurreentDoctor = FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
//        Common.CurrentUserType = "doctor";
        listPatients = (CardView) findViewById(R.id.sEARCchPatientsDoctors);
        BtnRequst=(CardView) findViewById(R.id.MYDOCTORSPatientsRequestCardView);
        SignOutBtn2=(CardView) findViewById(R.id.SignOUtDoctor);
        appointementBtn =(CardView)  findViewById(R.id.AppointmentsCardViewDoc);

        SignOutBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        BtnRequst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(DoctorHomeActivity.this, ConfirmedAppointmensActivity.class);
                startActivity(k);
            }
        });
        listPatients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(DoctorHomeActivity.this, MyPatientsActivity.class);
                startActivity(k);
            }
        });
        appointementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               doc = FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
//                showDatePickerDialog(v.getContext());
                Intent k = new Intent(DoctorHomeActivity.this, DoctorAppointementActivity.class);
                startActivity(k);
            }
        });



//        CakllendarDoc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(DoctorHomeActivity.this,"clicked",Toast.LENGTH_SHORT).show();
//        Intent k = new Intent(DoctorHomeActivity.this, MyCalendarDoctorActivity.class);
//        startActivity(k);
//       }
//
//    });
        }

//    public void showDatePickerDialog(Context wf){
//        DatePickerDialog datePickerDialog = new DatePickerDialog(
//                wf,
//                this,
//                Calendar.getInstance().get(Calendar.YEAR),
//                Calendar.getInstance().get(Calendar.MONTH),
//                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
//        datePickerDialog.show();
//    }
//
//    @Override
//    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//        String date = "month_day_year: " + month + "_" + dayOfMonth + "_" + year;
//        openPage(view.getContext(),doc,date);
//    }

    private void openPage(Context wf, String d,String day){
        Intent i = new Intent(wf, AppointementActivity.class);
        i.putExtra("key1",d+"");
        i.putExtra("key2",day);
        i.putExtra("key3","doctor");
        wf.startActivity(i);
    }
}
