package com.example.miguel.eva2_8_correo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etxtAsunto, etxtTexto, etxtCorreo;
    private Button btnSend;
    private Intent inCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxtAsunto = findViewById(R.id.etxtAsunto);
        etxtTexto = findViewById(R.id.etxtMsg);
        etxtCorreo = findViewById(R.id.etxtCorreo);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inCorreo = new Intent(Intent.ACTION_SEND);

                inCorreo.setType("vnd.android.cursor.dir/email");
                inCorreo.putExtra(Intent.EXTRA_SUBJECT, etxtAsunto.getText().toString());
                inCorreo.putExtra(Intent.EXTRA_EMAIL, etxtCorreo.getText().toString());
                inCorreo.putExtra(Intent.EXTRA_TEXT, etxtTexto.getText().toString());
                startActivity(Intent.createChooser(inCorreo, "To complete action choose:"));
            }
        });
    }
}
