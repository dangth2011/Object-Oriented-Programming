package hus.oop.midterm.mylist;

public class BasicStatistic {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public BasicStatistic(MyList data) {
        /* TODO */
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     *
     * @return giá trị lớn nhất.
     */
    public double max() {
        /* TODO */
        double max = Double.MIN_VALUE;
        for (int i = 0; i < this.data.size(); i++) {
            if ((double) this.data.get(i) > max) {
                max = (double) this.data.get(i);
            }
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     *
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        /* TODO */
        double min = Double.MAX_VALUE;
        for (int i = 0; i < this.data.size(); i++) {
            if ((double) this.data.get(i) < min) {
                min = (double) this.data.get(i);
            }
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu lưu trong list.
     *
     * @return kỳ vọng.
     */
    public double mean() {
        /* TODO */
        double sum = 0;
        for (int i = 0; i < this.data.size(); i++) {
            sum += (double) this.data.get(i);
        }
        return sum / this.data.size();
    }

    /**
     * Tính phương sai của mẫu lưu trong list.
     *
     * @return phương sai.
     */
    public double variance() {
        /* TODO */
        double sum = 0;
        for (int i = 0; i < this.data.size(); i++) {
            sum += ((double) this.data.get(i) - mean()) * ((double) this.data.get(i) - mean());
        }
        return Math.sqrt(sum / this.data.size());
    }
}