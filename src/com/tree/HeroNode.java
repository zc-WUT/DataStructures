package com.tree;

//先创建HeroNode 节点
class HeroNode {
    private int no;
    private String name;

    public HeroNode getParent() {
        return parent;
    }

    public void setParent(HeroNode parent) {
        this.parent = parent;
    }

    private HeroNode parent;
    private HeroNode left;
    private HeroNode right;

    //如果leftType=0.说明指向的左子树，如果是1则表示指向前驱节点
    private int leftType;
    //如果rightType=0.说明指向的右子树，如果是1则表示指向后继节点
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {

        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {

        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序查找
    public HeroNode preOrderSearch(int no) {
        //比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        //判断当前节点左子节点是否为空，如果不为空，则递归前序查找
        //如果左递归前序查找，找到节点，则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        //左递归前序查找，找到节点则返回，否则继续判断
        //当前的节点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode reNode = null;
        if (this.left != null) {
            reNode = this.left.infixOrderSearch(no);
        }
        if (reNode != null) {
            return reNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            reNode = this.right.infixOrderSearch(no);
        }
        return reNode;
    }

    //后续查找
    public HeroNode postOrderSearch(int no) {
        HeroNode reNode = null;
        if (this.left != null) {
            reNode = this.left.postOrderSearch(no);
        }
        if (this.right != null) {
            reNode = this.right.postOrderSearch(no);
        }
        if (reNode != null) {
            return reNode;
        }
        if (this.no == no) {
            return this;
        } else {
            return reNode;
        }
    }

    //递归删除节点
    //如果是叶子节点，则删除该节点
    //如果删除的节点是非叶子节点，则直接删除子树
    public void delNode(int no){
        if (this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        if (this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(no);
        }
        if (this.right!=null){
            this.right.delNode(no);
        }
    }
}
