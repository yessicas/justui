package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.Utility.ViewDialogGenerate;

public class GenerateMotifActivity extends AppCompatActivity {

    ViewDialogGenerate viewDialogGenerate;
    Button mButton;

    Spinner spinner;
    Context context;

    String names[]={"Pilih Model", "Model 1","Model 2", "Model 3"};

    RelativeLayout relativeLayout;
    Toolbar mToolbar;

    ArrayAdapter<String> adapter;
  //  Button buttongenerate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getApplicationContext();
        setContentView(R.layout.activity_generate_motif);
        relativeLayout = findViewById(R.id.resultgenerate);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Hasilkan Motif Baru");
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(relativeLayout.getVisibility() == View.VISIBLE) {
                    IsFinish("Apakah Anda kembali tanpa menyimpan?");
                }else{
                    finish();
                }
            }
        });

        relativeLayout.setVisibility(View.INVISIBLE);
        spinner = (Spinner)findViewById(R.id.spinner1);
        Button buttongenerate = (Button) findViewById(R.id.buttongenerate);
        buttongenerate.setBackground(getDrawable(R.drawable.bgbtntask_disabled));
        buttongenerate.setEnabled(false);
        adapter = new ArrayAdapter<String>(this, android. R.layout.simple_list_item_1, names);

        viewDialogGenerate = new ViewDialogGenerate(this);
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
                Button buttongenerate = (Button) findViewById(R.id.buttongenerate);
                String selected = spinner.getSelectedItem().toString();
                if(selected.equals("Pilih Model") || selected.equals(viewDialogGenerate.getSelected())){
                    buttongenerate.setBackground(getDrawable(R.drawable.bgbtntask_disabled));
                    buttongenerate.setEnabled(false);
                }else{
                    buttongenerate.setBackground(getDrawable(R.drawable.bgbtntask));
                    buttongenerate.setEnabled(true);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        buttongenerate.setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) {

                // TODO Auto-generated method stub
                viewDialogGenerate.showDialog();

                Handler handler = null;
                handler = new Handler();
                handler.postDelayed(new Runnable(){
                    public void run(){
                        Button buttongenerate = (Button) findViewById(R.id.buttongenerate);
                        viewDialogGenerate.hideDialog();
                        relativeLayout.setVisibility(View.VISIBLE);
                        viewDialogGenerate.setSelected(spinner.getSelectedItem().toString());
                        buttongenerate.setBackground(getDrawable(R.drawable.bgbtntask_disabled));
                        buttongenerate.setEnabled(false);
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


        ImageView imageView = (ImageView) findViewById(R.id.imageView4);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(16));
        Glide.with(imageView.getContext())
                .load(R.drawable.bintangmaratur)
                .apply(requestOptions)
                .into(imageView);
    }

    public void IsFinish(String alertmessage) {

        final AlertDialog.Builder builder2 = new AlertDialog.Builder(GenerateMotifActivity.this);
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

}
