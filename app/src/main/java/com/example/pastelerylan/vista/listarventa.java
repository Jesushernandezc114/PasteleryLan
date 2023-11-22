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
import com.example.pastelerylan.controlador.ConexionHelper2;
import com.example.pastelerylan.controlador.Utility;
import com.example.pastelerylan.modelo.Cliente;
import com.example.pastelerylan.modelo.Venta;

import java.util.ArrayList;
public class listarventa extends AppCompatActivity {
    ListView listviewVentas;
    ArrayList<String> listaInformacion;
    ArrayList<Venta> listaVentas;

    ConexionHelper2 conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarventa);
        listviewVentas = (ListView) findViewById(R.id.listviewventa);
        conn = new ConexionHelper2(getApplicationContext(), "bd_ventas", null, 1);
        listviewVentas = (ListView) findViewById(R.id.listviewventa);

        consultarListaClientes();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        listviewVentas.setAdapter(adaptador);


        listviewVentas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String informacion = "id venta: " + listaVentas.get(position).getId() + "\n";
                informacion+= "id Cliente: " + listaVentas.get(position).getIdcliente() + "\n";
                informacion+= "Descripcion: " + listaVentas.get(position).getDescripcion() + "\n";
                Toast.makeText(getApplicationContext(), informacion,Toast.LENGTH_LONG).show();
            }
        });

    }

    private void consultarListaClientes() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Venta venta =null;
        listaVentas = new ArrayList<Venta>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utility.TABLA_VENTAS, null);
        while (cursor.moveToNext()) {
            venta=new Venta();
            venta.setId(cursor.getInt(0));
            venta.setIdcliente(cursor.getInt(1));
            venta.setDescripcion(cursor.getString(2));
            listaVentas.add(venta);
        }
        obtenerLista();
    }

    private void obtenerLista(){
        listaInformacion= new ArrayList<String>();
        for (int i=0; i<listaVentas.size(); i++) {
            listaInformacion.add( "id:" + listaVentas.get(i).getId() + " -id cliente:"
                    + listaVentas.get(i).getIdcliente()+ " -Descripcion:" + listaVentas.get(i).getDescripcion()) ;
        }
    }}