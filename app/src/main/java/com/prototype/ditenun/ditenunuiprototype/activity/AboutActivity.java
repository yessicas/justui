package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.prototype.ditenun.ditenunuiprototype.R;

public class AboutActivity extends AppCompatActivity {

    CardView mCardView1;
    CardView mCardView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mCardView1 = (CardView) findViewById(R.id.card_view_up);
        mCardView2 = (CardView) findViewById(R.id.card_view_down);

        mCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutActivity.this, SejarahActivity.class);
                startActivity(intent);
            }
        });

        mCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutActivity.this, TentangActivity.class);
                startActivity(intent);
            }
        });
    }
}
