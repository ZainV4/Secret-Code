/*
 * Author: Zain AL Sudani
 * Date: 12/6/2022
 * Program name: Encryption {String Assignment}
 *
 * Agents at the VP secret foundation often have to exchange information.
 * It is very important that no one outside the foundation has access to this information.
 * Therefore, you have to write a program to encrypt all the messages that are sent out.
 * Ideally, each line of a message consists of 7 words, separated by spaces.
 * The first and last two words should be integers.
 */

import sun.nio.cs.ext.MacHebrew;

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
                        // main program prints everything {Output}
                        System.out.printf("%s --> %s\n",items.get(0), firstWord(Integer.parseInt(myfirstItem)));
                        System.out.printf("%s --> %s\n",items.get(1), secondWord(items.get(1)));
                        System.out.printf("%s --> %s\n",items.get(2), thirdWord(items.get(2)));
                        System.out.printf("%s --> %s\n",items.get(3), fourthWord(items.get(3)));
                        System.out.printf("%s --> %s\n",items.get(4), fifthWord(items.get(4)));
                        System.out.printf("%s --> %s\n",items.get(5), sixthWord(Integer.parseInt(items.get(5))));
                        System.out.printf("%s --> %s\n",items.get(6), seventhWord(Integer.parseInt(items.get(6))));

                       System.out.println(line);
                       System.out.printf("-> %s %s %s %s %s %s %s",firstWord(Integer.parseInt(myfirstItem)), secondWord(items.get(1)), thirdWord(items.get(2)),
                                fourthWord(items.get(3)), fifthWord(items.get(4)), sixthWord(Integer.parseInt(items.get(5))), seventhWord(Integer.parseInt(items.get(6))));
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
     * 
     *  retuns true if the string contains a digit
     * @param myWord is the only param {type String}
     * @return boolean
     *
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
     * @return String
     */
    public static String firstWord(int num) {
        return Integer.toString((int)Math.round(Math.abs(Math.sqrt(num)-50))); // formula
    }

    /***
     * shift the order of the characters in the word to right three places; the last three characters in the original word would be the three characters in the new word
     * @param myWord is the only param {type String}
     * @return String
     */
    public static String secondWord(String myWord) {
        return myWord.substring(myWord.length()-3)+myWord.substring(0,myWord.length()-3); // returns the switch String
    }

    /***
     * exchange first and last character, the rest of the characters are shifted to the upper case of the character two after it in the ASCII table
     * @param rawStr is the only param {type String}
     * @return String
     */
    public static String thirdWord(String rawStr) {
        // makes a char array of the String rawStr
        char[] myStringArray = rawStr.toCharArray();
        // String variable {made by StringBuilder}
        StringBuilder myStr = new StringBuilder();
        // adds last character of array to the string
        myStr.append(myStringArray[myStringArray.length-1]);

        // loop for the characters in between first and last characters, shifts to uppercase
        for (int i = 1; i < myStringArray.length-1; i++) {
            if (!(myStringArray[i] == 'z' && myStringArray[i] == 'y')) { // checks if the character is a y or z
                myStr.append((char) (myStringArray[i] - 30));
            } else {
                myStr.append('Z');
            }
        }
        // adds first character of array to the string
        myStr.append(myStringArray[0]);
        return myStr.toString();
    }

    /***
     * for each of the first and last characters, if it is uppercase, replace it with ‘$’,
     * otherwise, replace it with ‘&’; the rest of the characters are replaced with a random integer between 0 and 9 (inclusive)
     * @param myRawStr is the only param {type String}
     * @return String
     */
    public static String fourthWord(String myRawStr) {
        // turns the myRawStr into a array
        String[] myStringArray = myRawStr.split("");
        // makes a random int form 1 to 10
        int RandomNum = (int)(Math.random()*10);
        // the myStr variable {made by StringBuilder}
        StringBuilder myStr = new StringBuilder();
        // loops the process of changing the characters in between
        for (int i = 1; i < myStringArray.length-1;  i++) {
            myStringArray[i] = Integer.toString(RandomNum);
        }

        // adds the s variable from the array to the String myStr
        for (String s : myStringArray) {
            myStr.append(s);
        }

        // checks if the first character is uppercase
        if (Character.isUpperCase(myStr.charAt(0))) {
            myStr = new StringBuilder(myStr.toString().replace(myStr.charAt(0), '$'));
        } else {
            myStr = new StringBuilder(myStr.toString().replace(myStr.charAt(0), '&'));
        }

        // checks if the last character is uppercase
        if (Character.isUpperCase(myStr.charAt(myStr.length()-1))) {
            myStr = new StringBuilder(myStr.toString().replace(myStr.charAt(myStr.length()-1), '$'));
        } else {
            myStr = new StringBuilder(myStr.toString().replace(myStr.charAt(myStr.length()-1), '&'));
        }
        // makes the myStr to a string
        return myStr.toString();
    }

    /***
     * all "n" are replaced with "xx" and first "i" is replaced with "aa"
     * @return
     */
    public static String fifthWord(String myString) {
        // replaces all th n's with xx
        myString = myString.replaceAll("n", "xx");
        // replaces only the first i with aa
        myString = myString.replaceFirst("i", "aa");

        return myString;
    }

    /***
     * this word is always a number; find the answer with base of 10 raised to number of digit; take the absolute value of the difference between the answer between 30000
     * 1234-->20000 (10000-30000 = -20000)
     * @param myInt is the only param {type String}
     * @return String
     */
    /***
     *
     * @param myInt
     * @return
     */
    public static String sixthWord(int myInt) {
        // counts for all the Math.pow operations
        int Count = 0;
        // makes the int to a String array
        String[] numArray = Integer.toString(myInt).split("");
        // loops the operation
        for (String s : numArray) {
            Count = (int) Math.pow(10, Integer.parseInt(s));
        }

        // returns the formula
        return Integer.toString(Math.abs(Count-30000));
    }

    /***
     *this word is always a number; find the largest and closest smaller prime number of the number and take the square root of it and round the result
     *to the nearest integer
     * @param num
     * @return
     */
    public static String seventhWord(int num) {
        boolean Prime = true;
        // is going to be the closets prime number
        int myPrimeNum = 0;
        // founds out if it is a prime num or not
        for (int i = num; i >= num; i--) {
            int sqrt = (int) Math.sqrt(num) + 1;
            for (int j = 2; j < sqrt; j++) {
                if (i % j == 0) {
                    // number is perfectly divisible - no prime
                    Prime = false;
                } else {
                    myPrimeNum = i;
                }
            }

        }
        // returns the Answer
        return Integer.toString((int)Math.round(Math.sqrt(myPrimeNum)));
    }
}
