package com.example.gamesofthrones.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gamesofthrones.ApiService;
import com.example.gamesofthrones.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    private EditText editTextUsuario, editTextPassword;
    private Button btnIngresar;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = String.valueOf(editTextUsuario.getText());
                String Pass = String.valueOf(editTextPassword.getText());

                Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://172.23.1.147:5000/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
                ApiService postService = retrofit.create(ApiService.class);
                Call<Boolean> call = postService.Login(Username, Pass);

                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        try {
                            if (response.body()) {
                                Intent ingresar = new Intent(getApplicationContext(), InicioActivity.class);
                                startActivity(ingresar);
                            }else{
                                Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrecta", Toast.LENGTH_LONG).show();
                            }
                            }catch(Exception e){
                                Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrecta", Toast.LENGTH_LONG).show();
                            }
                        }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}