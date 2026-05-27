public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        // Add Valid Books
        try {

            library.addBook(new Book(1, "Java Basics", "James Gosling"));
            library.addBook(new Book(2, "OOP Concepts", "Bjarne Stroustrup"));
            library.addBook(new Book(3, "Data Structures", "Mark Allen"));

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        // Invalid Operations for Books
        try {

            // Duplicate Book ID
            library.addBook(new Book(1, "Duplicate Book", "Unknown"));

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        try {

            // Invalid Book ID
            library.addBook(new Book(-5, "Invalid ID Book", "Author"));

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        try {

            // Empty Title
            library.addBook(new Book(4, "", "Author"));

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        // Add Valid Users
        try {

            library.addUser(new User(101, "Jaya"));
            library.addUser(new User(102, "Madhuri"));

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        // Invalid Operations for Users
        try {

            // Duplicate User ID
            library.addUser(new User(101, "Duplicate User"));

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        try {

            // Invalid User ID
            library.addUser(new User(-10, "Invalid User"));

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        try {

            // Empty User Name
            library.addUser(new User(103, ""));

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        // Display Books
        library.displayBooks();

        // Borrow Book
        try {

            library.borrowBook(1);

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        // Invalid Borrow Operations
        try {

            // Borrow Same Book Again
            library.borrowBook(1);

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        try {

            // Borrow Non-Existing Book
            library.borrowBook(99);

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        // Return Book
        try {

            library.returnBook(1);

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        // Invalid Return Operations
        try {

            // Return Same Book Again
            library.returnBook(1);

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        try {

            // Return Non-Existing Book
            library.returnBook(100);

        } catch (LibraryException e) {

            System.out.println("Error: " + e.getMessage());
        }

        // Final Display
        library.displayBooks();
    }
}