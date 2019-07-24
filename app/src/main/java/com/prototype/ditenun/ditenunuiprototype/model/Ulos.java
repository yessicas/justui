package com.prototype.ditenun.ditenunuiprototype.model;

import android.widget.ImageView;


public class Ulos {
    public String nama;

    public int imageId;

    public Ulos(String nama, int imageId) {
        this.nama = nama;
        this.imageId = imageId;

    }

    public String getNama() {
        return nama;
    }


    public void setNama(String nama) {
        this.nama = nama;
    }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
