package com.example.examen_t3_pokemons.Services;

import com.example.examen_t3_pokemons.Clases.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PokemonService {

    @POST("crear")
    Call<Pokemon> create(@Body Pokemon pokemon);

        @GET("N00022599")
        Call<List<Pokemon>> allPokemons();

}
