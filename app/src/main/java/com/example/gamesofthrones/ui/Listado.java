package com.example.gamesofthrones.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gamesofthrones.ApiService;
import com.example.gamesofthrones.R;
import com.example.gamesofthrones.adapter.TemporadaAdapter;
import com.example.gamesofthrones.models.Temporada;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Listado extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private List<Temporada> listaTemporada;
    private TemporadaAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        getSupportActionBar().setTitle("Games of Thrones");

        listaTemporada = new ArrayList<Temporada>();

        obtenerListaApi();

        adapter = new TemporadaAdapter(listaTemporada);

        listView = findViewById(R.id.listViewPost);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }

    private void obtenerListaApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.1.147:5000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService postService = retrofit.create(ApiService.class);
        Call<List<Temporada>> call = postService.Get();

        call.enqueue(new Callback<List<Temporada>>() {
            @Override
            public void onResponse(Call<List<Temporada>> call, Response<List<Temporada>> response) {
                for(Temporada temporada :  response.body()) {
                    listaTemporada.add(temporada);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Temporada>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(Listado.this, DetalleActivity.class);
        intent.putExtra("KEY_ID", listaTemporada.get(position).getId());
        startActivity(intent);
    }
}
