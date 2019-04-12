package com.example.miguel.eva2_11_onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Captura extends AppCompatActivity {

    private EditText etxtNom, etxtApe;
    private Button btnMate, btnGo;
    private TextView txtMaterias;
    private Intent inLista;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            if(resultCode == Activity.RESULT_OK){
                txtMaterias.append(data.getStringExtra("MATERIA"));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);

        etxtApe = findViewById(R.id.etxtApe);
        etxtNom = findViewById(R.id.etxtNom);
        btnMate = findViewById(R.id.btnMat);
        txtMaterias = findViewById(R.id.txtMaterias);
        btnGo = findViewById(R.id.btnGo);

        inLista = new Intent(this, ListadoMaterias.class);

        btnMate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inLista,1000);
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inDatos = new Intent();
                inDatos.putExtra("NOMBRE", etxtNom.getText().toString());
                inDatos.putExtra("APELLIDO", etxtApe.getText().toString());
                inDatos.putExtra("MATERIAS", txtMaterias.getText().toString());
                setResult(Activity.RESULT_OK, inDatos);
                finish();
            }
        });
    }
}
