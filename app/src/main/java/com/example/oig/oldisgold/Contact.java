package com.example.oig.oldisgold;

/**
 * Created by zulfi on 15/06/16.
 */
public class Contact {
    String name;
    String phone;

    public Contact(){

    }

    public Contact(String name, String phone){
        this.name = name;
        this.phone = phone;

    }

    public String getPhone(){ return this.phone; }

    public String getName(){ return this.name; }

}
