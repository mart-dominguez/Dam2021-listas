package com.mdgz.dam.dam2021_listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mdgz.dam.dam2021_listas.model.Genero;
import com.mdgz.dam.dam2021_listas.model.Serie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<Serie> seriesAdapter;
    ArrayAdapter<Genero> generoAdapter;
    TextView generoSel;
    TextView serieSel;
    ListView listaSeries;
    Spinner cmbGenero;
    Button btnElegir;
    List<Genero> generoList;
    List<Serie> seriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generoList = Genero.ejemplos();
        seriesList = Serie.ejemplos();

        this.generoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,generoList);
        // this.seriesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,as);
        //this.seriesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice,as);
        this.seriesAdapter = new SeriesAdapter(this,seriesList);

        this.cmbGenero = findViewById(R.id.cmbGenero);
        this.listaSeries = findViewById(R.id.lvSeries);
        this.serieSel = findViewById(R.id.serieElegida);
        this.btnElegir = findViewById(R.id.btnElegirVarias);

        this.cmbGenero.setAdapter(this.generoAdapter);
        this.listaSeries.setAdapter(this.seriesAdapter);

       //this.listaSeries.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        SparseBooleanArray matrizRalaBoolean = new SparseBooleanArray();

        this.listaSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Serie aSerie =  seriesAdapter.getItem(position);
                serieSel.setText(" ELIGIO : "+aSerie.getNombre()+ " ( calific: "+aSerie.getCalificacion()+")");
            }
        });
//        this.listaSeries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//        btnElegir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                StringBuilder sb = new StringBuilder();
//                for(int i = 0; i<matrizRalaBoolean.size();i++){
//                    if(matrizRalaBoolean.get(i)){
//                        Serie aSerie =  seriesAdapter.getItem(i);
//                        sb.append(aSerie.getNombre()+ " ( calific: "+aSerie.getCalificacion()+")");
//                    } else {
//                        Toast.makeText(MainActivity.this,"Destildo "+i,Toast.LENGTH_LONG);
//                    }
//                }
//                Log.d("APP", "onClick: "+sb.toString());
//                serieSel.setText(" ELIGIO : "+sb.toString());
//            }
//        });
    }
}