package com.example.examen_t3_pokemons.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_t3_pokemons.Clases.Pokemon;
import com.example.examen_t3_pokemons.PokemonDetalleActivity;
import com.example.examen_t3_pokemons.R;
import com.google.android.material.transition.Hold;

import org.w3c.dom.Text;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PalabraViewHolder> {

    List<Pokemon> pokemons;

    public PokemonAdapter(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public PalabraViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_layout, parent, false);

        return new PalabraViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PokemonAdapter.PalabraViewHolder holder, int position) {

        View view= holder.itemView;
        Pokemon pokemon= pokemons.get(position);

        TextView tvNombre = holder.itemView.findViewById(R.id.tvNombre);
        TextView tvTipo = holder.itemView.findViewById(R.id.tvTipo);

        tvNombre.setText(pokemon.nombre);
        tvTipo.setText(pokemon.tipo);


        Button btnVerDetalle = holder.itemView.findViewById(R.id.btnVerDetalle);

        btnVerDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), PokemonDetalleActivity.class);
             //view.startActivity(intent);
                holder.itemView.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public class PalabraViewHolder extends RecyclerView.ViewHolder {
        public PalabraViewHolder( View itemView) {
            super(itemView);
        }
    }
}
