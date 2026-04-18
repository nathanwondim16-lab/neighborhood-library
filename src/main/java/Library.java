import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
public class Library {
    //Loading bar
    static final char[] loadingBar = {'⠋','⠙','⠹','⠸','⠼','⠴','⠦','⠧','⠇','⠏'}; // Loading bar generated with assistance from ChatGPT (OpenAI)

    // Book inventory
    static Book[][] inventory = {
            {new Book(1, "978-0061120084", "\033[1m\033[4mTo Kill a Mockingbird\033[0m")},
            {new Book(2,  "978-0451524935", "\033[1m\033[4m1984\033[0m")},
            {new Book(3,  "978-0743273565", "\033[1m\033[4mThe Great Gatsby\033[0m")},
            {new Book(4,  "978-0141439518", "\033[1m\033[4mPride and Prejudice\033[0m")},
            {new Book(5,  "978-0062315007", "\033[1m\033[4mThe Alchemist\033[0m")},
            {new Book(6,  "978-0307277671", "\033[1m\033[4mThe Road\033[0m")},
            {new Book(7,  "978-0544003415", "\033[1m\033[4mThe Hobbit\033[0m")},
            {new Book(8,  "978-0618640157", "\033[1m\033[4mThe Lord of the Rings\033[0m")},
            {new Book(9,  "978-0060850524", "\033[1m\033[4mBrave New World\033[0m")},
            {new Book(10, "978-0140449136", "\033[1m\033[4mCrime and Punishment\033[0m")},
            {new Book(11, "978-0307387899", "\033[1m\033[4mThe Kite Runner\033[0m")},
            {new Book(12, "978-0385472579", "\033[1m\033[4mZen and the Art of Motorcycle Maintenance\033[0m")},
            {new Book(13, "978-0679783268", "\033[1m\033[4mPride and Prejudice and Zombies\033[0m")},
            {new Book(14, "978-1400033416", "\033[1m\033[4mLife of Pi\033[0m")},
            {new Book(15, "978-0439139601", "\033[1m\033[4mHarry Potter and the Goblet of Fire\033[0m")},
            {new Book(16, "978-0439064873", "\033[1m\033[4mHarry Potter and the Chamber of Secrets\033[0m")},
            {new Book(17, "978-0439554930", "\033[1m\033[4mHarry Potter and the Sorcerer’s Stone\033[0m")},
            {new Book(18, "978-0316769488", "\033[1m\033[4mThe Catcher in the Rye\033[0m")},
            {new Book(19, "978-0060850524", "\033[1m\033[4mFahrenheit 451\033[0m")},
            {new Book(20, "978-0061122415", "\033[1m\033[4mAnimal Farm\033[0m")},
    };

    public static void main(String[] args) throws InterruptedException {

        // Creating scanner object to get user input.
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to Sno-Isle Libraries");
        int userChoice;

        do {
            System.out.println("-----------------------------------");
            System.out.println("1) Show Available Books");
            System.out.println("2) Show Checked Out Books");
            System.out.println("3) Checkout a book");
            System.out.println("4) Check in a book");
            System.out.println("5) Exit");
            System.out.println("-----------------------------------");
            System.out.print("\n\nSelect an option: ");
            userChoice = Integer.parseInt(scanner.nextLine()); // Stores the option the user selected

            switch(userChoice) {
                case 1:
                    loading();
                    displayAvailableBooks();
                    break;
                case 2:
                    loading();
                    displayCheckedOutBooks(inventory);
                    break;
                case 3:
                    loading();
                    checkout();
                    break;
                case 4:
                    // Add check in method here
                    break;
                case 5:
                    System.out.println("\nGoodbye for now 👋🏾");
                    break;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
        } while(userChoice != 5);
    }

    // Displays available books
    public static void displayAvailableBooks() {
        System.out.println();
        System.out.println("Books Available to be checked out: ");
        for(Book[] books : inventory) {
            for(Book book : books) {
                if(!book.getIsCheckedOut()) {
                    System.out.println(book);
                }

            }
        }
    }

    // Displays books that are checked out
    public static void displayCheckedOutBooks(Book[][] bookInventory) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mma");
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println();
        System.out.println("Checked out books: \n");
        for(Book[] books : inventory) {
            for(Book book : books) {
                if(book.getIsCheckedOut()) {
                    System.out.println(book + " ----> CHECKED OUT on " + date.format(dateFormat) + " at " + time.format(timeFormat) + " by " + book.getCheckedOutTo());
                }

            }
        }
    }

    // Checkout process
    public static void checkout() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the following details: ");
        System.out.print("Book ID: ");
        int bookID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Your name: ");
        String name = scanner.nextLine();
        for (Book[] books : inventory) {
            for (Book book : books) {
                if (book.getId() == bookID && !book.getIsCheckedOut()) {
                    book.checkOut(name);
                } else if (book.getId() == bookID && book.getIsCheckedOut()) {
                    System.out.println("\nSorry, this book has been checked out by someone else");
                }
            }
        }
    }

//    public static void checkIn() {
//
//    }

    // Displays the loading bar when generating information.
    public static void loading() throws InterruptedException {
        for(int i = 0; i < 100; i++) {
            char spinner = loadingBar[i % loadingBar.length]; // Resets back to the first element in the "loadingBar" array
            System.out.print("\rLoading " + spinner);
            Thread.sleep(20);
        }
        System.out.print("\r "); // Removes previous loading bar
    }
}
