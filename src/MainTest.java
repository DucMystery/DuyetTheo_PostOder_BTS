public class MainTest {

    public static void main(String[] args) {

        TreeNode<Integer> tn = new TreeNode<>();

        tn.insert(10);
        tn.insert(18);
        tn.insert(8);
        tn.insert(7);
        tn.insert(9);
        tn.insert(11);
        tn.insert(19);

        tn.postOder();
        System.out.println("=============");

        tn.PreOder();
    }

}
