package com.example.pastelerylan.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pastelerylan.R;

public class inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_inicio);
        Button BtnRegistrarC = findViewById(R.id.btnRegistrarCl);
        Button BtnListarC = findViewById(R.id.btnListarCl);
        Button BtnEditC = findViewById(R.id.btnEditCL);
        Button BtnRegistrarV = findViewById(R.id.btnRegistrarVN);
        Button BtnEditV = findViewById(R.id.btnEditVn);
        Button BtnListarV = findViewById(R.id.btnListarVn);
        BtnRegistrarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inicio.this,   registrarcliente.class);
                startActivity(intent);
            }
        });

        BtnListarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inicio.this,  ListarCliente.class);
                startActivity(intent);
            }
        });
        BtnEditC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inicio.this, EditCliente.class);
                startActivity(intent);
            }
        });
        BtnRegistrarV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inicio.this, registrarventa.class);
                startActivity(intent);
            }
        });
        BtnEditV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inicio.this, edit_venta.class);
                startActivity(intent);
            }
        });
        BtnListarV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inicio.this, listarventa.class);
                startActivity(intent);
            }
        });
    }

}