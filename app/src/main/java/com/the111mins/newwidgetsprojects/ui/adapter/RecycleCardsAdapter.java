package com.the111mins.newwidgetsprojects.ui.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.the111mins.newwidgetsprojects.R;
import com.the111mins.newwidgetsprojects.model.Album;

import java.util.ArrayList;

/**
 * Created by klimenko on 12.12.14.
 */
public class RecycleCardsAdapter extends RecyclerView.Adapter<RecycleCardsAdapter.CardViewHolder> implements View.OnClickListener {

    private Context mContext;
    private ArrayList<Album> mAlbums;
    private RecycleOnItemClickListener mListener;

    public interface RecycleOnItemClickListener {

        public void onOptionsClick(View view, int position);

        public void onItemClick(View view, int position);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_overflow) {
            mListener.onOptionsClick(v, (Integer) v.getTag());
        } else {
            mListener.onItemClick(v, (Integer) v.getTag());
        }
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private final RelativeLayout cardRoot;
        ImageView imageHolder;
        TextView textTitle;
        ImageButton buttonOverflow;

        public CardViewHolder(View itemView) {
            super(itemView);
            this.cardRoot = (RelativeLayout) itemView.findViewById(R.id.lyt_card_root);
            this.imageHolder = (ImageView) itemView.findViewById(R.id.image_art);
            this.textTitle = (TextView) itemView.findViewById(R.id.txt_album_title);
            this.buttonOverflow = (ImageButton) itemView.findViewById(R.id.btn_overflow);
        }
    }

    public RecycleCardsAdapter(Context context, ArrayList<Album> albums, RecycleOnItemClickListener listener) {
        mContext = context;
        this.mAlbums = albums;
        mListener = listener;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_album, parent, false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, final int listPosition) {
        Album album = mAlbums.get(listPosition);

        holder.imageHolder.setImageResource(album.getAlbumArt());
        holder.textTitle.setText(album.getTitle());

        holder.buttonOverflow.setOnClickListener(this);
        holder.cardRoot.setOnClickListener(this);

        holder.cardRoot.setTag(listPosition);
        holder.buttonOverflow.setTag(listPosition);

        Palette.generateAsync(((BitmapDrawable) mContext.getResources().getDrawable(album.getAlbumArt())).getBitmap(), new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                int vibrantColor = palette.getVibrantColor(0xffffffff);
                int textColor = palette.getVibrantSwatch().getTitleTextColor();
                holder.cardRoot.setBackgroundColor(vibrantColor);
                holder.textTitle.setTextColor(textColor);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAlbums.size();
    }
}
