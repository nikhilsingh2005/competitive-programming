public class Tree {
     private static class Node {
         int data;
         Node left, right;
         Node(int data) {
             this.data = data;
             left = right = null;
         }
     }
     public static void main(String[] args) {
         Node root = new Node(10);
         root.left = new Node(20);
         root.right = new Node(30);
         root.left.left = new Node(40);
         root.left.right = new Node(50);
         root.right.left = new Node(60);
         root.right.right = new Node(70);
         root.left.left.left = new Node(80);
         root.left.left.right = new Node(90);
         root.left.right.left = new Node(100);
     }
}
