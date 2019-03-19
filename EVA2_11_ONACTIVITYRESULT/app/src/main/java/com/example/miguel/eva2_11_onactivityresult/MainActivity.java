package com.example.miguel.eva2_11_onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCaptura;
    private TextView txtInfo;
    private Intent inCaptura;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            if(resultCode == Activity.RESULT_OK){
                txtInfo.append("Nombre: " + data.getStringExtra("NOMBRE") +
                        "\nApellido: " + data.getStringExtra("APELLIDO") +
                        "\nMaterias: " + data.getStringExtra("MATERIAS"));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCaptura = findViewById(R.id.btnCaptura);
        txtInfo = findViewById(R.id.txtInfo);

        inCaptura = new Intent(this, Captura.class);

        btnCaptura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inCaptura,1000);
            }
        });
    }
}
