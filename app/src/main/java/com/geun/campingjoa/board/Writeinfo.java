package com.geun.campingjoa.board;

public class Writeinfo {
    String nickname;
    String IDcode;
    String title;
    String contents;
    String photo;
    String time;

    public Writeinfo() {
    }

    public Writeinfo(String nickname, String IDcode, String title, String contents, String photo,String time) {
        this.nickname = nickname;
        this.IDcode = IDcode;
        this.title = title;
        this.contents = contents;
        this.photo = photo;
        this.time = time;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIDcode() {
        return IDcode;
    }

    public void setIDcode(String IDcode) {
        this.IDcode = IDcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}



