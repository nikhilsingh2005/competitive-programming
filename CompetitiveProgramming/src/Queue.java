public class Queue {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top;
    Node curr;
    int size;

    Queue() {
        this.top = null;
        this.curr = null;
        this.size = 0;
    }

    public void offer(int x) {
        Node newNode = new Node(x);
        if (curr == null) {
            top = newNode;
            curr = top;
        } else {
            curr.next = newNode;
            curr = newNode;
        }
        size++;
    }

    public int poll() {
        if (top == null) throw new RuntimeException("Queue is empty!");
        else {
            int val = top.data;
            top = top.next;
            size--;
            return val;
        }
    }

    public int peek() {
        if (top == null) throw new RuntimeException("Queue is empty!");
        else return top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        queue.offer(4);
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll());


    }
}
