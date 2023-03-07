package com.example.room_mvvm_artem.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.room_mvvm_artem.dao.ChessEntity;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    Repository repository;


    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<ChessEntity>> getAllChessTask(){
        return repository.getAllChessTask();
    }

    public void insertChessTask(List<ChessEntity> data){
        repository.insertChessTask(data);
    }

    public LiveData<List<ChessEntity>> getAllChessTaskByCategory(String category){
        return repository.getAllChessTaskByCategory(category);
    }
}
