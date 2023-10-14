package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Informacion extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        recyclerView = findViewById(R.id.recyclerViewUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiService apiService = MyApiClient.getApiService();
        Call<List<User>> call = apiService.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    List<User> userList = response.body();
                    userAdapter = new UserAdapter(Informacion.this, userList);

                    recyclerView.setAdapter(userAdapter);
                } else {
                    Toast.makeText(Informacion.this, "Error al obtener la lista de usuarios", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(Informacion.this, "Error al realizar la solicitud GET", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void menu_usuario(View view) {
        Intent intent = new Intent(this, menu.class);
        if (intent != null) {
            startActivity(intent);
        }
    }
}
