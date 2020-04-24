public class TreeNode<E extends Comparable> {

    Node<E> root;
    public void insert(E element) {
        if (root == null) {
            root = new Node<>(element);
        } else {
            Node<E> currentNode = root;
            while (currentNode != null) {
                if (element.compareTo(currentNode.data) < 0) {
                    if (currentNode.left == null) {
                        currentNode.left = new Node<>(element);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else if (element.compareTo(currentNode.data) > 0) {
                    if (currentNode.right == null) {
                        currentNode.right = new Node<>(element);
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                } else {
                    throw new RuntimeException("Gia tri da ton tai !");
                }

            }


        }
    }
    public void postOder(){
        postOder(root);
    }


        void postOder(Node<E> root){
        if (root ==null)return;
        postOder(root.left);
        postOder(root.right);
        System.out.println(root.data);
    }

    void PreOder(Node<E> root){
        if (root== null)return;
        System.out.println(root.data);
        PreOder(root.left);
        PreOder(root.right);
    }

    public void PreOder(){
        PreOder(root);
    }

}
