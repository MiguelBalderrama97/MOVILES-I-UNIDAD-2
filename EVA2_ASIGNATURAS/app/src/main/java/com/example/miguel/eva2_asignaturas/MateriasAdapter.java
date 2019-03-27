package com.example.miguel.eva2_asignaturas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MateriasAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Materia> materias;

    private ImageView imgMat;
    private TextView txtNom;

    public MateriasAdapter(Context context, int layout, List<Materia> materias) {
        this.context = context;
        this.layout = layout;
        this.materias = materias;
    }

    @Override
    public int getCount() {
        return materias.size();
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

        if(convertView == null){
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            convertView = layoutInflater.inflate(layout, parent, false);
        }

        ImageView imgMat = convertView.findViewById(R.id.imgMat);
        TextView txtNom = convertView.findViewById(R.id.txtNom);

        imgMat.setImageResource(materias.get(position).getIconMat());
        txtNom.setText(materias.get(position).getNom());

        return convertView;
    }
}
