package com.lifeistech.litboard2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class GachaActivity extends AppCompatActivity {

    TextView mafuteru;
    int count;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mafuteru = (TextView) findViewById(R.id.mafuteru);
        count = 0;


    }

    public void add(View v){
        count = count + 1;


        Random randomName = new Random();
        int index = randomName.nextInt(51);

        mafuteru.setText(index + "回ボタンが押されますた。");

    }










}