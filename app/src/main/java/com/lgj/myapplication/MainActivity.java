package com.lgj.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadOne(View v){
        Intent intent=new Intent(this, OneActivity.class);
        startActivity(intent);
    }
    public void loadTwo(View v){
        Intent intent=new Intent(this, TwoActivity.class);
        startActivity(intent);
    }
}