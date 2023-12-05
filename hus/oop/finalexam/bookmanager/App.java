package hus.oop.finalexam.bookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        testOriginalData();
        testSortPagesOfBookIncreasing();
        testSortPagesOfBookDecreasing();
        testPriceOfBooksIncreasing();
        testPriceOfBooksDecreasing();
        testFilterBooksLowestPrice(5);
        testFilterBooksHighestPrice(5);
        testFilterBooksOfAuthor("Durant Will");
        testFilterBooksOfPublisher("Penguin");
        testFilterBooksOfGenre("computer_science");

        /*
        TODO

        Viết code để test cho tất cả các hàm bên dưới.
        Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
        là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
        nộp lên classroom.
        */
    }

    public static void init() {
        String filePath = "/home/dangth2004/Programming/Java/src/hus/oop/finalexam/bookmanager/books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }

                /*
                TODO

                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào BookManager để quản lý.
                */
                String title = dataList.get(0);
                String author = dataList.get(1);
                String genre = dataList.get(2);
                int pages = Integer.parseInt(dataList.get(3));
                double price = Double.parseDouble(dataList.get(4));
                String publisher = dataList.get(5);

                Book.BookBuilder book = new Book.BookBuilder(title).withAuthor(author).
                        withGenre(genre).withPages(pages).withPrice(price).
                        withPublisher(publisher);
                Book book1 = book.build();

                BookManager.getInstance().append(book1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            Collections.addAll(result, splitData);
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        init();
        System.out.println("Test original data:");
        String bookIds = BookManager.getInstance().
                titleOfBooksToString(BookManager.getInstance().getBookList());
        System.out.println(bookIds);
        System.out.println();
    }

    public static void testSortPagesOfBookIncreasing() {
        System.out.println("Test sort pages of book increasing:");
        List<Book> books = BookManager.getInstance().sortPagesIncreasing();
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testSortPagesOfBookDecreasing() {
        /* TODO */
        System.out.println("Test sort pages of book decreasing:");
        List<Book> books = BookManager.getInstance().sortPagesDecreasing();
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testPriceOfBooksIncreasing() {
        /* TODO */
        System.out.println("Test sort price of book increasing:");
        List<Book> books = BookManager.getInstance().sortPriceIncreasing();
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testPriceOfBooksDecreasing() {
        /* TODO */
        System.out.println("Test sort price of book decreasing:");
        List<Book> books = BookManager.getInstance().sortPriceDecreasing();
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testFilterBooksLowestPrice(int howMany) {
        System.out.println("Test filter " + howMany + " books lowest price:");
        List<Book> books = BookManager.getInstance().filterBooksLowestPrice(howMany);
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testFilterBooksHighestPrice(int howMany) {
        /* TODO */
        System.out.println("Test filter " + howMany + " books highest price:");
        List<Book> books = BookManager.getInstance().filterBooksHighestPrice(howMany);
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testFilterBooksOfAuthor(String author) {
        /* TODO */
        System.out.println("Test filter books of author: " + author);
        List<Book> books = BookManager.getInstance().filterBooksOfAuthor(author);
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testFilterBooksOfPublisher(String publisher) {
        /* TODO */
        System.out.println("Test filter books of publisher: " + publisher);
        List<Book> books = BookManager.getInstance().filterBooksOfPublisher(publisher);
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testFilterBooksOfGenre(String genre) {
        /* TODO */
        System.out.println("Test filter books of genre: " + genre);
        List<Book> books = BookManager.getInstance().filterBooksOfGenre(genre);
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }
}
