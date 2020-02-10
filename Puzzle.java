import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle
{
   private String word;
   private ArrayList<String> guesses = new ArrayList<String>(26);
   public final int MAX_WORDS = 45402;
   public Puzzle () {
       try {
           File file = new File("words.txt");
           Scanner scanner = new Scanner(file);
           int i = 0;
           int n = (int)(Math.random()*MAX_WORDS);
           String line = "";
           while (i < n) {
               line = scanner.next();
               i++;
           }
           scanner.close();
           word = line.toUpperCase();
        }
        catch (FileNotFoundException e ) {
            e.printStackTrace();
        }
   }
   public Puzzle (String word) {
       this.word = word;
   }
   public String getWord () {
       return this.word;
   }
   public ArrayList<String> getGuesses () {
       return this.guesses;
   }
   public boolean isUnsolved () {
       int thrsh = word.length(), atm = 0;
       for (int i = 0; i < word.length(); i++) {
           if (this.getGuesses().contains(word.substring(i, i+1))) {
               atm++;
           }
       }
       if (atm == thrsh) return false;
       else return true;
   }
   public boolean makeGuess (String letter) {
       guesses.add(letter.toUpperCase());
       if (this.getWord().contains(letter)) {
           return true;
       } else return false;
   }
   public void show () {
       int length = word.length();
       String revealedLetters = new String();
       for (int i = 0; i < length; i++) {
           if (guesses.contains(this.getWord().substring(i, i+1))) {
               revealedLetters = revealedLetters + this.getWord().charAt(i);
           } else revealedLetters = revealedLetters + "_";
       }
       System.out.println("Puzzle: " + revealedLetters);
       System.out.println("Guesses: " + this.getGuesses());
    }
}
