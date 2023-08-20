package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

//Importacion de clase
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Register extends AppCompatActivity {

    //Declaracion de variables

    private EditText  editTextEmail, editTextPassword, editTextName;
    private ImageButton buttonRegister;
    private int startingPoints = 0; // Puntos iniciales
    private TextView textViewRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Se ubica el archivo del tipo de letra
        String ubicacion = "fuentes/zombie.TTF";
        Typeface Tf = Typeface.createFromAsset(Register.this.getAssets(),ubicacion);

        //Relacionamos las variables declaradas con los id de la interfaz
        textViewRegistro = findViewById(R.id.textView2);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress4);
        editTextPassword = findViewById(R.id.editTextTextPassword2);
        editTextName = findViewById(R.id.editTextText2);
        buttonRegister = findViewById(R.id.imageButton3);

        //Cambio de fuente de letra
        textViewRegistro.setTypeface(Tf);

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

                // Obtener el valor de zombieKillCount desde las preferencias compartidas
                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                int zombieKillCount = sharedPreferences.getInt("zombieKillCount", 0);


                // Crear una nueva instancia de preferencias compartidas para guardar la información de registro
                SharedPreferences.Editor editor = getSharedPreferences("UserData", MODE_PRIVATE).edit();
                editor.putString("email", email);
                editor.putString("password", password);
                editor.putString("name", name);
                editor.putString("registrationDate", currentDate);
                editor.putInt("points", zombieKillCount); // Usar el valor de zombieKillCount obtenido de las preferencias compartidas
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