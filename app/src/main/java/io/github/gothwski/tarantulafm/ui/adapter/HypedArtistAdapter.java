package io.github.gothwski.tarantulafm.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.gothwski.tarantulafm.R;
import io.github.gothwski.tarantulafm.domain.Artist;

/**
 * Created by ariana gothwski on 8/07/15.
 */
public class HypedArtistAdapter extends RecyclerView.Adapter<HypedArtistAdapter.HypedArtistViewHolder>{

    ArrayList<Artist> arists;
    Context context;

    public HypedArtistAdapter(Context context) {
        this.context = context;
        this.arists = new ArrayList<>();
    }

    //
    @Override
    public HypedArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_hyped_artist, parent, false);

        return new HypedArtistViewHolder(itemView);
    }

    //Conectar Viewholder con los datos
    @Override
    public void onBindViewHolder(HypedArtistViewHolder holder, int position) {
        Artist currentArtist = arists.get(position);

        holder.setArtistName(currentArtist.getName());
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
    public class HypedArtistViewHolder extends RecyclerView.ViewHolder{

        TextView artistName;
        ImageView artistImage;

        public HypedArtistViewHolder(View itemView) {
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.txt_name);
            artistImage = (ImageView) itemView.findViewById(R.id.img_artist);
        }

        public void setArtistName (String name) {
            artistName.setText(name);
        }
    }
}
