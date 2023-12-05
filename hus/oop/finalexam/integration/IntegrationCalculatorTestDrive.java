package hus.oop.finalexam.integration;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
    /*
     TODO

     - Chạy demo các hàm test.
     - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
       (ví dụ, NguyenVanA_123456_Integration.txt)
     - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
     */
        testArrayPolynomial();
        testListPolynomial();
        testIntegrationCalculator();
    }

    public static void testArrayPolynomial() {
    /*
     TODO

     - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
       sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
       giá trị của x).
     */
        System.out.println("Array Polynomial:");

        ArrayPolynomial poly1 = new ArrayPolynomial();
        poly1.append(4);
        poly1.append(5);
        poly1.append(10);
        poly1.set(6, 2);
        poly1.append(2);
        System.out.println("First poly:");
        System.out.println(poly1);

        ArrayPolynomial poly2 = new ArrayPolynomial();
        poly2.append(1);
        poly2.append(5);
        poly2.append(3);
        poly2.set(2, 1);
        System.out.println("Second poly:");
        System.out.println(poly2);

        System.out.println("Add 2 polys:");
        System.out.println(poly1.plus(poly2).toString());

        System.out.println("Minus 2 polys:");
        System.out.println(poly1.minus(poly2).toString());

        System.out.println("Multiply 2 polys:");
        System.out.println(poly1.multiply(poly2).toString());

        System.out.println("Value of first poly with x = 2:");
        System.out.println(poly1.evaluate(2));

        System.out.println("Value of second poly with x = 2:");
        System.out.println(poly2.evaluate(2));
        System.out.println();
    }

    public static void testListPolynomial() {
    /*
     TODO

     - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
       sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
       giá trị của x).
     */
        System.out.println("List Polynomial:");

        ListPolynomial poly1 = new ListPolynomial();
        poly1.append(4);
        poly1.append(5);
        poly1.append(10);
        poly1.set(6, 2);
        poly1.append(2);
        System.out.println("First poly:");
        System.out.println(poly1);

        ListPolynomial poly2 = new ListPolynomial();
        poly2.append(1);
        poly2.append(5);
        poly2.append(3);
        poly2.set(2, 1);
        System.out.println("Second poly:");
        System.out.println(poly2);

        System.out.println("Add 2 polys:");
        System.out.println(poly1.plus(poly2).toString());

        System.out.println("Minus 2 polys:");
        System.out.println(poly1.minus(poly2).toString());

        System.out.println("Multiply 2 polys:");
        System.out.println(poly1.multiply(poly2).toString());

        System.out.println("Value of first poly with x = 2:");
        System.out.println(poly1.evaluate(2));

        System.out.println("Value of second poly with x = 2:");
        System.out.println(poly2.evaluate(2));
        System.out.println();
    }

    public static void testIntegrationCalculator() {
    /*
     TODO

     - Tạo một đa thức.
     - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng
       IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
     - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
     */

        Polynomial poly = new ListPolynomial();
        ListPolynomial poly1 = (ListPolynomial) poly;
        poly1.append(1);
        poly1.append(5);
        poly1.append(3);
        poly1.set(2, 1);
        System.out.println("Polynomial:");
        System.out.println(poly1);

        SimpsonRule simpsonRule = new SimpsonRule(1, 100);
        MidpointRule midpointRule = new MidpointRule(1, 100);
        TrapezoidRule trapezoidRule = new TrapezoidRule(1, 100);

        IntegrationCalculator simpson = new IntegrationCalculator(simpsonRule, poly1);
        IntegrationCalculator midpoint = new IntegrationCalculator(midpointRule, poly1);
        IntegrationCalculator trapezoid = new IntegrationCalculator(trapezoidRule, poly1);

        String result = "";
        result += "SimpsonRule: " + simpson.integrate(2, 4) + "\n";
        result += "MidpointRule: " + midpoint.integrate(2, 4) + "\n";
        result += "TrapezoidRule: " + trapezoid.integrate(2, 4) + "\n";

        System.out.print(result);
    }
}
