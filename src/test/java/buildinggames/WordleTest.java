package buildinggames;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    class WordleTest {

        @Test
        void score_exact_match_all_green() {
            Wordle wordle = new Wordle("example", 6);
            String result = wordle.scoreGuess("example");
            assertEquals("🟩🟩🟩🟩🟩🟩🟩", result);
        }

        @Test
        void score_wrong_word_all_gray() {
            Wordle wordle = new Wordle("example", 6);
            String result = wordle.scoreGuess("zzzzzzz");
            assertEquals("⬜⬜⬜⬜⬜⬜⬜", result);
        }
    }


