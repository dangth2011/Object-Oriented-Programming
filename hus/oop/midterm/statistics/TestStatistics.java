package hus.oop.midterm.statistics;

import java.util.Arrays;

public class TestStatistics {
    public static void main(String[] args) {
        /*TODO*/
        testListDataSet();
        System.out.println();
        testArrayDataSet();
    }

    public static void testArrayDataSet() {
        System.out.println("Using Array Data Set:");
        DataSet arrayDataSet = new ArrayDataSet();

        arrayDataSet.append(3);
        arrayDataSet.append(5);
        arrayDataSet.append(-4);
        arrayDataSet.append(10);
        arrayDataSet.append(14);
        arrayDataSet.append(1);
        arrayDataSet.insert(2, 0);
        arrayDataSet.append(9);
        arrayDataSet.append(6);
        arrayDataSet.insert(20, 2);

        System.out.println(arrayDataSet);

        BasicStatistic testArray = new BasicStatistic();
        testArray.setDataSet(arrayDataSet);

        System.out.printf("Max is: %.2f\n", testArray.max());
        System.out.printf("Min is: %.2f\n", testArray.min());
        System.out.printf("Mean is: %.2f\n", testArray.mean());
        System.out.printf("Variance is: %.2f\n", testArray.variance());
        System.out.printf("Median is: %.2f\n", testArray.median());
        System.out.println("Rank is: " + Arrays.toString(testArray.rank()));

        arrayDataSet.remove(0);
        arrayDataSet.remove(arrayDataSet.size() - 1);
        testArray.setDataSet(arrayDataSet);

        System.out.println("After remove:");
        System.out.println(arrayDataSet);

        System.out.printf("Max is: %.2f\n", testArray.max());
        System.out.printf("Min is: %.2f\n", testArray.min());
        System.out.printf("Mean is: %.2f\n", testArray.mean());
        System.out.printf("Variance is: %.2f\n", testArray.variance());
        System.out.printf("Median is: %.2f\n", testArray.median());
        System.out.println("Rank is: " + Arrays.toString(testArray.rank()));
    }

    public static void testListDataSet() {
        System.out.println("Using List Data Set:");
        DataSet listDataSet = new ListDataSet();

        listDataSet.append(3);
        listDataSet.append(5);
        listDataSet.append(-4);
        listDataSet.append(10);
        listDataSet.append(14);
        listDataSet.append(1);
        listDataSet.insert(2, 0);
        listDataSet.append(9);
        listDataSet.append(6);
        listDataSet.insert(20, 2);

        System.out.println(listDataSet);

        BasicStatistic testList = new BasicStatistic();
        testList.setDataSet(listDataSet);

        System.out.printf("Max is: %.2f\n", testList.max());
        System.out.printf("Min is: %.2f\n", testList.min());
        System.out.printf("Mean is: %.2f\n", testList.mean());
        System.out.printf("Variance is: %.2f\n", testList.variance());
        System.out.printf("Median is: %.2f\n", testList.median());
        System.out.println("Rank is: " + Arrays.toString(testList.rank()));

        listDataSet.remove(0);
        listDataSet.remove(listDataSet.size() - 1);
        testList.setDataSet(listDataSet);

        System.out.println("After remove:");
        System.out.println(listDataSet);

        System.out.printf("Max is: %.2f\n", testList.max());
        System.out.printf("Min is: %.2f\n", testList.min());
        System.out.printf("Mean is: %.2f\n", testList.mean());
        System.out.printf("Variance is: %.2f\n", testList.variance());
        System.out.printf("Median is: %.2f\n", testList.median());
        System.out.println("Rank is: " + Arrays.toString(testList.rank()));
    }
}