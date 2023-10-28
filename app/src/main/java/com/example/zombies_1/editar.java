package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class editar extends AppCompatActivity {
    private EditText editNombre, editEmail, editContraseña;
    private ImageButton saveButton;
    private int userId; // Asegúrate de tener el ID del usuario

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        userId = getIntent().getIntExtra("userId", 0); // Obtén el ID del usuario pasado desde UserAdapter
        editNombre = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editContraseña = findViewById(R.id.editPassword);
        saveButton = findViewById(R.id.saveButton);

        // Obtén los datos del usuario pasados desde UserAdapter
        String nombre = getIntent().getStringExtra("nombre");
        String email = getIntent().getStringExtra("email");
        String contraseña = getIntent().getStringExtra("contraseña");

        // Muestra los datos en los campos de entrada
        editNombre.setText(nombre);
        editEmail.setText(email);
        editContraseña.setText(contraseña);

        // Configura el evento de clic para guardar los cambios
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén los nuevos valores del usuario editado
                String nuevoNombre = editNombre.getText().toString();
                String nuevoEmail = editEmail.getText().toString();
                String nuevaContraseña = editContraseña.getText().toString();

                // Envía una solicitud POST a la API para editar el usuario
                ApiService apiService = MyApiClient.getApiService();
                Call<Void> call = apiService.editarUsuario(userId, nuevoNombre, nuevoEmail, nuevaContraseña);

                // Maneja la respuesta de la API (éxito o fallo)
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            // Usuario editado con éxito
                            Toast.makeText(editar.this, "Usuario editado con éxito", Toast.LENGTH_SHORT).show();
                            finish(); // Cierra la actividad de edición
                        } else {
                            // Maneja el fallo en la edición del usuario
                            Log.e("Edición Error", "Código de error: " + response.code());
                            // Muestra un mensaje de error al usuario
                            Toast.makeText(editar.this, "Error al editar el usuario", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        // Maneja el fallo en la solicitud a la API
                        Toast.makeText(editar.this, "Error al realizar la solicitud de edición", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
