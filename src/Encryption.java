/*
 * Author: Zain AL Sudani
 * Date: 12/6/2022
 * Program name: Encryption
 *
 * Agents at the VP secret foundation often have to exchange information.
 * It is very important that no one outside the foundation has access to this information.
 * Therefore, you have to write a program to encrypt all the messages that are sent out.
 * Ideally, each line of a message consists of 7 words, separated by spaces.
 * The first and last two words should be integers.
 */

import java.util.Arrays; // imports extra Arrays method {like toCharArray}
import java.util.List; // Array list
import java.util.Scanner; // import input function

public class Encryption {
    public static void main(String[] args) { // main method
        Scanner scan = new Scanner(System.in); // Class that has the function to input data {any type}
        List<String> items; // Array list for words in The line
        while (true) { // continues looping if the input is not correctly put in
            try {
                System.out.println("Enter a seven word message:");
                String line = scan.nextLine(); // the secret message
                items = Arrays.asList(line.split(" ")); // a list of the words in the line
                String myfirstItem = items.get(0); // calling the first item in the list
                String mySecondLastItem = items.get(5); // calling the fifth item in the list
                String myLastItem = items.get(6); // calling the sixth item in the list
                // I have used parse method to trigger error message (NumberFormatException) if none of line 30, 31 and 32 is a digit
                Integer.parseInt(myfirstItem);
                Integer.parseInt(mySecondLastItem);
                Integer.parseInt(myLastItem);

                if (items.size() != 7) { // check if the whole string has 7 words & if it doesn't clear the whole list and start the loop over
                    items.clear();
                } else { // checks if there are any digits in the words 2, 3, 4 and 5
                    if (containsDigit(items.get(1))) {
                        System.out.println("remember only first and the last two words are supposed to have digits");
                    }else if (containsDigit(items.get(2))) {
                        System.out.println("remember only first and the last two words are supposed to have digits");
                    } else if (containsDigit(items.get(3))) {
                        System.out.println("remember only first and the last two words are supposed to have digits");
                    }else if (containsDigit(items.get(4))) {
                        System.out.println("remember only first and the last two words are supposed to have digits");
                    } else {
                        System.out.printf("%d --> %d\n",Integer.parseInt(myfirstItem),firstWord(Integer.parseInt(myfirstItem)));
                        System.out.printf("%s --> %s",items.get(1), secondWord(items.get(1)));
                        break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ex) { // if it is less than seven throw this error message
                System.out.println("please only input 7 words not less");
            }  catch (UnsupportedOperationException ex) { // if it is more than seven throw this error message
                System.out.println("please only input 7 words not more ");
            } catch (NumberFormatException ex) { // if first or the two last words aren't integers throw this error message
                System.out.println("remember first and the last two words are supposed to have only digits");
            }
        }
    }

    /***
     *  retuns true if the string contains a digit
     * @param myWord is the only param {type String}
     * @return boolean
     */
    public static boolean containsDigit(String myWord) {
        char[] chars = myWord.toCharArray(); // parsing the string into an array of chars
        for(char c : chars){ // loop the  array to get each character
            if (Character.isDigit(c)){ // check if it has a digit
                return true;
            }
        }
        return false; // else return false
    }

    /***
     * takes the square root of the number and find the absolute integer value of the closest integer-valued
     * of the difference( closest one) between the resulting square root and 50
     *
     * @param num is the only param {type int}
     * @return int
     */
    public static int firstWord(int num) {
        return (int)Math.round(Math.abs(Math.sqrt(num)-50)); // formula
    }

    /***
     * shift the order of the characters in the word to right three places; the last three characters in the original word would be the three characters in the new word
     * @param myWord is the only param {type String}
     * @return String
     */
    public static String secondWord(String myWord) {
        return myWord.substring(myWord.length()-3)+myWord.substring(0,myWord.length()-3); // returns the switch String
    }
    public static void thirdWord() {

    }
    public static void fourthWord() {

    }
    public static void fifthWord() {

    }
    public static void sixthWord() {

    }
    public static void seventhWord() {

    }

}
