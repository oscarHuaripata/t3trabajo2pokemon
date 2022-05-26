package com.example.examen_t3_pokemons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examen_t3_pokemons.Adapters.DetalleAdapter;
import com.example.examen_t3_pokemons.Adapters.PokemonAdapter;
import com.example.examen_t3_pokemons.Clases.Pokemon;
import com.example.examen_t3_pokemons.Services.PokemonService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonDetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detalle);

        RecyclerView rv =findViewById(R.id.rvDetalles);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/pokemons/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);

        service.allPokemons().enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                DetalleAdapter adapter = new DetalleAdapter(response.body());
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {

            }
        });

    }
}