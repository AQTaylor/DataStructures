// Name: Andrew Taylor
// Class: CS 3305/Section#04
// Term: Fall 2023
// Instructor: Umama Tasnim
// Assignment: 3




import java.util.Scanner;

public class testPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {	//user chooses which route they want to check for palindrome
                case 1:
                	testWordPalindrome(scanner);
                    break;
                case 2:
                	testCharacterPalindrome(scanner);
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        } while (choice != 3); //as long as user doesn't choose 3 program continues
        
        scanner.close();
    }

    public static void displayMenu() {	//main menu displayed
        System.out.println("-----MAIN MENU-----");
        System.out.println("1. Test word-by-word palindrome");
        System.out.println("2. Test character-by-character palindrome");
        System.out.println("3. Exit program");
        System.out.print("Enter option number: ");
    }

    public static void testWordPalindrome(Scanner scanner) {		//UI for palindrome if option 2 is selected
        System.out.println("You selected: Option 1");
        System.out.print("You entered: ");
        String input = scanner.nextLine().toLowerCase().replaceAll("[^a-z0-9 ]", "");

        if (isPalindromeWord(input)) {
            System.out.println("Judgment: Palindrome");
        } else {
            System.out.println("Judgment: Not Palindrome");
        }
    }
    
    public static void testCharacterPalindrome(Scanner scanner) {		//UI for palindrome if option 2 is selected
        System.out.println("You selected: Option 2");
        System.out.print("You entered: ");
        String input = scanner.nextLine().toLowerCase().replaceAll("[^a-z0-9]", "");

        if (isPalindromeCharacter(input)) {
            System.out.println("Judgment: Palindrome");
        } else {
            System.out.println("Judgment: Not Palindrome");
        }
    }
    
    public static boolean isPalindromeWord(String str) { //checking if sentence is palindrome
        String[] words = str.split(" ");
        int left = 0;
        int right = words.length - 1;

        while (left < right) {
            if (!words[left].equals(words[right])) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeCharacter(String str) { //checking if character is palindrome
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}