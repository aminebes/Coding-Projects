public class Book {

    // 	Variables declaration here
    private String author;
    private String title;
    private int year;

    public Book (String author, String title, int year) {
        this.author=author;
        this.title=title;
        this.year=year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Object other) {
        if(this==other) return true;
        if ((other instanceof Book)==false) return false;
        Book otherBook = (Book) other;
        if(this.getAuthor()==null && otherBook.getAuthor()!=null || this.getAuthor()!=null && otherBook.getAuthor()==null){
            return false;
        }
        if(this.getTitle()==null && otherBook.getTitle()!=null || this.getTitle()!=null && otherBook.getTitle()==null){
            return false;
        }

        if ((this.getAuthor()==null && otherBook.getAuthor()!=null )){
            return this.getTitle().equals(otherBook.getTitle())&&this.getYear()==otherBook.getYear();
        }
        if ((this.getTitle()==null && otherBook.getTitle()!=null )){
            return this.getAuthor().equals(otherBook.getAuthor())&&this.getYear()==otherBook.getYear();
        }
        if(this.getAuthor()==null && otherBook.getAuthor()==null) {
            return this.getTitle().equals(otherBook.getTitle())&&this.getYear()==otherBook.getYear();
        }

        if(this.getTitle()==null && otherBook.getTitle()==null ){
            return this.getAuthor().equals(otherBook.getAuthor())&&this.getYear()==otherBook.getYear();
        }
        int comparison = this.getAuthor().compareTo(otherBook.getAuthor());
        if (comparison == 0) {
            comparison = this.getTitle().compareTo(otherBook.getTitle());
            if (comparison == 0) {
                comparison = Integer.compare(this.getYear(), otherBook.getYear());
            }
        }

        return comparison==0;

    }


    public String toString() {
        return author+":"+title+"("+year+")";
    }
}
