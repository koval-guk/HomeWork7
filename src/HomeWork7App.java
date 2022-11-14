import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork7App {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("input string : ");
        String source = scanner.nextLine();
        System.out.print("input character : ");
        char symbol = scanner.nextLine().charAt(0);
        System.out.println("your string contained character '" + symbol + "' " + findSymbolOccurrence(source, symbol) + " time(s).");
        System.out.print("input target string : ");
        String target = scanner.nextLine();
        System.out.println("your string contained string \"" + target + "\" at position " + findWordPosition(source, target));
        System.out.println("reverse string is \"" + stringReverse(source) + "\"");
        System.out.println("is it palindrome - " + isPalindrome(source));
        System.out.println("********game1************");
        game_2_0(words);
        System.out.println("********game2************");
        game_2_1(words);
        scanner.close();
    }

    private static int findSymbolOccurrence(String source, char symbol) {
        int count = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    private static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    private static String stringReverse(String source) {
        String reverse = "";
        for (int i = source.length() - 1; i >= 0; i--) {
            reverse = reverse.concat(String.valueOf(source.charAt(i)));
        }
        return reverse;
    }

    private static boolean isPalindrome(String source) {
        return source.equalsIgnoreCase(stringReverse(source));
    }

    private static void game(String[] words) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String word = words[random.nextInt(words.length)];
        String answer = "";
        while (!answer.equalsIgnoreCase(word)) {
            int count = 0;
            System.out.print("guess the word: ");
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(word)) {
                System.out.println("Yes, the word is " + word);
                break;
            }
            while (count < word.length() && count < answer.length()) {
                if (answer.charAt(count) == word.charAt(count)) {
                    System.out.print(word.charAt(count));
                } else {
                    System.out.print("#");
                }
                count++;
            }
            for (int i = 0; i <= 15 - word.length(); i++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    private static void game_2_0(String[] words) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String word = words[random.nextInt(words.length)];
        String temp = "###############";
        String answer = "";
        int count = 0;
        while (true) {
            if (answer.equalsIgnoreCase(word)) {
                System.out.println("Yes, the word is \"" + word + "\".");
                break;
            } else if (count == word.length()) {
                System.out.println("No :( , the word is \"" + word + "\".");
                break;
            } else {
                System.out.print("Try number " + (count + 1) + ". Guess the word : ");
                answer = scanner.nextLine();
                temp = temp.replaceFirst("#", String.valueOf(word.charAt(count)));
                System.out.println(temp);
                count++;
            }
        }
    }

    private static void game_2_1(String[] words) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String word = words[random.nextInt(words.length)];
        char[] tempArray = new char[14];
        String answer = "";
        int count = 0;
        int tempRandom;
        Arrays.fill(tempArray, '#');
        while (true) {
            if (answer.equalsIgnoreCase(word)) {
                System.out.println("Yes, the word is \"" + word + "\".");
                break;
            } else if (count == word.length()) {
                System.out.println("No :( , the word is \"" + word + "\".");
                break;
            } else {
                System.out.print("Try number " + (count + 1) + ". Guess the word : ");
                answer = scanner.nextLine();
                while (true) {
                    tempRandom = random.nextInt(word.length());
                    if (tempArray[tempRandom] == '#') {
                        tempArray[tempRandom] = word.charAt(tempRandom);
                        break;
                    }
                }
            }
            System.out.println(tempArray);
            count++;
        }
    }
}
