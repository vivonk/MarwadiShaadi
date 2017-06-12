package com.example.sid.marwadishaadi.Chat2;

/**
 * Created by Lawrence Dalmet on 10-06-2017.
 */

public class MsgModel {

    boolean send;
    String msg;

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MsgModel(boolean send, String msg) {

        this.send = send;
        this.msg = msg;
    }
}
