package com.the111mins.newwidgetsprojects.utils;

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
        Album album2 = new Album(0, R.drawable.brand_new_eyes, "Brand New Eyes", "I Will Never Be The Same", "2009", new String[]{"Prelude", "I Am Not The One", "Worldless", "Starfields", "Burn", "Speak", "All For You", "Last Goodbye", "Set Your World On Fire", "Eyes Turning Black", "Superloop", "Cry Little Sister"});
        Album album3 = new Album(0, R.drawable.savages, "Savages", "I Will Never Be The Same", "2009", new String[]{"Prelude", "I Am Not The One", "Worldless", "Starfields", "Burn", "Speak", "All For You", "Last Goodbye", "Set Your World On Fire", "Eyes Turning Black", "Superloop", "Cry Little Sister"});
        Album album4 = new Album(0, R.drawable.the_verge, "The Verge", "I Will Never Be The Same", "2009", new String[]{"Prelude", "I Am Not The One", "Worldless", "Starfields", "Burn", "Speak", "All For You", "Last Goodbye", "Set Your World On Fire", "Eyes Turning Black", "Superloop", "Cry Little Sister"});
        Album album5 = new Album(0, R.drawable.crash_love, "Crash Love", "I Will Never Be The Same", "2009", new String[]{"Prelude", "I Am Not The One", "Worldless", "Starfields", "Burn", "Speak", "All For You", "Last Goodbye", "Set Your World On Fire", "Eyes Turning Black", "Superloop", "Cry Little Sister"});
        //Album album6 = new Album(0, R.drawable.llfd, "Love, Lust, Faith and Dreams", "I Will Never Be The Same", "2009", new String[]{"Prelude", "I Am Not The One", "Worldless", "Starfields", "Burn", "Speak", "All For You", "Last Goodbye", "Set Your World On Fire", "Eyes Turning Black", "Superloop", "Cry Little Sister"});
       /* Album album2 = new Album();
        Album album3 = new Album();
        Album album4 = new Album();
        Album album5 = new Album();
        Album album6 = new Album();
        Album album7 = new Album();
        Album album8 = new Album();
        Album album9 = new Album();
        Album album10 = new Album();
        Album album11 = new Album();*/
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        albums.add(album4);
        albums.add(album5);
        //albums.add(album6);
        return albums;
    }

}
