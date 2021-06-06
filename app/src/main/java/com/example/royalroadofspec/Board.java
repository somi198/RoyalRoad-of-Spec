package com.example.royalroadofspec;

import androidx.annotation.NonNull;

public class Board {

    public String title;
    public String content;
    public String userName;

    public Board(){

    }

    public Board(String title, String content, String userName){
        this.title = title;
        this.content = content;
        this.userName = userName;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Board{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
