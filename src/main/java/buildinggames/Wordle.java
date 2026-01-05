package buildinggames;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Wordle {
//    private String secretWord;
//    private int attempts;
//
//    // Emoji tiles
//    private static final String GREEN = "🟩";
//    private static final String YELLOW = "🟨";
//    private static final String GRAY = "⬜";
//
//    public Wordle(String secretWord, int attempts) {
//        this.secretWord = secretWord.toLowerCase().trim();
//        this.attempts = attempts;
//    }
//
//    public void play() {
//        Scanner scanner = new Scanner(System.in);
//        int remainingAttempts = attempts;
//
//
//        System.out.println("Welcome to Wordle!");
//        System.out.println("Guess the " + secretWord.length() + "-letter word.");
//
//        while (remainingAttempts > 0) {
//            System.out.println("\nAttempts remaining: " + remainingAttempts);
//            System.out.print("Enter your guess: ");
//            String guess = scanner.nextLine().toLowerCase().trim();
//
//            if (guess.length() != secretWord.length()) {
//                System.out.println("Invalid guess. Please enter a word with length " + secretWord.length() + ".");
//                continue;
//            }
//
//            // Build feedback tiles
//            String feedback = buildFeedback(guess);
//            System.out.println(feedback);
//
//            if (guess.equals(secretWord)) {
//                System.out.println("🎉 Congratulations! You guessed the secret word: " + secretWord);
//                return;
//            }
//
//            remainingAttempts--;
//        }
//
//        System.out.println("\n😢 Out of attempts. The secret word was: " + secretWord);
//    }
//
//    private String buildFeedback(String guess) {
//        int n = secretWord.length();
//        String[] tiles = new String[n];
//
//        Map<Character, Integer> remaining = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            char s = secretWord.charAt(i);
//            char g = guess.charAt(i);
//
//            if (g == s) {
//                tiles[i] = GREEN;
//            } else {
//                remaining.put(s, remaining.getOrDefault(s, 0) + 1);
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (tiles[i] != null) continue; // already green
//
//            char g = guess.charAt(i);
//            int count = remaining.getOrDefault(g, 0);
//
//            if (count > 0) {
//                tiles[i] = YELLOW;
//                remaining.put(g, count - 1);
//            } else {
//                tiles[i] = GRAY;
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (String t : tiles) sb.append(t);
//        return sb.toString();
//    }
//
//    public String score(String guess) {
//
//    }

    private final String secretWord;
    private final int attempts;

    // Emoji tiles
    private static final String GREEN = "🟩";
    private static final String YELLOW = "🟨";
    private static final String GRAY = "⬜";

    public Wordle(String secretWord, int attempts) {
        this.secretWord = secretWord.toLowerCase().trim();
        this.attempts = attempts;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int remainingAttempts = attempts;

        while (remainingAttempts > 0) {
            System.out.println("Attempts remaining: " + remainingAttempts);
            System.out.print("Enter your guess: ");

            String guess = scanner.nextLine().toLowerCase().trim();

            if (guess.length() != secretWord.length()) {
                System.out.println("Invalid guess. Please enter a word with length " + secretWord.length() + ".");
                continue;
            }

            String feedback = scoreGuess(guess);
            System.out.println(feedback);

            if (isWin(feedback)) {
                System.out.println("Congratulations! You guessed the secret word: " + secretWord);
                return;
            }

            remainingAttempts--;
            System.out.println();
        }

        System.out.println("Sorry, you are out of attempts. The secret word was: " + secretWord);
    }

    /**
     * Returns a string of emoji tiles like: 🟩⬜🟨⬜🟩
     * Handles duplicate letters correctly:
     * - First mark Greens.
     * - Then use remaining letter counts to mark Yellows.
     */
    public String scoreGuess(String guess) {
        int n = secretWord.length();
        char[] secret = secretWord.toCharArray();
        char[] g = guess.toCharArray();

        String[] result = new String[n];

        // Count remaining (non-green) letters in secret
        Map<Character, Integer> remaining = new HashMap<>();

        // 1) Mark greens and count remaining letters
        for (int i = 0; i < n; i++) {
            if (g[i] == secret[i]) {
                result[i] = GREEN;
            } else {
                remaining.put(secret[i], remaining.getOrDefault(secret[i], 0) + 1);
            }
        }

        // 2) Mark yellows or grays using remaining counts
        for (int i = 0; i < n; i++) {
            if (result[i] != null) continue; // already green

            int count = remaining.getOrDefault(g[i], 0);
            if (count > 0) {
                result[i] = YELLOW;
                remaining.put(g[i], count - 1);
            } else {
                result[i] = GRAY;
            }
        }

        // Build final string
        StringBuilder sb = new StringBuilder();
        for (String tile : result) sb.append(tile);
        return sb.toString();
    }

    private boolean isWin(String feedback) {
        return feedback.equals(GREEN.repeat(secretWord.length()));
    }
}


