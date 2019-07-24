package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;
    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private static final int REQUEST_ID_PICK_GALERY = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loading the default fragment
        loadFragment(new HomeFragment());

        //getting bottom navigation view and attaching the listener
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
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

        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
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
        }  else if (item.getItemId() == R.id.menu_search) {
            return true;
        }

        return true;
    }
}