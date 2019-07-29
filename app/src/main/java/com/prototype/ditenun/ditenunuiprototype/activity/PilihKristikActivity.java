package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.Utility.ViewDialogKristik;

public class PilihKristikActivity extends AppCompatActivity {
    private RadioButton radioButton1,radioButton2, radioButton3, radioButton4, radioButton5, radioButton6;
    private Button kristik;

    ViewDialogKristik viewDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kristik);
        viewDialog = new ViewDialogKristik(this);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Hasilkan Kristik Baru");
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        radioButton1=findViewById(R.id.radioButton1);
        radioButton2=findViewById(R.id.radioButton2);
        radioButton3=findViewById(R.id.radioButton3);
        radioButton4=findViewById(R.id.radioButton4);
        radioButton5=findViewById(R.id.radioButton5);
        radioButton6=findViewById(R.id.radioButton6);

        final Button kristik = (Button) findViewById(R.id.btnKristik);
        kristik.setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) {


                viewDialog.showDialog();

                Handler handler = null;
                handler = new Handler();
                handler.postDelayed(new Runnable(){
                    public void run(){
                        viewDialog.hideDialog();
                        Intent i = new Intent(getApplicationContext(), KristikMotifActivity.class);
                        i.putExtra("kristik", "baru");
                        startActivity(i);
                    }
                }, 3000);
            }
        });
    }
}
