package lw04.prelab;
import java.util.*;

public class Main {

    public static void insertionSort(int[] arr, int passes){
       for(int i=1; i<=passes;i++){
            int temp = arr[i];
            int j = i-1;
            
            while(j >= 0 && arr[j] < temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
    
    static int linearSearch(int[] arr, int target) {
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        
        int n = sc.nextInt();
        
        int[] branch = new int[n]; // 
        
        for(int i = 0 ; i < n ; i++){
            branch[i] = sc.nextInt();
        }
        
        int m = sc.nextInt();
        
        int[] target = new int[m];
        for(int i = 0 ; i <  m ; i++){
            target[i] = sc.nextInt();
        }
        
        
        insertionSort(branch, 3);
        
        for(int i = 0 ; i<branch.length ; i++){
            System.out.print(branch[i] + " ");
        }
        System.out.println();
        
        for(int t : target){ 
            int hasil = linearSearch(branch, t);
            
            if(hasil == -1){
                System.out.println(t + " : NOT FOUND");
            } else {
                System.out.println(t + " : FOUND at index " + hasil );
            }
        }
    }
}
