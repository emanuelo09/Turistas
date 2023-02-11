package com.example.turistas;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //ATRIBUTOS
    ImageButton buttonHotels;
    ImageButton buttonRestaurants;

    //METODOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();

        //cambiando el color del action bar
        ColorDrawable colorBar = new ColorDrawable(Color.parseColor("#497CB2"));
        bar.setBackgroundDrawable(colorBar);

        //Asociando los botones a eventos de click (Escucha click ome)
        buttonHotels = findViewById(R.id.iconHotels);
        buttonRestaurants = findViewById(R.id.iconRestaurants);

        buttonHotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentHotels = new Intent(MainActivity.this, Hotels.class);
                startActivity(intentHotels);

            }
        });

        buttonRestaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentRestaurant = new Intent(MainActivity.this, Restaurants.class);
                startActivity(intentRestaurant);

            }
        });

    }

    //Metodo para cambiar el idioma de mi app
    public void changeLanguage(String idiom){

        //Configurando el lenguaje del telefono
        Locale language = new Locale(idiom);
        Locale.setDefault(language);

        //Configuracion global en el talefono
        Configuration configurationPhone = getResources().getConfiguration();
        configurationPhone.locale = language;

        //Ejecutamos la cofiguracion
        getBaseContext().getResources().updateConfiguration(configurationPhone, getBaseContext().getResources().getDisplayMetrics());

    }

    //CARGAR EL MENU XML CREADO PREVIAMENTE (menu)
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    //DAR FUNCIONAMIENTO AL MENU
    public boolean onOptionsItemSelected(MenuItem item) {

        //OBSERVAMOS A QUE ITEM DEL MENU LE DAMOS CLICK
        int itemSelected = item.getItemId();

        switch (itemSelected){

            case(R.id.option):
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case(R.id.option1):
                Intent intentAb = new Intent(MainActivity.this, About.class);
                startActivity(intentAb);
                break;

            case(R.id.option2):
                this.changeLanguage("en");
                Intent intentEn= new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentEn);
                break;

            case(R.id.option3):
                this.changeLanguage("es");
                Intent intentEs = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentEs);
                break;

        }

        return super.onOptionsItemSelected(item);
    }


    //LASTKEY
}