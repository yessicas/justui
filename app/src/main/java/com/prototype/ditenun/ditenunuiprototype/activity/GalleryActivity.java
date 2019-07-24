package com.prototype.ditenun.ditenunuiprototype.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.fragment.TitleNavigationAdapter;
import com.prototype.ditenun.ditenunuiprototype.model.SpinnerNavItem;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity implements ActionBar.OnNavigationListener {

    // Title navigation Spinner data
    private ArrayList<SpinnerNavItem> navSpinner;

    private ActionBar actionBar;

    // Navigation adapter
    private TitleNavigationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ImageView imageView = (ImageView) findViewById(R.id.imageView1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GalleryActivity.this, PilihMotifActivity.class);
                startActivity(intent);
            }
        });

        // Get ActionBar
        actionBar = getSupportActionBar();

        // Hide the action bar title
        actionBar.setDisplayShowTitleEnabled(false);

        // Enabling Spinner dropdown navigation
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        // Spinner title navigation data
        navSpinner = new ArrayList<SpinnerNavItem>();
        navSpinner.add(new SpinnerNavItem("Foto"));
        navSpinner.add(new SpinnerNavItem("Camera"));
        navSpinner.add(new SpinnerNavItem("Download"));

        // title drop down adapter
        adapter = new TitleNavigationAdapter(getApplicationContext(), navSpinner);

        // assigning the spinner navigation
        actionBar.setListNavigationCallbacks(adapter, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /**
     * On selecting action bar icons
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    /**
     * Actionbar navigation item select listener
     * */
    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        // Action to be taken after selecting a spinner item
        return false;
    }
}
