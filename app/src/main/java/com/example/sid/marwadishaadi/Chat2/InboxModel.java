package com.example.sid.marwadishaadi.Chat2;

/**
 * Created by Lawrence Dalmet on 10-06-2017.
 */

public class InboxModel {
    String imgAdd,name, lastmsg,time;
    String count;
    boolean seen;

    public InboxModel(String imgAdd, String name, String lastmsg, String time, String count, boolean seen) {
        this.imgAdd = imgAdd;
        this.name = name;
        this.lastmsg = lastmsg;
        this.time = time;
        this.count = count;
        this.seen = seen;
    }

    public String getImgAdd() {
        return imgAdd;
    }

    public void setImgAdd(String imgAdd) {
        this.imgAdd = imgAdd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastmsg() {
        return lastmsg;
    }

    public void setLastmsg(String lastmsg) {
        this.lastmsg = lastmsg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
}
