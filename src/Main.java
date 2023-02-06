import java.sql.SQLOutput;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * This is a simple word guessing game. The user inputs as many words they believe are used with the specified letter
 * and get a score upon guessing an incorrect word or duplicating a word.
 *
 */
public class Main {

    public static void main(String[] args) {


        Instant starts = Instant.now();
        String guess;

        int score = 0;
        Scanner input = new Scanner(System.in);
        String seconds;
        ArrayList<String> puzzle = new ArrayList<> ();
        puzzle.add("iter");
        puzzle.add("rite");
        puzzle.add("tier");
        puzzle.add("tire");
        puzzle.add("trie");
        puzzle.add("ire");
        puzzle.add("rei");
        puzzle.add("ret");
        puzzle.add("rit");
        puzzle.add("tie");
        puzzle.add("er");
        puzzle.add("et");
        puzzle.add("re");
        puzzle.add("ti");
        ArrayList<String> guesses = new ArrayList<>();
        guesses.addAll(puzzle);
int counte = 0;

        Boolean cont = true;

        System.out.println("How many words can you create with the following letters:" +
                "\n  T   I   E   R");

        int k= 0;

        /**
         * Loop through the guesses the user inputs and remove them from the guesses list. If an input
         * is repeated or an incorrect guess is entered, exit the loop
         *
         */
        System.out.println("Enter a guess: ");
        String userInput = input.nextLine();
        while (cont) {


            if(guesses.contains(userInput)) {

                score += 100;
                guesses.remove(userInput);
                System.out.println("Good! Enter another guess: ");
                userInput = input.nextLine();


            } else {
                System.out.println("");
                cont = false;
            }

        }


        /**
         * Calculate the duration in solving the puzzle.
         */
        Instant ends = Instant.now();
        long mins = Duration.between(starts, ends).toMinutes();
        long time = Duration.between(starts, ends).toSeconds();
        long actual = time % 60;


        /**
         * Add a leading 0 to the seconds in time elapsed if less than or = 9
         */
        if (time <= 9) {
            seconds = "0" + actual;
        } else {
            seconds = String.valueOf(time);
        }

        /**
         * Calculate the score.
         */
        int totalscore = puzzle.size()  * 100;
        System.out.println("Your time was " + mins + ":" + seconds + " and with a score of "
                + score + " out of " + totalscore + " points");

        /**
         * Display what words the user did not guess.
         */
        System.out.println("Here are the other words you missed " + guesses.toString());

    }
}
