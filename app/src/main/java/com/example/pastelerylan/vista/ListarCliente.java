package com.example.pastelerylan.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pastelerylan.R;
import com.example.pastelerylan.controlador.ConexionHelper;
import com.example.pastelerylan.controlador.Utility;
import com.example.pastelerylan.modelo.Cliente;

import java.util.ArrayList;

public class ListarCliente extends AppCompatActivity {
    ListView listviewClientes;
    ArrayList<String> listaInformacion;
    ArrayList<Cliente> listaClientes;

    ConexionHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarcliente);

        listviewClientes = (ListView) findViewById(R.id.listviewClientes );
        conn = new ConexionHelper(getApplicationContext(), "bd_clientes", null, 1);
        listviewClientes = (ListView) findViewById(R.id.listviewClientes);

        consultarListaClientes();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        listviewClientes.setAdapter(adaptador);


        listviewClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String informacion = "id: " + listaClientes.get(position).getId() + "\n";
                informacion+= "Nombre: " + listaClientes.get(position).getNombre() + "\n";
                informacion+= "Telefono: " + listaClientes.get(position).getNumtelefonico() + "\n";
                Toast.makeText(getApplicationContext(), informacion,Toast.LENGTH_LONG).show();
            }
        });

    }

    private void consultarListaClientes() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Cliente cliente =null;
        listaClientes = new ArrayList<Cliente>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utility.TABLA_CLIENTES, null);
        while (cursor.moveToNext()) {
            cliente=new Cliente();
            cliente.setId(cursor.getInt(0));
            cliente.setNombre(cursor.getString(1));
            cliente.setNumtelefonico(cursor.getString(2));
            listaClientes.add(cliente);
        }
        obtenerLista();
    }

    private void obtenerLista(){
        listaInformacion= new ArrayList<String>();
        for (int i=0; i<listaClientes.size(); i++) {
             listaInformacion.add( "id:" + listaClientes.get(i).getId() + " -Nombre:"
                    + listaClientes.get(i).getNombre()+ " -Numero telefonico:" + listaClientes.get(i).getNumtelefonico()) ;
        }
    }}