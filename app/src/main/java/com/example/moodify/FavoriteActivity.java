package com.example.moodify;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    private ListView listViewFavorites;
    private TextView tvNoFavorites;
    private ArrayList<String> favoriteSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        listViewFavorites = findViewById(R.id.listViewFavorites);
        //tvNoFavorites = findViewById(R.id.tvNoFavorites);

        // Retrieve data passed from previous activity
        favoriteSongs = getIntent().getStringArrayListExtra("favoriteSongs");

        if (favoriteSongs != null && !favoriteSongs.isEmpty()) {
            // Populate list
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    favoriteSongs
            );
            listViewFavorites.setAdapter(adapter);
            tvNoFavorites.setVisibility(TextView.GONE);
        } else {
            // Show "no favorites" message
            tvNoFavorites.setVisibility(TextView.VISIBLE);
        }
    }
}

