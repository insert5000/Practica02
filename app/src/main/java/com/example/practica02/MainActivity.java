package com.example.practica02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class MainActivity extends AppCompatActivity {
    public static int CAMERA_PIC_REQUEST = 1;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText txtcorreo = (EditText)findViewById(R.id.txt_correo);
        Button btn_enviar = (Button)findViewById(R.id.btn_enviar);
        Button btn_camara = (Button)findViewById(R.id.btn_foto);
        final EditText txt_nombre = (EditText)findViewById(R.id.txt_nombre);
        final EditText txt_apellido = (EditText)findViewById(R.id.txt_apellido);
        final EditText txt_celular = (EditText)findViewById(R.id.txt_celular);
        final EditText txt_direccion = (EditText)findViewById(R.id.txt_direccion);

        btn_camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camaraIntent,CAMERA_PIC_REQUEST);
            }
        });


        final AwesomeValidation validacion = new AwesomeValidation(ValidationStyle.BASIC);
        validacion.addValidation(this, R.id.txt_correo, Patterns.EMAIL_ADDRESS,R.string.mensaje);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validacion.validate()){


                    Intent i = new Intent(MainActivity.this, Resultado.class);
                    i.putExtra("dato1",txt_nombre.getText().toString());
                    i.putExtra("dato2",txt_apellido.getText().toString());
                    i.putExtra("dato3",txt_direccion.getText().toString());
                    i.putExtra("dato4",txt_celular.getText().toString());
                    i.putExtra("dato5",txtcorreo.getText().toString());
                    i.putExtra("imagen1",bitmap);
                    startActivity(i);


                }
            }
        });
    }

    //capturando la imagen
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data ){
        MainActivity.super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == CAMERA_PIC_REQUEST){
            if(resultCode == RESULT_OK){
                 bitmap = (Bitmap)data.getExtras().get("data");
                ImageView foto = (ImageView)findViewById(R.id.img_foto);
                foto.setImageBitmap(bitmap);
            }
        }

    }
}