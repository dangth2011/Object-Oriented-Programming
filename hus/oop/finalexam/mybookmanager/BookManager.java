package hus.oop.finalexam.mybookmanager;

public class BookManager {
    // Singleton pattern
    private static BookManager instance;

    private final MyList bookList;

    private BookManager() {
        this.bookList = new MyLinkedList();
    }

    public static BookManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public MyList getBookList() {
        /* TODO */
        return this.bookList;
    }

    /**
     * Thêm book vào cuối danh sách.
     *
     * @param book
     */
    public void append(Book book) {
        /* TODO */
        this.bookList.append(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     *
     * @param book
     * @param index
     */
    public void add(Book book, int index) {
        /* TODO */
        this.bookList.insert(book, index);
    }

    /**
     * Xóa book ở vị trí index.
     *
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        this.bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     *
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        return (Book) this.bookList.get(index);
    }

    /**
     * Sắp xếp danh sách book theo thứ tự số trang tăng dần.
     *
     * @return
     */
    public MyList sortPagesIncreasing() {
        /* TODO */
        for (int i = 0; i < this.bookList.size() - 1; i++) {
            for (int j = i + 1; j < this.bookList.size(); j++) {
                if (bookAt(i).getPages() > bookAt(j).getPages()) {
                    Book book = bookAt(i);
                    this.bookList.set(bookAt(j), i);
                    this.bookList.set(book, j);
                }
            }
        }
        return this.bookList;
    }

    /**
     * Sắp xếp book theo thứ tự số trang giảm dần.
     *
     * @return
     */
    public MyList sortPagesDecreasing() {
        /* TODO */
        for (int i = 0; i < this.bookList.size() - 1; i++) {
            for (int j = i + 1; j < this.bookList.size(); j++) {
                if (bookAt(i).getPages() < bookAt(j).getPages()) {
                    Book book = bookAt(i);
                    this.bookList.set(bookAt(j), i);
                    this.bookList.set(book, j);
                }
            }
        }
        return this.bookList;
    }

    /**
     * Sắp xếp sách theo thứ tự giá tăng dần.
     *
     * @return
     */
    public MyList sortPriceIncreasing() {
        /* TODO */
        for (int i = 0; i < this.bookList.size() - 1; i++) {
            for (int j = i + 1; j < this.bookList.size(); j++) {
                if (bookAt(i).getPrice() > bookAt(j).getPrice()) {
                    Book book = bookAt(i);
                    this.bookList.set(bookAt(j), i);
                    this.bookList.set(book, j);
                }
            }
        }
        return this.bookList;
    }

    /**
     * Sắp xếp sách theo thứ tự giá giảm dần.
     *
     * @return
     */
    public MyList sortPriceDecreasing() {
        /* TODO */
        for (int i = 0; i < this.bookList.size() - 1; i++) {
            for (int j = i + 1; j < this.bookList.size(); j++) {
                if (bookAt(i).getPrice() < bookAt(j).getPrice()) {
                    Book book = bookAt(i);
                    this.bookList.set(bookAt(j), i);
                    this.bookList.set(book, j);
                }
            }
        }
        return this.bookList;
    }

    /**
     * Lọc ra những sách theo nhà xuất bản.
     *
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        /* TODO */
        MyList booksWithPublisher = new MyArrayList();
        for (int index = 0; index < this.bookList.size(); index++) {
            if (bookAt(index).getPublisher().equals(publisher)) {
                booksWithPublisher.append(bookAt(index));
            }
        }
        return booksWithPublisher;
    }

    /**
     * Lọc ra những sách theo thể loại.
     *
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        /* TODO */
        MyList booksWithGenre = new MyArrayList();
        for (int index = 0; index < this.bookList.size(); index++) {
            if (bookAt(index).getGenre().equals(genre)) {
                booksWithGenre.append(bookAt(index));
            }
        }
        return booksWithGenre;
    }

    /**
     * Lọc ra những sách theo tác giả.
     *
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        /* TODO */
        MyList booksWithAuthor = new MyArrayList();
        for (int index = 0; index < this.bookList.size(); index++) {
            if (bookAt(index).getAuthor().equals(author)) {
                booksWithAuthor.append(bookAt(index));
            }
        }
        return booksWithAuthor;
    }

    public static String titleOfBooksToString(MyList bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(MyList bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}