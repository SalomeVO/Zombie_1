package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //Funcion para el boton de regreso al menu de inicio
    public void regresar_inico(View view){
        Intent intent = null;
        intent = new Intent(this, MainActivity.class);

        if(intent!=null){
            startActivity(intent);
        }
    }

    //Funcion de prueba: en direccionar al menu del usuario ya logeado
    public void menu_usuario(View view){
        Intent intent = null;
        intent = new Intent(this, menu.class);

        if(intent!=null){
            startActivity(intent);
        }
    }
}