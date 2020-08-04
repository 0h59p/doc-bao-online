package com.example.tet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class flashscreen extends Activity {
    private final int SPLASH_DISPLAY_LEGTH = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashscreen);
        new  Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(flashscreen.this, MainActivity.class);
                flashscreen.this.startActivity(mainIntent);
                flashscreen.this.finish();
            }
        }, SPLASH_DISPLAY_LEGTH);
    }
}
