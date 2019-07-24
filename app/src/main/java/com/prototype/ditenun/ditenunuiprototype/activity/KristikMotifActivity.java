package com.prototype.ditenun.ditenunuiprototype.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.Utility.ViewDialog;

public class KristikMotifActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    ViewDialog viewDialog;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kristik_motif);

        relativeLayout = findViewById(R.id.hasilKristik);
        relativeLayout.setVisibility(View.INVISIBLE);

        viewDialog = new ViewDialog(this);
        mButton = findViewById(R.id.btnSimpanKristik);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(KristikMotifActivity.this, "Gambar Telah Tersimpan", Toast.LENGTH_SHORT).show();

            }
        });
        final AlertDialog.Builder builder = new AlertDialog.Builder(KristikMotifActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Simpan gambar?");
        builder.setMessage("Gambar akan tersimpan di koleksi Anda");
        builder.setPositiveButton("Simpan",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(), CollectionActivity.class);
                        startActivity(i);
                    }
                });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        Button buttongenerate = (Button) findViewById(R.id.btnKristik);
        buttongenerate.setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) {

                // TODO Auto-generated method stub
                viewDialog.showDialog();

                Handler handler = null;
                handler = new Handler();
                handler.postDelayed(new Runnable(){
                    public void run(){
                        viewDialog.hideDialog();
                        relativeLayout.setVisibility(View.VISIBLE);
                    }
                }, 7000);

            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
