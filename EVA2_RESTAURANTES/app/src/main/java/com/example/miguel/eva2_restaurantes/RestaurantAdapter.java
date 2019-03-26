package com.example.miguel.eva2_restaurantes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Restaurante> restaurantes = new ArrayList<>();

    public RestaurantAdapter(Context context, int layout, List<Restaurante> restaurantes) {
        this.context = context;
        this.layout = layout;
        this.restaurantes = restaurantes;
    }

    @Override
    public int getCount() {
        return restaurantes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout imgBack;
        TextView txtNom, txtDesc;

        if(convertView == null){ //NO EXISTE LA FILA, HAY QUE CREARLA
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            convertView = layoutInflater.inflate(layout, parent, false);
        }

        imgBack = convertView.findViewById(R.id.imgBack);
        txtNom = convertView.findViewById(R.id.txtNom);
        txtDesc = convertView.findViewById(R.id.txtDesc);

        imgBack.setBackgroundResource(restaurantes.get(position).getImg1());
        txtNom.setText(restaurantes.get(position).getNom());
        txtDesc.setText(restaurantes.get(position).getDesc());

        return convertView;
    }
}
