package com.example.miguel.eva2_6_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Toast.makeText(this, bundle.get("Nombre")+"", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, bundle.get("Estatura")+"", Toast.LENGTH_SHORT).show();
    }
}
