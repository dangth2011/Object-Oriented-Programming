package hus.oop.finalexam.integration;

public class SimpsonRule implements Integrator {
    private double precision;
    private int maxIterations;

    public SimpsonRule(double precision, int maxIterations) {
        /* TODO */
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n0, 2n0, 4n0, ...
     * Việc tính toán dừng lại khi |I_2n - In|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     *
     * @param poly
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(Polynomial poly, double lower, double upper) {
        /* TODO */
        int numOfSubIntervals = 2;
        double result = 0;
        double previousResult = 0;
        double error = 0;
        int numOfIterations = 0;

        do {
            previousResult = result;
            result = integrate(poly, lower, upper, numOfSubIntervals);
            error = Math.abs(result - previousResult) / 3;
            numOfSubIntervals *= 2;
            numOfIterations++;
        } while (error >= precision && numOfIterations <= maxIterations);

        return result;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân với numOfSubIntervals (số chẵn) khoảng phân hoạch đều.
     *
     * @param poly
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(Polynomial poly, double lower, double upper, int numOfSubIntervals) {
        /* TODO */
        double deltaX = (upper - lower) / numOfSubIntervals;
        double sum = 0;
        for (int i = 0; i <= numOfSubIntervals; i++) {
            if (i == numOfSubIntervals) {
                sum += poly.evaluate(upper);
            } else if (i == 0) {
                sum += poly.evaluate(lower);
            } else if (i % 2 == 0) {
                sum += 2 * poly.evaluate(lower + i * deltaX);
            } else {
                sum += 4 * poly.evaluate(lower + i * deltaX);
            }
        }
        return sum * deltaX / 3;
    }
}