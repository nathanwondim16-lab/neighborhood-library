public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Default constructor
    public Book() {
        id = 0;
        isbn = null;
        title = null;
        isCheckedOut = false;
        checkedOutTo = null;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
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
