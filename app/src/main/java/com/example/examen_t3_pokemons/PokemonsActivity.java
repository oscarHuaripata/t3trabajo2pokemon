package com.example.examen_t3_pokemons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PokemonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemons);

        Button btnCapturarPokemon =findViewById(R.id.btnCapturarPokemon);

        btnCapturarPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent =new Intent(getApplicationContext(), CapturarPokemonActivity.class);
            startActivity(intent);
            }
        });

        Button btnDetallePokemon = findViewById(R.id.btnMisPokemons);

        btnDetallePokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
                startActivity(intent);
            }
        });
    }
}