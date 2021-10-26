package com.example.gamesofthrones.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gamesofthrones.R;
import com.example.gamesofthrones.models.Temporada;

import java.util.List;

public class TemporadaAdapter  extends BaseAdapter {

    private List<Temporada> listaPost;

    public TemporadaAdapter(List<Temporada> listaPost) {
        this.listaPost = listaPost;
    }

    @Override
    public int getCount() {
        return this.listaPost.size();
    }

    @Override
    public Temporada getItem(int position) {
        return this.listaPost.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout;

        if(convertView==null){
            layout= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_temporada_item,null);
        }else{
            layout=convertView;
        }

        Temporada item = getItem(position);

        TextView textViewTitulo = layout.findViewById(R.id.textViewTitulo);
        TextView textViewContenido = layout.findViewById(R.id.textViewContenido);


        textViewTitulo.setText(item.getNombre());
        textViewContenido.setText(item.getLibro());



        return layout;
    }
}
