package com.example.tet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imbt1, imbt2, imbt3, imbt4, lth, lex, lht, lns, ltt, dk, rt, st, aaa;

    private DrawerLayout dlMain;
    private ImageButton imMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imbt1 = findViewById(R.id.imbt1);
        imbt2 = findViewById(R.id.imbt2);
        imbt3 = findViewById(R.id.imbt3);
        imbt4 = findViewById(R.id.imbt4);
        lth = findViewById(R.id.lth);
        lex = findViewById(R.id.lex);
        lht = findViewById(R.id.lht);
        lns = findViewById(R.id.lns);
        ltt = findViewById(R.id.ltt);
        dk = findViewById(R.id.dk);
        rt = findViewById(R.id.rt);
        st = findViewById(R.id.st);
        aaa = findViewById(R.id.aaa);
        aaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityaaa();
            }
        });

        lth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        lex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        lht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        lns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        lth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        ltt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitytt();
            }
        });
        dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitydk();
            }
        });
        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitytr();
            }
        });
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityst();
            }
        });

        initView();

        imbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();

            }
        });
        imbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }
        });
        imbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();

            }
        });
        imbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();


            }

        });


    }

    private void initView()
    {
        dlMain = findViewById(R.id.dl_main);
        imMenu = findViewById(R.id.imbMenu);
        imMenu.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imbMenu:
                dlMain.openDrawer(Gravity.LEFT);
                break;
        }

    }




    public void openActivity1()
    {
        Intent myIntent = new Intent(this, bao1.class);
        startActivity(myIntent);
    }
    public void openActivity2()
    {
        Intent myIntent = new Intent(this, bao2.class);
        startActivity(myIntent);
    }
    public void openActivity3()
    {
        Intent myIntent = new Intent(this, bao4.class);
        startActivity(myIntent);
    }
    public void openActivity4()
    {
        Intent myIntent = new Intent(this, bao3.class);
        startActivity(myIntent);
    }
    public void openActivitytt()
    {
        Intent myIntent = new Intent(this, thongtin.class);
        startActivity(myIntent);
    }
    public void openActivitydk()
    {
        Intent myIntent = new Intent(this, dieukhoan.class);
        startActivity(myIntent);
    }
    public void openActivitytr()
    {
        Intent myIntent = new Intent(this, riengtu.class);
        startActivity(myIntent);
    }
    public void openActivityst()
    {
        Intent myIntent = new Intent(this, setting.class);
        startActivity(myIntent);
    }
    public void openActivityaaa()
    {
        Intent myIntent = new Intent(this, bao2.class);
        startActivity(myIntent);
    }


}
