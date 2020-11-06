package com.yaritzapech.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvLikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);



        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.pnombre)); // Nombre
        //String telefono = parametros.getString(getResources().getString(R.string.likes)); // Likes
        String likes = parametros.getString(getResources().getString(R.string.likes)); // Likes

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        //tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvLikes = (TextView) findViewById(R.id.tvLikes);

        tvNombre.setText(nombre);
        //tvTelefono.setText(telefono);
        tvLikes.setText(likes);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if( keyCode == KeyEvent.KEYCODE_BACK ){
            Intent intent = new Intent(DetalleContacto.this,MainActivity.class);
            startActivity(intent);
        }

        return super.onKeyDown(keyCode, event);

    }




}



