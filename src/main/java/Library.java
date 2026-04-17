import java.util.Scanner;
public class Library {
    static final char[] spinner = {'⠋','⠙','⠹','⠸','⠼','⠴','⠦','⠧','⠇','⠏'}; // Loading bar generated with assistance from ChatGPT (OpenAI)
    public static void main(String[] args) throws InterruptedException {
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
        int userChoice;

        do {
            System.out.println("-----------------------------------");
            System.out.println("1) Show Available Books");
            System.out.println("2) Show Checked Out Books");
            System.out.println("3) Exit");
            System.out.println("-----------------------------------");
            System.out.print("\n\nSelect an option: ");
            userChoice = Integer.parseInt(scanner.nextLine());

            switch(userChoice) {
                case 1:
                    for(int i = 0; i < 100; i++) {
                        char frame = spinner[i % spinner.length];
                        System.out.print("\rLoading " + frame);
                        Thread.sleep(50);
                    }
                    System.out.print("\r "); // Removes previous loading bar
                    displayAvailableBooks(inventory);
                    break;
                case 2:
                    //displayCheckedOutBooks(inventory); Method has no implementation yet
                    break;
                case 3:
                    System.out.println("\nGoodbye for now 👋🏾");
                    break;
            }
        } while(userChoice != 3);



    }


    public static void displayAvailableBooks(Book[][] bookInventory) {
        System.out.println();
        System.out.println("Books Available to be checked out: ");
        for(Book[] books : bookInventory) {
            for(Book book : books) {
                if(!book.isCheckedOut()) {
                    System.out.println(book);
                }

            }
        }

    }

    public static void displayCheckedOutBooks(Book[][] bookInventory) {

    }


}
