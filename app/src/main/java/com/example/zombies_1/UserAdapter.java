package com.example.zombies_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;
    private Context context;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, @SuppressLint("RecyclerView") int position) {
        User user = userList.get(position);
        holder.userNameTextView.setText("Nombre: " + user.getName());
        holder.userPointsTextView.setText("Puntos: " + String.valueOf(user.getPoints()));
        holder.userIdTextView.setText("ID: " + String.valueOf(user.getId()));
        holder.userEmailTextView.setText("Email: " + user.getEmail());
        holder.userPasswordTextView.setText("Contraseña: " + user.getPassword());
        holder.userDataZTextView.setText("Fecha: " + user.getRegistrationDate());

        // Configura el botón de eliminar
        holder.eliminarImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUser(user.getId(), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userNameTextView;
        TextView userPointsTextView;
        TextView userIdTextView;
        TextView userEmailTextView;
        TextView userPasswordTextView;
        TextView userDataZTextView;
        ImageView eliminarImageView; // Cambia el tipo a ImageView

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userNameTextView = itemView.findViewById(R.id.userName);
            userPointsTextView = itemView.findViewById(R.id.userPoints);
            userIdTextView = itemView.findViewById(R.id.userId);
            userEmailTextView = itemView.findViewById(R.id.userEmail);
            userPasswordTextView = itemView.findViewById(R.id.userPassword);
            userDataZTextView = itemView.findViewById(R.id.userDataZ);
            eliminarImageView = itemView.findViewById(R.id.eliminar); // Cambia el tipo a ImageView
        }
    }

    private void deleteUser(int userId, int position) {
        ApiService apiService = MyApiClient.getApiService();
        Call<Void> call = apiService.deleteUser(userId);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Log.e("DELETE Error", "Código de error: " + response.code());
                } else {
                    // Elimina al usuario de la lista
                    userList.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(context, "Usuario eliminado con éxito", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Error al realizar la solicitud DELETE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
