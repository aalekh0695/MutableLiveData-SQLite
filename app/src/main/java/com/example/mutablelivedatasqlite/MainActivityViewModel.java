package com.example.mutablelivedatasqlite;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private FavouritesDBHelper dbHelper;
    private MutableLiveData<List<Favourites>> mFavList;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        dbHelper = new FavouritesDBHelper(application);
    }

    public MutableLiveData<List<Favourites>> getFavs() {
        if (mFavList == null) {
            mFavList = new MutableLiveData<>();
            loadFavs();
        }

        return mFavList;
    }

    private void loadFavs() {
        List<Favourites> newFavs = new ArrayList<>();
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.query(DbSettings.DBEntry.TABLE_NAME,
//                new String[]{
//                        DbSettings.DBEntry._ID,
//                        DbSettings.DBEntry.COL_FAV_URL,
//                        DbSettings.DBEntry.COL_FAV_DATE
//                },
//                null, null, null, null, null);
//        while (cursor.moveToNext()) {
//            int idxId = cursor.getColumnIndex(DbSettings.DBEntry._ID);
//            int idxUrl = cursor.getColumnIndex(DbSettings.DBEntry.COL_FAV_URL);
//            int idxDate = cursor.getColumnIndex(DbSettings.DBEntry.COL_FAV_DATE);
//            newFavs.add(new Favourites(cursor.getLong(idxId), cursor.getString(idxUrl), cursor.getLong(idxDate)));
//        }
//
//        cursor.close();
//        db.close();

        for(int i=1; i<=3; i++){
            newFavs.add(new Favourites(1, "google",123));
        }

        mFavList.setValue(newFavs);
    }




    public void addFav(String url, long date) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbSettings.DBEntry.COL_FAV_URL, url);
        contentValues.put(DbSettings.DBEntry.COL_FAV_DATE, date);

        long id = db.insertWithOnConflict(DbSettings.DBEntry.TABLE_NAME,
                null,
                contentValues,
                SQLiteDatabase.CONFLICT_REPLACE);
        db.close();

        List<Favourites> favList = mFavList.getValue();

        ArrayList<Favourites> clonedFavs;
        if(favList == null){
            clonedFavs = new ArrayList<>();
        }else{
            clonedFavs = new ArrayList<>(favList.size());
            for(int i=0; i<clonedFavs.size(); i++){
                clonedFavs.add(new Favourites(favList.get(i)));
            }
        }

        Favourites favourites = new Favourites(id, url, date);
        clonedFavs.add(favourites);
        mFavList.setValue(clonedFavs);

    }
}
