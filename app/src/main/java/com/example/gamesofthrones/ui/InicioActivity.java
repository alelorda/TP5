package com.example.gamesofthrones.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gamesofthrones.R;

public class InicioActivity extends AppCompatActivity {

    private Button btnListado, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnListado = findViewById(R.id.btnListado);
        btnListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ingresar = new Intent(getApplicationContext(), Listado.class);
                startActivity(ingresar);
            }
        });


    }
}