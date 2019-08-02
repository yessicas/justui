package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.adapter.Pager;
import com.prototype.ditenun.ditenunuiprototype.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import com.prototype.ditenun.ditenunuiprototype.Utility.CustomTypeFaceSpan;

//Implementing the interface OnTabSelectedListener to our MainActivity
//This interface would help in swiping views
public class CollectionActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        Intent intent = getIntent();

        if(intent.hasExtra("save")){
            Toast.makeText(CollectionActivity.this, "Gambar telah tersimpan", Toast.LENGTH_SHORT).show();
        }

        //Adding toolbar to the activity
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextAppearance(this, R.style.Courgette);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Foto"));
        tabLayout.addTab(tabLayout.newTab().setText("Generate"));
        tabLayout.addTab(tabLayout.newTab().setText("Kristik"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);



        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.setScrollPosition(position,0f,true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_collection);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                if (item.getItemId() == R.id.navigation_home){
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                }else if (item.getItemId() == R.id.navigation_add_photo){
                    Intent intent = new Intent(getBaseContext(), CameraActivity.class);
                    startActivity(intent);
                }
                return loadFragment(fragment);
            }
        });
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

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
