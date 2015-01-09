package com.the111mins.newwidgetsprojects.utils;

import android.content.Context;
import android.content.Intent;

import com.the111mins.newwidgetsprojects.R;
import com.the111mins.newwidgetsprojects.model.Album;

import java.util.ArrayList;

/**
 * Created by klimenko on 12.12.14.
 */
public class DataUtils {

    public static ArrayList<Album> getAlbumsData() {
        ArrayList<Album> albums = new ArrayList<Album>();
        Album album1 = new Album(0, R.drawable.standby, "Standby", "I Will Never Be The Same", "2009", new String[]{"Prelude", "I Am Not The One", "Worldless", "Starfields", "Burn", "Speak", "All For You", "Last Goodbye", "Set Your World On Fire", "Eyes Turning Black", "Superloop", "Cry Little Sister"});
        Album album2 = new Album(1, R.drawable.brand_new_eyes, "Brand New Eyes", "Paramore", "2009", new String[]{"Prelude", "I Am Not The One", "Worldless", "Starfields", "Burn", "Speak", "All For You", "Last Goodbye", "Set Your World On Fire", "Eyes Turning Black", "Superloop", "Cry Little Sister"});
        Album album3 = new Album(2, R.drawable.savages, "Savages", "Breathe Carolina", "2009", new String[]{"Prelude", "I Am Not The One", "Worldless", "Starfields", "Burn", "Speak", "All For You", "Last Goodbye", "Set Your World On Fire", "Eyes Turning Black", "Superloop", "Cry Little Sister"});
        Album album4 = new Album(3, R.drawable.the_verge, "The Verge", "There For Tomorrow", "2009", new String[]{"Prelude", "I Am Not The One", "Worldless", "Starfields", "Burn", "Speak", "All For You", "Last Goodbye", "Set Your World On Fire", "Eyes Turning Black", "Superloop", "Cry Little Sister"});
        Album album5 = new Album(4, R.drawable.crash_love, "Crash Love", "AFI", "2009", new String[]{"Prelude", "I Am Not The One", "Worldless", "Starfields", "Burn", "Speak", "All For You", "Last Goodbye", "Set Your World On Fire", "Eyes Turning Black", "Superloop", "Cry Little Sister"});

        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        albums.add(album4);
        albums.add(album5);
        return albums;
    }

    public static Intent getShareData(Context context, Album album) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, context.getString(R.string.text_share_text, album.getTitle(), album.getArtistName()));
        return sendIntent;
    }
}
