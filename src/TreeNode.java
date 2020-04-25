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


    public E search(E data){
        Node<E> current = root;

        while (data != current.data){
            if (data.compareTo(current.data)<0){
                current =current.left;
            }else {
                current =current.right;
            }
            if (current==null)return null;
        }
        return  current.data;
    }

    public Node<E> deleNode(Node<E> currentNode,E value){
        if (currentNode ==null){
            return currentNode;
        }
        if (value.compareTo(currentNode.data)>0){
            currentNode.right = deleNode(currentNode.right,value);
        }else if (value.compareTo(currentNode.data)<0){
            currentNode.left = deleNode(currentNode.left,value);
        }else {
            if (currentNode.left==null && currentNode.right==null){
                return null;
            }else if (currentNode.left == null){
                return currentNode.right;
            }else if (currentNode.right ==null){
                return currentNode.left;
            }else {
                E min = findMin(currentNode.right);
                currentNode.data = min;
                currentNode.right =deleNode(currentNode.right,min);
            }
        }
        return currentNode;
    }

   private E findMin(Node<E> node){
        while (node.left != null){
            node= node.left;
        }
        return node.data;
    }

}
