import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    double price;
    int availableCopies;
    String genre;

    // Constructor
    public Book(int id, String title, String author, double price, int availableCopies, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.availableCopies = availableCopies;
        this.genre = genre;
    }

    // Display book details
    public void displayDetails() {
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Available Copies: " + availableCopies);
        System.out.println("Genre: " + genre);
    }

    // Search by title
    public boolean matchesTitle(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    // Search by author
    public boolean matchesAuthor(String author) {
        return this.author.equalsIgnoreCase(author);
    }

    // Search by genre
    public boolean matchesGenre(String genre) {
        return this.genre.equalsIgnoreCase(genre);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an array to store books
        Book[] books = new Book[10];

        // Add some sample books to the array
        books[0] = new Book(101, "The Great Gatsby", "F. Scott Fitzgerald", 10.99, 5, "Fiction");
        books[1] = new Book(102, "To Kill a Mockingbird", "Harper Lee", 12.49, 3, "Fiction");
        books[2] = new Book(103, "1984", "George Orwell", 15.00, 2, "Dystopian");
        books[3] = new Book(104, "The Catcher in the Rye", "J.D. Salinger", 9.99, 4, "Fiction");
        books[4] = new Book(105, "Moby Dick", "Herman Melville", 18.99, 1, "Adventure");

        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the menu
            System.out.println("\nLibrary Management System");
            System.out.println("1. Search by Book ID");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. Search by Genre");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            boolean bookFound = false; // Variable to check if a book was found

            switch (choice) {
                case 1:
                    // Search by Book ID
                    System.out.print("Enter the Book ID (101 to 110): ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // consume newline after number
                    for (Book book : books) {
                        if (book != null && book.id == bookId) {
                            book.displayDetails();
                            bookFound = true;
                            break;
                        }
                    }
                    if (!bookFound) {
                        System.out.println("Book with ID " + bookId + " not found.");
                    }
                    break;

                case 2:
                    // Search by Title
                    System.out.print("Enter the Book Title: ");
                    String title = scanner.nextLine();
                    bookFound = false;
                    for (Book book : books) {
                        if (book != null && book.matchesTitle(title)) {
                            book.displayDetails();
                            bookFound = true;
                            break;
                        }
                    }
                    if (!bookFound) {
                        System.out.println("Book with title '" + title + "' not found.");
                    }
                    break;

                case 3:
                    // Search by Author
                    System.out.print("Enter the Author Name: ");
                    String author = scanner.nextLine();
                    bookFound = false;
                    for (Book book : books) {
                        if (book != null && book.matchesAuthor(author)) {
                            book.displayDetails();
                            bookFound = true;
                            break;
                        }
                    }
                    if (!bookFound) {
                        System.out.println("Book with author '" + author + "' not found.");
                    }
                    break;

                case 4:
                    // Search by Genre
                    System.out.print("Enter the Genre: ");
                    String genre = scanner.nextLine();
                    bookFound = false;
                    for (Book book : books) {
                        if (book != null && book.matchesGenre(genre)) {
                            book.displayDetails();
                            bookFound = true;
                        }
                    }
                    if (!bookFound) {
                        System.out.println("No books found in the genre '" + genre + "'.");
                    }
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            // Ask user if they want to continue or exit
            if (bookFound) {
                System.out.println("\nWould you like to continue?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Your choice: ");
                int continueChoice = scanner.nextInt();
                if (continueChoice == 2) {
                    System.out.println("Exiting the system...");
                    scanner.close();
                    break; // Exit the program
                }
            }
        }
    }
}
