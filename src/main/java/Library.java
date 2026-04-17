import java.util.Scanner;
public class Library {
    public static void main(String[] args) {
        Book[][] inventory = {
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

        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to Sno-Isle Libraries");
        String userChoice;

        do {
            System.out.println("HomePage: ");
            System.out.println("-----------------------------------");
            System.out.println("Show Available Books");
            System.out.println("Show Checked Out Books");
            System.out.println("Exit - closes out of the application");
            System.out.println("-----------------------------------");
            System.out.print("\n\n Select an option: ");
            userChoice = scanner.nextLine();
        } while(!userChoice.equalsIgnoreCase("Exit"));

        displayAvailableBooks(inventory);

    }


    public static void displayAvailableBooks(Book[][] bookInventory) {
        for(Book[] books : bookInventory) {
            for(Book book : books) {
                System.out.println(book);
            }
        }

    }

    public static void displayCheckedOutBooks(Book book) {

    }


}
