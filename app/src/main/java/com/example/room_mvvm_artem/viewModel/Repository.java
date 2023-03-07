package com.example.room_mvvm_artem.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.room_mvvm_artem.dao.ChessEntity;
import com.example.room_mvvm_artem.dao.DaoInt;
import com.example.room_mvvm_artem.dao.DataBaseManager;

import java.util.List;

public class Repository {

    private DataBaseManager dataBaseManager;
    private DaoInt dao;

    public Repository(Context context) {
        dataBaseManager = DataBaseManager.getInstance(context);
        dao = dataBaseManager.getDaoInt();
    }

   public LiveData<List<ChessEntity>> getAllChessTask(){
        return dao.getAllChessTask();
   }


    public void insertChessTask(List<ChessEntity> data){
        dao.insertChessTask(data);
    }

    public LiveData<List<ChessEntity>> getAllChessTaskByCategory(String category){
        return dao.getAllChessTaskByCategory(category);
    }
}
