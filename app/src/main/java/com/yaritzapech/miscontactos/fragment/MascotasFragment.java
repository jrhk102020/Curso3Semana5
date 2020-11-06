package com.yaritzapech.miscontactos.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yaritzapech.miscontactos.R;
import com.yaritzapech.miscontactos.adapter.ContactoAdaptador;
import com.yaritzapech.miscontactos.pojo.Contacto;

import java.util.ArrayList;



public class MascotasFragment extends Fragment {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;


    public MascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);


        // esto ya existe en el fragment
        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        ///GridLayoutManager glm = new GridLayoutManager(this, 2);
        ///listaContactos.setLayoutManager(glm);

        inicializarListaContactos();
        inicializarAdaptador();



        return v;
    }

    // Manda los datos al adaptador
    public ContactoAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }

    // Llena los datos
    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.boxito,"Boxito",0));
        contactos.add(new Contacto(R.drawable.cami, "Cami", 0));
        contactos.add(new Contacto(R.drawable.catty, "Catty", 0));
        contactos.add(new Contacto(R.drawable.cuqui,"Cuqui",0));
        contactos.add(new Contacto(R.drawable.flor, "Flor", 0));
        contactos.add(new Contacto(R.drawable.jamon, "Jamon", 0));
        contactos.add(new Contacto(R.drawable.pepito, "Pepito", 0));
    }

}
