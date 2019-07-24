package com.prototype.ditenun.ditenunuiprototype.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.prototype.ditenun.ditenunuiprototype.fragment.FotoFragment;
import com.prototype.ditenun.ditenunuiprototype.fragment.GenerateFragment;
import com.prototype.ditenun.ditenunuiprototype.fragment.KristikFragment;


public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                FotoFragment fotoFragment = new FotoFragment();
                return fotoFragment;
            case 1:
                GenerateFragment generateFragment = new GenerateFragment();
                return generateFragment;
            case 2:
                KristikFragment kristikFragment = new KristikFragment();
                return kristikFragment;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}