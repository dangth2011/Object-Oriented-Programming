package hus.oop.midterm.mylist;

public class MyLinkedListNode {
    private Object payload;
    private MyLinkedListNode next;

    public MyLinkedListNode(Object payload) {
        /* TODO */
        this.payload = payload;
    }

    public MyLinkedListNode(Object payload, MyLinkedListNode next) {
        /* TODO */
        this.payload = payload;
        this.next = next;
    }

    public Object getPayload() {
        return payload;
    }

    public MyLinkedListNode getNext() {
        return next;
    }

    public void setNext(MyLinkedListNode next) {
        this.next = next;
    }
}