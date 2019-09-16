package algorithm.to_offer;

public class offer13 {
    public static void reOrderArray(int [] array) {
        for (int i = 1; i <array.length; i++) {
            int j = i-1;
            if(array[i]%2==1){
                int tmp = array[i];
                while (j>=0&&array[j]%2==0){
                    array[j+1] = array[j];
                    j--;
                }
                array[j+1] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {2,4,6,1,3,5,7};
        offer13.reOrderArray(arr);
    }
}
