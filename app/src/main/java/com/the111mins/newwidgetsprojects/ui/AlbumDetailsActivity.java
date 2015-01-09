package com.the111mins.newwidgetsprojects.ui;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.the111mins.newwidgetsprojects.Const;
import com.the111mins.newwidgetsprojects.R;
import com.the111mins.newwidgetsprojects.model.Album;
import com.the111mins.newwidgetsprojects.ui.adapter.RecycleSongsAdapter;
import com.the111mins.newwidgetsprojects.utils.DataUtils;

/**
 * Created by klimenko on 15.12.14.
 */
public class AlbumDetailsActivity extends ActionBarActivity {

    private Album mAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);

        setupToolbar();

        mAlbum = (Album) getIntent().getSerializableExtra(Const.ALBUM_INTENT_EXTRA);

        ImageView albumArt = (ImageView) findViewById(R.id.image_art);
        albumArt.setImageResource(mAlbum.getAlbumArt());
        albumArt.setMinimumHeight(albumArt.getWidth());

        final LinearLayout about = (LinearLayout) findViewById(R.id.lyt_about);
        final TextView albumTitle = (TextView) findViewById(R.id.txt_album_title);
        albumTitle.setText(mAlbum.getTitle());
        final TextView artistName = (TextView) findViewById(R.id.txt_album_artist);
        artistName.setText(mAlbum.getArtistName());

        Palette.generateAsync(((BitmapDrawable) getResources().getDrawable(mAlbum.getAlbumArt())).getBitmap(), new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                int vibrantColor = palette.getVibrantColor(0xffffffff);
                int textTitleColor = palette.getVibrantSwatch().getTitleTextColor();
                int textColor = palette.getVibrantSwatch().getBodyTextColor();

                about.setBackgroundColor(vibrantColor);
                albumTitle.setTextColor(textTitleColor);
                artistName.setTextColor(textColor);
            }
        });

        RecyclerView songsRecycleView = (RecyclerView) findViewById(R.id.recycle_view_songs);
        songsRecycleView.setHasFixedSize(true);

        LinearLayoutManager recycleLayoutManager = new LinearLayoutManager(this);
        songsRecycleView.setLayoutManager(recycleLayoutManager);
        songsRecycleView.setItemAnimator(new DefaultItemAnimator());

        RecycleSongsAdapter songsAdapter = new RecycleSongsAdapter(mAlbum.getSongTitles());
        songsRecycleView.setAdapter(songsAdapter);

    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (toolbar != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(Color.TRANSPARENT);
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
            }
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_share) {
            startActivity(DataUtils.getShareData(AlbumDetailsActivity.this, mAlbum));
        } else if (item.getItemId() == R.id.action_open_in_browser) {
            //todo
        }

        return super.onOptionsItemSelected(item);
    }
}
