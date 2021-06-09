package com.example.royalroadofspec;

import java.util.Date;

public class Comment {

    private String nameStr;
    private String commentStr;

    public void setName(String name){
        nameStr = name;
    }
    public void setComment(String comment) {commentStr = comment;}

    public String getName(){
        return this.nameStr;
    }
    public String getComment() {return this.commentStr;}
}
