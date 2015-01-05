package com.the111mins.newwidgetsprojects.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.the111mins.newwidgetsprojects.R;
import com.the111mins.newwidgetsprojects.model.Album;
import com.the111mins.newwidgetsprojects.ui.adapter.RecycleCardsAdapter;
import com.the111mins.newwidgetsprojects.utils.DataUtils;

/**
 * Created by klimenko on 12.12.14.
 */
public class MainActivity extends ActionBarActivity implements RecycleCardsAdapter.CardViewHolder.OnViewClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView albumsRecycleView = (RecyclerView) findViewById(R.id.recycle_view);
        albumsRecycleView.setHasFixedSize(true);

        GridLayoutManager recycleLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        albumsRecycleView.setLayoutManager(recycleLayoutManager);
        albumsRecycleView.setItemAnimator(new DefaultItemAnimator());

        RecycleCardsAdapter albumsAdapter = new RecycleCardsAdapter(this, DataUtils.getAlbumsData(), this);
        albumsRecycleView.setAdapter(albumsAdapter);
    }

    @Override
    public void onAlbumClick(View view, View view2, Album tag) {
        Intent intent = new Intent(this, AlbumDetailsActivity.class);
        intent.putExtra("album", tag);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
                Pair.create(view, "art"), Pair.create(view2, "title"));
        ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
    }

    @Override
    public void onOptionClick() {

    }
}
