package buildinggames;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class WordProvider {
    private final List<String> words;
    private final Random random = new Random();

    public WordProvider(String resourcePath) {
        this.words = loadWordsFromResources(resourcePath);
        if (words.isEmpty()) {
            throw new IllegalStateException("No words found in " + resourcePath);
        }
    }

    public String getRandomWord(int length) {
        List<String> filtered = new ArrayList<>();
        for (String w : words) {
            if (w.length() == length) filtered.add(w);
        }
        if (filtered.isEmpty()) {
            throw new IllegalArgumentException("No words of length " + length + " found.");
        }
        return filtered.get(random.nextInt(filtered.size()));
    }

    private List<String> loadWordsFromResources(String resourcePath) {
        List<String> list = new ArrayList<>();

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (in == null) {
                throw new IllegalStateException("Resource not found: " + resourcePath);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String word = line.trim().toLowerCase();
                    if (!word.isEmpty() && word.matches("[a-z]+")) {
                        list.add(word);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load words from: " + resourcePath, e);
        }

        return list;
    }
}

