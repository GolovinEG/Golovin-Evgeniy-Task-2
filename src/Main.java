import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final StudentReader reader = new StudentReader("data.txt");
        final List<Student> studentList = reader.readStudents();
        System.out.println(studentList.stream().peek(System.out::println)
                .flatMap(data -> data.getBookList().stream())
                .sorted(Comparator.comparingInt(Book::getPageCount))
                .distinct()
                .filter(data -> data.getReleaseYear() > 2000)
                .limit(3)
                .map(data -> String.format("Release year: %d", data.getReleaseYear()))
                .findAny().orElse("No book found"));
    }
}
