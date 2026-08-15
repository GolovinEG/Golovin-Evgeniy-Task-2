public class Book {
    final private String name;
    final private int pageCount;
    final private int releaseYear;

    public Book(String name, int pageCount, int releaseYear) {
        this.name = name;
        this.pageCount = pageCount;
        this.releaseYear = releaseYear;
    }

    public Book(String data) {
        String[] splitData = data.split("\t"); //name, pageCount, releaseYear
        assert splitData.length == 3 : "Wrong data length";
        this.name = splitData[0];
        this.pageCount = Integer.parseInt(splitData[1]);
        this.releaseYear = Integer.parseInt(splitData[2]);
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
