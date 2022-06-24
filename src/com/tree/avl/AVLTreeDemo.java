package com.tree.avl;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr={10,11,7,6,8,9};
        //创建一个AVLTree对象
        AVLTree avlTree=new AVLTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }
        System.out.println(avlTree.getRoot().height()+"   "+avlTree.getRoot().leftHeight()+"   "+avlTree.getRoot().rightHeight());
        System.out.println(avlTree.getRoot().toString());
    }
}

class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    //查找要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父结点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //编写方法
    //1.返回的以Node为根节点的二叉排序树的最小节点的值
    //2.删除node为根节点的二叉排序树的最小节点

    /**
     * 用于删除有左右子节点的根节点
     *
     * @param node   node传入的节点(注意：该node不是原来要删除的那个节点，而是targetNode.right)，node不确定是否有左子节点和右子节点
     * @param parent 该parent就是原来要被删除的targetNode，这里用于传递最小叶子节点的父节点。
     * @return 返回的以node为节点的二叉排序树的最小节点的值
     */
    public int delFromRightTreeMin(Node node, Node parent) {
        boolean changed = false;
        Node temp = node;
        //传入的node是既有左节点也有右节点的
        //步骤：先往左节点一直往下找，找到最后一个左子节点，将该左子节点的值赋给node，再将该左子节点删除即可
        while (temp.left != null) {
            changed = true;
            parent = temp;
            temp = temp.left;
        }
        //delNode(temp.value); //删除一个叶子节点，老师的方法。个人认为这样做浪费内存，parent指针直接跟着走就行了。
        if (changed) {
            parent.left = null;
        } else {
            parent.right = null;
        }
        return temp.value;
    }

    //删除节点方法
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = search(value);
            //如果没有找到要删除的节点
            if (targetNode == null) {
                return;
            }
            //如果发现当前这颗二叉排序树只有一个节点:root=targetNode
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找到targetNode的父节点
            Node parent = searchParent(value);
            //如果要删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left == targetNode) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return;
            } else if ((targetNode.left != null && targetNode.right == null) || (targetNode.left == null && targetNode.right != null)) {
                //删除只有一颗子树的节点
                if (parent == null) {//此时只有两个节点，targetNode为根节点，只需要将root指向targetNode的左或右子节点即可
                    if (targetNode.left != null) {
                        root = targetNode.left;
                    } else {
                        root = targetNode.right;
                    }
                } else {
                    //如果targetNode只有左子节点
                    if (targetNode.left != null) {
                        if (parent.left == targetNode) {//如果targetNode是parent的左子节点
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        if (parent.left == targetNode) {//如果targetNode是parent的左子节点
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    }
                }
            } else {
                //删除具有左右子树的节点
                //第一种方法：从targetNode的右子树开始往左找最小的
                int val = delFromRightTreeMin(targetNode.right, targetNode);
                targetNode.value = val;
                //第二种方法：从targetNode的左子树开始往右找最大的
            }
        }
    }


    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root == null) {
            return;
        }
        root.infixOrder();
    }

}