package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.Utility.ViewDialog;

public class GenerateMotifActivity extends AppCompatActivity {

    ViewDialog viewDialog;
    Button mButton;

    Spinner spinner;

    String names[]={"Pilih Model", "Model 1","Model 2", "Model 3"};

    RelativeLayout relativeLayout;

    ArrayAdapter<String> adapter;
  //  Button buttongenerate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_motif);

        relativeLayout = findViewById(R.id.resultgenerate);
        relativeLayout.setVisibility(View.INVISIBLE);
        spinner = (Spinner)findViewById(R.id.spinner1);
        adapter = new ArrayAdapter<String>(this, android. R.layout.simple_list_item_1, names);

        viewDialog = new ViewDialog(this);
        mButton = findViewById(R.id.btnSimpanGenerate);

        final AlertDialog.Builder builder = new AlertDialog.Builder(GenerateMotifActivity.this);
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

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button buttongenerate = (Button) findViewById(R.id.buttongenerate);
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
                }, 5000);

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
