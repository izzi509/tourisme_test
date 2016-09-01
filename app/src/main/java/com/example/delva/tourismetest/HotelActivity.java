package com.example.delva.tourismetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class HotelActivity extends AppCompatActivity {

    ArrayList<Hotel> hotels;
    HotelArrayAdapter hotelAdapter;
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        lvItems = (ListView) findViewById(R.id.lvHotel);
        hotels = new ArrayList<>();
        hotelAdapter = new HotelArrayAdapter(this, hotels);
        lvItems.setAdapter(hotelAdapter);

        String url = "http://gogweb.info/schhh/android/listhotel.php";

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray hotelJsonResults = null;


                    hotelJsonResults = response;
                    hotels.addAll(Hotel.fromJsonArray(hotelJsonResults));
                    hotelAdapter.notifyDataSetChanged();
                    Log.d("DEBUG",hotelJsonResults.toString());

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });

    }
}
