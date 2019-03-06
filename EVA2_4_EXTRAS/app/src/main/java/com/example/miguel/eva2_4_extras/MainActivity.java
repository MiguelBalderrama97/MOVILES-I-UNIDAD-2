package com.example.miguel.eva2_4_extras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    private ListView list;
    private Intent inSecond;
    private List<String> materias = new ArrayList<>();
    private List<String> profes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materias.add("Fundamentos de programación");
        materias.add("Programación orientada a objetos");
        materias.add("Estructura de Datos");
        materias.add("Topicos Avanzados de Programación");
        materias.add("Graficación");
        materias.add("Programación WEB");
        materias.add("Aplicaciones I");
        materias.add("Aplicaciones II");
        materias.add("Aplicaciones III");

        profes.add("Royce Rodriguez");
        profes.add("Hector Fuentes");
        profes.add("Ruben Hernandez");
        profes.add("Maricela Caldera");
        profes.add("Jesus Espadas");
        profes.add("Leonardo Nevarez");
        profes.add("Ruben Hernandez");
        profes.add("Leonardo Nevarez");
        profes.add("Un wey");

        list = findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,materias));
        list.setOnItemClickListener(this);


        inSecond = new Intent(this, SecondActivity.class);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        inSecond.putExtra("MAESTRO", profes.get(position));
        startActivity(inSecond);
    }
}
