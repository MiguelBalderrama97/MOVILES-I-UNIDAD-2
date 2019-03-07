package com.example.miguel.eva2_6_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private Intent inSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);

        inSecond = new Intent(this, SecondActivity.class);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bDatos = new Bundle();
                bDatos.putString("Nombre", "Miguel Balderrama");
                bDatos.putDouble("Estatura", 1.73);
                inSecond.putExtras(bDatos);
                startActivity(inSecond);
            }
        });
    }
}
