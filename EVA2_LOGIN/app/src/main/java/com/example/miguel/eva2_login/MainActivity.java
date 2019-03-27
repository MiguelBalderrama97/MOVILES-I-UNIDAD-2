package com.example.miguel.eva2_login;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnExit;

    private int[] images = {R.drawable.ssj,R.drawable.ssj3,R.drawable.god,R.drawable.blue,
                            R.drawable.ultra};

    private Intent inSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExit = findViewById(R.id.btnExit);
        btnLogin = findViewById(R.id.btnLogin);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dlgMiDialog;
                dlgMiDialog = new Dialog(MainActivity.this);
                //EL LAYOUT
                dlgMiDialog.setContentView(R.layout.cuadro_dialogo);

                Button btnOK, btnCancel;
                final EditText etxtUser, etxtPass;
                ImageView imgRandom;

                etxtUser = dlgMiDialog.findViewById(R.id.etxtUser);
                etxtPass = dlgMiDialog.findViewById(R.id.etxtPass);
                imgRandom = dlgMiDialog.findViewById(R.id.imgRandom);
                btnOK = dlgMiDialog.findViewById(R.id.btnOK);
                btnCancel = dlgMiDialog.findViewById(R.id.btnCancel);

                int random = (int) (Math.random() * 5);

                imgRandom.setImageResource(images[random]);

                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(etxtUser.length() == 0 ||  etxtPass.length() == 0){
                            Toast.makeText(MainActivity.this, "Completar campos!", Toast.LENGTH_SHORT).show();
                        }else{
                            inSecond = new Intent(getApplicationContext(), SecondActivity.class);
                            dlgMiDialog.dismiss();
                            startActivity(inSecond);
                        }
                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dlgMiDialog.dismiss();
                    }
                });

                dlgMiDialog.show();
            }
        });
    }
}
