package com.the111mins.newwidgetsprojects.model;

import java.io.Serializable;

/**
 * Created by klimenko on 12.12.14.
 */
public class Album implements Serializable {

    private int mId;
    private int mAlbumArt;
    private String mTitle;
    private String mArtistName;
    private String mReleaseYear;
    private String[] mSongTitles;

    public Album(int id, int albumArt, String title, String artistName, String releaseYear, String[] songTitles) {
        this.mId = id;
        this.mAlbumArt = albumArt;
        this.mTitle = title;
        this.mArtistName = artistName;
        this.mReleaseYear = releaseYear;
        this.mSongTitles = songTitles;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public int getAlbumArt() {
        return mAlbumArt;
    }

    public void setAlbumArt(int albumArt) {
        this.mAlbumArt = albumArt;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public void setArtistName(String artistName) {
        this.mArtistName = artistName;
    }

    public String getReleaseYear() {
        return mReleaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.mReleaseYear = releaseYear;
    }

    public String[] getSongTitles() {
        return mSongTitles;
    }

    public void setSongTitles(String[] songTitles) {
        this.mSongTitles = songTitles;
    }
}
