package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.Utility.CustomTypeFaceSpan;
import com.prototype.ditenun.ditenunuiprototype.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loading the default fragment
        loadFragment(new HomeFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_home);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        if (item.getItemId() == R.id.navigation_home){
            fragment = new HomeFragment();
        } else if (item.getItemId() == R.id.navigation_add_photo){
            Intent intent = new Intent(this, CameraActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.navigation_collection){
            Intent i = new Intent(this, CollectionActivity.class);
            startActivity(i);
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);


        for(int i = 0; i<menu.size(); i++){
            MenuItem item = menu.getItem(i);
            applyFontToMenuItem(item, Typeface.DEFAULT);
            SpannableString s = new SpannableString(item.getTitle());
            s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, s.length(), 0);
            item.setTitle(s);
        }
        return true;
    }

    private void applyFontToMenuItem(MenuItem mi, Typeface font) {
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypeFaceSpan("", font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menu_tentang){
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        } else if (item.getItemId() == R.id.menu_bantuan) {
            startActivity(new Intent(this, HelpActivity.class));
            return true;
        }
        return true;
    }

    public void onClick(View v){
        Intent intent = new Intent(v.getContext(), MoreActivity.class);
        switch(v.getId()) {
            case R.id.sumatera_lainnya:
                intent.putExtra("daerah", "Sumatera");
                break;
            case R.id.ntt_lainnya:
                intent.putExtra("daerah", "Nusa Tenggara Timur");
                break;
            case R.id.toraja_lainnya:
                intent.putExtra("daerah", "Toraja");
                break;
            case R.id.bali_lainnya:
                intent.putExtra("daerah", "Bali");
                break;
            case R.id.papua_lainnya:
                intent.putExtra("daerah", "Papua");
                break;
        }
        startActivity(intent);
    }
}