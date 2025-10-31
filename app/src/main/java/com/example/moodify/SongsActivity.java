package com.example.moodify;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import com.example.moodify.model.Song;

public class SongsActivity extends AppCompatActivity {

    ArrayList<Song> songList = new ArrayList<>();
    String mood;
    SharedPreferences prefs;
    RecyclerView recyclerView;
    Button btnAddQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_acivity);

        recyclerView = findViewById(R.id.recyclerSongs);
        btnAddQuote = findViewById(R.id.btnAddQuote);

        prefs = getSharedPreferences("MoodifyPrefs", Context.MODE_PRIVATE);
        mood = getIntent().getStringExtra("mood");

        loadSongsForMood(mood);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SongAdapter(this, songList, prefs));

        btnAddQuote.setOnClickListener(v -> openAddQuoteDialog());
    }

    private void openAddQuoteDialog() {
        EditText input = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle("Add a Quote for " + mood)
                .setView(input)
                .setPositiveButton("Save", (dialog, which) -> {
                    String quote = input.getText().toString();
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("quote_" + mood, quote);
                    editor.apply();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void loadSongsForMood(String mood) {
        songList.clear();
        if (mood.equals("happy")) {
            songList.add(new Song("Abhi Toh Party Shuru Hui Hai", "https://youtu.be/8LZgzAZ2lpQ"));
            songList.add(new Song("London Thumakda", "https://youtu.be/udra3Mfw2oo"));
            songList.add(new Song("Shaam Shaandaar", "https://youtu.be/D21Di3NXcYM"));
            songList.add(new Song("Balam Pichkari", "https://youtu.be/0WtRNGubWGA"));
            songList.add(new Song("Gallan Goodiyaan", "https://youtu.be/jCEdTq3j-0U"));
            songList.add(new Song("Smile", "https://www.youtube.com/watch?v=rGDcbQKxY7Q&list=PLeDakahyfrO9EPCwHmosEB_M0tdL1lDwz&index=1&pp=iAQB8AUB"));
            songList.add(new Song("Ordinary", "https://www.youtube.com/watch?v=byxFUKxhT3s&list=PLeDakahyfrO9EPCwHmosEB_M0tdL1lDwz&index=12&pp=iAQB8AUB"));
            songList.add(new Song("Birdy", "https://www.youtube.com/watch?v=m8AXUq5uA0Y&list=PLeDakahyfrO9EPCwHmosEB_M0tdL1lDwz&index=35"));
            songList.add(new Song("Happy - Pharrell Williams", "https://www.youtube.com/watch?v=ZbZSe6N_BXs"));
            songList.add(new Song("Best Day of My Life - American Authors", "https://www.youtube.com/watch?v=Y66j_BUCBMY"));
        } else if (mood.equals("sad")) {
            songList.add(new Song("Channa Mereya", "https://youtu.be/284Ov7ysmfA"));
            songList.add(new Song("Agar Tum Saath Ho", "https://youtu.be/T94PHkuydcw"));
            songList.add(new Song("Kabira (Encore)", "https://youtu.be/jHNNMj5bNQw"));
            songList.add(new Song("Tujhe Bhula Diya", "https://youtu.be/6t1FNhQpaNk"));
            songList.add(new Song("Bhula Dena", "https://youtu.be/qCzJWiGMVjs"));
            songList.add(new Song("Fix You - Coldplay", "https://www.youtube.com/watch?v=k4V3Mo61fJM"));
            songList.add(new Song("Someone Like You - Adele", "https://www.youtube.com/watch?v=hLQl3WQQoQ0"));
            songList.add(new Song("Let Her Go - Passenger", "https://www.youtube.com/watch?v=RBumgq5yVrA"));
            songList.add(new Song("When I Was Your Man - Bruno Mars", "https://www.youtube.com/watch?v=ekzHIouo8Q4"));
            songList.add(new Song("Say Something - A Great Big World ft. Christina Aguilera", "https://www.youtube.com/watch?v=-2U0Ivkn2Ds"));
        } else if (mood.equals("chill")) {
            songList.add(new Song("Ilahi", "https://youtu.be/CmrOB_d8I7I"));
            songList.add(new Song("Phir Se Ud Chala", "https://youtu.be/JkYDc_8YF3Y"));
            songList.add(new Song("Safarnama", "https://youtu.be/wyGzng0T9JQ"));
            songList.add(new Song("Khaabon Ke Parinday", "https://youtu.be/lPDLHGzBGR0"));
            songList.add(new Song("Sooraj Dooba Hai", "https://youtu.be/tKJoJzQvLwQ"));
            songList.add(new Song("Perfect - Ed Sheeran", "https://www.youtube.com/watch?v=2Vv-BfVoq4g"));
            songList.add(new Song("Sunflower - Post Malone", "https://www.youtube.com/watch?v=ApXoWvfEYVU"));
            songList.add(new Song("Lovely - Billie Eilish", "https://www.youtube.com/watch?v=V1Pl8CzNzCw"));
            songList.add(new Song("Let’s Fall in Love for the Night - FINNEAS", "https://www.youtube.com/watch?v=hBjO3HPgFhg"));
            songList.add(new Song("Better Together - Jack Johnson", "https://www.youtube.com/watch?v=u57d4_b_YgI"));
        } else if (mood.equals("energetic")) {
            songList.add(new Song("Zinda - Bhaag Milkha Bhaag", "https://youtu.be/YxWlaYCA8MU"));
            songList.add(new Song("Brothers Anthem", "https://youtu.be/fWMIigbAc2U"));
            songList.add(new Song("Sultan Title Track", "https://youtu.be/wPxqcq6Byq0"));
            songList.add(new Song("Malhari", "https://youtu.be/UwzAVqQ0nGQ"));
            songList.add(new Song("Aala Re Aala", "https://youtu.be/HkX7QCECamA"));
            songList.add(new Song("Thunder - Imagine Dragons", "https://www.youtube.com/watch?v=fKopy74weus"));
            songList.add(new Song("Believer - Imagine Dragons", "https://www.youtube.com/watch?v=7wtfhZwyrcc"));
            songList.add(new Song("Stronger - Kanye West", "https://www.youtube.com/watch?v=PsO6ZnUZI0g"));
            songList.add(new Song("Don't Stop Me Now - Queen", "https://www.youtube.com/watch?v=HgzGwKwLmgM"));
            songList.add(new Song("Can’t Hold Us - Macklemore & Ryan Lewis", "https://www.youtube.com/watch?v=2zNSgSzhBfM"));
        }
    }
}
