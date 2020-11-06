
package com.yaritzapech.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.yaritzapech.miscontactos.R;
import com.yaritzapech.miscontactos.pojo.Contacto;
import java.util.ArrayList;



public class ConstructorContacto {

    private static final int LIKE = 1;

    private Context context;
    public ConstructorContacto(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarSeisContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarSeisContactos (BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Boxito");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.boxito);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Cami");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.cami);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Catty");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.catty);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Cuqui");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.cuqui);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Flor");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.flor);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Jamon");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.jamon);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Pepito");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.pepito);
        db.insertarContacto(contentValues);

    }


    public int darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_PET_ID_PET, contacto.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_PET_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);

        return contacto.getId();
        
    }


    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }



}
