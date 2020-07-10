package com.geun.campingjoa;

public class item_hotplace {

    public String profile;
    public String place;
    public String show;
    public String money;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public item_hotplace(String profile, String place, String show, String money) {
        this.profile = profile;
        this.place = place;
        this.show = show;
        this.money = money;
    }



}
