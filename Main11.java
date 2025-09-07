import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return isBorrowed; }
    public void borrow() { isBorrowed = true; }
    public void returned() { isBorrowed = false; }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}

class LibraryMember {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;

    public LibraryMember(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getMemberId() { return memberId; }
    public void borrowBook(Book book) { borrowedBooks.add(book); book.borrow(); }
    public void returnBook(Book book) { borrowedBooks.remove(book); book.returned(); }
}

class Library {
    private List<Book> books = new ArrayList<>();
    private List<LibraryMember> members = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void addMember(LibraryMember member) { members.add(member); }

    private Book findBook(String isbn) {
        for (Book b : books) if (b.getIsbn().equals(isbn)) return b;
        return null;
    }

    private LibraryMember findMember(String memberId) {
        for (LibraryMember m : members) if (m.getMemberId().equals(memberId)) return m;
        return null;
    }

    public void borrowBook(String memberId, String isbn) {
        LibraryMember member = findMember(memberId);
        Book book = findBook(isbn);
        if (member != null && book != null && !book.isBorrowed()) {
            member.borrowBook(book);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        } else System.out.println("Cannot borrow book.");
    }

    public void returnBook(String memberId, String isbn) {
        LibraryMember member = findMember(memberId);
        Book book = findBook(isbn);
        if (member != null && book != null && book.isBorrowed()) {
            member.returnBook(book);
            System.out.println(member.getName() + " returned " + book.getTitle());
        } else System.out.println("Cannot return book.");
    }

    public void displayBooks() {
        System.out.println("Books in Library:");
        for (Book b : books)
            System.out.println(b + (b.isBorrowed() ? " [Borrowed]" : ""));
    }

    public void displayMembers() {
        System.out.println("Library Members:");
        for (LibraryMember m : members)
            System.out.println(m.getName() + " (ID: " + m.getMemberId() + ")");
    }
}

public class Main11 {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Alchemist", "Paulo Coelho", "ISBN001");
        Book book2 = new Book("1984", "George Orwell", "ISBN002");
        Book book3 = new Book("Clean Code", "Robert Martin", "ISBN003");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        LibraryMember member1 = new LibraryMember("Alice", "M001");
        LibraryMember member2 = new LibraryMember("Bob", "M002");

        library.addMember(member1);
        library.addMember(member2);

        library.displayBooks();
        library.displayMembers();

        library.borrowBook("M001", "ISBN001");
        library.borrowBook("M002", "ISBN001");
        library.borrowBook("M002", "ISBN003");

        library.displayBooks();

        library.returnBook("M001", "ISBN001");
        library.displayBooks();
    }
}