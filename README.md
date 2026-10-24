# 🎮 Java Hangman Game

A command-line **Hangman game** written in Java. The program picks a random word from a text file, and you guess it one letter at a time before the hangman drawing is completed.

Built as a Java practice project covering file handling, collections, loops, input validation, and exception handling.

## 📸 Preview

<!-- Add a screenshot or GIF of your game here, for example: -->
<!-- ![Hangman gameplay](screenshot.png) -->

```text
====================
 Java Hangman Game
====================

  +---+
  |   |
  o   |
 /|   |
      |
=========
Word : a _ _ l e
Guessed: [a, l, e, z, x]
Lives left: 4
Guess a letter : p

Correct Guess!

  +---+
  |   |
  o   |
 /|   |
      |
=========
Word : a p p l e
You Win!
The word was: apple

Play again? (y/n) : n
Thanks for playing!
```

*The word and drawing change every round.*

## ✨ Features

- Random word selection from `Words.txt`
- ASCII hangman drawing that updates after each wrong guess
- Tracks guessed letters and remaining lives (6 wrong guesses allowed)
- Input validation: rejects numbers, symbols, multiple letters, and repeated guesses
- Win/loss detection with the answer revealed at the end
- Play-again option after every round
- Handles a missing or empty word file without crashing

## 📋 How to Play

1. The game picks a hidden word and shows it as underscores.
2. Type **one letter** and press Enter.
3. A correct guess reveals every matching position.
4. A wrong guess adds a part to the hangman.
5. Reveal the whole word before 6 wrong guesses to win.
6. After each round, enter `y` to play again or `n` to quit.

## 🚀 Getting Started

### Prerequisites

- **JDK 17 or later** (the code uses switch expressions and text blocks)
- A terminal, or an IDE such as IntelliJ IDEA, Eclipse, or VS Code

### Installation

```bash
git clone https://github.com/your-username/Hangman.git
cd Hangman
```

### Project Structure

```text
Hangman/
├── Hangman.java
├── Words.txt
└── README.md
```

### Compile and Run

From inside the project folder:

```bash
javac Hangman.java
java Hangman
```

### Running from an IDE

The program looks for `Words.txt` in the **working directory**, which in most IDEs is the project root, not the folder containing `Hangman.java`.

- If you get `Could not locate the file!`, move `Words.txt` to your project root, or
- change the path in the code (for example to `"src/Words.txt"`), or
- print the folder Java is using to see where it is looking:

```java
System.out.println(System.getProperty("user.dir"));
```

## 📄 Words.txt Format

Put **one word per line**, using letters only (no spaces, hyphens, or punctuation):

```text
apple
garden
journey
adventure
beautiful
```

Words are converted to lowercase when loaded, and blank lines should be avoided or skipped.

## 📚 Concepts Practiced

- Classes, methods, and constants (`static final`)
- Strings and character handling
- `ArrayList` for words, the word state, and guessed letters
- `while` and `do-while` loops
- `if-else` conditions and switch expressions
- Random selection with `Random`
- File reading with `BufferedReader` and `FileReader`
- Exception handling with `try-catch`
- User input with `Scanner` and input validation
- Java text blocks for ASCII art
- Resource management with try-with-resources

## ⚠️ Limitations

- Words with spaces or punctuation (like `ice cream`) are not supported. Write them as one word, such as `icecream`.
- Scores are not tracked across rounds.
- There are no hints or difficulty levels.
- `Words.txt` must be reachable from the working directory.

## 🔮 Future Improvements

- Easy, medium, and hard difficulty levels
- Word categories (animals, food, objects)
- Hint system
- Win/loss counter and winning streaks
- Avoid repeating the same word in consecutive rounds
- Graphical user interface (GUI)

## 👨‍💻 Author

**Arun Saini**

Part of my Java practice and GitHub portfolio.

## 📜 License

This project is open source and available under the [MIT License](LICENSE).

---

⭐ If you found this project useful, consider giving it a star!
