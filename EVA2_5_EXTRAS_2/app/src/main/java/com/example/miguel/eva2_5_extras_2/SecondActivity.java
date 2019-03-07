package com.example.miguel.eva2_5_extras_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtShow = findViewById(R.id.txtShow);

        Intent inDatos = getIntent();
        txtShow.append("Nombre: " + inDatos.getStringExtra("Nombre") + "\n");
        txtShow.append("Edad: " + inDatos.getIntExtra("Edad",  0) + "\n");
        txtShow.append("Salario: " + inDatos.getDoubleExtra("Salario", 20000) + "\n");
        if(inDatos.getBooleanExtra("Trabaja", true)){
            txtShow.append("Trabaja: Si \n");
        }else{
            txtShow.append("Trabaja: No \n");
        }
        txtShow.append("Estado: " + inDatos.getStringExtra("Estado") + "\n");

    }
}
