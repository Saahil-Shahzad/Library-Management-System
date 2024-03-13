# Library Management System

This is a simple Java-based Library Management System that allows users to manage books, users, and transactions.

## Table of Contents

1. [Description](#description)
2. [Setting Up and Running the Project Locally](#setting-up-and-running-the-project-locally)
3. [Prerequisites and Softwares Required](#prerequisites-and-softwares-required)
4. [Key Features and Functionalities](#key-features-and-functionalities)
5. [Usage](#usage)
6. [Future Plans](#future-plans)
7. [Contributing](#contributing)
8. [License](#license)

## Description

The Library Management System is designed to help manage the books, users, and transactions in a library. It provides a user-friendly interface to perform various operations such as adding books, users, and managing transactions.

The system uses a command-line interface (CLI) to interact with the user. It stores the data in text files, making it easy to manage and backup.

## Setting Up and Running the Project Locally

1. Clone the repository to your local machine using the following command:
   git clone https://github.com/Saahil-Shahzad/Library-Management-System.git

2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Run the `LibraryManagementSystem` class to start the application.
4. Follow the prompts to interact with the Library Management System.

## Prerequisites and Softwares Required

- JDK 8 or later
- A Java IDE (e.g., IntelliJ IDEA, Eclipse)

## Key Features and Functionalities

- Add new books with a unique ID, title, author, and genre.
- Add new users with a unique ID, name, and contact information.
- Borrow books by entering the book and user IDs.
- Return borrowed books by entering the book and user IDs.
- Search for books by title or author.
- Display all books, available books, and all users.
- Save and load data from files.

## Usage

1. Run the `LibraryManagementSystem` class to start the application.
2. Follow the prompts to perform the desired operation.
3. Repeat steps 2 and 3 for additional operations.

### Note:
The system uses the Serializable interface to save and load the data from files. Make sure that the files are in the same directory.

## Future Plans

As the sole developer behind this Library Management System project, I've been contemplating its future trajectory and have outlined a couple of exciting enhancements on the horizon.

### Integration of a GUI
Primarily, I intend to implement a Graphical User Interface (GUI) to augment the system's user experience. While functionality remains paramount, the addition of a visually intuitive interface promises to streamline user interactions and elevate the overall usability of the system.

### Database Integration
Furthermore, I plan to incorporate database functionality into the project. Despite the initial apprehension that databases might evoke, their utilization will significantly enhance data management capabilities. By facilitating structured storage and retrieval of library-related information, we can anticipate improvements in search efficiency and operational fluidity.

## Contributing

Contributions are welcome! To contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Commit your changes to the new branch.
4. Submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more information.
