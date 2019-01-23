import java.util.Arrays;
import java.util.Scanner;

public class hangagubbenorg

{
    public static void main(String[] args) {
        String[] words = {"potatis", "heja", "gulleplutt"};

        int randomWordNumber = (int) (Math.random() * words.length);

        char[] enteredLetters = new char[words[randomWordNumber].length()];
        int triesCount = 0;


        boolean wordIsGuessed = false;
        do {

            switch (enterLetter(words[randomWordNumber], enteredLetters)) {
                case 0:
                    triesCount++;

                    break;
                case 1:
                    triesCount++;
                    break;
                case 2:
                    break;
                case 3:
                    wordIsGuessed = true;
                    break;
            }
        } while (! wordIsGuessed);
        System.out.println("\nThe word is " + words[randomWordNumber] +
                ". You guesses wrong " + (triesCount -findEmptyPosition(enteredLetters)) +
                " time(s)");
    }

    // Hint user to enter a guess letter
    //returns 0 = letter entered is not in the word (counts as try)
    //returns 1 = letter were entered 1st time (counts as try)
    //returns 2 = already guessed letter was REentered
    //returns 3 = all letters were guessed
    public static int enterLetter(String word, char[] enteredLetters)    {

        System.out.print("(Your guess) Enter a letter ");

        if (! printWord(word, enteredLetters))
            return 3;
        System.out.print(" : ");
        Scanner input = new Scanner(System.in);
        int emptyPosition = findEmptyPosition(enteredLetters);
        char userInput = input.nextLine().charAt(0);
        if (inEnteredLetters(userInput, enteredLetters)) {
            System.out.println(userInput + " has already been guessed");
            return 2;
        }
        else if (word.contains(String.valueOf(userInput))) {
            enteredLetters[emptyPosition] = userInput;
            return 1;
        }
        else {

            System.out.println(userInput + " is not in the word");
            System.out.println("Keep guessing!");


            return 0;
        }
    }


    public static boolean printWord(String word, char[] enteredLetters) {

        boolean asteriskPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (inEnteredLetters(letter, enteredLetters))
                System.out.print(letter);
            else {
                System.out.print('-');
                asteriskPrinted = true;
            }
        }
        return asteriskPrinted;
    }


    public static boolean inEnteredLetters(char letter, char[] enteredLetters) {
        return new String(enteredLetters).contains(String.valueOf(letter));
    }


    public static int findEmptyPosition(char[] enteredLetters) {
        int i = 0;
        while (enteredLetters[i] != '\u0000') i++;
        return i;
    }
}
