package hus.oop.midterm.statistics;

public class ArrayDataSet extends AbstractDataSet {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public ArrayDataSet() {
        /* TODO */
        this.size = 0;
        this.data = new double[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        /* TODO */
        return this.size;
    }

    @Override
    public double element(int index) {
        /* TODO */
        for (int i = 0; i < this.size; i++) {
            if (index == i) {
                return this.data[i];
            }
        }
        return 0.0;
    }

    @Override
    public double[] elements(int from, int to) {
        /* TODO */
        double[] result = new double[to - from];
        int index = 0;
        for (int i = from; i <= to; i++) {
            result[index] = this.data[i];
            index++;
        }
        return result;
    }

    private boolean contains(double value) {
        for (double number : this.data) {
            if (number == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     *
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void append(double value) {
        /* TODO */
        if (this.size >= this.data.length) {
            enlarge();
        }

        if (!contains(value)) {
            this.data[this.size] = value;
            this.size++;
        }
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     *
     * @param value
     * @param index
     */
    @Override
    public void insert(double value, int index) {
        /* TODO */
        if (this.size >= this.data.length) {
            enlarge();
        }

        if (!contains(value)) {
            double[] array = this.data.clone();
            this.size++;
            System.arraycopy(array, 0, this.data, 0, index);
            System.arraycopy(array, index, this.data, index + 1, array.length - index - 1);
            this.data[index] = value;
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
        for (int i = index; i < this.size; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.size--;
    }

    /**
     * Xóa tất cả các phần tử dữ liệu có giá trị bằng value.
     *
     * @param value
     */
    @Override
    public void remove(double value) {
        /* TODO */
        int length = this.size;
        for (int i = 0; i < length; i++) {
            if (this.data[i] == value) {
                this.data[i] = this.data[i + 1];
                this.size--;
            }
        }
    }

    /**
     * Mở rộng gấp đôi kích thước mảng nếu hết chỗ để chứa dữ liệu.
     */
    private void enlarge() {
        /* TODO */
        double[] newArray = new double[2 * this.data.length];
        System.arraycopy(this.data, 0, newArray, 0, this.data.length);
        this.data = newArray;
    }
}
