public class QueueImplementationUsingArray {
    static class Queue {
        int n, rear, front;
        int[] s;

        Queue(int n) {
            this.n = n + 1;
            this.rear = 0;
            this.front = 0;
            s = new int[this.n];
        }

        public void offer(int e) {
            if (front == (rear + 1) % n) throw new RuntimeException("queue is full!");
            else {
                s[rear] = e;
                rear = (rear + 1) % n;
            }
        }

        public int poll() {
            if (rear == front) throw new RuntimeException("queue is Empty!");
            else {
                int temp = s[front];
                front = (front + 1) % n;
                return temp;
            }
        }

        public int size() {
            return (n - front + rear) % n;
        }

        public int peek() {
            if (rear == front) throw new RuntimeException("queue is Empty!");
            else return s[front];
        }

        public boolean empty() {
            return front == rear;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        try {
            q.offer(1);
            q.offer(2);
            q.offer(3);
            q.offer(4);
            System.out.println(q.size());
            q.offer(5);
            System.out.println(q.size());
            q.offer(6);
            System.out.println(q.size());
            System.out.println(q.peek());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
