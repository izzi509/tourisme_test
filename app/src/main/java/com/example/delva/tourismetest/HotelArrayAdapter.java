package com.example.delva.tourismetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Delva on 8/29/2016.
 */
public class HotelArrayAdapter extends ArrayAdapter<Hotel> {

    public HotelArrayAdapter(Context context, List<Hotel> hotels) {
        super(context, android.R.layout.simple_list_item_1, hotels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data item for position
        Hotel hotels = this.getItem(position);

        //check to see if existing view being reused
        //not using a recycled view-> inflate the layout
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_hotel_list, parent, false);
        }
        // find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
        //clear out recycled image from convertView from last time
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
        TextView tvAddress = (TextView) convertView.findViewById(R.id.tvAddress);

        tvTitle.setText(hotels.getNom());
        tvAddress.setText(hotels.getAdresse());

        // populate the thumbnail image
        //remote the download in the background



        Picasso.with(getContext()).load(hotels.getImagePath()).into(ivImage);

        return convertView;
    }
}
