package com.example.miguel.eva2_9_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd, btnAdd2;
    private TextView txtResu;

    private Intent inSecond, inOtra;

    private final int SECUNDARIA = 1000, OTRA = 2000;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        1-DISTINGUIR LA ACTIVIDAD QUE DEVUELVE EL RESULTADO
//        requestcode
//
//        2-SABER SI ENVIO RESULTADOS O CANCELO
//
//        3..PROCESAR LOS DATOS

        if(requestCode == SECUNDARIA){ //MI ACTIVIDAD SECUNDARIA DEVUELVE DATOS
            if(resultCode == Activity.RESULT_OK){
                //PROCESAR RESULTADOS
                //PONERLOS EN EL TEXTVIEW
                String sCade = data.getStringExtra("DATOS");
                txtResu.append("SEC: "+sCade);
            }else if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this, "SECUNDARIA: ACCION CANCELADA", Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode == OTRA){
            if(resultCode == Activity.RESULT_OK){
                //PROCESAR RESULTADOS
                //PONERLOS EN EL TEXTVIEW
                String sCade = data.getStringExtra("DATOS");
                txtResu.append("OTRA"+sCade);
            }else if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this, "OTRA: ACCION CANCELADA", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd2 = findViewById(R.id.btnAdd2);
        txtResu = findViewById(R.id.txtInfo);

        inSecond = new Intent(this, SecondActivity.class);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inSecond,SECUNDARIA);
            }
        });

        inOtra = new Intent(this, OtherActivity.class);
        btnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inOtra,OTRA);
            }
        });

    }
}
