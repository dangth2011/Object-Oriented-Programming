package hus.oop.midterm.statistics;

public abstract class AbstractDataSet implements DataSet {
    /**
     * Mô tả tập dữ liệu.
     *
     * @return mô tả tập dữ liệu dạng [a1, a2, a3, ..., an].
     */
    public AbstractDataSet() {

    }

    @Override
    public String toString() {
        /* TODO */
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            if (i == size() - 1) {
                result.append(element(i)).append("]");
            } else {
                result.append(element(i)).append(", ");
            }
        }
        return result.toString();
    }
}
