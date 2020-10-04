package com.lifeistech.litboard2;

public class post {

    String messenge;
    String userName;
    int number;

    public post () {

    }

    public post(String userName, String messenge, int number){

        this.userName = userName;
        this.messenge = messenge;
        this.number = number;
    }


    public String getMessenge(){return messenge;}

    public void setMessenge(String messenge) {this.messenge = messenge;}

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public int getNumber() {return number;}

    public void setNumber(int number) {this.number = number;}


    

}



