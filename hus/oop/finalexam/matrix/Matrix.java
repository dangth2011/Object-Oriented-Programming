package hus.oop.finalexam.matrix;

import java.util.Random;

public class Matrix {
    private double[][] data;

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     *
     * @param rows số hàng, columns số cột
     */
    public Matrix(int rows, int columns) {
        /* TODO */
        initRandom(rows, columns);
    }

    public double[][] getData() {
        return data;
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong đoạn [1, 10]
     *
     * @param rows số hàng, columns số cột
     */
    private void initRandom(int rows, int columns) {
        /* TODO */
        int max = 10;
        int min = 1;
        int range = max - min + 1;

        this.data = new double[rows][columns];
        for (int row = 0; row < this.data.length; row++) {
            for (int col = 0; col < this.data[0].length; col++) {
                this.data[row][col] = Math.random() * range;
            }
        }
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     *
     * @param row
     * @param col
     * @return
     */
    public double get(int row, int col) {
        /* TODO */
        return this.data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     *
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, double value) {
        /* TODO */
        this.data[row][col] = value;
    }

    /**
     * Phương thức sắp xếp các phần tử của ma trận theo thứ tự tăng dần.
     *
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự tăng dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public Matrix getSortedMatrix() {
        /* TODO */
        for (int row = 0; row < this.data.length; row++) {
            for (int col = 0; col < this.data[0].length - 1; col++) {
                for (int nextCol = col + 1; nextCol < this.data[0].length; nextCol++) {
                    if (this.data[row][col] > this.data[row][nextCol]) {
                        double temp = this.data[row][col];
                        this.data[row][col] = this.data[row][nextCol];
                        this.data[row][nextCol] = temp;
                    }
                }
            }
        }

        Matrix matrix = new Matrix(this.data.length, this.data[0].length);
        matrix.data = this.data.clone();
        return matrix;
    }

    /**
     * Phương thức cộng ma trận hiện tại với một ma trận khác.
     *
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public Matrix add(Matrix that) {
        /* TODO */
        if (this.data.length != that.data.length || this.data[0].length != that.data[0].length) {
            return null;
        } else {
            Matrix matrix = new Matrix(this.data.length, this.data[0].length);
            for (int row = 0; row < this.data.length; row++) {
                for (int col = 0; col < this.data[0].length; col++) {
                    matrix.data[row][col] = this.data[row][col] + that.data[row][col];
                }
            }
            return matrix;
        }
    }

    /**
     * Phương thức trừ ma trận hiện tại cho một ma trận khác.
     *
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public Matrix minus(Matrix that) {
        /* TODO */
        if (this.data.length != that.data.length || this.data[0].length != that.data[0].length) {
            return null;
        } else {
            Matrix matrix = new Matrix(this.data.length, this.data[0].length);
            for (int row = 0; row < this.data.length; row++) {
                for (int col = 0; col < this.data[0].length; col++) {
                    matrix.data[row][col] = this.data[row][col] - that.data[row][col];
                }
            }
            return matrix;
        }
    }

    /**
     * Phương thức nhân ma trận hiện tại với một ma trận khác.
     *
     * @param that
     * @return ma trận mới là ma trận nhân của ma trận hiện tại với ma trận truyền vào.
     */
    public Matrix multiply(Matrix that) {
        /* TODO */
        if (this.data[0].length != that.data.length) {
            return null;
        } else {
            Matrix matrix = new Matrix(this.data.length, that.data[0].length);
            double[][] multiply = new double[this.data.length][that.data[0].length];
            for (int row = 0; row < this.data.length; row++) {
                for (int resCol = 0; resCol < that.data[0].length; resCol++) {
                    for (int col = 0; col < this.data[0].length; col++) {
                        multiply[row][resCol] += this.data[row][col] * that.data[col][resCol];
                    }
                }
            }
            matrix.data = multiply.clone();
            return matrix;
        }
    }

    /**
     * Phương thức nhân ma trận với một số vô hướng.
     *
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public Matrix scaled(int value) {
        /* TODO */
        Matrix matrix = new Matrix(this.data.length, this.data[0].length);
        for (int row = 0; row < this.data.length; row++) {
            for (int col = 0; col < this.data[0].length; col++) {
                matrix.data[row][col] = value * this.data[row][col];
            }
        }
        return matrix;
    }

    /**
     * Phương thức nhân hàng thứ rowIndex của ma trận với một số vô hướng.
     *
     * @param value
     * @return ma trận mới là ma trận có hàng rowIndex bằng hàng rowIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledRow(int value, int rowIndex) {
        /* TODO */
        Matrix matrix = new Matrix(this.data.length, this.data[0].length);
        matrix.data = this.data.clone();
        for (int col = 0; col < this.data[0].length; col++) {
            matrix.data[rowIndex][col] = value * this.data[rowIndex][col];
        }
        return matrix;
    }

    /**
     * Phương thức nhân cột thứ columnIndex của ma trận với một số vô hướng.
     *
     * @param value
     * @return ma trận mới là ma trận có cột columnIndex bằng cột columnIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledColumn(int value, int columnIndex) {
        /* TODO */
        Matrix matrix = new Matrix(this.data.length, this.data[0].length);
        matrix.data = this.data.clone();
        for (int row = 0; row < this.data.length; row++) {
            matrix.data[row][columnIndex] = value * this.data[row][columnIndex];
        }
        return matrix;
    }

    /**
     * Phương thức hoán đổi hai hàng của ma trận.
     *
     * @param firstIndex
     * @param secondIndex
     */
    public void swapRows(int firstIndex, int secondIndex) {
        /* TODO */
        for (int col = 0; col < this.data[0].length; col++) {
            double temp = this.data[firstIndex][col];
            this.data[firstIndex][col] = this.data[secondIndex][col];
            this.data[secondIndex][col] = temp;
        }
    }

    /**
     * Phương thức hoán đổi hai cột của ma trận.
     *
     * @param firstIndex
     * @param secondIndex
     */
    public void swapColumns(int firstIndex, int secondIndex) {
        /* TODO */
        for (int row = 0; row < this.data.length; row++) {
            double temp = this.data[row][firstIndex];
            this.data[row][firstIndex] = this.data[row][secondIndex];
            this.data[row][secondIndex] = temp;
        }
    }

    /**
     * Phương thức cộng hàng destIndex của ma trận với hàng sourceIndex của ma trận được nhân với một số value.
     *
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addRow(double value, int sourceIndex, int destIndex) {
        /* TODO */
        for (int col = 0; col < this.data[0].length; col++) {
            this.data[destIndex][col] += value * this.data[sourceIndex][col];
        }
    }

    /**
     * Phương thức cộng cột destIndex của ma trận với cột sourceIndex của ma trận được nhân với một số value.
     *
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addColumn(double value, int sourceIndex, int destIndex) {
        /* TODO */
        for (int row = 0; row < this.data.length; row++) {
            this.data[row][destIndex] += value * this.data[row][sourceIndex];
        }
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     *
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public Matrix transpose() {
        /* TODO */
        Matrix matrix = new Matrix(this.data[0].length, this.data.length);
        for (int row = 0; row < this.data[0].length; row++) {
            for (int col = 0; col < this.data.length; col++) {
                matrix.data[row][col] = this.data[col][row];
            }
        }
        return matrix;
    }

    /**
     * Phương thức lấy ra ma trận dạng hình thang theo hàng (row echelon form)
     * sau khi thực hiện phép khử Gauss.
     *
     * @return ma trận dạng hình thang theo hàng.
     */
    public Matrix gaussianElimination() {
        /* TODO */
        Matrix matrix = new Matrix(this.data.length, this.data[0].length);
        matrix.data = this.data.clone();
        for (int index = 0; index < this.data.length; index++) {
            if (matrix.data[index][index] == 0) {
                double big = 0.0;
                int kRow = index;

                for (int row = index + 1; row < this.data.length; row++) {
                    if (Math.abs(matrix.data[row][index]) > big) {
                        big = Math.abs(matrix.data[row][index]);
                        kRow = row;
                    }
                }

                swapRows(index, kRow);
            }

            double pivot = matrix.data[index][index];

            for (int row = index + 1; row < this.data.length; row++) {
                double multiple = matrix.data[row][index] / pivot;
                for (int col = index; col < this.data[0].length; col++) {
                    matrix.data[row][col] -= multiple * matrix.data[index][col];
                }
            }
        }
        return matrix;
    }

    /**
     * Phương thức lấy ra ma trận dạng hình thang theo hàng rút gọn (reduced row echelon form)
     * sau khi thực hiện phép khử Gauss-Jordan
     *
     * @return
     */
    public Matrix gaussJordanElimination() {
        /* TODO */
        Matrix matrix = new Matrix(this.data.length, this.data[0].length);
        matrix.data = this.data.clone();
        for (int index = 0; index < this.data.length; index++) {
            if (matrix.data[index][index] == 0) {
                double big = 0.0;
                int kRow = index;

                for (int row = index + 1; row < this.data.length; row++) {
                    if (Math.abs(matrix.data[row][index]) > big) {
                        big = Math.abs(matrix.data[row][index]);
                        kRow = row;
                    }
                }

                swapRows(index, kRow);
            }

            double pivot = matrix.data[index][index];

            for (int row = 0; row < this.data.length; row++) {
                if (row != index) {
                    double multiple = matrix.data[row][index] / pivot;
                    for (int col = index; col < this.data[0].length; col++) {
                        matrix.data[row][col] -= multiple * matrix.data[index][col];
                    }
                }
            }
        }
        return matrix;
    }

    /**
     * Biểu diễn ma trận theo định dạng
     * a11 a12 ... a1n
     * a21 a22 ... a2n
     * ...
     * am1 am2 ... amn
     *
     * @return một chuỗi biểu diễn ma trận.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < this.data.length; row++) {
            for (int col = 0; col < this.data[0].length; col++) {
                result.append(String.format("%.2f", this.data[row][col])).append(" ");
            }
            if (row != this.data.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
}
