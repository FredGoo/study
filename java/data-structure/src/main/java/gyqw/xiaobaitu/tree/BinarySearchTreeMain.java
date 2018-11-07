package gyqw.xiaobaitu.tree;

import gyqw.xiaobaitu.tree.model.Node;

/**
 * @author fred
 * 2018/06/22 17:46
 */
public class BinarySearchTreeMain {
    private Node root;

    public static void main(String[] args) {

    }

    private void insert(int iData, double dData) {
        Node node = new Node();
        node.setiData(iData);
        node.setdData(dData);

        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                if (iData < current.getiData()) {
                    // 左子树
                } else {
                    // 右子树
                }
            }
        }
    }
}
