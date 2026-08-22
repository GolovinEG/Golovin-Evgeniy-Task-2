import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentReader {
    private final Path path;

    public StudentReader(String pathStr) {
        path = Paths.get(pathStr);
    }

    public List<Student> readStudents() {
        final List<String> dataList;
        final int splitIndex;
        final List<Book> bookList = new ArrayList<>();
        final List<Student> studentList = new ArrayList<>();
        try {
            dataList = Files.readAllLines(path);
            splitIndex = dataList.indexOf("##STUDENTS##");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dataList.subList(0, splitIndex).forEach(dataStr -> bookList.add(new Book(dataStr)));
        dataList.subList(splitIndex + 1, dataList.size()).forEach(dataStr -> {
            final String[] splitData = dataStr.split("\t");
            final List<Book> studentBooks = new ArrayList<>();
            assert splitData.length == 2 : "Wrong data length";
            Arrays.stream(splitData[1].split(","))
                    .forEach(strIndex -> studentBooks.add(bookList.get(Integer.parseInt(strIndex))));
            studentList.add(new Student(splitData[0], studentBooks));
        });
        return studentList;
    }
}
