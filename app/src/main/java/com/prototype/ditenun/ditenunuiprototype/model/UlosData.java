package com.prototype.ditenun.ditenunuiprototype.model;


public class UlosData {
    private String ulosName;
    private String ulosDescription;
    private int ulosImage;

    public UlosData(String ulosName, String ulosDescription, int ulosImage) {
        this.ulosName = ulosName;
        this.ulosDescription = ulosDescription;
        this.ulosImage = ulosImage;
    }

    public String getFlowerName() {
        return ulosName;
    }

    public String getFlowerDescription() {
        return ulosDescription;
    }

    public int getFlowerImage() {
        return ulosImage;
    }
}
