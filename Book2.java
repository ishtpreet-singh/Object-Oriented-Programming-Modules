import java.util.ArrayList;
import java.util.Scanner;

public class Book2 {
    private String title;
    private String author;
    private int publicationYear;

    public Book2(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }

    @Override
    public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + publicationYear;
    }

    static class Library {
        private ArrayList<Book2> books = new ArrayList<>();

        public void addBook(Book2 book) {
            books.add(book);
        }

        public void displayBooks() {
            int i = 1;
            for (Book2 book : books) {
                System.out.println(i + ". " + book);
                i++;
            }
        }

        public void findBooksByAuthor(String author) {
            boolean found = false;
            System.out.println("Books by Author \"" + author + "\":");
            for (Book2 book : books) {
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    System.out.println("Title: \"" + book.getTitle() + "\", Year: " + book.getPublicationYear());
                    found = true;
                }
            }
            if (!found) System.out.println("No books found by this author.");
        }

        public void borrowBook(String title) {
            for (Book2 book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    books.remove(book);
                    System.out.println("You have borrowed: " + book.getTitle());
                    return;
                }
            }
            System.out.println("Book \"" + title + "\" is not available.");
        }

        public void returnBook(Book2 book) {
            books.add(book);
            System.out.println("You have returned: " + book.getTitle());
        }

        public boolean isBookAvailable(String title) {
            for (Book2 book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.println("Enter the number of books to add:");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("Enter title of book " + (i + 1) + ":");
            String title = scanner.nextLine();
            System.out.println("Enter author of book " + (i + 1) + ":");
            String author = scanner.nextLine();
            System.out.println("Enter publication year of book " + (i + 1) + ":");
            int year = scanner.nextInt();
            scanner.nextLine(); 

            Book2 book = new Book2(title, author, year);
            library.addBook(book);
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:\n1. Display all books\n2. Borrow a book\n3. Return a book\n4. Find books by author\n5. Check book availability\n6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> library.displayBooks();
                case 2 -> {
                    System.out.println("Enter title to borrow:");
                    String title = scanner.nextLine();
                    library.borrowBook(title);
                }
                case 3 -> {
                    System.out.println("Enter title to return:");
                    String title = scanner.nextLine();
                    System.out.println("Enter author:");
                    String author = scanner.nextLine();
                    System.out.println("Enter publication year:");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    Book2 book = new Book2(title, author, year);
                    library.returnBook(book);
                }
                case 4 -> {
                    System.out.println("Enter author to search:");
                    String author = scanner.nextLine();
                    library.findBooksByAuthor(author);
                }
                case 5 -> {
                    System.out.println("Enter title to check availability:");
                    String title = scanner.nextLine();
                    if (library.isBookAvailable(title)) {
                        System.out.println("Book \"" + title + "\" is available.");
                    } else {
                        System.out.println("Book \"" + title + "\" is not available.");
                    }
                }
                case 6 -> exit = true;
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}