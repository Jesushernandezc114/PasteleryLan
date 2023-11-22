package com.example.pastelerylan.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pastelerylan.R;
import com.example.pastelerylan.controlador.ConexionHelper;
import com.example.pastelerylan.controlador.Utility;

public class EditCliente extends AppCompatActivity {
    EditText txtid;
    EditText txtnombre;
    EditText txtNumTelefonico;
    Button btnconsultar, btnupdate, btndelete;

    ConexionHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_cliente);
        conn = new ConexionHelper(getApplicationContext(), "bd_clientes", null, 1);

        txtid = (EditText) findViewById(R.id.editTextId);
        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtNumTelefonico = (EditText) findViewById(R.id.editDescripcion);


        btnconsultar = (Button) findViewById(R.id.btnBuscarCl);
        btnupdate = (Button) findViewById(R.id.btnRegistrarCl);
        btndelete = (Button) findViewById(R.id.btnEliminarCl);

        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarUsuario();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarUsuario();
            }
        });
    }

    // metodo elimina registro
    private void eliminarUsuario() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {txtid.getText().toString()};
        db.delete(Utility.TABLA_CLIENTES, Utility.CAMPO_ID + "=?", parametros);
        Toast.makeText(getApplicationContext(), "ATENCION, se eliminó el cliente", Toast.LENGTH_LONG).show();
        txtid.setText("");
        limpiar();
        db.close();
    }

    // metodo actualiza registro
    private void actualizarUsuario() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {txtid.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(Utility.CAMPO_NOMBRE, txtnombre.getText().toString());
        values.put(Utility.CAMPO_NUMTELEFONICO, txtNumTelefonico.getText().toString());

        db.update(Utility.TABLA_CLIENTES, values, Utility.CAMPO_ID + "=?", parametros);
        Toast.makeText(getApplicationContext(), "ATENCION, se actualizó el Cliente", Toast.LENGTH_LONG).show();
        limpiar();
        db.close();
    }

    // metodo del boton buscar
    private void consultar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {txtid.getText().toString()};

        try {
            Cursor cursor = db.rawQuery("SELECT " + Utility.CAMPO_NOMBRE + "," + Utility.CAMPO_NUMTELEFONICO +
                    " FROM " + Utility.TABLA_CLIENTES + " WHERE " + Utility.CAMPO_ID + "=? ", parametros);

            cursor.moveToFirst();
            txtnombre.setText(cursor.getString(0));
            txtNumTelefonico.setText(cursor.getString(1));

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "ATENCION, documento no existe", Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    private void consultarSql() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={txtid.getText().toString()};

        try {
            //select nombre,telefono from usuario where codigo=?
            Cursor cursor=db.rawQuery("SELECT "+Utility.CAMPO_NOMBRE+","+Utility.CAMPO_NUMTELEFONICO+
                    " FROM "+Utility.TABLA_CLIENTES+" WHERE "+Utility.CAMPO_ID+"=? ",parametros);

            cursor.moveToFirst();
            txtnombre.setText(cursor.getString(0));
            txtNumTelefonico.setText(cursor.getString(1));

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }

    }


    // metodo limpia los text
    private void limpiar() {
        txtnombre.setText("");
        txtNumTelefonico.setText("");
    }
}
