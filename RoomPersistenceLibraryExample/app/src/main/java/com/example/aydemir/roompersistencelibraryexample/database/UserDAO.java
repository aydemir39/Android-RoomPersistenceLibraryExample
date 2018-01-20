package com.example.aydemir.roompersistencelibraryexample.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by alican on 19.01.2018.
 */
@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE) //Aynı kayıt varsa eski olanı değiştirir.
    void insertusers(User... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE) //Aynı kayıt varsa eski olanı değiştirir.
    Long insertuser(User user);

    @Update
    void updateuser(User... users);

    @Delete
    void deleteuser(User user);

    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE userId= :userIds")
    User loadAllByIds(int userIds);

    @Query("DELETE FROM users")
    void nukeTable();
}

