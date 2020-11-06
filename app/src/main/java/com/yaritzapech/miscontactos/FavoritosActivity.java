package com.yaritzapech.miscontactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.yaritzapech.miscontactos.adapter.ContactoAdaptador;
import com.yaritzapech.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
    }
*/
    ArrayList<Contacto> Mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        //agrega la toolbar
        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        //agrega la flecha hacia atras.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //muestro el logo
        getSupportActionBar().setLogo(R.drawable.huella);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        listaMascotas = (RecyclerView) findViewById(R.id.rvPerritos);
        //muestro los objetos vertical
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //configuro que se muestra asi en el recicleview
        listaMascotas.setLayoutManager(llm);
        //cargo las mascotas
        InicializarListaMascotas();
        //cargo el adaptador
        inicializarAdaptador();

    }
    public void InicializarListaMascotas(){

        Mascotas=new ArrayList<Contacto>();

        Mascotas.add(new Contacto(R.drawable.boxito,"Boxito",9));
        Mascotas.add(new Contacto(R.drawable.cami,"Cami",8));
        Mascotas.add(new Contacto(R.drawable.catty,"Catty",8));
        Mascotas.add(new Contacto(R.drawable.cuqui, "Cuqui", 7));
        Mascotas.add(new Contacto(R.drawable.flor,"Flor",7));

    }

    public void inicializarAdaptador(){
        //crea uno objeto y le pasa la lista
        ContactoAdaptador adaptador=new ContactoAdaptador(Mascotas,this);
        //asigno el adaptador.
        listaMascotas.setAdapter(adaptador);
    }



}
