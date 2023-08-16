package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void cerrarSesion(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Cierra la actividad actual
    }

    //Funcion para el boton de informacion del usuario
    public void informacion_usuario(View view){
        Intent intent = null;
        intent = new Intent(this, Informacion.class);

        if(intent!=null){
            startActivity(intent);
        }
    }
}