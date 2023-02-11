package com.example.turistas;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.viewHolder> {

    public ArrayList<Restaurant> restaurantList;

    public Adapter2(ArrayList<Restaurant> restaurantList){ this.restaurantList = restaurantList; }

    @NonNull
    @Override
    public Adapter2.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item2,null,false);
        return new viewHolder(view2);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter2.viewHolder viewHolder, int i) {

        viewHolder.updateData(restaurantList.get(i));

    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageRestaurant;
        TextView nameRestaurant;
        TextView restaurantSentence;
        TextView restaurantType;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageRestaurant = itemView.findViewById(R.id.imageRestaurant);
            nameRestaurant = itemView.findViewById(R.id.nameRestaurant);
            restaurantSentence = itemView.findViewById(R.id.restaurantSentence);
            restaurantType = itemView.findViewById(R.id.restaurantType);

        }

        public void updateData(Restaurant restaurant){

            imageRestaurant.setImageResource(restaurant.getImage());
            nameRestaurant.setText(restaurant.getTitle());
            restaurantSentence.setText(restaurant.getSentence());
            restaurantType.setText(restaurant.getType());

        }

    }





}