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

public class registrarcliente extends AppCompatActivity {
    EditText textid;
    EditText txtNombre;
    EditText txtnumtelefonico;
    Button btnregistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarcliente);


        textid = findViewById(R.id.editTextId);
        txtnumtelefonico = findViewById(R.id.editDescripcion);
        txtNombre = findViewById(R.id.txtIDCL);
        btnregistrar = findViewById(R.id.btnRegistrarCl);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {registrarClientes();}
        });
    }

    private void registrarClientes() {
        ConexionHelper conn = new ConexionHelper(this, "bd_clientes", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utility.CAMPO_ID, textid.getText().toString());
        contentValues.put(Utility.CAMPO_NOMBRE, txtNombre.getText().toString());
        contentValues.put(Utility.CAMPO_NUMTELEFONICO, txtnumtelefonico.getText().toString());

        long idResultante = db.insert(Utility.TABLA_CLIENTES, null, contentValues);
        Toast.makeText(getApplicationContext(), "ATENCION, id Registrado..." + idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}