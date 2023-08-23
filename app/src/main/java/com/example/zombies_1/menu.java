package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    //Declaracion de variables
    private TextView textViewUserName;
    private TextView textViewUserPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Se ubica el archivo del tipo de letra
        String ubicacion = "fuentes/zombie.TTF";
        Typeface Tf = Typeface.createFromAsset(menu.this.getAssets(),ubicacion);

        //Los ID de las vista
        textViewUserName = findViewById(R.id.textView3);
        textViewUserPoints = findViewById(R.id.textView7);

        //Cambio de fuente de letra
        textViewUserName.setTypeface(Tf);
        textViewUserPoints.setTypeface(Tf);

        // Recuperar la información del usuario almacenada en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String userName = sharedPreferences.getString("name", "");
        int userPoints = sharedPreferences.getInt("points", 0);

        // Mostrar la información en los TextViews correspondientes
        textViewUserName.setText(""+userName);
        textViewUserPoints.setText(":" + userPoints);

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

    // Función para el botón de jugar
    public void jugar(View view) {
        Intent intent = new Intent(this, Escenario_juego.class);
        startActivity(intent);
    }

    // Función para el botón de datelles
    public void detalles(View view) {
        Intent intent = new Intent(this, Detalles.class);
        startActivity(intent);
    }
}