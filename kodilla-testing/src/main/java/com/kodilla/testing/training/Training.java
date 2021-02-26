package com.kodilla.testing.training;

public class Training implements Interface {

    private int id;
    private boolean online;

    public Training() {
        this.id = id;
        this.online = online;
    }



    public boolean isOnline(){
        if(online=true){
            return true;
        }
        else{
            return false;
        }
    }
    public int idNumber(){
        return id;
    }
}

