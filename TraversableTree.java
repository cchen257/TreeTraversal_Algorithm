import java.util.*;

public class TraversableTree<E extends Comparable<E>> {
   private Node<E> root;

   // Construct a new empty tree.
   public TraversableTree() {}

   // Adds the specified element to the tree.
   public void add(E e) {
      root = add(e, root);
   }
   
   // Adds the specified element to the tree.
   private Node<E> add(E e, Node<E> root) {
      if (root == null) return new Node<E>(e); // Case where the tree is empty.
      int compare = e.compareTo(root.data);
      if (compare < 0)                    // If e < root.data, add it to the left subtree.
         root.left = add(e, root.left);
      else if (compare > 0)               // If e > root.data, add it to the right subtree.
         root.right = add(e, root.right);
      return root;
   }

   private static class Node<E extends Comparable<E>> {
      E data;
      Node<E> left = null, right = null;
      Node(E data) {
         this.data = data;
      }
   }
   
   /*****Traversal methods*****/
   
   // Prints the tree pre-order
   void preOrder(Node<E> root) {
	   if (root==null) return;
	   System.out.print(root.data + " ");
	   preOrder(root.left);
	   preOrder(root.right);
   }
   
   void postOrder(Node<E> root) {
	   if (root==null) return;
	   postOrder(root.left);
	   postOrder(root.right);
	   System.out.print(root.data + " ");
   }
   
   void inOrder(Node<E> root) {
	   if (root==null) return;
	   inOrder(root.left);
	   System.out.print(root.data + " ");
	   inOrder(root.right);
   }
   
   void levelOrder() {
	   Queue<Node<E>> queue = new ArrayDeque<>();
	   queue.add(root);
	   while (!queue.isEmpty()) {
		   Node<E> n = queue.remove();
		   System.out.print(n.data + " ");
		   if (n.left != null) queue.add(n.left);
		   if (n.right != null) queue.add(n.right);
	   }
   }
	
	public static void main(String[] args) {
		  TraversableTree<Integer> tree = new TraversableTree<>();
		  
	      tree.add(5);
	      tree.add(3);
	      tree.add(7);
	      tree.add(2);
	      tree.add(4);
	      tree.add(6);
	      tree.add(8);
	      
	      tree.preOrder(tree.root);
	      System.out.println("(pre-order)");
	      
	      tree.postOrder(tree.root);
	      System.out.println("(post-order)");
	      
	      tree.inOrder(tree.root);
	      System.out.println("(in-order)");
	      
	      tree.levelOrder();
	      System.out.println("(level-order)");
	   }
}