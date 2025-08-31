import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + publicationYear;
    }

    static class Library {
        private ArrayList<Book> books = new ArrayList<>();

        public void addBook(Book book) {
            books.add(book);
        }

        public void displayBooks() {
            int i = 1;
            for (Book book : books) {
                System.out.println(i + ". " + book);
                i++;
            }
        }

        public void findBooksByAuthor(String author) {
            boolean found = false;
            System.out.println("Books by Author \"" + author + "\":");
            for (Book book : books) {
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    System.out.println("Title: \"" + book.getTitle() + "\", Year: " + book.getPublicationYear());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No books found by this author.");
            }
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

            Book book = new Book(title, author, year);
            library.addBook(book);
        }

        System.out.println("\nAll books in the library:");
        library.displayBooks();

        System.out.println("\nEnter author to search for:");
        String searchAuthor = scanner.nextLine();
        library.findBooksByAuthor(searchAuthor);

        scanner.close();
    }
}