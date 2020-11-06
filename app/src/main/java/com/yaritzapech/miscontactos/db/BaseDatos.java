
package com.yaritzapech.miscontactos.db;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import com.yaritzapech.miscontactos.pojo.Contacto;

        import java.util.ArrayList;


public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBD.TABLE_PETS + "(" +
                ConstantesBD.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_PETS_NOMBRE + " TEXT, " +
                ConstantesBD.TABLE_PETS_FOTO + " INTEGER" +
                ")";
        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstantesBD.TABLE_LIKES_PET + "(" +
                ConstantesBD.TABLE_LIKES_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_LIKES_PET_ID_PET + " INTEGER, " +
                ConstantesBD.TABLE_LIKES_PET_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBD.TABLE_LIKES_PET_ID_PET + ") " +
                "REFERENCES " + ConstantesBD.TABLE_PETS + "(" + ConstantesBD.TABLE_PETS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLE_LIKES_PET);
        onCreate(db);
    }


    public ArrayList<Contacto> obtenerTodosLosContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Contacto contactoActual = new Contacto();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setFoto(registros.getInt(3));

            String queryLikes = "SELECT COUNT("+ConstantesBD.TABLE_LIKES_PET_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBD.TABLE_LIKES_PET +
                    " WHERE " + ConstantesBD.TABLE_LIKES_PET_ID_PET + "=" + contactoActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                contactoActual.setLike(registrosLikes.getInt(0));
            }else {
                contactoActual.setLike(0);
            }

            contactos.add(contactoActual);

        }

        db.close();

        return contactos;
    }

    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_PETS, null, contentValues);
        db.close();
    }

    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_LIKES_PET, null, contentValues);
        db.close();
    }

    public int obtenerLikesContacto(Contacto contacto){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBD.TABLE_LIKES_PET_NUMERO_LIKES+")" +
                " FROM " + ConstantesBD.TABLE_LIKES_PET +
                " WHERE " + ConstantesBD.TABLE_LIKES_PET_ID_PET + " = "+contacto.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }


}

