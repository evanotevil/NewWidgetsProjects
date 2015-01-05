package com.the111mins.newwidgetsprojects.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.the111mins.newwidgetsprojects.R;

/**
 * Created by klimenko on 18.12.14.
 */
public class RecycleSongsAdapter extends RecyclerView.Adapter<RecycleSongsAdapter.SongViewHolder> {

    private final Context mContext;
    private final String[] mSongs;

    public RecycleSongsAdapter(Context context, String[] songsArray) {
        this.mContext = context;
        this.mSongs = songsArray;
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {

        private final TextView songTitle;

        public SongViewHolder(View itemView) {
            super(itemView);
            this.songTitle = (TextView) itemView.findViewById(R.id.song_title);
        }
    }
    @Override
    public RecycleSongsAdapter.SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_song, parent, false);

        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleSongsAdapter.SongViewHolder holder, final int listPosition) {
        holder.songTitle.setText(mSongs[listPosition]);
    }

    @Override
    public int getItemCount() {
        return mSongs.length;
    }
}
