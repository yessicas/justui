package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.prototype.ditenun.ditenunuiprototype.R;

public class HelpActivity extends AppCompatActivity {

    CardView mCardView1;
    CardView mCardView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        mCardView1 = (CardView) findViewById(R.id.card_view_1);
        mCardView2 = (CardView) findViewById(R.id.card_view_2);

        mCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelpActivity.this, ToGenerateActivity.class);
                startActivity(intent);
            }
        });

        mCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelpActivity.this, ToKristikActivity.class);
                startActivity(intent);
            }
        });
    }
}
