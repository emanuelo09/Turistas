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

public class Restaurants extends AppCompatActivity {

    ArrayList<Restaurant> list2 = new ArrayList<>();
    RecyclerView logicalList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        logicalList2 = findViewById(R.id.recycler2);
        logicalList2.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        createRestaurantList();
        Adapter2 adaptor = new Adapter2(list2);
        logicalList2.setAdapter(adaptor);

    }

    private void createRestaurantList() {

        list2.add(new Restaurant(R.drawable.restaurant1, getString(R.string.restaurantTitle1), getString(R.string.restaurantSentence1), getString(R.string.restaurantType1) ));
        list2.add(new Restaurant(R.drawable.restaurant2, getString(R.string.restaurantTitle2), getString(R.string.restaurantSentence2), getString(R.string.restaurantType2) ));
        list2.add(new Restaurant(R.drawable.restaurant3, getString(R.string.restaurantTitle3), getString(R.string.restaurantSentence3), getString(R.string.restaurantType3) ));
        list2.add(new Restaurant(R.drawable.restaurant4, getString(R.string.restaurantTitle4), getString(R.string.restaurantSentence4), getString(R.string.restaurantType4) ));


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
                Intent intent = new Intent(Restaurants.this, MainActivity.class);
                startActivity(intent);
                break;

            case(R.id.option1):
                Intent intentAb = new Intent(Restaurants.this, About.class);
                startActivity(intentAb);
                break;

            case(R.id.option2):
                this.changeLanguage("en");
                Intent intentEn= new Intent(Restaurants.this, Restaurants.class);
                startActivity(intentEn);
                break;

            case(R.id.option3):
                this.changeLanguage("es");
                Intent intentEs = new Intent(Restaurants.this, Restaurants.class);
                startActivity(intentEs);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}