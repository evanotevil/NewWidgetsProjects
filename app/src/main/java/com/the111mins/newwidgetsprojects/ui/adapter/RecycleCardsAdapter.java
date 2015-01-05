package com.the111mins.newwidgetsprojects.ui.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.the111mins.newwidgetsprojects.R;
import com.the111mins.newwidgetsprojects.model.Album;

import java.util.ArrayList;

/**
 * Created by klimenko on 12.12.14.
 */
public class RecycleCardsAdapter extends RecyclerView.Adapter<RecycleCardsAdapter.CardViewHolder> {

    private Context mContext;
    private ArrayList<Album> mAlbums;
    private CardViewHolder.OnViewClickListener mListener;

    public static class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final OnViewClickListener listener;
        private final CardView card;
        ImageView imageHolder;
        TextView textTitle;
        ImageButton imageOverflow;

        public CardViewHolder(View itemView, OnViewClickListener listener) {
            super(itemView);
            this.listener = listener;
            this.card = (CardView) itemView;
            this.imageHolder = (ImageView) itemView.findViewById(R.id.image_holder);
            this.textTitle = (TextView) itemView.findViewById(R.id.text_title);
            this.imageOverflow = (ImageButton) itemView.findViewById(R.id.image_overflow);
            imageHolder.setOnClickListener(this);
            imageOverflow.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v instanceof ImageButton) {
                //todo open options
                listener.onOptionClick();
            } else {
                listener.onAlbumClick(v, textTitle, (Album) v.getTag());
            }
        }

        public static interface OnViewClickListener {

            public void onAlbumClick(View view, View view2, Album tag);

            public void onOptionClick();
        }
    }

    public RecycleCardsAdapter(Context context, ArrayList<Album> albums, CardViewHolder.OnViewClickListener listener) {
        mContext = context;
        this.mAlbums = albums;
        mListener = listener;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

        return new CardViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, final int listPosition) {
        Album album = mAlbums.get(listPosition);

        holder.imageHolder.setImageResource(album.getAlbumArt());
        holder.imageHolder.setTag(album);
        holder.textTitle.setText(album.getTitle());

        Palette.generateAsync(((BitmapDrawable) mContext.getResources().getDrawable(album.getAlbumArt())).getBitmap(), new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                int vibrantColor = palette.getVibrantColor(0xffffffff);
                int textColor = palette.getVibrantSwatch().getTitleTextColor();
                holder.card.setBackgroundColor(vibrantColor);
                holder.textTitle.setTextColor(textColor);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAlbums.size();
    }
}
