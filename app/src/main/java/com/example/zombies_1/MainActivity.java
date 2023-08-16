package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Funcion para el boton de ingresar
    public void ingresar(View view){
        Intent intent = null;
        intent = new Intent(this, login.class);

        if(intent!=null){
            startActivity(intent);
        }
    }

    //Funcion para el boton de registrarse
    public void registarse(View view){
        Intent intent = null;
        intent = new Intent(this, Register.class);

        if(intent!=null){
            startActivity(intent);
        }
    }
}