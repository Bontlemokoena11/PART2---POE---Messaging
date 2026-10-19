
package com.myproject;
import java.util.Scanner;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class Main {
    
    public static void main (String []args){
        
       System.out.println("register your details");
       Scanner input = new Scanner(System.in);
       System.out.println("Enter username");
       String username = input.nextLine();
       System.out.println("Enter Cellphone Number");
       String cellphone = input.nextLine();
       System.out.println("Enter Password");
       String password = input.nextLine();
       
       LogIn login = new LogIn();
       
       String status = login.registerUser(username, password);
       System.out.println(status);
       
       login.returnLoginStatus(username, password);
        
        
        
        
        Messaging message = new Messaging();
        
        Scanner scanner= new Scanner(System.in);
        
        int choice ;
        System.out.println("Welcome to QuickChat");
        
        boolean isValid;
        do{
            System.out.println("Type in recipient celll");
            String recipientCell = scanner.nextLine();
            isValid = message.checkRecipientCell(recipientCell);
        } while(isValid==false);
        
        System.out.println("How many messages would you like to enter");
        int maxMessages = scanner.nextInt();
        
        do {

            System.out.println("Option 1 :Send Messages ");
            System.out.println("Option 2 :Coming Soon ");
            System.out.println("Option 3 :Quit ");
            System.out.println("enter");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice==1){
                System.out.println("Write your message");
                String text = scanner.nextLine();
                
                if (message.checkMessagelength(text)) {
                    System.out.println("What would you like to do, send, store or disregard");
                    String userAction = scanner.nextLine();
                    message.sentMessage(userAction, text);
                }
                
            }

            else if (choice==2){
                System.out.println("Coming Soon");
            }
            else if (choice==3){
                System.out.println("Goodbye");
            }
            else {
                System.out.println("error, incorrect value");
            }
        } while(choice!=3 || message.numMessagesSent==maxMessages);
        
    }
}
