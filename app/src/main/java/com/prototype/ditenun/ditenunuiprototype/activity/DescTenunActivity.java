package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.prototype.ditenun.ditenunuiprototype.R;

public class DescTenunActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_tenun);

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
