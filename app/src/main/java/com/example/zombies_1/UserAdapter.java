package com.example.zombies_1;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.userNameTextView.setText("Nombre: " + user.getName());
        holder.userPointsTextView.setText("Puntos: " + String.valueOf(user.getPoints()));
        holder.userIdTextView.setText("ID: " + String.valueOf(user.getId()));
        holder.userEmailTextView.setText("Email: " + user.getEmail());
        holder.userPasswordTextView.setText("Contraseña: " + user.getPassword());
        holder.userDataZTextView.setText("Fecha: " + user.getRegistrationDate());
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

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userNameTextView = itemView.findViewById(R.id.userName);
            userPointsTextView = itemView.findViewById(R.id.userPoints);
            userIdTextView = itemView.findViewById(R.id.userId);
            userEmailTextView = itemView.findViewById(R.id.userEmail);
            userPasswordTextView = itemView.findViewById(R.id.userPassword);
            userDataZTextView = itemView.findViewById(R.id.userDataZ);
        }
    }
}
