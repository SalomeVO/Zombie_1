package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class menu extends AppCompatActivity {

    //Declaracion de variables
    private TextView textViewUserName;
    private TextView textViewUserPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textViewUserName = findViewById(R.id.textView3); //Los ID de las vista
        textViewUserPoints = findViewById(R.id.textView7);

        // Recuperar la información del usuario almacenada en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String userName = sharedPreferences.getString("name", "");
        int userPoints = sharedPreferences.getInt("points", 0);

        // Mostrar la información en los TextViews correspondientes
        textViewUserName.setText(""+userName);
        textViewUserPoints.setText(""+userPoints);

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