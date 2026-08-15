import java.util.List;
import java.util.LinkedList;

public class Student {
    final private String name;
    final private List<Book> bookList;

    public Student(String name, List<Book> bookList) {
        this.name = name;
        this.bookList = new LinkedList<>(bookList);
    }

    public String getName() {
        return name;
    }

    public List<Book> getBookList() {
        return new LinkedList<>(bookList);
    }

    @Override
    public String toString() {
        return String.format("Student: %s", name);
    }
}
