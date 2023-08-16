package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

//Importacion de clase
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Register extends AppCompatActivity {

    //Declaracion de variables

    private EditText  editTextEmail, editTextPassword, editTextName;
    private ImageButton buttonRegister;
    private int startingPoints = 0; // Puntos iniciales

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Relacionamos las variables declaradas con los id de la interfaz
        editTextEmail = findViewById(R.id.editTextTextEmailAddress4);
        editTextPassword = findViewById(R.id.editTextTextPassword2);
        editTextName = findViewById(R.id.editTextText2);
        buttonRegister = findViewById(R.id.imageButton3);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener valores ingresados por el usuario
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String name = editTextName.getText().toString();

                // Obtener la fecha actual
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentDate = sdf.format(new Date());

                // Guardar la información de registro en SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", email);
                editor.putString("password", password);
                editor.putString("name", name);
                editor.putString("registrationDate", currentDate);
                editor.putInt("points", startingPoints);
                editor.apply();

                // Construir el mensaje de registro exitoso
                String registrationInfo = "Fecha: " + currentDate + "\nCorreo: " + email + "\nContraseña: " + password + "\nNombre: " + name + "\nPuntos: " + startingPoints;

                // Mostrar un mensaje de registro exitoso
                Toast.makeText(Register.this, "Registro exitoso:\n" + registrationInfo, Toast.LENGTH_LONG).show();

                // Redirigir al usuario al menú
                Intent intent = new Intent(Register.this, menu.class);
                startActivity(intent);

            }
        });
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