package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.Utility.ViewDialogKristik;

public class KristikMotifActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    ViewDialogKristik viewDialogKristik;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kristik_motif);

        relativeLayout = findViewById(R.id.resultgenerate);
        relativeLayout.setVisibility(View.INVISIBLE);

        viewDialogKristik = new ViewDialogKristik(this);
        mButton = findViewById(R.id.btnSimpanGenerate);
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

        final Button buttongenerate = (Button) findViewById(R.id.btnKristik);
        buttongenerate.setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) {

                // TODO Auto-generated method stub
                viewDialogKristik.showDialog();

                Handler handler = null;
                handler = new Handler();
                handler.postDelayed(new Runnable(){
                    public void run(){
                        viewDialogKristik.hideDialog();
                        relativeLayout.setVisibility(View.VISIBLE);
                    }
                }, 7000);

                if(viewDialogKristik.checkDialog()){
                    buttongenerate.setBackground(getDrawable(R.drawable.bgbtntask_disabled));;
                    buttongenerate.setEnabled(false);
                }
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
