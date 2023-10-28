package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

//Importar clases
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import retrofit2.Call;

public class login extends AppCompatActivity {

    //Declaracion de variables
    private EditText editTextLoginEmail, editTextLoginPassword;
    private TextView textViewIncioSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Se ubica el archivo del tipo de letra
        String ubicacion = "fuentes/zombie.TTF";
        Typeface Tf = Typeface.createFromAsset(login.this.getAssets(),ubicacion);


        // Relacionar las variables con los elementos de la interfaz
        textViewIncioSesion = findViewById(R.id.textView);
        editTextLoginEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextLoginPassword = findViewById(R.id.editTextTextPassword);

        //Cambio de fuente de letra
        textViewIncioSesion.setTypeface(Tf);
    }

    // Función para el botón de inicio de sesión
    public void iniciarSesion(View view) {
        String loginEmail = editTextLoginEmail.getText().toString();
        String loginPassword = editTextLoginPassword.getText().toString();

        ApiService apiService = MyApiClient.getApiService();

        Call<User> call = apiService.loginUser(loginEmail, loginPassword);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    Toast.makeText(login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(login.this, menu.class);
                    startActivity(intent);
                } else {

                    Log.e("Login", "Fallo inicio de sesión: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Login", "Error en la solicitud: " + t.getMessage());
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
