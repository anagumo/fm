package io.github.gothwski.tarantulafm.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.github.gothwski.tarantulafm.R;
import io.github.gothwski.tarantulafm.domain.Artist;

/**
 * Created by ariana gothwski on 16/07/15.
 */
public class TopArtistAdapter extends RecyclerView.Adapter<TopArtistAdapter.TopArtistViewHolder>{

    ArrayList<Artist> arists;
    Context context;

    public TopArtistAdapter(Context context) {
        this.context = context;
        this.arists = new ArrayList<>();
    }

    //
    @Override
    public TopArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_top_artist, parent, false);

        return new TopArtistViewHolder(itemView);
    }

    //Conectar Viewholder con los datos
    @Override
    public void onBindViewHolder(TopArtistViewHolder holder, int position) {
        Artist currentArtist = arists.get(position);

        holder.setArtistName(currentArtist.getName());
        holder.setArtistPlaycount(currentArtist.getPlaycount());
        holder.setArtistListeners(currentArtist.getListeners());

        if (currentArtist.getUrlMediumImage() != null)
            holder.setArtistImage(currentArtist.getUrlMediumImage());

        else
            holder.setArtistDefaultImage();
    }

    //
    @Override
    public int getItemCount() {
        return arists.size();
    }

    public void addAll(@NonNull ArrayList<Artist> arists){
        if (arists == null)
            throw new NullPointerException("The items cannot be null");

        this.arists.addAll(arists);
        notifyDataSetChanged();
    }

    // Item data
    public class TopArtistViewHolder extends RecyclerView.ViewHolder{

        TextView artistName;
        TextView artistPlaycount;
        TextView artistListeners;
        ImageView artistImage;

        public TopArtistViewHolder(View itemView) {
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.txt_name);
            artistImage = (ImageView) itemView.findViewById(R.id.img_artist);
            artistListeners = (TextView) itemView.findViewById(R.id.txt_listeners);
            artistPlaycount = (TextView) itemView.findViewById(R.id.txt_playcount);
        }

        public void setArtistName(String name) {
            artistName.setText(name);
        }

        public void setArtistImage(String url) {
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.drawable.artist_placeholder)
                    .into(artistImage);
        }

        public void setArtistPlaycount(String playcount) {
            artistPlaycount.setText(playcount);
        }

        public void setArtistListeners(String listeners) {
            artistListeners.setText(listeners);
        }

        public void setArtistDefaultImage() {
            Picasso.with(context)
                    .load(R.drawable.artist_placeholder)
                    .into(artistImage);
        }
    }
}
