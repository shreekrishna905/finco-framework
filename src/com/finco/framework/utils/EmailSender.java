package com.finco.framework.utils;

public class EmailSender {

    private static EmailSender instance = null;

    private EmailSender(){}

    public static EmailSender getInstance(){
        if(instance==null){
            instance = new EmailSender();
        }
        return instance;
    }

    public void sendEmail(String email){
        System.out.println("Sending email to:"+email);
    }

}
