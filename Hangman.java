import java.util.*;
import java.io.*;

public class Hangman {

    private static final int MAX_WRONG_GUESSES = 6;

    public static void main(String[] args) {

        String filePath = "Words.txt";
        ArrayList<String> words = new ArrayList<>();
        Random random = new Random();

        // ---------- Load words ONCE ----------
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate the file: " + filePath);
        } catch (IOException e) {
            System.out.println("Something went wrong while reading the file!");
        }

        if (words.isEmpty()) {
            System.out.println("No valid words available. Exiting game.");
            return;
        }

        System.out.println("====================");
        System.out.println(" Java Hangman Game");
        System.out.println("====================\n");

        // One Scanner shared by every round, closed when the program ends
        try (Scanner sc = new Scanner(System.in)) {

            boolean playAgain;

            // ---------- Play-again loop ----------
            do {
                String word = words.get(random.nextInt(words.size()));
                playRound(word, sc);
                playAgain = askPlayAgain(sc);
            } while (playAgain);

            System.out.println("Thanks for playing!");
        }
    }

    // Plays a single game with the given word
    static void playRound(String word, Scanner sc) {

        ArrayList<Character> wordState = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        ArrayList<Character> guessedLetters = new ArrayList<>();
        int wrongGuesses = 0;
        boolean won = false;

        while (wrongGuesses < MAX_WRONG_GUESSES && !won) {

            System.out.print(drawHangman(wrongGuesses));

            System.out.print("Word : ");
            for (char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.println("Guessed: " + guessedLetters);
            System.out.println("Lives left: " + (MAX_WRONG_GUESSES - wrongGuesses));
            System.out.print("Guess a letter : ");

            // Handle end of input (e.g. Ctrl+D) without crashing
            if (!sc.hasNextLine()) {
                System.out.println("\nInput closed. Exiting round.");
                return;
            }

            String input = sc.nextLine().trim().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a single letter (a-z).\n");
                continue;
            }

            char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed '" + guess + "'. Try another.\n");
                continue;
            }
            guessedLetters.add(guess);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct Guess!\n");

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }

                if (!wordState.contains('_')) {
                    won = true;
                }
            } else {
                wrongGuesses++;
                System.out.println("Wrong Guess!\n");
            }
        }

        // ---------- End-of-round output ----------
        System.out.print(drawHangman(wrongGuesses));

        if (won) {
            StringBuilder sb = new StringBuilder();
            for (char c : wordState) {
                sb.append(c).append(' ');
            }
            System.out.println("Word : " + sb);
            System.out.println("You Win!");
        } else {
            System.out.println("GAME OVER!");
        }
        System.out.println("The word was: " + word + "\n");
    }

    // Keeps asking until the user answers y or n
    static boolean askPlayAgain(Scanner sc) {
        while (true) {
            System.out.print("Play again? (y/n) : ");

            if (!sc.hasNextLine()) {
                return false; // no more input, so stop
            }

            String answer = sc.nextLine().trim().toLowerCase();

            if (answer.equals("y") || answer.equals("yes")) {
                System.out.println();
                return true;
            }
            if (answer.equals("n") || answer.equals("no")) {
                return false;
            }
            System.out.println("Please type y or n.");
        }
    }

    static String drawHangman(int wrongGuesses) {

        return switch (wrongGuesses) {
            case 0 -> """
                      +---+
                      |   |
                          |
                          |
                          |
                    =========
                    """;
            case 1 -> """
                      +---+
                      |   |
                      o   |
                          |
                          |
                    =========
                    """;
            case 2 -> """
                      +---+
                      |   |
                      o   |
                      |   |
                          |
                    =========
                    """;
            case 3 -> """
                      +---+
                      |   |
                      o   |
                     /|   |
                          |
                    =========
                    """;
            case 4 -> """
                      +---+
                      |   |
                      o   |
                     /|\\  |
                          |
                    =========
                    """;
            case 5 -> """
                      +---+
                      |   |
                      o   |
                     /|\\  |
                     /    |
                    =========
                    """;
            case 6 -> """
                      +---+
                      |   |
                      o   |
                     /|\\  |
                     / \\  |
                    =========
                    """;
            default -> "";
        };
    }
}