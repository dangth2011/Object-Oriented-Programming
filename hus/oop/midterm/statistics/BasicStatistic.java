package hus.oop.midterm.statistics;

public class BasicStatistic implements Statistic {
    private DataSet dataSet;

    /**
     * Hàm dựng khởi tạo tập dữ liệu.
     */
    public BasicStatistic() {
        /* TODO */
        //dataSet = new ListDataSet();
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        /* TODO */
        return this.dataSet.size();
    }

    @Override
    public double max() {
        /* TODO */
        double max = Double.MIN_VALUE;
        for (int i = 0; i < this.dataSet.size(); i++) {
            if (this.dataSet.element(i) > max) {
                max = this.dataSet.element(i);
            }
        }
        return max;
    }

    @Override
    public double min() {
        /* TODO */
        double min = Double.MAX_VALUE;
        for (int i = 0; i < this.dataSet.size(); i++) {
            if (this.dataSet.element(i) < min) {
                min = this.dataSet.element(i);
            }
        }
        return min;
    }

    @Override
    public double mean() {
        /* TODO */
        double sum = 0;
        for (int i = 0; i < this.dataSet.size(); i++) {
            sum += this.dataSet.element(i);
        }
        return sum / this.dataSet.size();
    }

    @Override
    public double variance() {
        /* TODO */
        double sum = 0;
        double mean = mean();
        for (int i = 0; i < this.dataSet.size(); i++) {
            sum += (this.dataSet.element(i) - mean) * (this.dataSet.element(i) - mean);
        }
        return Math.sqrt(sum / this.dataSet.size());
    }

    public double[] toArray() {
        double[] newArray = new double[this.dataSet.size()];
        for (int i = 0; i < this.dataSet.size(); i++) {
            newArray[i] = this.dataSet.element(i);
        }
        return newArray;
    }

    public void sortIncreasing(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    double number = array[i];
                    array[i] = array[j];
                    array[j] = number;
                }
            }
        }
    }

    @Override
    public double[] rank() {
        /* TODO */
        double[] dataArray = toArray();
        double[] sortedArray = toArray();
        sortIncreasing(sortedArray);
        double[] rank = new double[this.dataSet.size()];
        int index = 0;
        for (double number : dataArray) {
            for (int j = 0; j < sortedArray.length; j++) {
                if (number == sortedArray[j]) {
                    rank[index] = (double) j + 1;
                    index++;
                }
            }
        }
        return rank;
    }

    @Override
    public double median() {
        /* TODO */
        double[] array = toArray();
        sortIncreasing(array);
        int size = array.length;
        double median = 0;
        if (size % 2 == 1) {
            median = array[(size + 1) / 2 - 1];
        } else {
            median = (array[size / 2 - 1] + array[size / 2]) / 2;
        }
        return median;
    }
}
