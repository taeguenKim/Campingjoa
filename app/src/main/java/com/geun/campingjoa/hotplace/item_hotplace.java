package com.geun.campingjoa.hotplace;

import android.graphics.drawable.Drawable;

public class item_hotplace {

    public int profile;
    public String place="";
    public String show="";
    public String money="";
    public String people="";
    public String title="";
    public String url="";

    public item_hotplace(int profile, String place, String show, String money, String people, String title, String url) {
        this.profile = profile;
        this.place = place;
        this.show = show;
        this.money = money;
        this.people = people;
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public item_hotplace() {
    }
}
