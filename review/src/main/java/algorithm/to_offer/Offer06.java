package algorithm.to_offer;

public class Offer06 {


    //O(n)
    public int minNumberInRotateArray(int [] array) {
        if(array.length  == 0)
            return 0;
        int i;
        for (i = 0; i <array.length-1 ; i++) {
            if(array[i+1]<array[i])
                return array[i+1];
        }

        return array[0];
    }



    // 二分法
    public int minNumberInRotateArray2(int [] array) {
        int low = 0;
        int high  = array.length-1;
        while (low<high){
            int mid = low + (high-low)/2;
            if(array[mid]>array[high]){
                low = mid+1;
            }
            else if(array[mid] == array[high]){
                high = high-1;
            }
            else {
                high=mid;
            }
        }

        return array[low];
    }

    public static void main(String[] args) {

    }

}

