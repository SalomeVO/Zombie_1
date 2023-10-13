package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;


public class menu extends AppCompatActivity {

    private TextView textViewUserName;
    private TextView textViewUserPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        String ubicacion = "fuentes/zombie.TTF";
        Typeface Tf = Typeface.createFromAsset(menu.this.getAssets(), ubicacion);

        textViewUserName = findViewById(R.id.textView3);
        textViewUserPoints = findViewById(R.id.textView7);

        textViewUserName.setTypeface(Tf);
        textViewUserPoints.setTypeface(Tf);

        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String userName = sharedPreferences.getString("name", "");
        int userPoints = sharedPreferences.getInt("points", 0);

        textViewUserName.setText("" + userName);
        textViewUserPoints.setText(":" + userPoints);
    }

    public void cerrarSesion(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void informacion_usuario(View view) {
        ApiService apiService = MyApiClient.getApiService();
        Call<List<User>> call = apiService.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    List<User> userList = response.body();
                    Intent intent = new Intent(menu.this, Informacion.class);
                    intent.putParcelableArrayListExtra("userList", (ArrayList<User>) userList);
                    if (intent != null) {
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(menu.this, "Error al obtener la lista de usuarios", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(menu.this, "Error al realizar la solicitud GET", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void jugar(View view) {
        Intent intent = new Intent(this, Escenario_juego.class);
        startActivity(intent);
    }

    public void detalles(View view) {
        Intent intent = new Intent(this, Detalles.class);
        startActivity(intent);
    }
}
