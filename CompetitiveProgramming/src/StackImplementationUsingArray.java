public class StackImplementationUsingArray {
    static class Stack {
        int n, ind;
        int[] s;

        Stack(int n) {
            this.n = n;
            this.ind = 0;
            s = new int[n];
        }

        public void push(int e) {
            if (ind == n) {
                System.out.println("stack is full!");
            } else {
                s[ind++] = e;
            }
        }

        public int pop() {
            if (empty()) throw new RuntimeException("Stack is Empty!");
            else return s[--ind];
        }

        public int size() {
            return ind;
        }

        public int peek() {
            if (empty()) throw new RuntimeException("Stack is Empty!");
            else return s[ind - 1];
        }

        public boolean empty() {
            return ind == 0;
        }

        public int search(int e) {
            for (int i = ind - 1; i >= 0; i--) {
                if (s[i] == e) return ind - i;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Stack obj1 = new Stack(3);
        obj1.push(10);
        obj1.push(101);
        obj1.push(1010);
        obj1.push(1001);
        System.out.println(obj1.empty());
        System.out.println(obj1.search(10));
        System.out.println(obj1.size());
        System.out.println(obj1.peek());
        System.out.println(obj1.search(1010));
        System.out.println(obj1.pop());
        System.out.println(obj1.pop());
        System.out.println(obj1.peek());
    }
}
