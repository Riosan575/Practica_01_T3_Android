package com.example.practica_t3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.practica_t3.adapters.animeadapter;
import com.example.practica_t3.entities.Anime;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public boolean fav = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Anime> animes = GetAnime();


        RecyclerView rv = findViewById(R.id.tvAnime);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        animeadapter adapter = new animeadapter(animes);

        adapter.setOnclickListener(new View.OnClickListener() {

            ImageButton imageView = findViewById(R.id.btnFav);

            @Override
            public void onClick(View v) {

                if(fav){
                    imageView.setImageResource(R.drawable.favorito);
                    fav = false;
                }else{
                    imageView.setImageResource(R.drawable.nofavorito);
                    fav = true;
                }
            }
        });

        rv.setAdapter(adapter);

    }

    public List<Anime> GetAnime(){

        List<Anime> animes = new ArrayList<>();



        animes.add(new Anime("https://upload.wikimedia.org/wikipedia/commons/2/2a/Fairy_Tail_symbol.png","Fairy Tail","Fairy Tail es un manga de aventura y fantasía escrito e ilustrado por Hiro Mashima."));
        animes.add(new Anime("https://pm1.narvii.com/7288/97ed39f2c09d313addc6c325437420081f55b123r1-1451-2048v2_uhq.jpg","One Piece","One Piece es un anime y manga escrito e ilustrado por Eiichirō Oda y actualmente es el manga más comprado en el mundo."));
        animes.add(new Anime("https://www.hjackets.com/wp-content/uploads/2020/11/Naruto-Shippuden-Uzumaki-Naruto-Jacket.jpg","Naruto","NARUTO, es una serie de manga escrita e ilustrada por Masashi Kishimoto."));
        animes.add(new Anime("https://wallpapersflix.com/wp-content/uploads/2020/05/Tokyo-Ghoul-Background-Phone.jpg","Tokio Ghoul","Tokyo Ghoul es una serie de manga japonesa de fantasía oscura escrita e ilustrada por Sui Ishida."));
        animes.add(new Anime("https://cdn.thedeadtoons.com/wp-content/uploads/2020/08/Black-Clover-1.png","Black Clover","Black Clover es una serie de manga japonesa escrita e ilustrada por Yūki Tabata"));


        return animes;
    }
}