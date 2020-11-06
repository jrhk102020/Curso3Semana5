package com.yaritzapech.miscontactos.adapter;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yaritzapech.miscontactos.pojo.Contacto;
import com.yaritzapech.miscontactos.DetalleContacto;
import com.yaritzapech.miscontactos.R;

import java.util.ArrayList;


public class ContactoAdaptador2 extends RecyclerView.Adapter<ContactoAdaptador2.ContactoViewHolder>{

    /*
    // antes
    ArrayList<Contacto> contactos;

    public ContactoAdaptador(ArrayList<Contacto> contactos){
        this.contactos = contactos;
    }
    */

    /* */
    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador2(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }


    // Inflar el layout y lo pasara al viewholder para que obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_detalle,parent,false);
        return new ContactoViewHolder(v);
    }

    // asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolderholder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolderholder.imgFotoP.setImageResource(contacto.getFoto());
        contactoViewHolderholder.tvLikesP.setText(contacto.getLike()+"");

        // On click
        /* */
        contactoViewHolderholder.imgFotoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // mensaje en pantalla
                //Toast.makeText(activity, contacto.getNombre(),Toast.LENGTH_SHORT).show();

                // Intent para Detalle contacto
                Intent intent = new Intent(activity,DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("likes", contacto.getLike());
                activity.startActivity(intent);

            }
        });

        /*
        contactoViewHolderholder.imgBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Like en "+contacto.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });
        */

    }

    @Override
    public int getItemCount() {   // cantidad de elemenos que contiene mi lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoP;
        private TextView tvLikesP;


        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFotoP = (ImageView) itemView.findViewById(R.id.imgFotoPerfil);
            tvLikesP = (TextView) itemView.findViewById(R.id.tvLikesCV);


        }
    }

}

