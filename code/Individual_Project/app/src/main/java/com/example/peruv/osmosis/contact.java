package com.example.peruv.osmosis;

/**
 * Created by peruv on 11/22/2017.
 */

public class contact{
    private String username, password;

    public contact(String username, String password){
        this.username = username;
        this.password = password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
//    public int getid(int id){
//        return id+1;
//    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
}
