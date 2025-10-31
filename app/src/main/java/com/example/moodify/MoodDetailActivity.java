package com.example.moodify;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MoodDetailActivity extends AppCompatActivity {

    ImageView imgMood;
    TextView tvMoodTitle,tvQuote;
    Button btnplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_detail);

        imgMood=findViewById(R.id.imgMood);
        tvMoodTitle = findViewById(R.id.tvMoodTitle);
        tvQuote = findViewById(R.id.tvQuote);
        btnplay = findViewById(R.id.btnplay);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String quote = intent.getStringExtra("quote");
        String url = intent.getStringExtra("url");
        int image = intent.getIntExtra("image", 0);

        tvMoodTitle.setText(name + " Mood");
        tvQuote.setText(quote);
        imgMood.setImageResource(image);

        btnplay.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        });
    }
}