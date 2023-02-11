package com.example.turistas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    //ATRIBUTOS DE LA CLASE ADAPTER
    public ArrayList<Hotel> hotelList;

    //CONSTRUCTOR
    public Adapter(ArrayList<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    @NonNull
    @Override
    public Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,null,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder viewHolder, int i) {

        viewHolder.updateData(hotelList.get(i));

    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView photoHotel;
        TextView nameHotel;
        TextView hotelPrice;
        TextView hotelContext;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            photoHotel = itemView.findViewById(R.id.photoHotel);
            nameHotel = itemView.findViewById(R.id.nameHotel);
            hotelPrice = itemView.findViewById(R.id.hotelPrice);
            hotelContext = itemView.findViewById(R.id.hotelContext);

        }

        public void updateData(Hotel hotel) {

            photoHotel.setImageResource(hotel.getPhotography());
            nameHotel.setText(hotel.getName());
            hotelPrice.setText(hotel.getPrice());
            hotelContext.setText(hotel.getContext());
        }
    }


    //LASTKEY
}