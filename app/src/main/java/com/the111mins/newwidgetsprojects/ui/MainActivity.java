package com.the111mins.newwidgetsprojects.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.the111mins.newwidgetsprojects.Const;
import com.the111mins.newwidgetsprojects.R;
import com.the111mins.newwidgetsprojects.model.Album;
import com.the111mins.newwidgetsprojects.ui.adapter.RecycleCardsAdapter;
import com.the111mins.newwidgetsprojects.utils.DataUtils;

import java.util.ArrayList;

/**
 * Created by klimenko on 12.12.14.
 */
public class MainActivity extends ActionBarActivity implements RecycleCardsAdapter.RecycleOnItemClickListener {

    private ArrayList<Album> mAlbums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView albumsRecycleView = (RecyclerView) findViewById(R.id.recycle_view);
        albumsRecycleView.setHasFixedSize(true);

        GridLayoutManager recycleLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        albumsRecycleView.setLayoutManager(recycleLayoutManager);
        albumsRecycleView.setItemAnimator(new DefaultItemAnimator());

        mAlbums = DataUtils.getAlbumsData();
        RecycleCardsAdapter albumsAdapter = new RecycleCardsAdapter(this, mAlbums, this);
        albumsRecycleView.setAdapter(albumsAdapter);
    }

    @Override
    public void onOptionsClick(View view, final int position) {
        PopupMenu.OnMenuItemClickListener cardMenuListener = new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.action_share) {
                    startActivity(DataUtils.getShareData(MainActivity.this, mAlbums.get(position)));
                } else if (itemId == R.id.action_delete) {
                    // todo
                }
                return true;
            }
        };

        PopupMenu cardMenu = new PopupMenu(MainActivity.this, view);
        cardMenu.inflate(R.menu.menu_card);
        cardMenu.setOnMenuItemClickListener(cardMenuListener);
        cardMenu.show();
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(MainActivity.this, AlbumDetailsActivity.class);
        intent.putExtra(Const.ALBUM_INTENT_EXTRA, mAlbums.get(position));
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, view, getString(R.string.text_art));
        ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
    }
}
