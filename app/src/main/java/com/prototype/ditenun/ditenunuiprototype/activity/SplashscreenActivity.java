package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.prototype.ditenun.ditenunuiprototype.R;


public class SplashscreenActivity extends AppCompatActivity {

    private static int splashInterval = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashscreenActivity.this, MainActivity.class);
                startActivity(intent);
                this.finish();
            }

            private void finish() {

            }
        }, splashInterval);
    }
}