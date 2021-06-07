package com.example.royalroadofspec;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListBoardItem {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    private String title;
    private String userName;
    private String content;
    private String category;
    private String date;
    private Integer likes;
    private Integer comments;

    public ListBoardItem(){

    }

    public ListBoardItem(String title, String content, String userName, String category, String date, Integer likes, Integer comments){
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.category = category;
        this.date = date;
        this.likes = likes;
        this.comments = comments;
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

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public Integer getLikes(){
        return likes;
    }

    public void setLikes(Integer likes){
        this.likes = likes;
    }

    public Integer getComments(){
        return comments;
    }

    public void setComments(Integer comments){
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Board{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", likes='" + likes + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}