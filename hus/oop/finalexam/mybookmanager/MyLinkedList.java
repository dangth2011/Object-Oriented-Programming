package hus.oop.finalexam.mybookmanager;

public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        this.size = 0;
    }

    /**
     * Lấy kích thước của list.
     *
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        return this.size;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     *
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        /* TODO */
        return getNodeByIndex(index).getPayload();
    }

    /**
     * Sửa phần tử ở vị trí index là payload.
     *
     * @param payload
     * @param index
     */
    @Override
    public void set(Object payload, int index) {
        /* TODO */
        getNodeByIndex(index).setPayload(payload);
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        checkBoundaries(index, this.size);
        if (index == 0) {
            this.head = this.head.getNext();
        } else {
            MyLinkedListNode node = getNodeByIndex(index - 1);
            MyLinkedListNode nextNode = node.getNext().getNext();
            node.setNext(nextNode);
        }
        this.size--;
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     *
     * @param payload
     */
    @Override
    public void append(Object payload) {
        /* TODO */
        if (this.head == null) {
            this.head = new MyLinkedListNode(payload);
        } else {
            MyLinkedListNode node = this.head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new MyLinkedListNode(payload));
        }
        this.size++;
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     *
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        /* TODO */
        checkBoundaries(index, this.size);
        if (index == 0) {
            this.head = new MyLinkedListNode(payload, this.head);
        } else {
            MyLinkedListNode node = getNodeByIndex(index - 1);
            node.setNext(new MyLinkedListNode(payload, node.getNext()));
        }
        this.size++;
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     *
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator();
    }

    /**
     * Lấy node ở vị trí index.
     *
     * @param index
     * @return
     */
    private MyLinkedListNode getNodeByIndex(int index) {
        /* TODO */
        checkBoundaries(index, this.size);
        MyLinkedListNode node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    /*
     * Inner class implements the Iterator pattern
     */
    private class MyLinkedListIterator implements MyIterator {
        /*
         * MyLinkedListIterator cần phải biết vị trí hiện tại khi nó đang duyệt qua dữ liệu của MyLinkedList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho Iterator là vị trí node đầu tiên trong MyLinkedList.
         */
        public MyLinkedListIterator() {
            /* TODO */
            this.currentPosition = 0;
        }

        /**
         * Kiểm tra trong MyLinkedList có còn phần tử tiếp theo không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            /* TODO */
            return this.currentPosition < size();
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
         *
         * @return payload của phần tử hiện tại.
         */
        @Override
        public Object next() {
            /* TODO */
            int position = this.currentPosition;
            this.currentPosition++;
            return get(position);
        }

        /**
         * iterator xóa phần tử hiện tại của MyLinkedList.
         */
        @Override
        public void remove() {
            /* TODO */
            if (this.currentPosition == 0) {
                MyLinkedList.this.remove(0);
            } else {
                MyLinkedList.this.remove(this.currentPosition - 1);
                this.currentPosition--;
            }
        }
    }
}