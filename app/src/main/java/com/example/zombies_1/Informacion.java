package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

//Importar clases
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

public class Informacion extends AppCompatActivity {

    //Declaramos variables
    private TextView textViewEmail;
    private TextView textViewPassword;
    private TextView textViewNome;
    private TextView textViewPoints;
    private TextView textViewFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        //Se ubica el archivo del tipo de letra
        String ubicacion = "fuentes/zombie.TTF";
        Typeface Tf = Typeface.createFromAsset(Informacion.this.getAssets(),ubicacion);

        //Los ID de las vista
        textViewEmail = findViewById(R.id.textView5);
        textViewPassword = findViewById(R.id.textView6);
        textViewNome = findViewById(R.id.textView9);
        textViewPoints = findViewById(R.id.textView10);
        textViewFecha = findViewById(R.id.textView8);


        //Cambio de fuente de letra
        textViewEmail.setTypeface(Tf);
        textViewPassword.setTypeface(Tf);
        textViewNome.setTypeface(Tf);
        textViewPoints.setTypeface(Tf);
        textViewFecha.setTypeface(Tf);


        // Acceder a los datos almacenados en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "");
        String password = sharedPreferences.getString("password", "");
        String name = sharedPreferences.getString("name", "");
        int points = sharedPreferences.getInt("points", 0);
        String registrationDate = sharedPreferences.getString("registrationDate", "");

        // Mostrar los datos en los elementos de la vista
        TextView textViewEmail = findViewById(R.id.textView5);
        TextView textViewPassword = findViewById(R.id.textView6);
        TextView textViewName = findViewById(R.id.textView9);
        TextView textViewPoints = findViewById(R.id.textView10);
        TextView textViewRegistrationDate = findViewById(R.id.textView8);

        textViewEmail.setText("Correo: " + email);
        textViewPassword.setText("Contraseña: " + password);
        textViewName.setText("Usuario: " + name);
        textViewPoints.setText("Punteo: " + points);
        textViewRegistrationDate.setText("Fecha de Creación: " + registrationDate);
    }

    //Funcion para el boton de regreso al menu de inicio
    public void menu_usuario(View view){
        Intent intent = null;
        intent = new Intent(this, menu.class);

        if(intent!=null){
            startActivity(intent);
        }
    }
}