package com.example.room_mvvm_artem.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.room_mvvm_artem.R;
import com.example.room_mvvm_artem.dao.ChessEntity;
import com.example.room_mvvm_artem.viewModel.MainViewModel;

import java.io.File;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    TextView textSolve;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSolve = findViewById(R.id.text_solve);
        imageView = findViewById(R.id.image_view);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.getAllChessTask().observe(MainActivity.this, new Observer<List<ChessEntity>>() {
                    @Override
                    public void onChanged(List<ChessEntity> chessTasks) {
                        String str = "res/drawable/" + chessTasks.get(0).imgPath + ".png";
                        imageView.setImageBitmap(BitmapFactory.decodeFile(str));

                        Log.d("777", str);
                        textSolve.setText(chessTasks.get(0).category + " " + chessTasks.get(0).solve);
                        Log.d("777", chessTasks.get(0).category + " " + chessTasks.get(0).solve);
                    }
                });


            }
        });
    }
}