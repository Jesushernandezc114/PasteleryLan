package com.example.pastelerylan.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import com.example.pastelerylan.R;
import com.example.pastelerylan.controlador.UsuarioHelper;

public class login extends AppCompatActivity {
    UsuarioHelper dbhelper;
    EditText txtUser, txtPass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button BtnEntrar = findViewById(R.id.btnEntrar);
        Button BtnRegistrarse = findViewById(R.id.btnRegistrar);
        txtUser = findViewById(R.id.User);
        txtPass = findViewById(R.id.Pass);
         dbhelper = new UsuarioHelper(this);


        BtnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isLogged = dbhelper.checkUser(txtUser.getText().toString(), txtPass.getText().toString());
                if(isLogged){
                    Intent intent = new Intent(login.this,   inicio.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(login.this,"Error en el campo Usuario/o Contraseña",Toast.LENGTH_LONG).show();
                }
            }
        });

        BtnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,   Registrarse.class);
                startActivity(intent);
            }
        });



    }

}




