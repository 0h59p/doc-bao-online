package com.example.tet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import danhsach0.danhsach1;
import danhsach0.danhsach2;
import danhsach0.danhsach3;
import danhsach0.danhsach4;
import danhsach0.danhsach5;
import danhsach0.danhsach6;
import danhsach0.danhsach7;
import danhsach0.danhsach8;

public class bao1 extends AppCompatActivity {


    ImageButton bt1,bt2, bt3, bt4, bt5, bt6, bt7, bt8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao1);
        bt1 = findViewById(R.id.imbt1);
        bt2 = findViewById(R.id.imbt2);
        bt3 = findViewById(R.id.imbt3);
        bt4 = findViewById(R.id.imbt4);
        bt5 = findViewById(R.id.imbt5);
        bt6 = findViewById(R.id.imbt6);
        bt7 = findViewById(R.id.imbt7);
        bt8 = findViewById(R.id.imbt8);



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity5();
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity6();
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity7();
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity8();
            }
        });

    }
    public void openActivity1()
    {
        Intent myIntent=new Intent(this, danhsach1.class);
        startActivity(myIntent);
    }
    public void openActivity2()
    {
        Intent myIntent=new Intent(this, danhsach2.class);
        startActivity(myIntent);
    }public void openActivity3()
    {
        Intent myIntent=new Intent(this, danhsach3.class);
        startActivity(myIntent);
    }public void openActivity4()
    {
        Intent myIntent=new Intent(this, danhsach4.class);
        startActivity(myIntent);
    }public void openActivity5()
    {
        Intent myIntent=new Intent(this, danhsach5.class);
        startActivity(myIntent);
    }public void openActivity6()
    {
        Intent myIntent=new Intent(this, danhsach6.class);
        startActivity(myIntent);
    }public void openActivity7()
    {
        Intent myIntent=new Intent(this, danhsach7.class);
        startActivity(myIntent);
    }
    public void openActivity8()
    {
        Intent myIntent=new Intent(this, danhsach8.class);
        startActivity(myIntent);
    }
}
