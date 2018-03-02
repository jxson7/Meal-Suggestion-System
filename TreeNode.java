import java.io.*;

class TreeNode {
    TreeNode LeftChild;
    TreeNode RightChild;
    String Payload;

    TreeNode(String Payload) {
        this.Payload = Payload;
        this.LeftChild = null;
        this.RightChild = null;
    }
// Getters
    public TreeNode getLeftChild() {return this.LeftChild;}
    public TreeNode getRightChild() {return this.RightChild;}
    public String getPayload() {return this.Payload;}

// Setters
    public void setLeftChild(TreeNode left) {
        this.LeftChild = left;
    }

    public void setRightChild(TreeNode right) {
        this.RightChild = right;
    }

    public void setPayload(String s) {
        this.Payload = s;
    }

// adding LeftChild and RightChild
    public TreeNode addLeftChild(String Payload) {
        return LeftChild = new TreeNode(Payload);
    }

    public TreeNode addRightChild(String Payload) {
        return RightChild = new TreeNode(Payload);
    }

// isLeaf() method
    public Boolean isLeaf() {
        return (this.LeftChild==null&&this.RightChild==null);
    }

// Pre-Order 
    public void preOrder(BufferedWriter x) throws IOException {
        if(!this.isLeaf()) {
            x.write("q"+this.Payload);
        }
        else {
            x.write(this.Payload);
        }
        x.newLine();
        if (this.LeftChild != null) this.LeftChild.preOrder(x);
        if (this.RightChild != null) this.RightChild.preOrder(x);
    }


}
