# Java Wordle (Console Game)

A console-based Wordle-style game written in Java.  
Players try to guess a secret word within a limited number of attempts, receiving color-coded feedback after each guess.

## 🎮 Features
- 🟩 **Green**: correct letter in the correct position
- 🟨 **Yellow**: correct letter in the wrong position
- ⬜ **Gray**: letter not in the word
- Handles duplicate letters correctly
- Configurable number of attempts
- Clean, object-oriented design

## 📁 Project Structure

- `Wordle.java` → core game logic
- `WordleGame.java` → application entry point (`main` method)

## ▶️ How to Run

### Option 1: Run from IntelliJ (recommended)
1. Open the project in IntelliJ
2. Navigate to:
3. Click **Run ▶**

### Option 2: Run with Maven
Make sure Maven is installed, then run:

```bash
mvn compile
