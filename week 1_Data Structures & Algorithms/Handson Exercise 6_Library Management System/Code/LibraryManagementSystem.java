import java.util.Arrays;
import java.util.Comparator;
public class LibraryManagementSystem {
    static class Book {
        int bookId;
        String title;
        String author;
        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }
        @Override
        public String toString() {
            return bookId + " - " + title + " by " + author;
        }
    }
    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }
    public static Book binarySearch(Book[] books, String targetTitle) {
        int low = 0, high = books.length - 1;
        targetTitle = targetTitle.toLowerCase();
        while (low <= high) {
            int mid = (low + high) / 2;
            String midTitle = books[mid].title.toLowerCase();
            int comparison = midTitle.compareTo(targetTitle);
            if (comparison == 0) return books[mid];
            else if (comparison < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
    public static void displayBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "Data Structures", "Mark Allen"),
            new Book(102, "Java Programming", "Herbert Schildt"),
            new Book(103, "Operating Systems", "Galvin"),
            new Book(104, "Computer Networks", "Tanenbaum"),
            new Book(105, "Artificial Intelligence", "Stuart Russell")
        };
        System.out.println("All Books:");
        displayBooks(books);
        System.out.println("\nLinear Search for 'Java Programming':");
        Book found1 = linearSearch(books, "Java Programming");
        System.out.println(found1 != null ? "Found: " + found1 : "Book not found.");
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));
        System.out.println("\nBinary Search for 'Java Programming':");
        Book found2 = binarySearch(books, "Java Programming");
        System.out.println(found2 != null ? "Found: " + found2 : "Book not found.");
    }
}
