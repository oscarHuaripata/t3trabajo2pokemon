package com.example.examen_t3_pokemons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examen_t3_pokemons.Adapters.PokemonAdapter;
import com.example.examen_t3_pokemons.Clases.Pokemon;
import com.example.examen_t3_pokemons.Services.PokemonService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CapturarPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar_pokemon);



        Button btnCrear = findViewById(R.id.btnCrear);
        RecyclerView rv= findViewById(R.id.rvPalabras);

        EditText etNombre = findViewById(R.id.etNombre);
        EditText etTipo = findViewById(R.id.etTipo);
        EditText etUrlImagen = findViewById(R.id.etUrlImagen);
        EditText etLatitud=findViewById(R.id.etLatitud);
        EditText etLongitud =findViewById(R.id.etLongitud);


        Pokemon pokemon = new Pokemon();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://upn.lumenes.tk/pokemons/N00022599/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                PokemonService service =retrofit.create(PokemonService.class);




                etNombre.setText(pokemon.getNombre());
                etTipo.setText(pokemon.getTipo());
                etUrlImagen.setText(pokemon.getUrl_imagen());
                etLatitud.setText(pokemon.getLatitude());
                etLongitud.setText(pokemon.getLongitude());

                service.create(pokemon).enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        Log.i("MAIN_APP",  new Gson().toJson( response.body()));

                       // PokemonAdapter adapter =new PokemonAdapter(response.body());

                        //response.body().toString();

                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {
                        Log.i("MAIN_APP",  "No se pudo estabecer conexion");
                    }
                });

            }
        });


    }
}