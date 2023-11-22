package com.example.pastelerylan.vista;

import static com.example.pastelerylan.controlador.UsuarioHelper.DBName;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pastelerylan.R;
import com.example.pastelerylan.controlador.UsuarioHelper;
import com.example.pastelerylan.controlador.Utility;

public class Registrarse extends AppCompatActivity {
    EditText textUsuario;
    EditText textpassword;
    Button btnregistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        textUsuario = findViewById(R.id.User);
        textpassword = findViewById(R.id.Pass);
        btnregistrar = findViewById(R.id.registerButton);
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {registrarUsuarios();}
        });
    }

    private void registrarUsuarios() {
        UsuarioHelper conn = new UsuarioHelper(this);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utility.CAMPO_USUARIO, textUsuario.getText().toString());
        contentValues.put(Utility.CAMPO_PASSWORD, textpassword.getText().toString());

        long idResultante = db.insert(Utility.TABLA_USUARIO, null, contentValues);
        Toast.makeText(getApplicationContext(), "ATENCION, Registrado..." + idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}