/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {
        return checkNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkNode(Node node, int min, int max) {
        if(node == null)
            return true;
        if(node.data >= max || node.data <= min)
            return false;
        return checkNode(node.left, min, node.data) && checkNode(node.right, node.data, max);
    }