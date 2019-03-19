package com.example.miguel.eva2_11_onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Captura extends AppCompatActivity {

    private EditText etxtNom, etxtApe;
    private Button btnMate;
    private TextView txtMaterias;
    private Intent inLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);

        etxtApe = findViewById(R.id.etxtApe);
        etxtNom = findViewById(R.id.etxtNom);
        btnMate = findViewById(R.id.btnMat);
        txtMaterias = findViewById(R.id.txtMaterias);

        inLista = new Intent(this, ListadoMaterias.class);

        btnMate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inLista,1000);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Intent inDatos = new Intent();
        inDatos.putExtra("NOMBRE", etxtNom.getText().toString());
        inDatos.putExtra("APELLIDO", etxtApe.getText().toString());
        inDatos.putExtra("MATERIAS", txtMaterias.getText());
        setResult(Activity.RESULT_OK);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }
}
