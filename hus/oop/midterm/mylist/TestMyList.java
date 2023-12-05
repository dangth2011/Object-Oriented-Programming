package hus.oop.midterm.mylist;

public class TestMyList {
    public static void main(String[] args) {
        /*
         * TODO
         * Chạy demo các hàm test.
         * Lưu kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_MyList>.txt
         * (ví dụ, NguyenVanA_123456_MyList.txt)
         */
        testMyArrayList();
        System.out.println();
        testMyLinkedList();
    }

    public static void testMyArrayList() {
        /*
         * TODO
         * Tạo ra một list kiểu MyArrayList có các phần tử dữ liệu kiểu Double.
         * Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
         * In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
         */
        System.out.println("Using ArrayList:");
        MyList arrayList = new MyArrayList();
        arrayList.append((double) 3);
        arrayList.append((double) 4);
        arrayList.append((double) 5);
        arrayList.append((double) 6);
        arrayList.append((double) 7);
        BasicStatistic basicStatistic = new BasicStatistic(arrayList);

        System.out.println(arrayList);

        System.out.printf("Max is: %.2f\n", basicStatistic.max());
        System.out.printf("Min is: %.2f\n", basicStatistic.min());
        System.out.printf("Mean is: %.2f\n", basicStatistic.mean());
        System.out.printf("Variance is: %.2f\n", basicStatistic.variance());
    }

    public static void testMyLinkedList() {
        /*
         * TODO
         * Tạo ra một list kiểu MyLinkedList có các phần tử dữ liệu kiểu Double.
         * Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
         * In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
         */
        System.out.println("Using LinkedList:");
        MyList linkedList = new MyLinkedList();
        linkedList.append((double) 3);
        linkedList.append((double) 4);
        linkedList.append((double) 5);
        linkedList.append((double) 6);
        linkedList.append((double) 7);
        BasicStatistic basicStatistic = new BasicStatistic(linkedList);

        System.out.println(linkedList);

        System.out.printf("Max is: %.2f\n", basicStatistic.max());
        System.out.printf("Min is: %.2f\n", basicStatistic.min());
        System.out.printf("Mean is: %.2f\n", basicStatistic.mean());
        System.out.printf("Variance is: %.2f\n", basicStatistic.variance());
    }
}