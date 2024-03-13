# Library-ManagementSystem


## Library Management System in Java
This is a comprehensive Java implementation of a Library Management System. The system includes classes for Book, User, and Library objects, as well as exception classes for handling empty fields and invalid inputs. It allows for adding new books and users, borrowing and returning books, and searching for books by title or author. It also includes methods for displaying all books, available books, and users. Additionally, the system has the capability to save and load data from files, allowing for the preservation of data between different executions of the program.

## Brief Description
This project is a simple Java implementation of a Library Management System. It allows users to add new books and users, borrow and return books, and search for books by title or author. It also includes methods for displaying all books, available books, and users. The system also has the capability to save and load data from files, allowing for the preservation of data between different executions of the program.

## Instructions for Setting Up and Running the Project Locally
To run the project locally, you will need to have the following software installed:

JDK (Java Development Kit) version 8 or higher
A text editor or IDE (Integrated Development Environment) that supports Java, such as IntelliJ IDEA or Eclipse
Once you have the required software, follow these steps to set up and run the project:

Clone the repository to your local machine.
Open the project in your preferred text editor or IDE.
Compile the project by running the command javac LibraryManagementSystem.java in the terminal or command prompt.
Run the project by executing the command java LibraryManagementSystem in the terminal or command prompt.
Explanation of Key Features and Functionalities Implemented
The system includes classes for Book, User, and Library objects, as well as exception classes for handling empty fields and invalid inputs.

## Book
The Book class represents a book object in the library. It has the following attributes:

bookId: an integer that serves as the unique identifier of each book object. It is automatically assigned by the autoBookId static variable.
title: a string that stores the title of the book.
author: a string that stores the author of the book.
genre: a string that stores the genre of the book.
availabilityStatus: a boolean that indicates whether the book is available or not.
The class also includes a constructor for creating new book objects, and methods for getting and setting the values of its attributes.

## User
The User class represents a user object in the library. It has the following attributes:

userId: an integer that serves as the unique identifier of each user object. It is automatically assigned by the autoUserId static variable.
name: a string that stores the name of the user.
contactInformation: a string that stores the contact information of the user.
borrowedBooks: an ArrayList of book objects that stores the books borrowed by the user.
The class also includes a constructor for creating new user objects, and methods for getting and setting the values of its attributes.

## Library
The Library class represents the library itself. It has the following attributes:

books: an ArrayList of book objects that stores all the books in the library.
users: an ArrayList of user objects that stores all the users in the library.
The class also includes methods for adding new books and users, borrowing and returning books, and searching for books by title or author. Additionally, it includes methods for displaying all books, available books, and users. It also has methods for saving and loading data from files, allowing for the preservation of data between different executions of the program.

## Exceptions
The system includes two exception classes for handling empty fields and invalid inputs:

EmptyFieldException: This exception is thrown when a required field is left empty. It is used in the Book and User classes to ensure that all required fields are filled in when creating new objects.
InvalidInputException: This exception is thrown when an invalid input is provided by the user. It is used in the Library class to ensure that the user inputs a valid choice from the menu.

### Note: The system uses the Serializable interface to save and load the data from files. Make sure that the files are in the same directory.
