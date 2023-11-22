package com.example.pastelerylan.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pastelerylan.R;
import com.example.pastelerylan.controlador.ConexionHelper;
import com.example.pastelerylan.controlador.Utility;

public class registrarventa extends AppCompatActivity {
    EditText textid;
    EditText txtid_cliente;
    EditText txtDescripcion;
    Button btnregistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarventa);

        textid = findViewById(R.id.editTextId);
        txtid_cliente = findViewById(R.id.txtIDCL);
        txtDescripcion = findViewById(R.id.editDescripcion);
        btnregistrar = findViewById(R.id.btnRegistrarCl);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {registrarClientes();}
        });
    }

    private void registrarClientes() {
        ConexionHelper conn = new ConexionHelper(this, "bd_ventas", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utility.CAMPO_ID_VENTAS, textid.getText().toString());
        contentValues.put(Utility.CAMPO_ID_CLIENTE, txtid_cliente.getText().toString());
        contentValues.put(Utility.CAMPO_DESCRIPCION, txtDescripcion.getText().toString());

        long idResultante = db.insert(Utility.TABLA_VENTAS, null, contentValues);
        Toast.makeText(getApplicationContext(), "ATENCION, id Registrado..." + idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}