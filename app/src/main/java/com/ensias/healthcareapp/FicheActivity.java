package com.ensias.healthcareapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.ensias.healthcareapp.model.Fiche;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.appcompat.app.AppCompatActivity;

public class FicheActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText Medicine;
    private EditText Description;
    private EditText Traitement;
    private Spinner Type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche);

        Medicine = findViewById(R.id.write_medicine);
        Description = findViewById(R.id.write_description);
        Traitement = findViewById(R.id.write_prescription);
        Type = findViewById(R.id.write_type_spinner);

        //Spinner to choose fiche type
        Spinner spinner = findViewById(R.id.write_type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fiche_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //Add fiche
        Button addFicheButton = findViewById(R.id.button_add_Slip);
        addFicheButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFiche();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String SeltectedFicheType = adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void addFiche(){
        String medicine = Medicine.getText().toString();
        String description =  Description.getText().toString();
        String traitement = Traitement.getText().toString();
        String type =  Type.getSelectedItem().toString();

        String patient_name = getIntent().getStringExtra("patient_name");
        String patient_email = getIntent().getStringExtra("patient_email");


        CollectionReference ficheRef = FirebaseFirestore.getInstance().collection("Patient").document(""+patient_email+"")
                .collection("MyMedicalFolder");
        ficheRef.document().set(new Fiche(medicine, description, traitement, type, FirebaseAuth.getInstance().getCurrentUser().getEmail().toString()));

        Toast.makeText(this, " Data Added "+patient_name, Toast.LENGTH_LONG).show();
        finish();
    }

}
