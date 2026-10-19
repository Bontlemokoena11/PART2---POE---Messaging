package com.myproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Student
 */
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
        
public class Messaging {
    public String myRecipientCell;
    public int numMessagesSent = 0;
    public String[] myMessageIDs = new String[100];
    public String[] mySentMessages = new String[100];
    
    
    public boolean checkMessageID(String messageID){
        return messageID.length()<=10;
        
    }
    
    public boolean checkRecipientCell(String recipientCell) {
        if(recipientCell.startsWith("+27") && recipientCell.length()==12){
            System.out.println("correct recipientCell");
            return true;
        }
        else {
            System.out.println("incorrect recipientCell");
            return false;
            
        }
        
    }
    
    public String createMessageHash(String messageID, int messageNum, String message) {
        String messageHash = messageID.charAt(0) + messageID.charAt(1) + ":" + Integer.toString(messageNum) + ":";
        
        String[] words = message.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length-1];
        
        messageHash = messageHash + firstWord + lastWord;   
       
        return messageHash;
        
    }
    
    public String sentMessage(String userAction, String message){
        if (userAction.equals("sent")){
            mySentMessages[numMessagesSent] = message;
            return "Message successfully sent";
        }
        else if(userAction.equals("disregard")){
            return "Press 0 to delete message";
        }
        else if(userAction.equals("store")){
            storeMessage(message);
            return "Message successfully stored";
        }
        else{
            return "Invalid request";
        }
      
    }
    
    public void printMessages(){
        for (int i=0; i < mySentMessages.length; ++i){
            String messageID = myMessageIDs[i];
            int messageNum = i;
            String message = mySentMessages[i];
            String messageHash = createMessageHash(messageID, messageNum, message);
            System.out.println(messageID + " " + messageHash + " " + myRecipientCell + " " + message);
        }
    }
    
    public int returnTotalMessages() {
        return numMessagesSent;
    }
    
    public void storeMessage(String message) {
        try (FileWriter file = new FileWriter("messages.json")) {
            file.write(message);
            System.out.println("Message successfully stored to messages.json");
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
    
    public boolean checkMessagelength(String message) {
        if(message.length()<=250) {
            System.out.println("Message is valid");
            return true;
        }
        else{
            System.out.println("Please enter a message of less than 250 characters");
            return false;
        }
        
    }
    
    
    
    

     
        
        
    
    
    
    
            
    
        
    
    
    

    

    
}
    
   
        