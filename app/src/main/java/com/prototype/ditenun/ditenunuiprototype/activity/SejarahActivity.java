package com.prototype.ditenun.ditenunuiprototype.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.prototype.ditenun.ditenunuiprototype.R;

public class SejarahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sejarah);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
