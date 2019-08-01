package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.Utility.ViewDialogKristik;

public class PilihKristikActivity extends AppCompatActivity {
    private RadioGroup radioGroup1, radioGroup2;
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
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           IsFinish("Apakah Anda batal membuat kristik baru?");
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.imageView4);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(16));
        Glide.with(imageView.getContext())
                .load(R.drawable.bintangmaratur)
                .apply(requestOptions)
                .into(imageView);

        final AlertDialog.Builder builder = new AlertDialog.Builder(PilihKristikActivity.this);
        builder.setCancelable(true);
        builder.setMessage("Hasilkan kristik motif?");
        builder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        final Button kristik = (Button) findViewById(R.id.btnKristik);
        kristik.setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) {
                radioGroup1 = (RadioGroup) findViewById(R.id.group1);
                radioGroup2 = (RadioGroup) findViewById(R.id.group2);

                int check1 =  radioGroup1.getCheckedRadioButtonId();
                int check2 =  radioGroup2.getCheckedRadioButtonId();
                if(check1 != -1 && check2 != -1){
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }else if(check1 == -1 && check2 == -1){
                    RadioAlert("Pilih ukuran dan warna motif!");
                }else if(check1 == -1){
                    RadioAlert("Pilih ukuran motif!");
                }else if(check2 == -1){
                    RadioAlert("Pilih warna motif!");
                }
            }
        });
    }

    public void IsFinish(String alertmessage) {

        final AlertDialog.Builder builder2 = new AlertDialog.Builder(PilihKristikActivity.this);
        builder2.setCancelable(true);
        builder2.setMessage(alertmessage);
        builder2.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(), DescTenunActivity.class);
                        startActivity(i);
                    }
                });
        builder2.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });


        AlertDialog dialog = builder2.create();
        dialog.show();

    }

    public void RadioAlert(String alertmessage) {

        final AlertDialog.Builder builder2 = new AlertDialog.Builder(PilihKristikActivity.this);
        builder2.setCancelable(true);
        builder2.setMessage(alertmessage);
        builder2.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });


        AlertDialog dialog = builder2.create();
        dialog.show();

    }
}
