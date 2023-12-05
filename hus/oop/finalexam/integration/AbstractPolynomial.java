package hus.oop.finalexam.integration;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     *
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < coefficients().length; i++) {
            if (i == 0) {
                result.append("[").append(coefficient(i)).append(" + ");
            } else if (i == coefficients().length - 1) {
                result.append(coefficient(i)).append("x^").append(i).append("]");
            } else {
                result.append(coefficient(i)).append("x^").append(i).append(" + ");
            }
        }
        return result.toString();
    }

    /**
     * Lấy đạo hàm đa thức.
     *
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        double[] derive = new double[coefficients().length - 1];
        for (int i = 1; i < coefficients().length; i++) {
            derive[i - 1] = coefficient(i) * i;
        }
        return derive;
    }
}
