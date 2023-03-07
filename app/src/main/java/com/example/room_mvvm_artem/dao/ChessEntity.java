package com.example.room_mvvm_artem.dao;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "chess", indices = {@Index(value = {"img_path"}, unique = true)})
public class ChessEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "category")
    @NonNull
    public String category;

    @ColumnInfo(name = "img_path")
    @NonNull
    public String imgPath = "";

    @ColumnInfo(name = "solve")
    @NonNull
    public String solve = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
