package hus.oop.finalexam.mybookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        testOriginalData();
        testSortPagesOfBookIncreasing();
        testSortPagesOfBookDecreasing();
        testPriceOfBooksIncreasing();
        testPriceOfBooksDecreasing();
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
        String filePath = "/home/dangth2004/Programming/Java/src/hus/oop/finalexam/mybookmanager/books.csv";
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
        /* TODO */
        System.out.println("Test sort pages of book increasing:");
        MyList books = BookManager.getInstance().sortPagesIncreasing();
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testSortPagesOfBookDecreasing() {
        /* TODO */
        System.out.println("Test sort pages of book decreasing:");
        MyList books = BookManager.getInstance().sortPagesDecreasing();
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testPriceOfBooksIncreasing() {
        /* TODO */
        System.out.println("Test sort price of book increasing:");
        MyList books = BookManager.getInstance().sortPriceIncreasing();
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testPriceOfBooksDecreasing() {
        /* TODO */
        System.out.println("Test sort price of book decreasing:");
        MyList books = BookManager.getInstance().sortPriceDecreasing();
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testFilterBooksOfAuthor(String author) {
        /* TODO */
        System.out.println("Test filter books of author: " + author);
        MyList books = BookManager.getInstance().filterBooksOfAuthor(author);
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testFilterBooksOfPublisher(String publisher) {
        /* TODO */
        System.out.println("Test filter books of publisher: " + publisher);
        MyList books = BookManager.getInstance().filterBooksOfPublisher(publisher);
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }

    public static void testFilterBooksOfGenre(String genre) {
        /* TODO */
        System.out.println("Test filter books of genre: " + genre);
        MyList books = BookManager.getInstance().filterBooksOfGenre(genre);
        String bookTitlesString = BookManager.getInstance().titleOfBooksToString(books);
        System.out.println(bookTitlesString);
        System.out.println();
    }
}
