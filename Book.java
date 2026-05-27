public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean available;

    // Constructor
    public Book(int bookId, String title, String author) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Getters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Display Book Details
    @Override
    public String toString() {

        return "Book ID: " + bookId +
                ", Title: " + title +
                ", Author: " + author +
                ", Available: " + available;
    }
}