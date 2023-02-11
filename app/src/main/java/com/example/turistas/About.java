package com.example.turistas;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Locale;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ActionBar bar = getSupportActionBar();

        //cambiando el color del action bar
        ColorDrawable colorBar = new ColorDrawable(Color.parseColor("#497CB2"));
        bar.setBackgroundDrawable(colorBar);

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
                Toast.makeText(this,"Seleccionaste opcion 1", Toast.LENGTH_SHORT).show();
                break;

            case(R.id.option2):
                this.changeLanguage("en");
                Intent intent1 = new Intent(About.this, About.class);
                startActivity(intent1);
                break;

            case(R.id.option3):
                this.changeLanguage("es");
                Intent intent2 = new Intent(About.this, About.class);
                startActivity(intent2);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}