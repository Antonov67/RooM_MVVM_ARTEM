package com.example.room_mvvm_artem.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoInt {

    @Query("SELECT * FROM 'chess'")
    LiveData<List<ChessEntity>> getAllChessTask();

    @Insert
    void insertChessTask(List<ChessEntity> data);

    @Query("SELECT * FROM 'chess' WHERE category like :category")
    LiveData<List<ChessEntity>> getAllChessTaskByCategory(String category);

}
