package com.example.aydemir.roompersistencelibraryexample.database;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users") //tablo adını istersek böyle değiştirebiliyoruz.
//@Entity default durum. tablo adı User olur
public class User {
    @PrimaryKey(autoGenerate = true)//otomatik olarak arttırıyor
    public int userId;
    @ColumnInfo(name = "first_name")// kolon ismi olarak firstname(default) değil,first_name kullanıldı.
    public String firstname;
    @ColumnInfo(name = "sur_name")
    public String surname;
}
