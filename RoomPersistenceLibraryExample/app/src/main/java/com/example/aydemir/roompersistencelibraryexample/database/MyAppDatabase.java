package com.example.aydemir.roompersistencelibraryexample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by alican on 19.01.2018.
 */

@Database(entities = {User.class}, version =1 )
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
}
