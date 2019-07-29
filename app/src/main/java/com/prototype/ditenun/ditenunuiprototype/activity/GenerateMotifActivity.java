package com.prototype.ditenun.ditenunuiprototype.activity;

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
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.Utility.ViewDialogGenerate;

public class GenerateMotifActivity extends AppCompatActivity {

    ViewDialogGenerate viewDialogGenerate;
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
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Hasilkan Motif Baru");
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        relativeLayout = findViewById(R.id.resultgenerate);
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
    }


}
