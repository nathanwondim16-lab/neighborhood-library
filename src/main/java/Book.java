public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Default constructor
    public Book() {
        
    }

    public Book(int bookId, String bookIsbn, String bookTitle) {
        id = bookId;
        title = bookTitle;
        isbn = bookIsbn;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

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
