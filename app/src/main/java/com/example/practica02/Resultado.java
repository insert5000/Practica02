package com.example.practica02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {


    TextView nombre,apellido,direccion,celular,correo;
    ImageView ima;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        recibirDatos();
    }

    public void recibirDatos(){

        nombre = (TextView)findViewById(R.id.nombre);
        String d1 = getIntent().getStringExtra("dato1");
        nombre.setText("Nombre: "+d1);
        apellido = (TextView)findViewById(R.id.apellido);
        String d2 = getIntent().getStringExtra("dato2");
        apellido.setText("Apellido: "+d2);
        direccion = (TextView)findViewById(R.id.direccion);
        String d3 = getIntent().getStringExtra("dato3");
        direccion.setText("Direccion:"+d3);
        celular = (TextView)findViewById(R.id.celular);
        String d4 = getIntent().getStringExtra("dato4");
        celular.setText("Celular: "+d4);
        correo = (TextView)findViewById(R.id.correo);
        String d5 = getIntent().getStringExtra("dato5");
        correo.setText("Correo: "+d5);

        ImageView  figura2 = (ImageView)findViewById(R.id.imagen_fi);
        Bitmap foto2 = (Bitmap)getIntent().getParcelableExtra("imagen1");
        figura2.setImageBitmap(foto2);



    }
}