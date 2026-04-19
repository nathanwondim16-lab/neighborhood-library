public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Default constructor
    public Book() {
        checkedOutTo = "";
        isCheckedOut = false;
    }

    // Constructor with args
    public Book(int bookId, String bookIsbn, String bookTitle) {
        id = bookId;
        title = bookTitle;
        isbn = bookIsbn;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getISBN() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }


    // Setter methods
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Behavioral methods
    public void checkOut(String name) {
        isCheckedOut = true;
        checkedOutTo = name;
    }

    public void checkIn() {
        checkedOutTo = "";
        isCheckedOut = false;
    }

    public String toString() {
        return "Book ID: " + id + "| ISBN: " + isbn + "| Title: " + title;
    }
}
