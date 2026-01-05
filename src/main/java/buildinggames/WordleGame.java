package buildinggames;

public class WordleGame {
    public static void main(String[] args) {
        WordProvider provider = new WordProvider("words.txt");

        int wordLength = 7;
        int attempts = 6;

        String secret = provider.getRandomWord(wordLength);


        Wordle wordle = new Wordle(secret, attempts);
        wordle.play();
    }
}
