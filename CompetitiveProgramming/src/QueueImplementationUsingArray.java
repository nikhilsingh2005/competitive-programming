public class QueueImplementationUsingArray {
    static class Queue {
        int n, rear, front;
        int[] s;

        Queue(int n) {
            this.n = n;
            this.rear = 0;
            this.front = 0;
            s = new int[n];
        }

        public void offer(int e) {
            if (rear == n) throw new RuntimeException("queue is full!");
            else s[rear++] = e;
        }

        public int poll() {
            if (rear == front) throw new RuntimeException("queue is Empty!");
            else return s[front++];
        }

        public int size() {
            return rear - front;
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
        q.offer(1);
        q.offer(2);
//        q.offer(3);
//        q.offer(4);
//        q.offer(5);
//        q.offer(6);
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.poll());
//        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.poll());
    }
}
