//--- Filename: LibraryManagementSystem.java ---//

import java.util.Scanner;

public class LibraryManagementSystem {

    static Scanner in = new Scanner(System.in);    // Making a static Scanner object

    static Library library = new Library();         // Creating a library object

    ///----- MAIN METHOD -----///
    public static void main(String[] args) {    // Entry point of the program

        // Filling the library's books and users ArrayLists with the program's previous execution's data
        library.readBooksFromFile();
        library.readUsersFromFile();

        System.out.println();   // Adding space
        System.out.println("/////----- LIBRARY MANAGEMENT SYSTEM -----/////");  // Title
        System.out.println();   // Adding space

        menu();     // Invoking the menu method

        // Saving this execution's data
        library.writeBooksToFile();
        library.writeUsersToFile();
    }

    ///----- CUSTOM METHOD -----///
    public static void menu() {

        // Displaying the menu
        System.out.println("Please Enter a choice (1-10) from the menu displayed below: ");
        System.out.println("1. Add new book(s)");
        System.out.println("2. Add new user(s)");
        System.out.println("3. Borrow a book(s)");
        System.out.println("4. Return a book(s)");
        System.out.println("5. Search a book(s) by its title");
        System.out.println("6. Search a book(s) by its author");
        System.out.println("7. Display all books");
        System.out.println("8. Display available books");
        System.out.println("9. Display all users");
        System.out.println("10. Exit");

        // Exception Handling
        int choice = 0;
        try {
            choice = in.nextInt();
            if (choice > 10 || choice < 1) {
                throw new InvalidInputException();
            }
        } catch (Exception e) {

            System.err.println("ERROR: PLEASE ENTER AN INTEGER FROM (1-10).\n");
            menu();
        }

        System.out.println();   // Adding space

        // To keep the user inside the program unless the user decides to exit
        switch (choice) {
            case 1:
                library.addNewBook();
                menu();
                break;
            case 2:
                library.addNewUser();
                menu();
                break;
            case 3:
                library.checkOutBook();
                menu();
                break;
            case 4:
                library.returnBook();
                menu();
                break;
            case 5:
                library.searchBookByTitle();
                menu();
                break;
            case 6:
                library.searchBookByAuthor();
                menu();
                break;
            case 7:
                library.displayAllBooks();
                menu();
                break;
            case 8:
                library.displayAvailableBooks();
                menu();
                break;
            case 9:
                library.displayAllUsers();
                break;
            case 10:     // For the "Exit" choice
                break;
            default:
                break;
        }
    }
}
