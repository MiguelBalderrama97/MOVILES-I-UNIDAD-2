package com.example.miguel.eva2_2_contactos;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCon, btnShowCon;
    private Intent iVerContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCon = findViewById(R.id.btnCon);
        btnShowCon = findViewById(R.id.btnShowCon);

        btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUri = "content://contacts/people/";
                iVerContactos = new Intent(Intent.ACTION_VIEW, Uri.parse(sUri));
                startActivity(iVerContactos);
            }
        });

        btnShowCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUri = ContactsContract.Contacts.CONTENT_URI + "/1";
                iVerContactos = new Intent(Intent.ACTION_EDIT, Uri.parse(sUri));
                startActivity(iVerContactos);
            }
        });
    }
}
