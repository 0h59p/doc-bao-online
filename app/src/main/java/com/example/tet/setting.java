package com.example.tet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import tonghopp.tonghop;

public class setting extends AppCompatActivity {
    Button send;
    ImageButton home;
    EditText nhan, tieude, noidung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        send = findViewById(R.id.send);
        nhan = findViewById(R.id.nhan);
        tieude = findViewById(R.id.tieude);
        noidung = findViewById(R.id.noidung);
        home = findViewById(R.id.imbhom);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nguoinhan = nhan.getText().toString().trim();
                String mota = tieude.getText().toString().trim();
                String thu = noidung.getText().toString().trim();
                sendEmail(nguoinhan,mota, thu );
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();

            }
        });


    }

    private void sendEmail(String nguoinhan, String mota, String thu) {
        Intent mEmailIntent = new Intent(Intent.ACTION_SEND);
        mEmailIntent.setData(Uri.parse("mailto: "));
        mEmailIntent.setType("text/plain");
        mEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{nguoinhan});
        mEmailIntent.putExtra(Intent.EXTRA_SUBJECT, mota);
        mEmailIntent.putExtra(Intent.EXTRA_TEXT, thu);
        try{
            startActivity(Intent.createChooser(mEmailIntent, "Choose an Email Client"));

        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public  void openActivity()
    {
        Intent myIntent=new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}