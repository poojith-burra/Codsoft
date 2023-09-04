import java.util.Scanner;

public class GuessRandomNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Hey Guest! welcome to the Number Guessing Game!");
            System.out.println("Guess a number between 1 and 100.");
            System.out.println();

        while (playAgain) {
            int correctNum= generateRandomNumber();
            int maxAttempts= specifyMaxAttempts(sc);
            int score = 0;
            while (score < maxAttempts) {


                int guess = getGuess(sc);
                score++;       

                if (guess == correctNum) {
                    System.out.println("Congratulations! You guessed the number Correctly.");
                    break;
                } else if (guess < correctNum) {
                    System.out.println("Your guess is too low! Try again.");
                } else {
                    System.out.println("Your gues is too high! Try again.");
                }
            }

            if (score == maxAttempts) {
                System.out.println("Sorry! You ran out of Attempts. The Correct number was " + correctNum + ".");
            }

            System.out.println("Your score is: " + score);
            System.out.println("Do you want to play again? (yes/no)");
            String playAgainInput = sc.next();

            if (!playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for Playing the Number Guessing Game!");
        sc.close();
    }

    private static int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    private static int specifyMaxAttempts(Scanner scan) {
        System.out.println("Enter the number of Attempts:");
        return scan.nextInt();
    }

    private static int getGuess(Scanner scanner) {
        System.out.print("Enter the guessed Number: ");
        return scanner.nextInt();
    }
}