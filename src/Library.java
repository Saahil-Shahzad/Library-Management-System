//--- Filename: Library.java ---//

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    Scanner in = new Scanner(System.in);    // Making a Scanner object

    ///----- ATTRIBUTES -----///
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    ///----- CUSTOM METHODS -----///
    public void addNewBook() {

        try {   // Exception handling

            boolean isTitleEmpty, isAuthorEmpty, isGenreEmpty;     // For exception handling in reading inputs

            char repeat = 'Y';    // For while loop's condition; to repeat the process as per user's choice

            while (repeat == 'y' || repeat == 'Y') {

                // Reading book's info for its object creation
                System.out.println("Enter the book's TITLE: ");
                String bookTitle = in.nextLine();
                bookTitle = bookTitle.toLowerCase();    // Ensuring validity (preventing cases like "Universe" and "universe" to be considered different)
                isTitleEmpty = bookTitle.isEmpty();     // Checking if bookTitle is empty

                // Throwing an exception if the book's title is empty
                if (isTitleEmpty) {

                    throw new EmptyFieldException();
                }

                // Preventing duplication of data
                for (Book book : books) {

                    if (book.title.equals(bookTitle)) {

                        System.err.println("\nERROR: THIS BOOK ALREADY EXISTS.");
                        addNewBook();
                    }
                }

                System.out.println("Enter the book's AUTHOR: ");
                String bookAuthor = in.nextLine();
                bookAuthor = bookAuthor.toLowerCase();
                isAuthorEmpty = bookAuthor.isEmpty();

                // Throwing an exception if the book's author is empty
                if (isAuthorEmpty) {

                    throw new EmptyFieldException();
                }

                System.out.println("Enter the book's GENRE: ");
                String bookGenre = in.nextLine();
                bookGenre = bookGenre.toLowerCase();
                isGenreEmpty = bookGenre.isEmpty();

                // Throwing an exception if the book's genre is empty
                if (isGenreEmpty) {

                    throw new EmptyFieldException();
                }

                System.out.println();   // Adding space

                // Making a book object
                Book book = new Book(bookTitle, bookAuthor, bookGenre);

                books.add(book);    // Adding the book to the book ArrayList

                // Confirmation
                System.out.printf("NEW BOOK (\"%s\") ADDED.\n", book.title);
                System.out.println();   // Adding space

                System.out.println("Want to add more books? (Y/N): ");   // asking user's choice
                repeat = in.next().charAt(0);

                System.out.println();   // Adding space

                // Checking if the input is valid, if not, prompting the user again
                while ( !(repeat == 'n' || repeat == 'N' || repeat == 'y' || repeat == 'Y') ) {

                    System.err.println("ERROR: PLEASE ENTER \"Y\" OR \"N\".\n");
                    System.out.println("Want to add more books? (Y/N): ");   // asking user's choice
                    repeat = in.next().charAt(0);

                    System.out.println();   // Adding space
                }

                String ignore = in.nextLine();  // To ignore random input
            }
        } catch (EmptyFieldException e) {

            System.err.println("ERROR: THIS FIELD CANNOT BE LEFT EMPTY.\n");
            addNewBook();
        } catch (Exception e) {

            System.err.println("ERROR: PLEASE PROVIDE A VALID INPUT.\n");
            addNewBook();
        }

        System.out.println();   // Adding space
    }

    public void addNewUser() {

        try {   // Exception handling

            boolean isNameEmpty, isContactInformationEmpty;     // For exception handling in reading inputs

            char repeat = 'Y';    // For while loop's condition; to repeat the process as per user's choice

            while (repeat == 'y' || repeat == 'Y') {

                // Reading user's info for its object creation
                System.out.println("Enter the user's NAME: ");
                String userName = in.nextLine();
                userName = userName.toLowerCase();
                isNameEmpty = userName.isEmpty();     // Checking if userName is empty

                // Throwing an exception if the user's name is empty
                if (isNameEmpty) {

                    throw new EmptyFieldException();
                }

                System.out.println("Enter the user's CONTACT INFORMATION: ");
                String userContactInfo = in.nextLine();
                userContactInfo = userContactInfo.toLowerCase();
                isContactInformationEmpty = userContactInfo.isEmpty();     // Checking if userContactInformation is empty

                // Throwing an exception if the user's contact information is empty
                if (isContactInformationEmpty) {

                    throw new EmptyFieldException();
                }

                // Preventing duplication of data
                for (User user : users) {

                    if (user.contactInformation.equals(userContactInfo) && user.name.equals(userName)) {

                        System.err.println("\nERROR: THIS USER ALREADY EXISTS.");
                        addNewUser();
                    }
                }

                System.out.println();   // Adding space

                // Making a user object
                User user = new User(userName, userContactInfo);

                users.add(user);   // Adding the user to the user ArrayList

                // Confirmation
                System.out.printf("NEW USER (\"%s\") ADDED.\n", user.name);
                System.out.println();   // Adding space

                System.out.println("Want to add more users? (Y/N): ");   // asking user's choice
                repeat = in.next().charAt(0);

                System.out.println();   // Adding space

                // Checking if the input is valid, if not, prompting the user again
                while ( !(repeat == 'n' || repeat == 'N' || repeat == 'y' || repeat == 'Y') ) {

                    System.err.println("ERROR: PLEASE ENTER \"Y\" OR \"N\".\n");
                    System.out.println("Want to add more users? (Y/N): ");   // asking user's choice
                    repeat = in.next().charAt(0);

                    System.out.println();   // Adding space
                }

                String ignore = in.nextLine();  // To ignore random input
            }
        } catch (EmptyFieldException e) {

        System.err.println("ERROR: THIS FIELD CANNOT BE LEFT EMPTY.\n");
        addNewUser();
        } catch (Exception e) {

        System.err.println("ERROR: PLEASE PROVIDE A VALID INPUT.\n");
        addNewUser();
        }

        System.out.println();   // Adding space
    }

    public void checkOutBook() {

        try {   // Exception handling

            // Reading the book and user IDs
            System.out.println("Enter the ID of the book: ");
            int idOfBook = in.nextInt();

            System.out.println("Enter the ID of the user: ");
            int idOfUser = in.nextInt();

            System.out.println();   // Adding space

            if (books.get(idOfBook - 1).availabilityStatus) {   // Letting someone borrow a book only if its available

                char repeat = 'Y';    // For while loop's condition; to repeat the process as per user's choice

                while (repeat == 'y' || repeat == 'Y') {

                    // Setting the availability status of the book to false in library's ArrayList that is storing books
                    books.get(idOfBook - 1).availabilityStatus = false;

                    // Adding the book in the borrowed books ArrayList of the user in Library's ArrayList that is storing users
                    users.get(idOfUser - 1).borrowedBooks.add(books.get(idOfBook - 1));

                    // Confirmation
                    System.out.println("----------- CHECKOUT CONFIRMATION -----------");
                    System.out.printf("BORROWER: %s (%d)\n", users.get(idOfUser - 1).name, idOfUser);
                    System.out.printf("BOOK BORROWED: %s (%d)\n", books.get(idOfBook - 1).title, idOfBook);
                    System.out.println();   // Adding space

                    System.out.println("Want to borrow more books? (Y/N): ");   // asking user's choice
                    repeat = in.next().charAt(0);

                    System.out.println();   // Adding space

                    // Checking if the input is valid, if not, prompting the user again
                    while ( !(repeat == 'n' || repeat == 'N' || repeat == 'y' || repeat == 'Y') ) {

                        System.err.println("ERROR: PLEASE ENTER \"Y\" OR \"N\".\n");
                        System.out.println("Want to borrow more books? (Y/N): ");   // asking user's choice
                        repeat = in.next().charAt(0);

                        System.out.println();   // Adding space
                    }

                    String ignore = in.nextLine();  // To ignore random input
                }
            } else {

                System.out.println("SORRY, THIS BOOK IS NOT AVAILABLE.\n");
                return; // Exiting the method
            }
        } catch (IndexOutOfBoundsException e) {

            System.err.println("ERROR: INDEX OUT OF BOUND.\n");
            checkOutBook();
        } catch (Exception e) {

            System.err.println("ERROR: PLEASE ENTER AN INTEGER.\n");
            checkOutBook();
        }

        System.out.println();   // Adding space
    }

    public void returnBook() {

        try {   // Exception handling

            // Reading the book and user IDs
            System.out.println("Enter the ID of the book: ");
            int idOfBook = in.nextInt();

            System.out.println("Enter the ID of the user: ");
            int idOfUser = in.nextInt();

            System.out.println();   // Adding space

            if (!books.get(idOfBook - 1).availabilityStatus) {  // Returning a book only if it has been borrowed

                char repeat = 'Y';    // For while loop's condition; to repeat the process as per user's choice

                while (repeat == 'y' || repeat == 'Y') {

                    // Setting the availability status of the book to true in library's ArrayList that is storing books
                    books.get(idOfBook - 1).availabilityStatus = true;

                    // Removing the book from the borrowed books ArrayList of the user in Library's ArrayList that is storing users
                    users.get(idOfUser - 1).borrowedBooks.remove(books.get(idOfBook - 1).bookId - 1);

                    // Confirmation
                    System.out.println("----------- RETURN CONFIRMATION -----------");
                    System.out.printf("BORROWER: %s (%d)\n", users.get(idOfUser - 1).name, idOfUser);
                    System.out.printf("BOOK RETURNED: %s (%d)\n", books.get(idOfBook - 1).title, idOfBook);
                    System.out.println();   // Adding space

                    System.out.println("Want to return more books? (Y/N): ");   // asking user's choice
                    repeat = in.next().charAt(0);

                    System.out.println();   // Adding space

                    // Checking if the input is valid, if not, prompting the user again
                    while ( !(repeat == 'n' || repeat == 'N' || repeat == 'y' || repeat == 'Y') ) {

                        System.err.println("ERROR: PLEASE ENTER \"Y\" OR \"N\".\n");
                        System.out.println("Want to return more books? (Y/N): ");   // asking user's choice
                        repeat = in.next().charAt(0);

                        System.out.println();   // Adding space
                    }

                    String ignore = in.nextLine();  // To ignore random input
                }
            } else {

                System.out.println("SORRY, THIS BOOK IS NOT FROM OUR LIBRARY.\n");
                return; // Exiting the method
            }
        } catch (IndexOutOfBoundsException e) {

            System.err.println("ERROR: INDEX OUT OF BOUND.\n");
            checkOutBook();
        } catch (Exception e) {

            System.err.println("ERROR: PLEASE ENTER AN INTEGER.\n");
            returnBook();
        }

        System.out.println();   // Adding space
    }

    public void searchBookByTitle() {

        try {   // Exception handling

            boolean isTitleEmpty;     // For exception handling in reading input

            char repeat = 'Y';    // For while loop's condition; to repeat the process as per user's choice

            while (repeat == 'y' || repeat == 'Y') {

                // Reading the book's title
                System.out.println("Enter the TITLE of the book: ");
                String bookTitle = in.nextLine();
                bookTitle = bookTitle.toLowerCase();
                isTitleEmpty = bookTitle.isEmpty();     // Checking if bookTitle is empty

                // Throwing an exception if the book's title is empty
                if (isTitleEmpty) {

                    throw new EmptyFieldException();
                }

                System.out.println();   // Adding space

                // Using enhanced for-loop to compare the argument with each book's title
                for (Book i : books) {

                    if (i.title.equals(bookTitle)) {

                        System.out.println("BOOK FOUND! following are the details: ");

                        // Invoking the book displaying method
                        displayBook(i);

                        return; // To stop the method when book is found
                    }
                }

                System.out.println("BOOK NOT FOUND!");
                System.out.println();   // Adding space

                System.out.println("Want to search more books? (Y/N): ");   // asking user's choice
                repeat = in.next().charAt(0);

                System.out.println();   // Adding space

                // Check if the input is valid, if not, prompt the user again
                while ( !(repeat == 'n' || repeat == 'N' || repeat == 'y' || repeat == 'Y') ) {

                    System.err.println("ERROR: PLEASE ENTER \"Y\" OR \"N\".\n");
                    System.out.println("Want to search more books? (Y/N): ");   // asking user's choice
                    repeat = in.next().charAt(0);

                    System.out.println();   // Adding space
                }

                String ignore = in.nextLine();  // To ignore random input
            }
        } catch (EmptyFieldException e) {

            System.err.println("ERROR: THIS FIELD CANNOT BE EMPTY.\n");
            searchBookByTitle();
        } catch (Exception e) {

            System.err.println("ERROR: PLEASE ENTER A VALID INPUT.\n");
            searchBookByTitle();
        }

        System.out.println();   // Adding space
    }

    public void searchBookByAuthor() {

        try {   // Exception handling

            boolean isAuthorEmpty;     // For exception handling in reading input

            char repeat = 'Y';    // For while loop's condition; to repeat the process as per user's choice

            while (repeat == 'y' || repeat == 'Y') {

                // Reading the book's author
                System.out.println("Enter the AUTHOR of the book: ");
                String bookAuthor = in.nextLine();
                bookAuthor = bookAuthor.toLowerCase();
                isAuthorEmpty = bookAuthor.isEmpty();     // Checking if bookTitle is empty

                // Throwing an exception if the book's title is empty
                if (isAuthorEmpty) {

                    throw new EmptyFieldException();
                }

                System.out.println();   // Adding space

                // Using enhanced for-loop to compare the argument with each book's author
                for (Book i : books) {

                    if (i.author.equals(bookAuthor)) {

                        System.out.println("BOOK FOUND! following are the details: ");

                        // Invoking the book displaying method
                        displayBook(i);

                        return; // To stop the method when book is found
                    }
                }


                System.out.println("BOOK NOT FOUND!");
                System.out.println();   // Adding space

                System.out.println("Want to search more books? (Y/N): ");   // asking user's choice
                repeat = in.next().charAt(0);

                System.out.println();   // Adding space

                // Check if the input is valid, if not, prompt the user again
                while ( !(repeat == 'n' || repeat == 'N' || repeat == 'y' || repeat == 'Y') ) {

                    System.err.println("ERROR: PLEASE ENTER \"Y\" OR \"N\".\n");
                    System.out.println("Want to search more books? (Y/N): ");   // asking user's choice
                    repeat = in.next().charAt(0);

                    System.out.println();   // Adding space
                }

                String ignore = in.nextLine();  // To ignore random input
            }
        } catch (EmptyFieldException e) {

            System.err.println("ERROR: THIS FIELD CANNOT BE EMPTY.\n");
            searchBookByAuthor();
        } catch (Exception e) {

            System.err.println("ERROR: PLEASE ENTER A VALID INPUT.\n");
            searchBookByAuthor();
        }

        System.out.println();   // Adding space
    }

    // To reduce code redundancy; this method is being used in other methods
    public void displayBook(Book book) {

        System.out.printf("Book ID: %d\n", book.bookId);
        System.out.printf("Book TITLE: %s\n", book.title);
        System.out.printf("Book AUTHOR: %s\n", book.author);
        System.out.printf("Book GENRE: %s\n", book.genre);
        // availabilityStatus contains a boolean value, ternary operator is used below to display the status as a string
        System.out.printf("Book AVAILABILITY STATUS: %s\n", (book.availabilityStatus) ? "Available" : "Unavailable");
        System.out.println();   // Adding Space
    }

    public void displayAllBooks() {

        // Using enhanced for-loop to display all the books
        for (Book i : books) {

            // Invoking the book displaying method
            displayBook(i);
        }
    }

    public void displayAllUsers() {

        // Using enhanced for-loop to display all the users
        for (User i : users) {

            System.out.printf("User ID: %d\n", i.userId);
            System.out.printf("User NAME: %s\n", i.name);
            System.out.printf("User CONTACT INFORMATION: %s\n", i.contactInformation);
            System.out.println();   // Adding Space
        }
    }

    public void displayAvailableBooks() {

        // Using enhanced for-loop to display all the books
        for (Book i : books) {

            // Displaying only if the book is available
            if (i.availabilityStatus) {     // Availability status returns a boolean value

                // Invoking the book displaying method
                displayBook(i);
                return; // To end the method
            }
        }
        System.out.println("THERE ARE NO AVAILABLE BOOKS.\n");
    }

    public void writeBooksToFile() {

        try {

            // Creating a file for storing books
            File file = new File("library-books.dat");

            // Creating an ObjectOutputStream to write objects to the file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

            // Writing each book object in the ArrayList to the file
            for (Book book : books) {

                oos.writeObject(book);
            }

            oos.close();    // Closing the ObjectOutputStream

            System.out.println("BOOKS DATA SAVED TO THE FILE.\n");

        } catch (IOException e) {   // Handling IO exceptions

            e.printStackTrace();    // Printing the stack trace if an exception occurs
        }
    }

    public void readBooksFromFile() {

        books.clear();  // Clearing the existing books

        try {

            // Creating a file for reading books
            File file = new File("library-books.dat");

            if (!file.exists()) {   // Creating a file is it does not exist

                file.createNewFile();
                System.out.println("\"" + file + "\" FILE CREATED.\n");
            }

            // Creating an ObjectInputStream to read objects from the file
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            Object obj;
            // Reading objects from the file until EOF (end of file) is reached
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof Book) {
                    books.add((Book) obj);  // Adding the read book object to the ArrayList
                }
            }

            ois.close();    // Closing the ObjectInputStream

        } catch (EOFException e) {      // Catching Exceptions

            System.out.println("BOOKS DATA READ FROM FILE.\n");
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);  // Rethrowing the exception as a runtime exception
        }
    }

    public void writeUsersToFile() {

        try {

            // Creating a file for storing users
            File file = new File("library-users.dat");

            // Creating an ObjectOutputStream to write objects to the file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

            // Writing each user object in the ArrayList to the file
            for (User user : users) {

                oos.writeObject(user);
            }

            oos.close();    // Closing the ObjectOutputStream

            System.out.println("USERS DATA SAVED TO THE FILE.\n");

        } catch (IOException e) {   // Handling IO exceptions

            e.printStackTrace();    // Printing the stack trace if an exception occurs
        }
    }

    public void readUsersFromFile() {

        users.clear();  // Clearing the existing books

        try {

            // Creating a file for reading users
            File file = new File("library-users.dat");

            if (!file.exists()) {   // Creating a file if it does not exist

                file.createNewFile();
                System.out.println("\"" + file + "\" FILE CREATED.\n");
            }

            // Creating an ObjectInputStream to read objects from the file
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            Object obj;
            // Reading objects from the file until EOF (end of file) is reached
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof User) {
                    users.add((User) obj);  // Adding the read user object to the ArrayList
                }
            }

            ois.close();    // Closing the ObjectInputStream

        } catch (EOFException e) {      // Catching Exceptions

            System.out.println("USERS DATA READ FROM FILE.\n");
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);  // Rethrowing the exception as a runtime exception
        }
    }
}
