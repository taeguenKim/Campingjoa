package com.geun.campingjoa.board;

public class Writeinfo {
    private String title;
    private String contents;
    private String publisher;

    public Writeinfo() {
    }

    public Writeinfo(String title, String contents, String publisher) {
        this.title = title;
        this.contents = contents;
        this.publisher = publisher;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
