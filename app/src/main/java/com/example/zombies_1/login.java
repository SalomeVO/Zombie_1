package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//Importar clases
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    //Declaracion de variables
    private EditText editTextLoginEmail, editTextLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Relacionar las variables con los elementos de la interfaz
        editTextLoginEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextLoginPassword = findViewById(R.id.editTextTextPassword);
    }

    // Función para el botón de inicio de sesión
    public void iniciarSesion(View view) {

        // Obtener valores ingresados por el usuario
        String loginEmail = editTextLoginEmail.getText().toString();
        String loginPassword = editTextLoginPassword.getText().toString();

        // Recuperar la información almacenada en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String savedEmail = sharedPreferences.getString("email", "");
        String savedPassword = sharedPreferences.getString("password", "");

        // Verificar la autenticación
        if (loginEmail.equals(savedEmail) && loginPassword.equals(savedPassword)) {
            // Inicio de sesión exitoso
            Toast.makeText(login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

            // Redirigir al usuario a la vista de menú
            Intent intent = new Intent(login.this, menu.class);
            startActivity(intent);
        } else {
            // Inicio de sesión fallido
            Toast.makeText(login.this, "Inicio de sesión fallido", Toast.LENGTH_SHORT).show();
        }
    }

    //Funcion para el boton de regreso al menu de inicio
    public void regresar_inico(View view){
        Intent intent = null;
        intent = new Intent(this, MainActivity.class);

        if(intent!=null){
            startActivity(intent);
        }
    }

}
