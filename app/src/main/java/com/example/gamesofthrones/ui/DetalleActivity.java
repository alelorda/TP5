package com.example.gamesofthrones.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gamesofthrones.ApiService;
import com.example.gamesofthrones.R;
import com.example.gamesofthrones.models.Temporada;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleActivity   extends AppCompatActivity {

    private TextView textViewNombre, textViewAnio, textViewcantEspisodios, textViewLibro;
    private RatingBar ratingBar;
    private ImageView imageViewFotoDetalle;
    private String urlImagen;
    int postId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_item);

        Bundle extras = getIntent().getExtras();
        postId = extras.getInt("KEY_ID");

        findViewsById();
        //
        cargarPost(postId);

    }

    private void findViewsById(){
        textViewNombre = findViewById(R.id.textViewNombre);
        textViewcantEspisodios = findViewById(R.id.textViewcantEspisodios);
        textViewAnio = findViewById(R.id.textViewAnio);
        textViewLibro = findViewById(R.id.textViewLibro);
        ratingBar = findViewById(R.id.ratingBar);
        imageViewFotoDetalle = findViewById(R.id.imageViewFotoDetalle);

    }

    private void cargarPost(int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.1.147:5000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService postService = retrofit.create(ApiService.class);
        Call<Temporada> call = postService.GetSeasonById(id);
        call.enqueue(new Callback<Temporada>() {
            @Override
            public void onResponse(Call<Temporada> call, Response<Temporada> response) {
                Temporada temporada = (Temporada) response.body();
                textViewNombre.setText(temporada.getNombre());
                textViewAnio.setText(temporada.getAnio());
                textViewcantEspisodios.setText(temporada.getCantEpisodios());
                textViewLibro.setText(temporada.getLibro());
                ratingBar.setRating(temporada.getRating());

                Picasso.get()
                        .load(temporada.getFoto())
                        .into(imageViewFotoDetalle);

            }

            @Override
            public void onFailure(Call<Temporada> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_LONG).show();
            }

        });
    }

}
