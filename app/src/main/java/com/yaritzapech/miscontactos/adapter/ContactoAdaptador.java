package com.yaritzapech.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yaritzapech.miscontactos.db.ConstructorContacto;
import com.yaritzapech.miscontactos.pojo.Contacto;
import com.yaritzapech.miscontactos.DetalleContacto;
import com.yaritzapech.miscontactos.R;

import java.util.ArrayList;


public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

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

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }


    // Inflar el layout y lo pasara al viewholder para que obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }

    // asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolderholder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolderholder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolderholder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolderholder.tvTelenoCV.setText(contacto.getLike()+"");

        // On click
        /* */
        contactoViewHolderholder.imgFoto.setOnClickListener(new View.OnClickListener() {
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

        contactoViewHolderholder.imgBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ConstructorContacto constructorContacto = new ConstructorContacto(activity);
                int idU = constructorContacto.darLikeContacto(contacto);


                Toast.makeText(activity,"Like en "+contacto.getNombre() + " !",Toast.LENGTH_SHORT).show();

                Toast.makeText(activity,"id: "+idU ,Toast.LENGTH_SHORT).show();

                int res = constructorContacto.obtenerLikesContacto(contacto);

                contactoViewHolderholder.tvTelenoCV.setText(res + " " + activity.getString(R.string.likes));
                //Toast.makeText(activity,"Likes: "+ res ,Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {   // cantidad de elemenos que contiene mi lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelenoCV;
        private ImageButton imgBoton;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelenoCV = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            imgBoton = (ImageButton) itemView.findViewById(R.id.botonLike);

        }
    }

}
