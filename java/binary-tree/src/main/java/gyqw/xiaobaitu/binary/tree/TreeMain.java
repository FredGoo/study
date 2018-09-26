package gyqw.xiaobaitu.binary.tree;

import gyqw.xiaobaitu.binary.tree.model.Node;

/**
 * @author fred
 * @date 2018/06/21 11:11
 */
public class TreeMain {
    private Node root;

    public static void main(String[] args) {
        TreeMain treeMain = new TreeMain();
        treeMain.insert(13, 13d);
        treeMain.insert(2, 52d);
        treeMain.insert(5, 2d);
        treeMain.insert(21, 277d);
        treeMain.insert(42, 62d);

        Node node0 = treeMain.find(21);
        if (node0 != null) {
            node0.showNode();
        }
        Node node1 = treeMain.find(13);
        if (node1 != null) {
            node1.showNode();
        }

        Node[] border = treeMain.border();
        border[0].showNode();
        border[1].showNode();
        
        System.out.println("end");
    }

    public Node getRoot() {
        return root;
    }

    private void insert(int iData, double dData) {
        // 创建一个node节点
        Node node = new Node();
        node.setiData(iData);
        node.setdData(dData);

        // 判断root是否为空
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;

                if (iData < current.getiData()) {
                    current = current.getLeftNode();
                    if (current == null) {
                        parent.setLeftNode(node);
                        return;
                    }
                } else {
                    current = current.getRightNode();
                    if (current == null) {
                        parent.setRightNode(node);
                        return;
                    }
                }
            }
        }
    }

    private Node find(int key) {
        Node current = root;

        while (current.getiData() != key) {
            if (key < current.getiData()) {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }

            if (current == null) {
                return null;
            }
        }

        return current;
    }

    public Node[] border() {
        Node[] borderNodeArray = new Node[2];

        Node current = root;
        Node min = null;
        while (current != null) {
            min = current;
            current = current.getLeftNode();
        }
        borderNodeArray[0] = min;

        current = root;
        Node max = null;
        while (current != null) {
            max = current;
            current = current.getRightNode();
        }
        borderNodeArray[1] = max;

        return borderNodeArray;
    }
}
