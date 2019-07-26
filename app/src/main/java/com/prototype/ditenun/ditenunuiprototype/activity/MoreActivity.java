package com.prototype.ditenun.ditenunuiprototype.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.adapter.UlosAdapter;
import com.prototype.ditenun.ditenunuiprototype.model.UlosData;

import java.util.ArrayList;
import java.util.List;

public class MoreActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<UlosData> mUlosList;
    UlosData mUlosData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =  getIntent();
        String daerah = intent.getStringExtra("daerah");
        getSupportActionBar().setTitle("Tenun " + daerah);
        setContentView(R.layout.activity_more);

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
}