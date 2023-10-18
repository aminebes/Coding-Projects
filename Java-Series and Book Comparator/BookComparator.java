import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    // Implement the comparator method for books.
	
	public int compare(Book b1, Book b2) {
        int authorComparison = b1.getAuthor().compareTo(b2.getAuthor());
        if (authorComparison != 0) {
            return authorComparison;
        }

        int titleComparison = b1.getTitle().compareTo(b2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }

        return Integer.compare(b1.getYear(), b2.getYear());
    }

}