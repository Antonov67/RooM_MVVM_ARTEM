package com.example.room_mvvm_artem.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {ChessEntity.class},version = 1)
public abstract class DataBaseHelper extends RoomDatabase {

    public static final String DATABASE_NAME = "db";

    public abstract DaoInt daoInt();


}
