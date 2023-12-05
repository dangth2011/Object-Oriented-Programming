package hus.oop.finalexam.matrix;

public class SquareMatrix extends Matrix {

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     *
     * @param size
     */
    public SquareMatrix(int size) {
        /* TODO */
        super(size, size);
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     *
     * @return đường chéo chính của ma trận.
     */
    public double[] principalDiagonal() {
        /* TODO */
        double[] result = new double[super.getData().length];
        for (int index = 0; index < super.getData().length; index++) {
            result[index] = super.get(index, index);
        }
        return result;
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     *
     * @return đường chéo phụ của ma trận.
     */
    public double[] secondaryDiagonal() {
        /* TODO */
        double[] result = new double[super.getData().length];
        int index = 0;
        for (int i = super.getData().length - 1; i >= 0; i--) {
            result[index] = super.get(super.getData().length - 1 - i, i);
            index++;
        }
        return result;
    }
}
