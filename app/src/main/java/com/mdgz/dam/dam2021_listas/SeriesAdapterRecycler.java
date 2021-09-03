package com.mdgz.dam.dam2021_listas;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdgz.dam.dam2021_listas.model.Serie;

import java.util.List;

public class SeriesAdapterRecycler extends RecyclerView.Adapter<SeriesAdapterRecycler.ViewHolder>{

    private static final String TAG = "SeriesAdapterRecycler";
    private List<Serie> mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo;
        SeekBar skCalif;
        TextView tvGenero;
        ImageView imgFav;
        View v;

        public ViewHolder(View fila) {
            super(fila);
            v = fila;
            tvTitulo = fila.findViewById(R.id.rowTitulo);
            skCalif = fila.findViewById(R.id.rowCalif);
            tvGenero = fila.findViewById(R.id.rowGenero);
            imgFav = fila.findViewById(R.id.rowEnMiLista);
        }

        public View contenedor(){
            return v;
        }

        public TextView getTvTitulo() {
            return tvTitulo;
        }

        public SeekBar getSkCalif() {
            return skCalif;
        }

        public TextView getTvGenero() {
            return tvGenero;
        }

        public ImageView getImgFav() {
            return imgFav;
        }
    }


    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public SeriesAdapterRecycler(List<Serie> dataSet) {
        mDataSet = dataSet;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fila_recycler, viewGroup, false);
        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        Serie unaSerie = mDataSet.get(position);
        if(position%2==0){
            viewHolder.contenedor().setBackgroundColor(Color.parseColor("#FFC0F3ED"));
        }

        viewHolder.tvTitulo.setText(unaSerie.getNombre());
        viewHolder.skCalif.setProgress(unaSerie.getCalificacion());
        viewHolder.skCalif.setTag(position);
        viewHolder.tvGenero.setText(unaSerie.getGenero().getDescripcion());

        if(unaSerie.getEnMiLista()){
            viewHolder.imgFav.setImageResource(android.R.drawable.star_big_on);
        } else {
            viewHolder.imgFav.setImageResource(android.R.drawable.star_big_off);
        }

    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
