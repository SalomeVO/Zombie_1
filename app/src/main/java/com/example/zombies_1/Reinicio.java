package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Reinicio extends AppCompatActivity {

    //Declaracion de variables
    private TextView textViewUser;
    private TextView textViewUserPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reinicio);

        //Se ubica el archivo del tipo de letra
        String ubicacion = "fuentes/zombie.TTF";
        Typeface Tf = Typeface.createFromAsset(Reinicio.this.getAssets(),ubicacion);

        //Los ID de las vista
        textViewUser = findViewById(R.id.textView13);
        textViewUserPoints = findViewById(R.id.textView11);

        //Cambio de fuente de letra
        textViewUser.setTypeface(Tf);
        textViewUserPoints.setTypeface(Tf);

        // Recuperar el valor del contador de zombies eliminados del intent
        int zombieKillCount = getIntent().getIntExtra("zombieKillCount", 0);

        // Encontrar la TextView en la vista de reinicio
        TextView textViewZombieKillCount = findViewById(R.id.textView11);

        // Mostrar la cantidad de zombies eliminados en la TextView
        textViewZombieKillCount.setText(String.valueOf(zombieKillCount));
    }

    // Función para el botón de reiniciar el juego
    public void reiniciarJuego(View view) {
        // Aquí podrías reiniciar las variables del juego y regresar a Escenario_juego
        Intent intent = new Intent(this, Escenario_juego.class);
        startActivity(intent);
        finish(); // Cierra la actividad actual
    }

    // Función para el botón de regresar al menú
    public void regresarAlMenu(View view) {
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);
        finish(); // Cierra la actividad actual
    }
}
