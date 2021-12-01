/*
 * This program reads a random integer(from 1-6) and checks to see if the user
 * has guessed it. 
 *
 *
 * By Zefeng Wang
 * Created on November 30, 2021
 * */

// import Scanner class
import java.util.Scanner;

// class DiceGame.
class DiceGame {
  // Continuously runs the guessing game until the user guesses the correct number.
  public static void main(String[] args) {
    Scanner scannerObj = new Scanner(System.in);
    boolean playAgain = false;
    String answer = "";
    int correctNumber = (int) (Math.random() * 6 + 1);
    int attempts = 0;
    int guess = 0;
    while (guess != correctNumber || playAgain) {
      System.out.print("Guess a number between 1 and 6: ");
      attempts++;
      playAgain = false;
      try {
        guess = Integer.parseInt(scannerObj.next());
      } catch (Exception e) {
        System.out.println("Please enter an integer.");
        continue;
      }
      if (guess <= 6 && guess >=  1) {
        if (guess > correctNumber) {
          System.out.println("You guessed too high! Try Again!");
        } else if (guess < correctNumber) {
          System.out.println("You guessed too low! Try Again!");
        } else {
          System.out.printf("You are correct! You guessed %s times.\n", attempts);
          System.out.print("Do you want to play again (y/n)?");
          answer = scannerObj.next();
          if (answer.equals("y")) {
            playAgain = true;
            correctNumber = (int) (Math.random() * 6 + 1);
            attempts = 0;
            guess = 0;
          }
        }
      } else {
        System.out.println("This number isn't between 1 and 6.");
      }
    }
    System.out.println("Thanks for playing!"); 
  } 
}

