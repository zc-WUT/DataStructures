import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] arr=new int[in.nextInt()];
    for (int i = 0; i < arr.length; i++) {
      arr[i]=in.nextInt();
    }
    find(arr);
    ArrayList
  }


  public static void find(int[] arr) {
    int[] newArr=new int[arr.length];
    int[] temp=new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      temp[i]=arr[i];
      newArr[i]=arr[i];
    }
    for (int i=1;i<arr.length-1;i++){
      if (arr[i]-arr[i-1]>=0){
        arr[i]=arr[i-1]-1;
      }
    }

    for (int i=temp.length-2;i>0;i--){
      if (temp[i]-temp[i+1]>=0){
        temp[i]=temp[i+1]-1;
      }
    }
    long ans=0;
    for (int i = 0; i < arr.length; i++) {
      arr[i]=Math.max(arr[i],temp[i]);
      ans+=newArr[i]-arr[i];
    }
    System.out.println(ans);
  }
}
