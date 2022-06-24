package com.tree.avl;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }


    //返回以该节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    //返回左子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    //左旋转方法
    private void leftRotate() {
        //创建新节点，值为当前根节点的值
        Node newNode = new Node(value);
        //新节点的左子树设置成根节点的左子树
        newNode.left = left;
        //新节点的右子树设置成根节点的右子树的左子树
        newNode.right = right.left;
        //根节点的值设置为右子节点的值
        value = right.value;
        //根节点的右子树设置成 根节点的右子树的右子树
        right = right.right;
        //根节点的左子树设置成新结点
        left = newNode;
    }

    //右旋转方法,与左旋转步骤对称即可
    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    /**
     * 查找要删除的节点
     *
     * @param value 希望删除的节点的值
     * @return 如果找到返回该节点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除结点的父结点

    /**
     * @param value 要找到的结点的值
     * @return 返回的是要删除的结点的父结点，如果没有就返回null
     */
    public Node searchParent(int value) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value); //向左子树递归查找
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value); //向右子树递归查找
            } else {
                return null; // 没有找到父结点
            }
        }

    }

    //添加节点的方法
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的节点的值和当前子树的根节点的关系
        if (node.value < this.value) {
            //如果当前节点左子节点为null
            if (this.left == null) {
                this.left = node;
            } else {
                //递归左子树继续添加
                this.left.add(node);
            }
        } else { //添加的节点值岛屿当前节点的值
            if (this.right == null) {
                this.right = node;
            } else {
                //递归右子树继续添加
                this.right.add(node);
            }
        }

        //当添加完一个节点后，右子树的高度-左子树的高度 > 1,需要进行左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果右节点的左子树高度大于它的右子树高度，
            // 需要对右节点进行右旋转
            if (right != null && right.rightHeight() < right.leftHeight()) {
                //先对右子树进行右旋转
                right.rightRotate();
            }
            //再对根节点进行左旋转
            leftRotate();
            return; //运行到这里就说明二叉树已经平衡了，不需要执行下面的代码
        }

        //当添加完一个节点后，左子树的高度-右子树的高度 > 1,需要进行右旋转
        if (leftHeight() - rightHeight() > 1) {
            //如果左节点的右子树高度大于它的左子树高度，
            // 需要对左节点进行左旋转
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //先对左节点进行左旋转
                left.leftRotate();
            }
            //再对根节点进行右旋转
            rightRotate();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
