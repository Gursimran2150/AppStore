package com.gursimran.appstore;

public class Model {
    String appName,category,imageUrl;
    public  Model(){

    }

    public Model(String appName, String category, String imageUrl) {
        this.appName = appName;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
