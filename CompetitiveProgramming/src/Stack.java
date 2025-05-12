class Stack {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    int size = 0;
    Node top;

    Stack() {
        top = null;
        size = 0;
    }


    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            newNode.next = null;
        } else {
            newNode.next = top;
        }
        top = newNode;
        size++;
    }

    public int pop() {
        if (top == null) throw new RuntimeException("Stack is empty");
        else {
            int val = top.data;
            top = top.next;
            size--;
            return val;
        }
    }

    public int peek() {
        if (top == null) throw new RuntimeException("Stack is empty");
        else return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.push(4);
        System.out.println(stack.size());
        System.out.println(stack.peek());
    }
}
