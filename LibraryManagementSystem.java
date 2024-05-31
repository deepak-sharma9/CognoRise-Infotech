import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }
}

class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        books.add(newBook);
        System.out.println("Book '" + title + "' by " + author + " added to the catalog.");
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found in the catalog.");
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author '" + author + "' in the catalog.");
        }
    }

    public void checkoutBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isCheckedOut()) {
                    book.setCheckedOut(true);
                    System.out.println("Book '" + title + "' checked out successfully.");
                } else {
                    System.out.println("Book '" + title + "' is already checked out.");
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book with title '" + title + "' not found in the catalog.");
        }
    }

    public void returnBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isCheckedOut()) {
                    book.setCheckedOut(false);
                    System.out.println("Book '" + title + "' returned successfully.");
                } else {
                    System.out.println("Book '" + title + "' is already available in the library.");
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book with title '" + title + "' not found in the catalog.");
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Adding famous books to the catalog
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("1984", "George Orwell");
        library.addBook("Pride and Prejudice", "Jane Austen");
        library.addBook("The Catcher in the Rye", "J.D. Salinger");
        library.addBook("The Hobbit", "J.R.R. Tolkien");
        library.addBook("The Lord of the Rings", "J.R.R. Tolkien");
        library.addBook("Harry Potter and the Sorcerer's Stone", "J.K. Rowling");
        library.addBook("The Chronicles of Narnia", "C.S. Lewis");
        library.addBook("To Kill a Mockingbird", "Harper Lee"); // Adding another copy

        // Displaying available books
        library.displayAvailableBooks();

        // Menu for user interaction
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Search by Title");
            System.out.println("2. Search by Author");
            System.out.println("3. Checkout Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Available Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    library.searchByTitle(title);
                    break;
                case 2:
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    library.searchByAuthor(author);
                    break;
                case 3:
                    System.out.print("Enter the title of the book to checkout: ");
                    title = scanner.nextLine();
                    library.checkoutBook(title);
                    break;
                case 4:
                    System.out.print("Enter the title of the book to return: ");
                    title = scanner.nextLine();
                    library.returnBook(title);
                    break;
                case 5:
                    library.displayAvailableBooks();
                    break;
                case 0:
                    System.out.println("Exiting the library management system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from the menu.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
