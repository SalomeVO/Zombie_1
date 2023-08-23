package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    //Declaracion de variables
    private TextView textViewUserLugar;
    private TextView textViewUserSemestre;
    private TextView textViewUserClase;
    private TextView textViewUserCarrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //Se ubica el archivo del tipo de letra
        String ubicacionZombie = "fuentes/zombie.TTF";
        Typeface Tfz = Typeface.createFromAsset(Detalles.this.getAssets(),ubicacionZombie);

        //Se ubica el archivo del tipo de letra
        String ubicacion = "fuentes/carta.OTF";
        Typeface Otf = Typeface.createFromAsset(Detalles.this.getAssets(),ubicacion);

        //Se ubica el archivo del tipo de letra
        String ubicacionNachos = "fuentes/Spicy Nachos.OTF";
        Typeface Otfn = Typeface.createFromAsset(Detalles.this.getAssets(),ubicacionNachos);

        //Los ID de las vista
        textViewUserLugar = findViewById(R.id.textView20);
        textViewUserSemestre = findViewById(R.id.textView19);
        textViewUserClase = findViewById(R.id.textView18);
        textViewUserCarrera = findViewById(R.id.textView17);


        //Cambio de fuente de letra
        textViewUserLugar.setTypeface(Otf);
        textViewUserSemestre.setTypeface(Otf);
        textViewUserClase.setTypeface(Otfn);
        textViewUserCarrera.setTypeface(Tfz);
    }

    // Función para el botón de regresar al menú
    public void regresarAlMenu(View view) {
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);
        finish(); // Cierra la actividad actual
    }
}