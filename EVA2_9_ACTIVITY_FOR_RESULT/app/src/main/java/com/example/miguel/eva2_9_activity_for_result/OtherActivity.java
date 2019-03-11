package com.example.miguel.eva2_9_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OtherActivity extends AppCompatActivity {

    private EditText etxtDatos;
    private Button btnOk, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        etxtDatos = findViewById(R.id.etxtDatosO);
        btnOk = findViewById(R.id.btnOkO);
        btnCancel = findViewById(R.id.btnCancelO);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sCade = etxtDatos.getText().toString();
                Intent inDatos = new Intent();
                inDatos.putExtra("DATOS", sCade);
                setResult(Activity.RESULT_OK,inDatos);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }
}
