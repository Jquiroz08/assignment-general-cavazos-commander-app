package com.example;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import org.json.simple.*;

public class CavazosExample {
  public static String fileName =
  "C:\\Users\\josep\\OneDrive\\Desktop\\Github\\assignment-general-cavazos-commander-app\\src\\demo\\src\\main\\java\\com\\example\\commands.json";
  
  public static JSONArray commandJSONArray = JSONFile.readArray(fileName);
  public static String[] commandArray = getCommandArray(commandJSONArray);

  public static Stack<String> redo = new Stack<>(); 
  public static Stack<String> undo = new Stack<>(); 

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input = "";

    while(!(input.equals("q"))){
      printMenu();
      input = scan.nextLine();
      executeCommand(input);
    }
    scan.close();
  }

  public static void printLine(){
    System.out.println("-------------------------------------------------------");
  }

  public static void printMenu(){
    printLine();
    System.out.println("General Cavazos Commander App");
    printLine();
    System.out.println("i:      Issue Command");
    System.out.println("l:      List of commands");
    System.out.println("u:      Undo last command that was issued");
    System.out.println("r:      Redo last command that was issued");
    System.out.println("q:      Quit");
    printLine();
    System.out.println("Enter a command:");
  }

  public static void executeCommand(String input){
     switch(input){
        case "l": 
          print(commandArray);
          break;
        case "i":
          randomCommand(commandArray);
          break;
        case "q":
          break;
        default:
          System.out.println("Please input valid command");
          break;
     }
  }
  // randomly issue commands from General Cavazos
  public static void randomCommand(String[] commandArray){
    Random rand = new Random();
    String command = commandArray[rand.nextInt(commandArray.length)];
    undo.push(command);
    System.out.println("[Command Issued]: General Cavazos issues the troops to " + command );
  }

  // print command array
  public static void print(String[] commandArray) {
    System.out.printf("Number\tCommand\n");
    System.out.printf("------\t---------------\n");
    for (int i = 0; i < commandArray.length; i++) {
      System.out.printf("%04d\t%s\n", i, commandArray[i]);
    }
  }

  // get array of commands
  public static String[] getCommandArray(JSONArray commandArray) {
    String[] arr = new String[commandArray.size()];

    // get names from json object
    for (int i = 0; i < commandArray.size(); i++) {
      String command = commandArray.get(i).toString();
      arr[i] = command;
    }
    return arr;
  }
}
