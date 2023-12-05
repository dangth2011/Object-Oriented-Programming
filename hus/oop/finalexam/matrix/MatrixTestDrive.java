package hus.oop.finalexam.matrix;

import java.util.Arrays;

public class MatrixTestDrive {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận vuông có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Các phần tử của ma trận được khởi tạo ngẫu nhiên có giá trị nằm trong đoạn [1, 10].

        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - Tìm và in ra một ma trận dạng hình thang theo hàng (row echelon form) dùng phép khử Gauss của 2 ma trận.
          - Tìm và in ra ma trận dạng hình thang theo hàng rút gọn (reduced row echelon form) dùng phép khử Gauss-Jordan.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */
        
        int max = 10;
        int min = 5;
        int range = max - min + 1;
        int size = (int) (Math.random() * range) + min;

        SquareMatrix matrix1 = new SquareMatrix(size);
        SquareMatrix matrix2 = new SquareMatrix(size);

        System.out.println("Ma trận 1:");
        System.out.println(matrix1);
        System.out.println();
        System.out.println("Ma trận chuyển vị tương ứng: ");
        System.out.println(matrix1.transpose().toString());
        System.out.println();

        System.out.println("Ma trận 2:");
        System.out.println(matrix2);
        System.out.println();
        System.out.println("Ma trận chuyển vị tương ứng: ");
        System.out.println(matrix2.transpose().toString());
        System.out.println();

        System.out.println("Đường chéo chính ma trận 1: ");
        double[] principalDiagonal1 = matrix1.principalDiagonal();
        for (double number : principalDiagonal1) {
            System.out.printf("%.2f ", number);
        }
        System.out.println();
        System.out.println("Đường chéo phụ ma trận 1: ");
        double[] secondaryDiagonal1 = matrix1.secondaryDiagonal();
        for (double number : secondaryDiagonal1) {
            System.out.printf("%.2f ", number);
        }
        System.out.println();
        System.out.println();

        System.out.println("Đường chéo chính ma trận 2: ");
        double[] principalDiagonal2 = matrix2.principalDiagonal();
        for (double number : principalDiagonal2) {
            System.out.printf("%.2f ", number);
        }
        System.out.println();
        System.out.println("Đường chéo phụ ma trận 2: ");
        double[] secondaryDiagonal2 = matrix2.secondaryDiagonal();
        for (double number : secondaryDiagonal2) {
            System.out.printf("%.2f ", number);
        }
        System.out.println();

        System.out.println("Ma trận tổng của 2 ma trận: ");
        System.out.println(matrix1.add(matrix2).toString());
        System.out.println();

        System.out.println("Ma trận hiệu của ma trận thứ nhất cho ma trận thứ 2: ");
        System.out.println(matrix1.minus(matrix2).toString());
        System.out.println();

        System.out.println("Ma trận tích của 2 ma trận: ");
        System.out.println(matrix1.multiply(matrix2).toString());
        System.out.println();

        System.out.println("Ma trận dạng hình thang theo hàng dùng phép khử Gauss của ma trận 1: ");
        System.out.println(matrix1.gaussianElimination().toString());
        System.out.println();

        System.out.println("Ma trận dạng hình thang theo hàng dùng phép khử Gauss của ma trận 2: ");
        System.out.println(matrix2.gaussianElimination().toString());
        System.out.println();

        System.out.println("Ma trận dạng hình thang theo hàng dùng phép khử Gauss-Jordan của ma trận 1: ");
        System.out.println(matrix1.gaussJordanElimination().toString());
        System.out.println();

        System.out.println("Ma trận dạng hình thang theo hàng dùng phép khử Gauss-Jordan của ma trận 2: ");
        System.out.println(matrix2.gaussJordanElimination().toString());
        System.out.println();
    }
}
