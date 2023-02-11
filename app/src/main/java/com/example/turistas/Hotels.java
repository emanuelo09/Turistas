package com.example.turistas;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Locale;

public class Hotels extends AppCompatActivity {

    //ATRIBUTOS
    ArrayList<Hotel> list = new ArrayList<>();
    RecyclerView logicalList;

    //METODOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        logicalList = findViewById(R.id.recycler);
        logicalList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        createHotelList();
        Adapter adapter = new Adapter(list);
        logicalList.setAdapter(adapter);

    }

    public void createHotelList(){

        list.add(new Hotel(R.drawable.hotel1, getString(R.string.hotelName1), getString(R.string.hotelPrice1), getString(R.string.hotelContext1)));
        list.add(new Hotel(R.drawable.hotel2, getString(R.string.hotelName2), getString(R.string.hotelPrice2), getString(R.string.hotelContext2)));
        list.add(new Hotel(R.drawable.hotel3, getString(R.string.hotelName3), getString(R.string.hotelPrice3), getString(R.string.hotelContext3)));
        list.add(new Hotel(R.drawable.hotel4, getString(R.string.hotelName4), getString(R.string.hotelPrice4), getString(R.string.hotelContext4)));


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
                Intent intent = new Intent(Hotels.this, MainActivity.class);
                startActivity(intent);
                break;

            case(R.id.option1):
                Intent intentAb = new Intent(Hotels.this, About.class);
                startActivity(intentAb);
                break;

            case(R.id.option2):
                this.changeLanguage("en");
                Intent intentEn= new Intent(Hotels.this, Hotels.class);
                startActivity(intentEn);
                break;

            case(R.id.option3):
                this.changeLanguage("es");
                Intent intentEs = new Intent(Hotels.this, Hotels.class);
                startActivity(intentEs);
                break;

        }

        return super.onOptionsItemSelected(item);
    }







    //Last Key
}