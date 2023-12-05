package hus.oop.finalexam.integration;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        /* TODO */
        this.coefficients = new ArrayList<>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     *
     * @return
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        return this.coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     *
     * @return
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] result = new double[this.coefficients.size()];
        for (int index = 0; index < this.coefficients.size(); index++) {
            result[index] = this.coefficients.get(index);
        }
        return result;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial append(double coefficient) {
        /* TODO */
        this.coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insert(double coefficient, int index) {
        /* TODO */
        ListPolynomial result = new ListPolynomial();
        if (index == this.coefficients.size()) {
            result.append(coefficient);
        } else {
            for (int i = 0; i < this.coefficients.size(); i++) {
                if (i < index) {
                    result.coefficients.set(i, this.coefficients.get(i));
                } else if (i > index) {
                    result.coefficients.set(i + 1, this.coefficients.get(i));
                } else {
                    result.coefficients.add(index, coefficient);
                }
            }
        }
        return result;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        /* TODO */
        ListPolynomial result = new ListPolynomial();
        result.coefficients = this.coefficients;
        result.coefficients.set(index, coefficient);
        return result;
    }

    /**
     * Lấy ra bậc của đa thức.
     *
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        return this.coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     *
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double sum = 0;
        for (int i = this.coefficients.size() - 1; i > 0; i--) {
            sum = (sum + this.coefficient(i)) * x;
        }
        return sum + this.coefficient(0);
    }

    /**
     * Lấy đạo hàm của đa thức.
     *
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        ListPolynomial derive = new ListPolynomial();
        for (int i = 0; i < coefficients.size() - 1; i++) {
            derive.append(0);
        }
        for (int i = 1; i < coefficients().length; i++) {
            derive.coefficients.set(i - 1, this.coefficients.get(i) * i);
        }
        return derive;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        /* TODO */
        ListPolynomial result = new ListPolynomial();
        if (this.coefficients.size() > another.coefficients.size()) {
            result.coefficients = this.coefficients;
        } else {
            result.coefficients = another.coefficients;
        }
        for (int i = 0; i < this.coefficients.size(); i++) {
            result.coefficients.set(i, this.coefficients.get(i));
        }
        for (int i = 0; i < another.coefficients.size(); i++) {
            result.coefficients.set(i, result.coefficients.get(i) + another.coefficients.get(i));
        }
        return result;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        /* TODO */
        ListPolynomial result = new ListPolynomial();
        if (this.coefficients.size() > another.coefficients.size()) {
            result.coefficients = this.coefficients;
        } else {
            result.coefficients = another.coefficients;
        }
        for (int i = 0; i < this.coefficients.size(); i++) {
            result.coefficients.set(i, this.coefficients.get(i));
        }
        for (int i = 0; i < another.coefficients.size(); i++) {
            result.coefficients.set(i, result.coefficients.get(i) - another.coefficients.get(i));
        }
        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        /* TODO */
        ListPolynomial result = new ListPolynomial();
        for (int i = 0; i < coefficients.size() + another.coefficients.size() - 1; i++) {
            result.append(0);
        }
        for (int i = 0; i < coefficients.size(); i++) {
            for (int j = 0; j < another.coefficients.size(); j++) {
                result.set(result.coefficient(i + j) + coefficients.get(i) * another.coefficients.get(j), i + j);
            }
        }
        return result;
    }
}