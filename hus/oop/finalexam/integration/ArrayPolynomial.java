package hus.oop.finalexam.integration;

import java.util.Arrays;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        /* TODO */
        this.coefficents = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     *
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        return this.coefficents[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     *
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        return this.coefficents;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial append(double coefficient) {
        /* TODO */
        if (this.size >= this.coefficents.length) {
            enlarge();
        }

        this.coefficents[this.size] = coefficient;
        this.size++;

        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (this.size >= this.coefficents.length) {
            enlarge();
        }

        double[] arr = this.coefficents.clone();
        this.size++;
        System.arraycopy(arr, 0, this.coefficents, 0, index);
        this.coefficents[index] = coefficient;
        System.arraycopy(arr, index, this.coefficents, index + 1, arr.length - index - 1);

        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        this.coefficents[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     *
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        return this.size - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     *
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double sum = 0;
        for (int i = this.coefficents.length - 1; i > 0; i--) {
            sum = (sum + this.coefficents[i]) * x;
        }
        return sum + this.coefficents[0];
    }

    /**
     * Lấy đạo hàm của đa thức.
     *
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        ArrayPolynomial derive = new ArrayPolynomial();
        derive.coefficents = new double[this.coefficents.length - 1];
        for (int i = 1; i < this.coefficents.length; i++) {
            derive.coefficents[i - 1] = this.coefficents[i] * i;
        }
        return derive;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        /* TODO */
        ArrayPolynomial sum = new ArrayPolynomial();
        sum.coefficents = new double[Math.max(this.coefficents.length,
                another.coefficents.length)];
        System.arraycopy(this.coefficents, 0, sum.coefficents, 0,
                this.coefficents.length);
        for (int i = 0; i < another.coefficents.length; i++) {
            sum.coefficents[i] += another.coefficents[i];
        }
        return sum;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        /* TODO */
        ArrayPolynomial result = new ArrayPolynomial();
        result.coefficents = new double[Math.max(this.coefficents.length,
                another.coefficents.length)];
        System.arraycopy(this.coefficents, 0, result.coefficents, 0,
                this.coefficents.length);
        for (int i = 0; i < another.coefficents.length; i++) {
            result.coefficents[i] -= another.coefficents[i];
        }
        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        /* TODO */
        ArrayPolynomial result = new ArrayPolynomial();
        result.coefficents = new double[this.coefficents.length + another.coefficents.length - 1];
        Arrays.fill(result.coefficents, 0);
        for (int i = 0; i < this.coefficents.length; i++) {
            for (int j = 0; j < another.coefficents.length; j++) {
                result.coefficents[i + j] += this.coefficents[i] * another.coefficents[j];
            }
        }
        return result;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        double[] result = new double[this.coefficents.length * 2];
        System.arraycopy(this.coefficents, 0, result, 0, this.coefficents.length);
        this.coefficents = result;
    }
}
