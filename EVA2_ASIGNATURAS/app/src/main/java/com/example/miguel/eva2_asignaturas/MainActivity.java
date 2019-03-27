package com.example.miguel.eva2_asignaturas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    private ListView listMaterias;

    private List<Materia> materias;
    private MateriasAdapter materiasAdapter;

    private Intent inDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listMaterias = findViewById(R.id.listMaterias);

        materias = getMaterias();

        materiasAdapter = new MateriasAdapter(this, R.layout.list_item, materias);
        listMaterias.setAdapter(materiasAdapter);

        listMaterias.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        inDatos = new Intent(this, InfoActivity.class);
        bundle.putString("Materia", materias.get(position).getNom());
        bundle.putInt("Creditos", materias.get(position).getCreditos());
        bundle.putInt("Imagen", materias.get(position).getIconDoc());
        bundle.putString("Docente", materias.get(position).getDocente());
        inDatos.putExtras(bundle);
        startActivity(inDatos);
    }

    private List<Materia> getMaterias() {
        List<Materia> list = new ArrayList<Materia>() {{
            add(new Materia(R.drawable.prog1,R.drawable.prof1,5,"Fundamentos de Programación","Carlos Perez"));
            add(new Materia(R.drawable.prog2,R.drawable.prof2,5,"Programación Orientada a Objetos","Hernan Sanchez"));
            add(new Materia(R.drawable.prog3,R.drawable.maestra1,5,"Estructura de Datos","Karla Lara"));
            add(new Materia(R.drawable.prog4,R.drawable.prof1,5,"Topicos Avanzados de Prog","Luis Robles"));
            add(new Materia(R.drawable.bd,R.drawable.prof2,5,"Fundamentos de BD","Carlos Quintana"));
            add(new Materia(R.drawable.red,R.drawable.maestra1,4,"Fund de Telecomunicaciones","Eva Estrada"));
            add(new Materia(R.drawable.bd,R.drawable.prof1,4,"Taller de BD","Joel Lopez"));
            add(new Materia(R.drawable.redes2,R.drawable.prof2,5,"Redes de Computadoras","Alfredo Peralta"));
            add(new Materia(R.drawable.prog2,R.drawable.maestra1,5,"Graficación","Gabriela Hernandez"));
            add(new Materia(R.drawable.bd,R.drawable.prof1,5,"Admon de BD","Carlos Gutierrez"));
            add(new Materia(R.drawable.js,R.drawable.prof2,5,"Programación WEB","David Ramirez"));
            add(new Materia(R.drawable.red1,R.drawable.maestra1,5,"Conmutacion y Enrutamiento","Marcela Aguilar"));
            add(new Materia(R.drawable.and,R.drawable.prof1,5,"APPS I","Edgar Alvarez"));
            add(new Materia(R.drawable.and,R.drawable.prof2,5,"APPS II","Angel Guzman"));
            add(new Materia(R.drawable.red,R.drawable.maestra1,5,"Admon de Redes","Maria Cardenas"));
            add(new Materia(R.drawable.js,R.drawable.prof1,5,"Apps Hibridas","Arturo Figueroa"));
            add(new Materia(R.drawable.ios,R.drawable.prof2,5,"APPS III","Juan Castillo"));
            add(new Materia(R.drawable.prog2,R.drawable.maestra1,5,"Temas selectos","Denisse Vazquez"));
        }};
        return list;
    }
}
