package com.example.miguel.eva2_11_onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListadoMaterias extends AppCompatActivity implements ListView.OnItemClickListener {

    private ListView list;
    private String[] asMaterias = {"Fundamentos de programación", "Programación orientada a objetos","Estructura de datos","Topicos avandados",
                                    "Graficación","Programación WEB","APPS1","APPS2","APPS3","Hibridas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_materias);

        list = findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,asMaterias));
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent inDatos = new Intent();
        inDatos.putExtra("MATERIA",asMaterias[position]+"\n");
        setResult(Activity.RESULT_OK,inDatos);
        finish();
    }
}
