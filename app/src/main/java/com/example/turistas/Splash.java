package com.example.turistas;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    //Atributos

    MediaPlayer song;


    //Metodos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Oculte Action bar (barra morada que esta encima de la app)
        ActionBar bar = getSupportActionBar();
        bar.hide();

        //Lanzar cancion
        song = MediaPlayer.create(this,R.raw.song);
        song.start();

        //Temporizar duracion del splash
        TimerTask startApp = new TimerTask() {
            @Override
            public void run() {

                //Lanzar una nueva actividad
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);

                song.stop();

            }

        };

        Timer time = new Timer();
        time.schedule(startApp,10000);


    }





}