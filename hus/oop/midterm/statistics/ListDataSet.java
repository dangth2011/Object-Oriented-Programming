package hus.oop.midterm.statistics;

import java.util.ArrayList;
import java.util.List;

public class ListDataSet extends AbstractDataSet {
    private List<Double> data;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public ListDataSet() {
        /* TODO */
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        /* TODO */
        return this.data.size();
    }

    @Override
    public double element(int index) {
        /* TODO */
        return this.data.get(index);
    }

    @Override
    public double[] elements(int from, int to) {
        /* TODO */
        double[] result = new double[to - from];
        int index = 0;
        for (int i = from; i <= to; i++) {
            result[index] = this.data.get(i);
            index++;
        }
        return result;
    }

    public boolean contains(double value) {
        for (double number : this.data) {
            if (number == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     *
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void append(double value) {
        /* TODO */
        if (!contains(value)) {
            this.data.add(value);
        }
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     *
     * @param value
     * @param index
     */
    @Override
    public void insert(double value, int index) {
        /* TODO */
        if (!contains(value)) {
            this.data.add(index, value);
        }
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        this.data.remove(index);
    }

    /**
     * Xóa tất cả các phần tử dữ liệu có giá trị bằng value.
     *
     * @param value
     */
    @Override
    public void remove(double value) {
        /* TODO */
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i) == value) {
                this.data.remove(i);
            }
        }
    }
}