import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    public static void main(String[] args) {
        String[][] wordCategories = {
                {"apple", "banana", "orange", "grape", "pear"},
                {"dog", "cat", "bird", "lion", "tiger"},
                {"india", "egypt", "france", "portugal", "canada"},
                {"football", "cricket", "badminton", "basketball", "boxing"}
        };
        String[] categories = {"Fruit", "Animal", "Country", "Sports"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a category:");
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }
        int categoryChoice = scanner.nextInt();

        String[] words = wordCategories[categoryChoice - 1];
        Random rand = new Random();
        int randomIndex = rand.nextInt(words.length);
        String wordToGuess = words[randomIndex];
        int maxAttempts = 6;
        int attempts = 0;
        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord[i] = '_';
        }

        while (attempts < maxAttempts) {
            System.out.println("Guess the word: " + String.valueOf(guessedWord));
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            boolean correctGuess = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attempts++;
                System.out.println("Incorrect guess. Attempts remaining: " + (maxAttempts - attempts));
            }

            if (String.valueOf(guessedWord).equals(wordToGuess)) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                break;
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("You ran out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }
}
