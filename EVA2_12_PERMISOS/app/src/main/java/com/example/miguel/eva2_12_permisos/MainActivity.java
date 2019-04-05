package com.example.miguel.eva2_12_permisos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etxtNumber;
    private Button btnCall;

    private String telefono;

    private Intent inLlamar;

    private final int PERMISO_CALL_PHONE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxtNumber = findViewById(R.id.etxtNumber);
        btnCall = findViewById(R.id.btnCall);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telefono = "tel:" + etxtNumber.getText();

                inLlamar = new Intent(Intent.ACTION_CALL, Uri.parse(telefono));
                startActivity(inLlamar);
            }
        });

//        ESTAMOS VERIFICANDO SI TENEMOS PERMISOS
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    PERMISO_CALL_PHONE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISO_CALL_PHONE:
                if (grantResults.length > 00 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(this, "YA HAY PERMISOS", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "NO HAY PERMISOS", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
