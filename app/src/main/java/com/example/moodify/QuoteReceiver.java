package com.example.moodify;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Map;

public class QuoteReceiver extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        TextView tvQuotes = findViewById(R.id.tvQuotes);
        SharedPreferences prefs = getSharedPreferences("MoodifyPrefs", Context.MODE_PRIVATE);
        Map<String, ?> allQuotes = prefs.getAll();

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, ?> entry : allQuotes.entrySet()) {
            if (entry.getKey().contains("_")) { // only quotes, not favorites
                builder.append("💭 ").append(entry.getValue()).append("\n\n");
            }
        }

        if (builder.length() == 0) builder.append("No quotes added yet!");
        tvQuotes.setText(builder.toString());
    }
}
