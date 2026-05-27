import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    private HashMap<Integer, User> users;

    // Constructor
    public Library() {

        books = new ArrayList<>();
        users = new HashMap<>();
    }

    // Add Book
    public void addBook(Book book) throws LibraryException {

        // Invalid Book ID
        if (book.getBookId() <= 0) {

            throw new LibraryException("Invalid Book ID.");
        }

        // Empty Title
        if (book.getTitle().trim().isEmpty()) {

            throw new LibraryException("Book title cannot be empty.");
        }

        // Empty Author
        if (book.getAuthor().trim().isEmpty()) {

            throw new LibraryException("Author name cannot be empty.");
        }

        // Duplicate Book ID
        for (Book b : books) {

            if (b.getBookId() == book.getBookId()) {

                throw new LibraryException("Book ID already exists.");
            }
        }

        books.add(book);

        System.out.println("Book added successfully.");
    }

    // Add User
    public void addUser(User user) throws LibraryException {

        // Invalid User ID
        if (user.getUserId() <= 0) {

            throw new LibraryException("Invalid User ID.");
        }

        // Empty User Name
        if (user.getName().trim().isEmpty()) {

            throw new LibraryException("User name cannot be empty.");
        }

        // Duplicate User ID
        if (users.containsKey(user.getUserId())) {

            throw new LibraryException("User ID already exists.");
        }

        users.put(user.getUserId(), user);

        System.out.println("User added successfully.");
    }

    // Display Books using Stream API and Lambda Expression
    public void displayBooks() {

        if (books.isEmpty()) {

            System.out.println("\nNo books available in library.");
            return;
        }

        System.out.println("\nBooks Available in Library:");

        books.stream()
                .forEach(book -> System.out.println(book));
    }

    // Borrow Book
    public void borrowBook(int bookId) throws LibraryException {

        Book foundBook = books.stream()
                .filter(book -> book.getBookId() == bookId)
                .findFirst()
                .orElse(null);

        // Book Not Found
        if (foundBook == null) {

            throw new LibraryException("Book not found.");
        }

        // Already Borrowed
        if (!foundBook.isAvailable()) {

            throw new LibraryException("Book already borrowed.");
        }

        foundBook.setAvailable(false);

        System.out.println("Book borrowed successfully.");
    }

    // Return Book
    public void returnBook(int bookId) throws LibraryException {

        Book foundBook = books.stream()
                .filter(book -> book.getBookId() == bookId)
                .findFirst()
                .orElse(null);

        // Book Not Found
        if (foundBook == null) {

            throw new LibraryException("Book not found.");
        }

        // Book Was Not Borrowed
        if (foundBook.isAvailable()) {

            throw new LibraryException("Book was not borrowed.");
        }

        foundBook.setAvailable(true);

        System.out.println("Book returned successfully.");
    }
}