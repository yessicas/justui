package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.prototype.ditenun.ditenunuiprototype.R;

public class PilihKristikActivity extends AppCompatActivity {
    private RadioButton radioButton1,radioButton2, radioButton3, radioButton4, radioButton5, radioButton6;
    private Button kristik;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kristik);

        radioButton1=findViewById(R.id.radioButton1);
        radioButton2=findViewById(R.id.radioButton2);
        radioButton3=findViewById(R.id.radioButton3);
        radioButton4=findViewById(R.id.radioButton4);
        radioButton5=findViewById(R.id.radioButton5);
        radioButton6=findViewById(R.id.radioButton6);
        kristik=findViewById(R.id.btnKristik);
        kristik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton1.isChecked()){
                    Toast.makeText(getApplicationContext(), ""+radioButton1.getText().toString(),Toast.LENGTH_SHORT).show();

                }else if (radioButton2.isChecked()){
                    Toast.makeText(getApplicationContext(), ""+radioButton2.getText().toString(),Toast.LENGTH_SHORT).show();

                }
            }
        });

        final Button kristik = (Button) findViewById(R.id.btnKristik);
        kristik.setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) {

                Intent i = new Intent(getApplicationContext(), CollectionActivity.class);
                startActivity(i);


            }
        });
    }
}
