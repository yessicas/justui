package com.prototype.ditenun.ditenunuiprototype.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.fragment.TitleNavigationAdapter;
import com.prototype.ditenun.ditenunuiprototype.model.SpinnerNavItem;

import java.io.ByteArrayOutputStream;
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
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);

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

    public void onClick(View v){
        int image = 0;
        if(v.getId() == R.id.imageView1) {
            image = R.drawable.sadum;
            sentIntent(image);
        }
        if(v.getId() == R.id.imageView2) {
            image = R.drawable.gambar1;
            sentIntent(image);
        }
        if(v.getId() == R.id.imageView3) {
            image = R.drawable.gambar2;
            sentIntent(image);
        }
    }

    public void sentIntent(int image){
        Intent intent = new Intent(GalleryActivity.this, PilihMotifActivity.class);
        Bundle bundle=new Bundle();
        bundle.putInt("image",image);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.closemenu, menu);

        return true;
    }

    /**
     * On selecting action bar icons
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menu_close){
            onBackPressed();
            return true;
        }

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
