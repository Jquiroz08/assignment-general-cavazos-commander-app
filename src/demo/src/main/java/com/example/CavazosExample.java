package com.example;

import java.util.Random;
import java.util.Scanner;

import org.json.simple.*;

public class CavazosExample {

  public static void main(String[] args) {
    String fileName =
    "C:\\Users\\josep\\OneDrive\\Desktop\\Github\\assignment-general-cavazos-commander-app\\src\\demo\\src\\main\\java\\com\\example\\commands.json";
    
    JSONArray commandJSONArray = JSONFile.readArray(fileName);
    String[] commandArray = getCommandArray(commandJSONArray);
    
    Scanner scan = new Scanner(System.in);
    String input = "";

    while(!(input.equals("q"))){
      printMenu();
      input = scan.nextLine();
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
  // randomly issue commands from General Cavazos
  public static void randomCommand(String[] commandArray, int numCommand) {
    Random rand = new Random();
    System.out.printf("Number\tCommand\n");
    System.out.printf("------\t---------------\n");
    for (int i = 0; i < numCommand; i++) {
      int randIndex = rand.nextInt(commandArray.length);
      System.out.printf("%04d\t%s\n", i, commandArray[randIndex]);
    }
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
