package com.example.moodify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnHappy, btnSad, btnChill, btnEnergetic, btnQuotes, btnFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHappy = findViewById(R.id.btnhappy);
        btnSad = findViewById(R.id.btnsad);
        btnChill = findViewById(R.id.btnchill);
        btnEnergetic = findViewById(R.id.btnenergetic);
        btnQuotes = findViewById(R.id.btnQuote);
        btnFavorites = findViewById(R.id.btnfavorite);

        btnHappy.setOnClickListener(v -> openSongs("happy"));
        btnSad.setOnClickListener(v -> openSongs("sad"));
        btnChill.setOnClickListener(v -> openSongs("chill"));
        btnEnergetic.setOnClickListener(v -> openSongs("energetic"));

        btnQuotes.setOnClickListener(v -> startActivity(new Intent(this, QuoteReceiver.class)));
        btnFavorites.setOnClickListener(v -> startActivity(new Intent(this, FavoriteActivity.class)));
    }

    private void openSongs(String mood) {
        Intent intent = new Intent(this, SongsActivity.class);
        intent.putExtra("mood", mood);
        startActivity(intent);
    }
}
