package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.prototype.ditenun.ditenunuiprototype.R;

public class DescTenunActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_tenun);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("DiTenun");
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(16));
        Glide.with(imageView.getContext())
                .load(R.drawable.bintangmaratur)
                .apply(requestOptions)
                .into(imageView);

            Button button1 = (Button) findViewById(R.id.button1);
            button1.setOnClickListener(new View.OnClickListener() {


                public void onClick(View arg0) {

                    // TODO Auto-generated method stub

                    Intent i = new Intent(getApplicationContext(), GenerateMotifActivity.class);

                    startActivity(i);

                }
            });

        Button button2= (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) {

                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), KristikMotifActivity.class);

                startActivity(i);

            }
        });



    }
}
