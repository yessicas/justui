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
public class FotoFragment extends Fragment {

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_foto, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageFoto);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());

                View mView = getLayoutInflater().inflate(R.layout.dialog_layout_foto, null);

                mBuilder.setView(mView);
                PhotoView photoView = mView.findViewById(R.id.dialog_foto);
                photoView.setImageResource(R.drawable.gambar2);
                AlertDialog mDialog = mBuilder.create();
                mDialog.setCanceledOnTouchOutside(true);
                mDialog.show();
            }
        });
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return rootView;
    }
}