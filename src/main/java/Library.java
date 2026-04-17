import java.util.Scanner;
public class Library {
    //Loading bar
    static final char[] loadingBar = {'⠋','⠙','⠹','⠸','⠼','⠴','⠦','⠧','⠇','⠏'}; // Loading bar generated with assistance from ChatGPT (OpenAI)

    // Book inventory
    static Book[][] inventory = {
            {new Book(1, "978-0061120084", "To Kill a Mockingbird")},
            {new Book(2,  "978-0451524935", "1984")},
            {new Book(3,  "978-0743273565", "The Great Gatsby")},
            {new Book(4,  "978-0141439518", "Pride and Prejudice")},
            {new Book(5,  "978-0062315007", "The Alchemist")},
            {new Book(6,  "978-0307277671", "The Road")},
            {new Book(7,  "978-0544003415", "The Hobbit")},
            {new Book(8,  "978-0618640157", "The Lord of the Rings")},
            {new Book(9,  "978-0060850524", "Brave New World")},
            {new Book(10, "978-0140449136", "Crime and Punishment")},
            {new Book(11, "978-0307387899", "The Kite Runner")},
            {new Book(12, "978-0385472579", "Zen and the Art of Motorcycle Maintenance")},
            {new Book(13, "978-0679783268", "Pride and Prejudice and Zombies")},
            {new Book(14, "978-1400033416", "Life of Pi")},
            {new Book(15, "978-0439139601", "Harry Potter and the Goblet of Fire")},
            {new Book(16, "978-0439064873", "Harry Potter and the Chamber of Secrets")},
            {new Book(17, "978-0439554930", "Harry Potter and the Sorcerer’s Stone")},
            {new Book(18, "978-0316769488", "The Catcher in the Rye")},
            {new Book(19, "978-0060850524", "Fahrenheit 451")},
            {new Book(20, "978-0061122415", "Animal Farm")},
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
            System.out.println("3) Exit");
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
                    System.out.println("\nGoodbye for now 👋🏾");
                    break;
            }

            if(userChoice != 3) {
                System.out.print("\nWould you like to checkout a book? ");
                String checkInBook = scanner.nextLine();
                if(checkInBook.equalsIgnoreCase("yes")) {
                    System.out.println("Please provide the following details: ");
                    System.out.print("Book ID: ");
                    int id = scanner.nextInt(); // stores the ID of the book
                    scanner.nextLine();
                    checkout(id); // passes in the ID of the book the user wants to checkout
                    // Add code that adds that book they checked in back into the inventory array.
                }
            }
        } while(userChoice != 3);



    }

    // Displays available books
    public static void displayAvailableBooks() {
        System.out.println();
        System.out.println("Books Available to be checked out: ");
        for(Book[] books : inventory) {
            for(Book book : books) {
                if(!book.isCheckedOut()) {
                    System.out.println(book);
                }

            }
        }
    }

    // Displays books that are checked out
    public static void displayCheckedOutBooks(Book[][] bookInventory) {
        System.out.println();
        System.out.println("Books that are checked out: \n");
        for(Book[] books : inventory) {
            for(Book book : books) {
                if(book.isCheckedOut()) {
                    System.out.println(book);
                }

            }
        }
    }

    // Checkout process
    public static void checkout(int bookId) {
        for(int i = 0; i < inventory.length; i++) {
            for(int j = 0; j < inventory[i].length; j++) {
                if(inventory[i][j].getId() == bookId) {
                    inventory[i][j].setCheckedOut(true);
                }
            }
        }
    }


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
