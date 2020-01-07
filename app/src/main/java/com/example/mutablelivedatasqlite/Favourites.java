package com.example.mutablelivedatasqlite;

public class Favourites {
    public long mId;
    public String mUrl;
    public long mDate;

    public Favourites(long mId, String mUrl, long mDate) {
        this.mId = mId;
        this.mUrl = mUrl;
        this.mDate = mDate;
    }

    public Favourites(Favourites favourites) {
        this.mId = favourites.mId;
        this.mUrl = favourites.mUrl;
        this.mDate = favourites.mDate;
    }
}
