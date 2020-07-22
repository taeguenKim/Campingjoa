package com.geun.campingjoa.login;

public class Usersinfo {
    private String name;
    private String birthday;
    private String usersid;

    public Usersinfo() {
    }

    public Usersinfo(String name, String birthday, String usersid) {
        this.name = name;
        this.birthday = birthday;
        this.usersid = usersid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUsersid() {
        return usersid;
    }

    public void setUsersid(String usersid) {
        this.usersid = usersid;
    }
}
