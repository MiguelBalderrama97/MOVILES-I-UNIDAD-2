package com.example.miguel.eva2_restaurantes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    private ListView list;
    private List<Restaurante> restaurantes = new ArrayList<>();
    private RestaurantAdapter myAdapter;
    private Intent inInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);

        restaurantes = getAllRestaurants();

        myAdapter = new RestaurantAdapter(this, R.layout.list_item, restaurantes);
        list.setAdapter(myAdapter);

        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        inInfo = new Intent(this, InfoActivity.class);
        Bundle bDatos = new Bundle();
        bDatos.putInt("Imagen", restaurantes.get(position).getImg1());
        bDatos.putString("Nombre", restaurantes.get(position).getNom());
        bDatos.putString("Descripcion", restaurantes.get(position).getDesc());
        bDatos.putString("Calle", restaurantes.get(position).getCalle());
        bDatos.putString("Colonia", restaurantes.get(position).getColonia());
        bDatos.putString("Telefono", restaurantes.get(position).getTelefono());
        inInfo.putExtras(bDatos);
        startActivity(inInfo);
    }

    private List<Restaurante> getAllRestaurants(){
        restaurantes.add(new Restaurante(R.drawable.barrafina,"Barrafina","Comida Mexicana",
                "Periferico Juventud #1831","Juventud","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.bourkestreetbakery,"Bourke Bakery","Panaderia",
                "Avenida Industrial #2630","Revolución","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.cafedeadend,"Cafedeadend","Cafeteria clasica",
                "Avenida Heroico #1163","Industrial","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.cafeloisl,"Cafe Loisl","El mejor cafe",
                "Avenida Juan Escutia #5235","Tierra y Libertad","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.confessional,"Confessional","Pizzeria artesanal",
                "Avenida Jose Maria Iglesias #2623","Panoramico","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.donostia,"Donostia","Comida mexiquense",
                "Avenida Americas #5624","Panamericana","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.fiveleaves,"Five Leaves","Reposteria",
                "Avenida Washington #5312","5 de Febrero","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.forkeerestaurant,"Forkee","Pura tortilla",
                "Avenida Cantera #9822","Mision del Bosque","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.grahamavenuemeats,"Graham Meats","Panaderia",
                "Avenida Graham #3464","Petterson","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.haighschocolate,"Haighs Chocolate","Puro Chocolate",
                "Avenida Mirador #4613","Campestre","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.palominoespresso,"Palomino Expresso","Cafeteria",
                "Avenida Ortiz Mena #2565","2 de Noviembre","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.petiteoyster,"Petite Oyster","Comida Japonesa",
                "Avenida Deza y Ulloa #1623","Centro","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.posatelier,"Posatelier","Elegancia",
                "Avenida Universiad #9871","Arboledas","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.royaloak,"Royaloak","Comida sana",
                "Avenida Vallarta #7412","Karike","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.teakha,"Tea Kha","Lo mejor para beber",
                "Avenida Tecnologico #2565","Colinas del Sol","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.thaicafe,"Thai Cafe","Cafeteria",
                "Avenida Ortiz Mena #8643","Misiones","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.traif,"Traif","Papas francesas",
                "Avenida Aguilas #2565","Colinas del Sol","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.upstate,"Upstate","Carne roja",
                "Avenida Homero #2565","3 de marzo","6141227624"));
        restaurantes.add(new Restaurante(R.drawable.wafflewolf,"Waffle Wolf","Desayunos",
                "Avenida Pascual Orozco #2565","","6141227624"));
        return restaurantes;
    }
}
