package com.example.royalroadofspec;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListBoardItem {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    private String titleStr;
    private String nameStr;
    private String likeStr;
    private String chatStr;
    private String timeStr;

    public void setTitle(String title){
        titleStr = title;
    }
    public void setName(String name){
        nameStr = name;
    }
    public void setLike(String like) {likeStr = like;}
    public void setChat(String chat) {chatStr = chat;}
    public void setTime(Date date) {timeStr = sdf.format(date);}

    public String getTitle(){
        return this.titleStr;
    }
    public String getName(){
        return this.nameStr;
    }
    public String getLike() { return this.likeStr;}
    public String getChat() {return this.chatStr;}
    public String getTime() {return this.timeStr + "   |";}
}