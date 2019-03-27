package com.example.miguel.eva2_asignaturas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView txtMateria, txtCreditos, txtDocente;
    private ImageView imgDocente;

    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        txtMateria = findViewById(R.id.txtMateria);
        txtCreditos = findViewById(R.id.txtCreditos);
        txtDocente = findViewById(R.id.txtDocente);
        imgDocente = findViewById(R.id.imgDocente);

        intent = getIntent();
        bundle = intent.getExtras();

        String materia = bundle.getString("Materia");
        String docente = bundle.getString("Docente");
        int imagen = bundle.getInt("Imagen");
        int creditos = bundle.getInt("Creditos");

        txtMateria.setText(materia);
        txtCreditos.setText(creditos+"");
        txtDocente.setText(docente);
        imgDocente.setImageResource(imagen);
    }
}
