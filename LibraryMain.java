import java.util.ArrayList;
import java.util.Scanner;

class Book3 {
    private String title;
    private String author;
    private int publicationYear;

    public Book3(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() { return title; }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (" + publicationYear + ")";
    }
}

class User {
    String name;
    ArrayList<Book3> borrowedBooks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }
}

class Library {
    ArrayList<Book3> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    public void addBook(Book3 book) { books.add(book); }
    public void addUser(User user) { users.add(user); }

    public void displayBooks() {
        if (books.isEmpty()) System.out.println("No books in library.");
        else books.forEach(System.out::println);
    }

    public void borrowBook(String title, User user) {
        for (Book3 book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                user.borrowedBooks.add(book);
                System.out.println(user.name + " borrowed " + book);
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String title, User user) {
        for (Book3 book : user.borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                user.borrowedBooks.remove(book);
                books.add(book);
                System.out.println(user.name + " returned " + book);
                return;
            }
        }
        System.out.println(user.name + " did not borrow this book.");
    }
}

public class LibraryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Add book\n2. Add user\n3. Display books\n4. Borrow book\n5. Return book\n6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter book title:");
                    String title = sc.nextLine();
                    System.out.println("Enter author:");
                    String author = sc.nextLine();
                    System.out.println("Enter publication year:");
                    int year = sc.nextInt();
                    sc.nextLine();
                    library.addBook(new Book3(title, author, year));
                }
                case 2 -> {
                    System.out.println("Enter user name:");
                    String name = sc.nextLine();
                    library.addUser(new User(name));
                }
                case 3 -> library.displayBooks();
                case 4 -> {
                    System.out.println("Enter user name:");
                    String uname = sc.nextLine();
                    User user = library.users.stream().filter(u -> u.name.equalsIgnoreCase(uname)).findFirst().orElse(null);
                    if (user != null) {
                        System.out.println("Enter book title to borrow:");
                        String title = sc.nextLine();
                        library.borrowBook(title, user);
                    } else System.out.println("User not found.");
                }
                case 5 -> {
                    System.out.println("Enter user name:");
                    String uname = sc.nextLine();
                    User user = library.users.stream().filter(u -> u.name.equalsIgnoreCase(uname)).findFirst().orElse(null);
                    if (user != null) {
                        System.out.println("Enter book title to return:");
                        String title = sc.nextLine();
                        library.returnBook(title, user);
                    } else System.out.println("User not found.");
                }
                case 6 -> exit = true;
                default -> System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}