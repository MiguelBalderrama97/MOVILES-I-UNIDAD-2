package com.example.miguel.eva2_1_intentos;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Principal extends AppCompatActivity {

    private EditText etxtNum, etxtURL, etxtNum2, etxtMSG;
    private Button btnCall, btnBrowse, btnSend, btnLlamar;
    private Intent inMarcar, inBrowse, inMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        etxtNum = findViewById(R.id.etxtNum);
        btnCall = findViewById(R.id.btnCall);
        etxtURL = findViewById(R.id.etxtURL);
        btnBrowse = findViewById(R.id.btnBrowse);
        etxtNum2 = findViewById(R.id.etxtNum2);
        etxtMSG = findViewById(R.id.etxtMSG);
        btnSend = findViewById(R.id.btnSend);
        btnLlamar = findViewById(R.id.btnLlamar);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sTel = "tel:" + etxtNum.getText().toString();
                inMarcar = new Intent(Intent.ACTION_DIAL,Uri.parse(sTel));
//                SIN RECUPERAR RESULTADOS
                startActivity(inMarcar);
//                PARA RECUPERAR RESULTADOS
//                startActivityForResult();
            }
        });

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sURL = etxtURL.getText().toString();
                inBrowse = new Intent(Intent.ACTION_WEB_SEARCH);
                inBrowse.putExtra(SearchManager.QUERY, sURL);
                startActivity(inBrowse);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etxtMSG.getText().toString();
                String tel = "smsto:" + etxtNum2.getText().toString();
                inMsg = new Intent(Intent.ACTION_SENDTO, Uri.parse(tel));
                inMsg.putExtra("sms_body", msg);
                startActivity(inMsg);
            }
        });

        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sTel = "tel:" + etxtNum.getText().toString();
                inMarcar = new Intent(Intent.ACTION_CALL,Uri.parse(sTel));
//                SIN RECUPERAR RESULTADOS
                startActivity(inMarcar);
//                PARA RECUPERAR RESULTADOS
//                startActivityForResult();
            }
        });
    }
}
