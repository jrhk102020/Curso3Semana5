package com.yaritzapech.miscontactos.db;


public class ConstantesBD {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PETS           = "contacto";
    public static final String TABLE_PETS_ID        = "id";
    public static final String TABLE_PETS_NOMBRE    = "nombre";
    //public static final String TABLE_PETS_TELEFONO  = "telefono";
   // public static final String TABLE_PETS_EMAIL     = "email";
    public static final String TABLE_PETS_FOTO      = "foto";

    public static final String TABLE_LIKES_PET = "contacto_likes";
    public static final String TABLE_LIKES_PET_ID = "id";
    public static final String TABLE_LIKES_PET_ID_PET = "id_contacto";
    public static final String TABLE_LIKES_PET_NUMERO_LIKES = "numero_likes";

}
