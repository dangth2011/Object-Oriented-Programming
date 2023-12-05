package hus.oop.finalexam.mybookmanager;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     *
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder string = new StringBuilder();
        for (int index = 0; index < this.size(); index++) {
            string.append(String.format("%s ", this.get(index).toString()));
        }
        return string.toString();
    }

    public void checkBoundaries(int index, int limit) {
        if (index > limit || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}