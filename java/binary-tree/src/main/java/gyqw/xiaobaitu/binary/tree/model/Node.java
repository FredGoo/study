package gyqw.xiaobaitu.binary.tree.model;

/**
 * @author fred
 * @date 2018/06/21 11:12
 */
public class Node {
    private int iData;
    private double dData;
    private Node leftNode;
    private Node rightNode;

    public int getiData() {
        return iData;
    }

    public void setiData(int iData) {
        this.iData = iData;
    }

    public double getdData() {
        return dData;
    }

    public void setdData(double dData) {
        this.dData = dData;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public void showNode() {
        System.out.println("{" + iData + ", " + dData + "}");
    }
}
