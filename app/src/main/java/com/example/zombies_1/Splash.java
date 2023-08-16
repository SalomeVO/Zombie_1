package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int duracion_splash = 900; //segundos

        //Hander: es un temporizador que permite ejecutar una instruccion en un tiempo determinado
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Inicia las vistas
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
            }
        }, duracion_splash);
    }
}