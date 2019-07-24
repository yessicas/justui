package com.prototype.ditenun.ditenunuiprototype.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;
import com.prototype.ditenun.ditenunuiprototype.R;


//Our class extending fragment
public class GenerateFragment extends Fragment {

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_generate, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageGenerate);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());

                View mView = getLayoutInflater().inflate(R.layout.dialog_layout_generate, null);

                PhotoView photoView = mView.findViewById(R.id.dialog_generate);
                photoView.setImageResource(R.drawable.generatebintangmaratur);
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return rootView;
    }
}