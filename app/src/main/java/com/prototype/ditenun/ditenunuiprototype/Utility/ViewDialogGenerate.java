package com.prototype.ditenun.ditenunuiprototype.Utility;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.prototype.ditenun.ditenunuiprototype.R;

public class ViewDialogGenerate {

    Activity activity;
    Dialog dialog;
    String selected = "";
    //..we need the context else we can not create the dialog so get context in constructor

    public ViewDialogGenerate(Activity activity) {
        this.activity = activity;
    }

    public void showDialog() {

        dialog  = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //...set cancelable false so that it's never get hidden
        dialog.setCancelable(false);
        //...that's the layout i told you will inflate later
        dialog.setContentView(R.layout.dialog_layout_loading_generate);

        //...initialize the imageView form infalted layout
        ImageView gifImageView = dialog.findViewById(R.id.custom_loading_imageView);

        /*
        it was never easy to load gif into an ImageView before Glide or Others library
        and for doing this we need DrawableImageViewTarget to that ImageView
        */
        DrawableImageViewTarget imageViewTarget = new DrawableImageViewTarget(gifImageView);

        //...now load that gif which we put inside the drawble folder here with the help of Glide

        Glide.with(activity)
                .load(R.drawable.custom_loading_image)
                .transition(new DrawableTransitionOptions().crossFade())
                .apply(new RequestOptions().placeholder(R.drawable.custom_loading_image).transform(new CenterCrop()))
                .into(imageViewTarget);

        //...finaly show it
        dialog.show();
    }

    public String getSelected(){
        return selected;
    }

    public void setSelected(String selected){
        this.selected = selected;
    }

    //..also create a method which will hide the dialog when some work is done
    public void hideDialog(){
        dialog.dismiss();
    }

}

