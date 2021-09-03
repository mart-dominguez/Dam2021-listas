package com.mdgz.dam.dam2021_listas;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mdgz.dam.dam2021_listas.model.Serie;

import java.util.List;

public class SeriesAdapter extends ArrayAdapter<Serie> {

    public static class SerieViewHolder {
        TextView tvTitulo;
        SeekBar skCalif;
        TextView tvGenero;
        ImageView imgFav;

        public SerieViewHolder(View fila){
            Log.d("MI_SERIE_ADAPTER", "Realiza los FIND VIEW BY ID: ");

            tvTitulo = fila.findViewById(R.id.rowTitulo);
            skCalif = fila.findViewById(R.id.rowCalif);
            tvGenero = fila.findViewById(R.id.rowGenero);
            imgFav = fila.findViewById(R.id.rowEnMiLista);
        }

    }

    SeriesAdapter(Context ctx, List<Serie> datos){
        super(ctx,0,datos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("MI_SERIE_ADAPTER", "getView: para fila: " + position + " convert: " + convertView);

        LayoutInflater inflater = LayoutInflater.from(this.getContext());

        // INICIO IMPLEMENTACION RECYLER
        // Implements recycler pattern
        // queremos ahorrar el proceso de inflado y realizarlo la menor
        // cantidad de veces posibles

        // si converView es NO NULO lo utilizo
        View fila = convertView;

        // si convertView SI ES NULO lo inflo
        if (fila == null) {
            /// esta operacion que es costosa y crea siempre objetos nuevos que luego se desechan
            // deja de repetirse y como maximo se ejecuta la cantidad de filas que tiene la pantalla
            Log.d("MI_SERIE_ADAPTER", "CREA NUEVO INFLADO: " + position + " convert: " + convertView);
            fila = inflater.inflate(R.layout.fila_serie, parent, false);
        }
        // FIN IMPLEMENTACION RECYLER
        //------------------------------------------------------

        // el objetivo del patron holder es que
        // la busqueda findViewById no se realice SIEMPRE Y CADA UNA
        // DE LAS VECES en que se invoca getView sino una vez por cada fila inflada

        /** NO SE USA MAAAAS
        TextView tvTitulo = fila.findViewById(R.id.rowTitulo);
        SeekBar skCalif = fila.findViewById(R.id.rowCalif);
        TextView tvGenero = fila.findViewById(R.id.rowGenero);
        ImageView imgFav = fila.findViewById(R.id.rowEnMiLista);
         **/

        // PATRON HOLDER
        SerieViewHolder serieViewHolder = (SerieViewHolder) fila.getTag();
        if(serieViewHolder==null){
            serieViewHolder = new SerieViewHolder(fila);
            fila.setTag(serieViewHolder);

            final TextView serieText = serieViewHolder.tvTitulo;
            final String titulo = serieViewHolder.tvTitulo.getText().toString();

            serieViewHolder.skCalif.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    //Integer pos = (Integer)ratingBar.getTag();
                    //getItem(pos).setCalificacion((int)rating);
                    if(fromUser){
                        serieText.setText(titulo+ " -" +progress);
                        Integer posAct = (Integer) seekBar.getTag();
                        Serie s = getItem(posAct);
                        s.setCalificacion(progress);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        }
        // PATRON HOLDER FIN
        //------------------------------------------------------

        Serie unaSerie = this.getItem(position);
        if(position%2==0){
            fila.setBackgroundColor(Color.parseColor("#FFC0F3ED"));
        }

        serieViewHolder.tvTitulo.setText(unaSerie.getNombre());
        serieViewHolder.skCalif.setProgress(unaSerie.getCalificacion());
        serieViewHolder.skCalif.setTag(position);
        serieViewHolder.tvGenero.setText(unaSerie.getGenero().getDescripcion());






        if(unaSerie.getEnMiLista()){
            serieViewHolder.imgFav.setImageResource(android.R.drawable.star_big_on);
        } else {
            serieViewHolder.imgFav.setImageResource(android.R.drawable.star_big_off);
        }

        //return super.getView(position, convertView, parent);
        return  fila;
    }
}
