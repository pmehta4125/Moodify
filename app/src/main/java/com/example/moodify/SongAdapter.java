package com.example.moodify;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.moodify.model.Song;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private Context context;
    private List<Song> songList;
    private SharedPreferences prefs;

    public SongAdapter(Context context, List<Song> songList, SharedPreferences prefs) {
        this.context = context;
        this.songList = songList;
        this.prefs = prefs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_song_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.txtSongName.setText(song.getTitle());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(song.getUrl()));
            context.startActivity(intent);
        });

       /* boolean isFav = prefs.getBoolean(song.getTitle(), false);
        holder.btnFavorite.setImageResource(isFav ? R.drawable.ic_favorite : R.drawable.ic_favorite_border);

        holder.btnFavorite.setOnClickListener(v -> {
            boolean currentlyFav = prefs.getBoolean(song.getTitle(), false);
            prefs.edit().putBoolean(song.getTitle(), !currentlyFav).apply();
            holder.btnFavorite.setImageResource(!currentlyFav ? R.drawable.ic_favorite : R.drawable.ic_favorite_border);
        });*/
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtSongName;
        ImageButton btnFavorite;

        public ViewHolder(View itemView) {
            super(itemView);
            txtSongName = itemView.findViewById(R.id.txtSongName);
            // btnFavorite = itemView.findViewById(R.id.btnFavorite);
        }
    }
}
