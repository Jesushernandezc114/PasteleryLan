package com.example.pastelerylan.controlador;

import static com.example.pastelerylan.controlador.Utility.CAMPO_USUARIO;
import static com.example.pastelerylan.controlador.Utility.TABLA_USUARIO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuarioHelper extends SQLiteOpenHelper {
    public static final String DBName = "bd_usuario";
    public UsuarioHelper(@Nullable Context context) {
    super(context, DBName, null, 3);
}

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(Utility.CREAR_TABLA_USUARIO);}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLA_USUARIO);
        onCreate(db);

    }
    public boolean checkUser(String user, String password){
        SQLiteDatabase bd = this.getWritableDatabase();

        Cursor fila=bd.rawQuery("Select user,password from "+ TABLA_USUARIO +" where user = ? and password=?",new String[]{user , password});
        if (fila.getCount() > 0)

            return true;
            else return false;


    }

}
