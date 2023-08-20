package com.example.zombies_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Escenario_juego extends AppCompatActivity {

    // Variables para el juego
    private int zombieKillCount = 0;
    private int gameDurationInSeconds = 20;
    private CountDownTimer countDownTimer;
    private TextView timerTextView;
    private TextView zombieCountTextView;
    private boolean isAnimating = false;
    private boolean isZombieTumba = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escenario_juego);

        // Inicialización de vistas
        timerTextView = findViewById(R.id.textView12);//conometro
        zombieCountTextView = findViewById(R.id.textView4);//conteo

        // Configuración del clic en la imagen del zombie
        ImageView zombieImageView = findViewById(R.id.imageView8);
        zombieImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnimating) {
                    // Iniciar la animación si no está en curso
                    iniciarAnimacion(zombieImageView);
                }
            }
        });

        // Temporizador de cuenta regresiva
        countDownTimer = new CountDownTimer(gameDurationInSeconds * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000));
            }
            public void onFinish() {
                navegarAPantallaReinicio();
            }
        };
        countDownTimer.start();
    }

    // Método para iniciar la animación y cambiar las imágenes
    private void iniciarAnimacion(final ImageView imageView) {
        isAnimating = true;

        // Cargar la animación de movimiento desde el archivo XML
        Animation moveAnimation = AnimationUtils.loadAnimation(this, R.anim.move_zombie);

        // Generar posiciones aleatorias para la imagen en la pantalla
        int randomX = new Random().nextInt(imageView.getWidth());
        int randomY = new Random().nextInt(imageView.getHeight());

        // Cambiar la imagen del zombie a tumba o viceversa
        imageView.setImageResource(isZombieTumba ? R.drawable.zombie : R.drawable.tumba);
        isZombieTumba = !isZombieTumba;

        // Configurar las nuevas posiciones de la imagen
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        params.leftMargin = randomX;
        params.topMargin = randomY;
        imageView.setLayoutParams(params);

        // Incrementar el contador de zombies eliminados
        zombieKillCount++;
        actualizarUIRecuentoZombies();

        // Actualizar el valor de zombieKillCount en las preferencias compartidas
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("points", zombieKillCount);
        editor.apply();


        // Iniciar la animación
        imageView.startAnimation(moveAnimation);

        // Restaurar la imagen después de un segundo
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isAnimating) {
                    imageView.setImageResource(isZombieTumba ? R.drawable.zombie : R.drawable.tumba);
                    isZombieTumba = !isZombieTumba;
                    isAnimating = false;
                }
            }
        }, 1000);
    }

    private void actualizarUIRecuentoZombies() {
        zombieCountTextView.setText(String.valueOf(zombieKillCount));
    }

    // Método para navegar a la pantalla de reinicio con el recuento de zombies eliminados
    private void navegarAPantallaReinicio() {
        Intent intent = new Intent(this, Reinicio.class);
        intent.putExtra("zombieKillCount", zombieKillCount);
        startActivity(intent);
        finish();
    }
}
