import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    public static void main(String[] args) {
        // List of words to choose from
        String[] words = {"java", "programming", "hangman", "computer", "science"};

        // Select a random word from the list
        Random random = new Random();
        String word = words[random.nextInt(words.length)];

        // Initialize variables
        int maxAttempts = 6;
        int attempts = 0;
        boolean wordGuessed = false;
        List<Character> guessedLetters = new ArrayList<>();
        List<Character> incorrectLetters = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (attempts < maxAttempts && !wordGuessed) {
            // Display current state of the word
            displayWordState(word, guessedLetters);

            // Prompt the user for a letter
            System.out.print("Guess a letter: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            // Check if the letter is in the word
            if (word.indexOf(guess) >= 0) {
                guessedLetters.add(guess);
                System.out.println("Good guess!");
            } else {
                incorrectLetters.add(guess);
                attempts++;
                System.out.println("Wrong guess!");
            }

            // Display the hangman figure
            displayHangman(attempts);

            // Check if the word is fully guessed
            wordGuessed = isWordGuessed(word, guessedLetters);

            System.out.println();
        }

        // Display the result of the game
        if (wordGuessed) {
            System.out.println("Congratulations! You've guessed the word: " + word);
        } else {
            System.out.println("Sorry, you've run out of attempts. The word was: " + word);
        }

        scanner.close();
    }

    private static void displayWordState(String word, List<Character> guessedLetters) {
        for (char letter : word.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                System.out.print(letter + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    private static void displayHangman(int attempts) {
        switch (attempts) {
            case 1:
                System.out.println("  O");
                break;
            case 2:
                System.out.println("  O");
                System.out.println("  |");
                break;
            case 3:
                System.out.println("  O");
                System.out.println(" \\|");
                break;
            case 4:
                System.out.println("  O");
                System.out.println(" \\|/");
                break;
            case 5:
                System.out.println("  O");
                System.out.println(" \\|/");
                System.out.println("  |");
                break;
            case 6:
                System.out.println("  O");
                System.out.println(" \\|/");
                System.out.println("  |");
                System.out.println(" / \\");
                break;
            default:
                System.out.println();
        }
    }

    private static boolean isWordGuessed(String word, List<Character> guessedLetters) {
        for (char letter : word.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }
}
