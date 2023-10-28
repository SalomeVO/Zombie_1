package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String name = editTextName.getText().toString().trim();

                // Verificar si los campos están vacíos
                if (email.isEmpty() || password.isEmpty() || name.isEmpty()) {
                    Toast.makeText(Register.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Obtener la fecha actual
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentDate = sdf.format(new Date());

                // Crear un objeto User con los datos ingresados por el usuario
                User user = new User(0, name, startingPoints, email, password, currentDate, ""); // Ajusta los valores necesarios

                // Llamar a la API para registrar al usuario
                ApiService apiService = MyApiClient.getApiService();
                Call<Void> call = apiService.registrarUsuario(user, "api"); // Agregar "api" como control

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            // Mostrar un mensaje de registro exitoso
                            Toast.makeText(Register.this, "Registro exitoso", Toast.LENGTH_LONG).show();

                            // Redirigir al usuario al menú
                            Intent intent = new Intent(Register.this, menu.class);
                            startActivity(intent);
                        } else {
                            // Mostrar un mensaje de error en el registro
                            Toast.makeText(Register.this, "Error en el registro", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        // Mostrar un mensaje de error en la solicitud
                        Toast.makeText(Register.this, "Error en la solicitud", Toast.LENGTH_SHORT).show();
                    }
                });
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