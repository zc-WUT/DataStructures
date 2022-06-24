package com;


import java.util.*;

public class MyAlgorithm {
  public static class Node {
    public int value;
    Node left;
    Node right;

    public Node(int data) {
      this.value = data;
    }
  }

  public static void preShow(Node head) {
    if (head == null) {
      return;
    }
    Node pre = head;
    Node son = null;
    while (pre != null) {
      son = pre.left;
      if (son != null) {
        while (son.right != null && son.right != pre) {
          son = son.right;
        }
        if (son.right == null) {
          son.right = pre;
          System.out.print(pre.value + " ");
          pre = pre.left;
          continue;
        } else {
          son.right = null;
        }
      } else {
        System.out.print(pre.value + " ");
      }
      pre = pre.right;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(4);
    head.left = new Node(2);
    head.right = new Node(6);
    head.left.left = new Node(1);
    head.left.right = new Node(3);
    head.right.left = new Node(5);
    head.right.right = new Node(7);
    preShow(head);
  }
}

class QuickSort {
  public static void main(String[] args) {
    int[] arr = {-100, 50, -30, 1, 10, 7, 6, 2};
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  public static void quickSort(int[] arr, int left, int right) {
    int i = left;
    int j = right;
    int head = arr[left];
    int temp = 0;
    while (i < j) {
      while (arr[j] >= head && i < j) {
        j--;
      }
      while (arr[i] <= head && i < j) {
        i++;
      }
      if (i < j) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    arr[left] = arr[i];
    arr[i] = head;

    if (i - left > 1) {
      quickSort(arr, left, i - 1);
    }
    if (right - j > 1) {
      quickSort(arr, i + 1, right);
    }
  }
}

class BinarySearch {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 4, 4, 4, 4, 4, 5, 6, 7};
    binarySearch(arr, 4);
  }

  public static void binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    int mid = 0;
    while (left < right) {
      mid = (left + right) / 2;
      if (arr[mid] > target) {
        right = mid - 1;
      } else if (arr[mid] < target) {
        left = mid + 1;
      } else {
        int idx = mid - 1;
        while (idx >= 0 && arr[idx] == target) {
          System.out.println(idx);
          idx--;
        }
        System.out.println(mid);
        idx = mid + 1;
        while (idx <= right && arr[idx] == target) {
          System.out.println(idx);
          idx++;
        }
        break;
      }
    }
  }

}

class Solution1 {
  public void hammingWeight(int n) {
    int count = 0;
    while (n > 0) {
      if (n % 2 == 1) {
        count++;
        n = (n - 1) / 2;
      } else {
        n = n / 2;
      }
    }
    System.out.println("正整数" + n + "转为二进制时数字位数为1的个数为" + count);

  }
}

class Linked {
  public static void main(String[] args) {
    Node head1 = new Node(1);
    Node head2 = new Node(2);
    Node head3 = new Node(3);
    Node head4 = new Node(4);
    Node head5 = new Node(5);
    Node head6 = new Node(6);
    Node head7 = new Node(7);
    head1.setRight(head2);
    head2.setRight(head3);
    head3.setRight(head4);
    head4.setRight(head5);
    head5.setRight(head6);
    head6.setRight(head7);
    head7.setRight(head3);
    findDoor(head1);

  }

  public static void hasCycle(Node head) {
    Node fast = head;
    Node slow = head;
    while (fast.getRight().getRight() != null && slow.getRight() != null) {
      fast = fast.getRight().getRight();
      slow = slow.getRight();
      if (slow.getValue() >= fast.getValue()) {
        System.out.println("有环");
        return;
      }
    }
    System.out.println("没有环");
  }

  public static void findDoor(Node head) {
    Node fast = head;
    HashSet<Integer> hashSet = new HashSet<>();
    while (!hashSet.contains(fast.getValue())) {
      hashSet.add(fast.getValue());
      if (fast.getRight() != null) {
        fast = fast.getRight();
      } else {
        System.out.println("没有环，如果为" + head.getValue());
        return;
      }
    }
    System.out.println("找到了环入口:" + fast.getValue());
  }
}

class 计算器 {
  public static void main(String[] args) {

  }
}

class MergeSort {

}

class findLarge1000 {
  public static void main(String[] args) {
    int[] arr = {-1, -20, 0, 60, 4, 20, 1, 30};
    System.out.println(Arrays.toString(search(arr, 0, arr.length - 1, 6)));
  }

  public static int[] search(int[] arr, int left, int right, int k) {
    int i = sortOnce(arr, left, right);
    if (i == k - 1 || i == k) {
      return Arrays.copyOfRange(arr, k, arr.length);
    }
    return i < k - 1 ? search(arr, i + 1, right, k) : search(arr, left, i - 1, k);
  }

  public static int sortOnce(int[] arr, int left, int right) {
    int i = left;
    int j = right;
    int head = arr[left];
    while (i < j) {
      while (i < j && arr[j] >= head) {
        j--;
      }
      while (i < j && arr[i] <= head) {
        i++;
      }
      if (i < j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
      }
    }
    arr[left] = arr[i];
    arr[i] = head;
    return i;
  }
}

class MergeSort1 {
  public static void main(String[] args) {
    int[] arr = {-10, -20, 6, 0, 10, 5, 7, 2, 1};
    int[] temp = new int[arr.length];
    sort(arr, 0, arr.length - 1, temp);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] arr, int left, int right, int[] temp) {
    if (left < right) {
      int mid = (left + right) / 2;
      sort(arr, left, mid, temp);
      sort(arr, mid + 1, right, temp);
      merge(arr, left, mid, right, temp);
    }
  }

  public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
    int i = left;
    int j = mid + 1;
    int idx = 0;
    while (i <= mid && j <= right) {
      temp[idx++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    }
    while (i <= mid) {
      temp[idx++] = arr[i++];
    }
    while (j <= right) {
      temp[idx++] = arr[j++];
    }
    idx = 0;
    while (left <= right) {
      arr[left++] = temp[idx++];
    }
  }
}

class HeapSort {
  public static void main(String[] args) {
    int[] arr = {4, 6, 8, 5, 9};
    heapSort(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  public static void heapSort(int[] arr, int length) {
    for (int i=length/2-1;i>=0;i--){
      adjustHeap(arr,i,length);
    }
    int temp=0;
    for (int i=length-1;i>=0;i--){
      temp=arr[i];
      arr[i]=arr[0];
      arr[0]=temp;
      adjustHeap(arr,0,i);
    }
  }

  public static void adjustHeap(int[] arr, int i, int length) {
    int temp = arr[i];
    for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
      if (k + 1 < length && arr[k] < arr[k + 1]) {
        k=k+1;
      }
      if (arr[i]<arr[k]){
        arr[i]=arr[k];
        i=k;
      }else {
        break;
      }
    }
    arr[i]=temp;
  }
}

class LongString {
  public static void main(String[] args) {
    String a = "abcdaefghi";
    int i = lengthOfLongestSubstring(a);
    System.out.println(i);
  }

  public static int lengthOfLongestSubstring(String s) {
    int len = s.length();
    if (len <= 1) {
      return len;
    }
    HashSet<Character> set = new HashSet<>();
    int right = -1;
    int ans = 0;
    for (int i = 0; i < len; i++) {
      if (i > 0) {
        set.remove(s.charAt(i - 1));
      }
      while (right + 1 < len && !set.contains(s.charAt(right + 1))) {
        set.add(s.charAt(right + 1));
        right++;
      }
      ans = Math.max(ans, set.size());
    }
    return ans;
  }
}

class SymmetryTree {
  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(2);
    Node node4 = new Node(3);
    Node node5 = new Node(4);
    Node node6 = new Node(4);
    Node node7 = new Node(3);
    node1.setLeft(node2);
    node1.setRight(node3);
    node2.setLeft(node4);
    node2.setRight(node5);
    node3.setLeft(node6);
    node3.setRight(node7);
    System.out.println(node1);
    boolean symmetry = isSymmetry(node1.getLeft(), node1.getRight());
    System.out.println(symmetry);
  }

  public static boolean isSymmetry(Node left, Node right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    if (left.getValue() != right.getValue()) {
      return false;
    }
    return isSymmetry(left.getLeft(), right.getRight()) && isSymmetry(left.getRight(), right.getLeft());
  }
}

class FindMinStep {
  public static void main(String[] args) {
    int i = fidMin(79);
    System.out.println(i);
  }

  public static int fidMin(int num) {
    if (num == 1) {
      return 0;
    }
    if (num % 2 == 0) {
      return fidMin(num / 2) + 1;
    }
    int i = fidMin(num + 1);
    int j = fidMin(num - 1);
    return Math.min(i, j) + 1;
  }
}

class FindCommonFather {
  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node7 = new Node(7);
    node1.setLeft(node2);
    node1.setRight(node3);
    node2.setLeft(node4);
    node2.setRight(node5);
    node3.setLeft(node6);
    node3.setRight(node7);
    Node node = fidFather(node1, node4, node5);
    System.out.println(node);
  }

  public static Node fidFather(Node root, Node left, Node right) {
    if (root == null) {
      return null;
    }
    if (root.getValue() == left.getValue() || root.getValue() == right.getValue()) {
      return root;
    }
    Node l = fidFather(root.getLeft(), left, right);
    Node r = fidFather(root.getRight(), left, right);
    if (l != null && r != null) {
      return root;
    } else if (l != null) {
      return l;
    } else if (r != null) {
      return r;
    } else {
      return null;
    }
  }
}

class FindRightNode {
  int lastLevel = 0;

  public void findRight(Node node, int level, List<Integer> ans) {
    if (ans.size() == 0 || level > lastLevel) {
      ans.add(node.getValue());
      lastLevel = level;
    }
    if (node.getRight() != null) {
      findRight(node.getRight(), level + 1, ans);
    }
    if (node.getLeft() != null) {
      findRight(node.getRight(), level + 1, ans);
    }
  }

  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node7 = new Node(7);
    node1.setLeft(node2);
    node1.setRight(node3);
    node2.setLeft(node4);
    node2.setRight(node5);
    node3.setLeft(node6);
    node3.setRight(node7);
    FindRightNode findRightNode = new FindRightNode();
    List<Integer> ans = new ArrayList<>();
    findRightNode.findRight(node1, 0, ans);
    System.out.println(ans);
  }
}

class FindSonArr {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    solition(arr);

  }

  public static void solition(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    for (int num : nums) {
      list.add(num);
    }
    findAns(ans, list, 0, list.size());
    for (List<Integer> an : ans) {
      System.out.println(an.toString());
    }
  }

  public static void findAns(List<List<Integer>> ans, List<Integer> list, int first, int end) {
    if (first == end - 1) {
      ans.add(new ArrayList<>(list));
      return;
    }
    for (int i = first; i < end; i++) {
      Collections.swap(list, first, i);
      findAns(ans, list, first + 1, end);
      Collections.swap(list, first, i);
    }
  }
}

class GroupAnagrams {
  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> lists = groupAnagrams(strs);
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    char[] cha = null;
    for (String str : strs) {
      cha = str.toCharArray();
      Arrays.sort(cha);
      String s = String.valueOf(cha);
      List<String> list = map.get(s);
      if (list == null) {
        list = new ArrayList<>();
        list.add(str);
        map.put(s, list);
      } else {
        list = map.get(s);
        list.add(str);
        map.put(s, list);
      }
    }
    Collection<List<String>> values = map.values();
    List<List<String>> ans = new ArrayList<>();
    for (List<String> value : values) {
      ans.add(value);
    }
    return ans;
  }
}
