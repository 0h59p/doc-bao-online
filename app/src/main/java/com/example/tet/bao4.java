package com.example.tet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import ngoisao.danhsach2_1;
import ngoisao.danhsach2_2;
import ngoisao.danhsach2_3;
import ngoisao.danhsach2_4;
import ngoisao.danhsach2_5;
import ngoisao.danhsach2_6;
import ngoisao.danhsach2_7;
import ngoisao.danhsach2_8;
// ngoi sao

public class bao4 extends AppCompatActivity {

    ImageButton bt1,bt2, bt3, bt4, bt5, bt6, bt7, bt8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao4);
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
        Intent myIntent=new Intent(this, danhsach2_1.class);
        startActivity(myIntent);
    }
    public void openActivity2()
    {
        Intent myIntent=new Intent(this, danhsach2_2.class);
        startActivity(myIntent);
    }public void openActivity3()
    {
        Intent myIntent=new Intent(this, danhsach2_3.class);
        startActivity(myIntent);
    }public void openActivity4()
    {
        Intent myIntent=new Intent(this, danhsach2_4.class);
        startActivity(myIntent);
    }public void openActivity5()
    {
        Intent myIntent=new Intent(this, danhsach2_5.class);
        startActivity(myIntent);
    }public void openActivity6()
    {
        Intent myIntent=new Intent(this, danhsach2_6.class);
        startActivity(myIntent);
    }
    public void openActivity7()
    {
        Intent myIntent=new Intent(this, danhsach2_7.class);
        startActivity(myIntent);
    }public void openActivity8()
    {
        Intent myIntent=new Intent(this, danhsach2_8.class);
        startActivity(myIntent);
    }
}
