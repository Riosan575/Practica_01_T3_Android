package com.example.practica_t3.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica_t3.R;
import com.example.practica_t3.entities.Anime;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class animeadapter extends RecyclerView.Adapter<animeadapter.AnimeViewHolder>
                          implements View.OnClickListener{


    List<Anime> animes;

    private View.OnClickListener listener;

    public animeadapter(List<Anime> animes) {
        this.animes = animes;
    }

    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime,parent,false);


        view.setOnClickListener(this);

        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(animeadapter.AnimeViewHolder holder, int position) {

        View view = holder.itemView;

        Anime anime = animes.get(position);

        ImageView tvImage = view.findViewById(R.id.tvImagen);
        TextView tvNombre = view.findViewById(R.id.tvNombre);
        TextView tvDetalle = view.findViewById(R.id.tvDetalle);

        Picasso.get().load(anime.Imagen).into(tvImage);

        tvNombre.setText(anime.Nombre);
        tvDetalle.setText(anime.Detalle);
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {

    }

    public class AnimeViewHolder extends RecyclerView.ViewHolder {

        public AnimeViewHolder(View itemView) {
            super(itemView);
        }
    }

}
