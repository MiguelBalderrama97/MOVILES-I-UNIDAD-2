package com.example.miguel.eva2_restaurantes;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.IDNA;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    private LinearLayout imagen2;
    private TextView txtNom, txtDesc, txtCalle, txtColonia;
    private Button btnTel;

    private static final int REQUEST_CALL = 1;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imagen2 = findViewById(R.id.imagen);
        txtNom = findViewById(R.id.txtNom2);
        txtDesc = findViewById(R.id.txtDesc2);
        txtCalle = findViewById(R.id.txtCalle2);
        txtColonia = findViewById(R.id.txtColonia2);
        btnTel = findViewById(R.id.txtTel2);

        Intent intent = getIntent();
        bundle = intent.getExtras();

        int imagen = bundle.getInt("Imagen");
        String nombre = bundle.getString("Nombre");
        String descripcion = bundle.getString("Descripcion");
        String calle = bundle.getString("Calle");
        String colonia = bundle.getString("Colonia");
        final String telefono = bundle.getString("Telefono");

        imagen2.setBackgroundResource(imagen);
        txtNom.setText(nombre);
        txtDesc.setText(descripcion);
        txtCalle.setText(calle);
        txtColonia.setText(colonia);
        btnTel.setText(telefono);

        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(InfoActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(InfoActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }else{
                    String dial = "tel:" + telefono;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        final String telefono2 = bundle.getString("Telefono");
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                if(ContextCompat.checkSelfPermission(InfoActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(InfoActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }else{
                    String dial = "tel:" + telefono2;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        }
    }
}
