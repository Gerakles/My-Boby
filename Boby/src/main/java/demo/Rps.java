package demo;

import java.util.Random;
import java.util.Scanner;

public class Rps {
    /*
        Valid user input: 
        rock, paper, scissors, scissor
        r, p, s
    */

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner( System.in );
            if (sc.hasNext()) { //Checks for null values
                String userInput = quickFormat( sc.next() );
                sc.close();
                if (isValid( userInput )) {
                    game( userInput );
                } else {
                    displayInputs();
                }
            } else {
                displayInputs(); //Null value, displaying correct inputs
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void game(String user) {
        String computer = computerResults();
        print( user + " vs " + computer + "\n" );
        if (user.equalsIgnoreCase( computer )) {
            print( "Stalemate! No winners." );
        } else {
            if (checkWin( user, computer )) print( "You won against the computer!" );
            else {
                print( "You lost against the computer!" );
            }
        }
    }

    private static String computerResults() {
        String types[] = {"rock", "paper", "scissors"};
        Random rand = new Random();
        int computerChoice = rand.nextInt( 3 );
        return types[computerChoice];
    }

    private static boolean isValid(String input) {
        switch (input.toLowerCase()) {
            case "rock":
                return true;
            case "paper":
                return true;
            case "scissors":
                return true;
            default:
                return false;
        }
    }

    private static boolean checkWin(String user, String opponent) {
        if ((!isValid( user )) || (!isValid( opponent ))) {
            return false;
        }
        String rock = "rock", paper = "paper", scissors = "scissors";
        if ((user.equalsIgnoreCase( rock )) && (opponent.equalsIgnoreCase( scissors ))) {
            return true;
        }
        if ((user.equalsIgnoreCase( scissors )) && (opponent.equalsIgnoreCase( paper ))) {
            return true;
        }
        return (user.equalsIgnoreCase( paper )) && (opponent.equalsIgnoreCase( rock ));
        //If no possible win, assume loss
    }

    private static void displayInputs() {
        //One place to edit it all
        print( "Invalid user input!\nWrite rock, paper or scissors!" );
    }

    private static void print(String text) {
        //Makes printing text easier
        System.out.println( text );
    }

    private static String quickFormat(String input) {
        //Just some quick function to shorten inputs
        String output = input;
        switch (input.toLowerCase()) {
            case "r":
                output = "rock";
                break;
            case "p":
                output = "paper";
                break;
            case "s":
                output = "scissors";
                break;
        }
        return output;
    }
}