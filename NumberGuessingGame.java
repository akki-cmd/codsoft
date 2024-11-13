import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void playRound(int round_Number) {
        //generate random no.
        Random random = new Random();
        int target_num = random.nextInt(100) + 1;

        int Guess = -1;
        int attempts = 0;
        int Total_Attempts = 7;

        Scanner sc = new Scanner(System.in);

        System.out.println("Round " + round_Number + ": Guess the number between 1 and 100.");
        
        while (Guess != target_num && attempts < Total_Attempts) {
            System.out.print("Enter guess (" + (attempts + 1) + "/" + Total_Attempts + "): ");
            Guess = sc.nextInt();
            attempts++;

           
            if (Guess < target_num) {
                System.out.println("too low! Try again.");
            } else if (Guess > target_num) {
                System.out.println("too high Try again.");
            } else {
                System.out.println("Congratulations! You guessed  correct number in " + attempts + " attempts.");
                break;
            }

            if (attempts == Total_Attempts) {
                System.out.println("Sorry, used all " + Total_Attempts + " attempts. The correct number was: " + target_num);
            }
        }
    }
    public static void playGame() {
        Scanner sc = new Scanner(System.in);
        int total_Rounds = 0;
        int rounds_Won = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            total_Rounds++;
            playRound(total_Rounds);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = sc.next().toLowerCase();
            if (response.equals("no")) {
                break;
            } else if (response.equals("yes")) {
                rounds_Won++; 
            }
        }

        System.out.println("\nGame Over! You played " + total_Rounds + " rounds and won " + rounds_Won + " rounds.");
    }

    public static void main(String[] args) {
        playGame(); 
    }
}
