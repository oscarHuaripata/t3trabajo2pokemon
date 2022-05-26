package com.example.examen_t3_pokemons.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_t3_pokemons.Clases.Pokemon;
import com.example.examen_t3_pokemons.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetalleAdapter extends RecyclerView.Adapter<DetalleAdapter.PalabraViewHolder>{
    List<Pokemon> pokemons;

    public DetalleAdapter(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public PalabraViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_detalle_layout, parent, false);

        return new DetalleAdapter.PalabraViewHolder(view);
    }

    @Override
    public void onBindViewHolder( DetalleAdapter.PalabraViewHolder holder, int position) {

        View view= holder.itemView;
        Pokemon pokemon= pokemons.get(position);
        ImageView imagenPokemon = holder.itemView.findViewById(R.id.imagenDetalle);
        TextView tvNombreDetalle= holder.itemView.findViewById(R.id.tvNombreDetalle);
        TextView tvTipoDetalle = holder.itemView.findViewById(R.id.tvTipoDetalle);


        Picasso.get().load(pokemon.getUrl_imagen()).into(imagenPokemon);

        tvNombreDetalle.setText(pokemon.nombre);
        tvTipoDetalle.setText(pokemon.tipo);
    }

    @Override
    public int getItemCount() {
     return  pokemons.size();
    }

    public class PalabraViewHolder extends RecyclerView.ViewHolder {
        public PalabraViewHolder(View itemView) {
            super(itemView);
        }
    }
}
