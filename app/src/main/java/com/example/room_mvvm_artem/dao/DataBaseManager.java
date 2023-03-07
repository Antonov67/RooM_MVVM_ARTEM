package com.example.room_mvvm_artem.dao;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class DataBaseManager {

    private DataBaseHelper db;
    private static DataBaseManager instance;

    private DataBaseManager(Context context){
        db = Room.databaseBuilder(context,
                DataBaseHelper.class,
                DataBaseHelper.DATABASE_NAME)
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                initData(context);
                            }
                        });
                    }
                })
                .build();
    }

    public static DataBaseManager getInstance(Context context){
        if (instance == null){
            instance = new DataBaseManager(context.getApplicationContext());
        }
        return instance;
    }

    public DaoInt getDaoInt(){
        return db.daoInt();
    }

    public void initData(Context context){
        List<ChessEntity> chessTasks = new ArrayList<>();
        ChessEntity chessTask = new ChessEntity();

        chessTask.category = "тактика";
        chessTask.imgPath = "task1";
        chessTask.solve = "решение первой задачи";

        chessTasks.add(chessTask);

        chessTask = new ChessEntity();

        chessTask.category = "этюды";
        chessTask.imgPath = "task2";
        chessTask.solve = "решение второй задачи";

        chessTasks.add(chessTask);

        DataBaseManager.getInstance(context).getDaoInt().insertChessTask(chessTasks);
    }
}
