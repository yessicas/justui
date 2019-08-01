package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.Utility.CustomTypeFaceSpan;
import com.prototype.ditenun.ditenunuiprototype.adapter.UlosAdapter;
import com.prototype.ditenun.ditenunuiprototype.model.UlosData;

import java.util.ArrayList;
import java.util.List;

public class MoreActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    RecyclerView mRecyclerView;
    List<UlosData> mUlosList;
    UlosData mUlosData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =  getIntent();
        String daerah = intent.getStringExtra("daerah");
//        getSupportActionBar().setTitle("Tenun " + daerah);
        setContentView(R.layout.activity_more);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(MoreActivity.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mUlosList = new ArrayList<>();
        mUlosData = new UlosData("Harungguan", "test",
                R.drawable.harungguan_potrait);
        mUlosList.add(mUlosData);
        mUlosData = new UlosData("Ragihotang", "test",
                R.drawable.ragihotang_potrait);
        mUlosList.add(mUlosData);
        mUlosData = new UlosData("Ragiidup", "test",
                R.drawable.ragiidup_potrait);
        mUlosList.add(mUlosData);
        mUlosData = new UlosData("Suri-suri", "test",
                R.drawable.surisuri_potrait);
        mUlosList.add(mUlosData);
        mUlosData = new UlosData("Bintang Maratur", "test",
                R.drawable.bintangmaratur_potrait);
        mUlosList.add(mUlosData);
        mUlosData = new UlosData("Mangiring", "test",
                R.drawable.mangiring_potrait);
        mUlosList.add(mUlosData);


        UlosAdapter ulosAdapter = new UlosAdapter(MoreActivity.this, mUlosList);
        mRecyclerView.setAdapter(ulosAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        if (item.getItemId() == R.id.navigation_home){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
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
}