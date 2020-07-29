/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
  Map<Node, NodeCopy> map;
  
  public NodeCopy copyRandomBinaryTree(Node root) {
    map = new HashMap<>();
    makeMap(root);
    return copyNodes(root);
  }
  
  public NodeCopy copyNodes(Node root) {
    if (root == null) return null;
    
    NodeCopy n1 = map.get(root);
    n1.left  = copyNodes(root.left);
    n1.right = copyNodes(root.right);
    if (root.random != null) {n1.random = map.get(root.random);}
    
    return n1;
  }
  
  public NodeCopy makeMap(Node root) {
    if (root == null) return null;
    
    NodeCopy n1 = new NodeCopy(root.val);
    map.put(root, n1);
    n1.left  = makeMap(root.left);
    n1.right = makeMap(root.right);
    return n1;
  } 
  
}
