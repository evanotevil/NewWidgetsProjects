package com.the111mins.newwidgetsprojects.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by klimenko on 18.12.14.
 */
public class RecycleSongsAdapter extends RecyclerView.Adapter<RecycleSongsAdapter.SongViewHolder> {

    private final String[] mSongs;

    public RecycleSongsAdapter(String[] songsArray) {
        this.mSongs = songsArray;
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {

        private TextView songTitle;

        public SongViewHolder(View itemView) {
            super(itemView);
            this.songTitle = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    @Override
    public RecycleSongsAdapter.SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);

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
