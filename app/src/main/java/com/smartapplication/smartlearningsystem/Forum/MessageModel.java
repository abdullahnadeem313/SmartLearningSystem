package com.smartapplication.smartlearningsystem.Forum;

public class MessageModel {

    private String userName;
    private String msgText;

    public MessageModel() {
    }

    public MessageModel(String userName, String msgText) {
        this.userName = userName;
        this.msgText = msgText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }
}
