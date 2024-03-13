//--- Filename: Book.java ---//

import java.io.Serializable;

public class Book implements Serializable {

    static int autoBookId = 0;  // For automatic assignment of book IDs

    ///----- ATTRIBUTES -----///
    int bookId;
    String title;
    String author;
    String genre;
    boolean availabilityStatus;

    ///----- CONSTRUCTOR -----///
    Book(String bookTitle, String bookAuthor, String bookGenre) {

        autoBookId++;   // Incrementing the autoBookId variable to assign new IDs to each additional book

        bookId = autoBookId;
        title = bookTitle;
        author = bookAuthor;
        genre = bookGenre;
        availabilityStatus = true;  // Added books will be available by default
    }
}
