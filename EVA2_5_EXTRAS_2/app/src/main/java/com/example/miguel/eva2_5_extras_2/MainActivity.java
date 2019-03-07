package com.example.miguel.eva2_5_extras_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText etxtNom, etxtEdad, etxtSal;
    private RadioGroup rg;
    private RadioButton rbSol, rbCas, rbViu, rbJun;
    private CheckBox cbTra;
    private Button btnShow;
    private Intent iSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);

        etxtNom = findViewById(R.id.etxtNom);
        etxtEdad = findViewById(R.id.etxtEdad);
        etxtSal = findViewById(R.id.etxtSal);
        rg = findViewById(R.id.rg);
        rbCas = findViewById(R.id.rbCas);
        rbJun = findViewById(R.id.rbJun);
        rbSol = findViewById(R.id.rbSol);
        rbViu = findViewById(R.id.rbViu);
        cbTra = findViewById(R.id.cbTrabaja);

        iSecond = new Intent(this, SecondActivity.class);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iSecond.putExtra("Nombre",  etxtNom.getText().toString());
                iSecond.putExtra("Edad", Integer.parseInt(etxtEdad.getText().toString()));
                iSecond.putExtra("Salario", Double.parseDouble(etxtSal.getText().toString()));
                iSecond.putExtra("Trabaja", cbTra.isChecked());
                if(rbCas.isChecked()){
                    iSecond.putExtra("Estado", "Casado");
                }else if(rbJun.isChecked()){
                    iSecond.putExtra("Estado", "Juntado");
                }else if(rbSol.isChecked()){
                    iSecond.putExtra("Estado", "Soltero");
                }else if(rbViu.isChecked()){
                    iSecond.putExtra("Estado", "Viudo");
                }
                startActivity(iSecond);
            }
        });
    }
}
