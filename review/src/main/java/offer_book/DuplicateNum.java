package offer_book;

public class DuplicateNum {
    boolean duplicate(int[] nums){
        if (nums == null||nums.length ==0)
            return false;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]<0||nums[i]>=nums.length)
                return false;
        }
        for (int i = 0; i <nums.length ; i++) {
            while (nums[i]!=i){
                if(nums[i] == nums[nums[i]])
                    return true;
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return false;
    }


    int getDuplicate(int[] nums){
        if (nums == null||nums.length==0)
            return -1;
        int start = 1;
        int end = nums.length-1;
        while (end>=start){
            int middle = ((end-start)>>1)+start;
            int count = countRange(nums,start,middle);
            if (end == start){
                if (count>1)
                    return start;
                else break;
            }
            if (count>middle-start+1)
                end = middle;
            else start = middle+1;

        }
        return -1;
    }
    private int countRange(int[] nums,int start,int end){
        if (nums == null)
            return 0;
        int count = 0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]>=start&&nums[i]<=end)
                ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        DuplicateNum duplicateNum = new DuplicateNum();
        int[] nums = {2,3,5,4,3,2,6,7};
        System.out.println(duplicateNum.getDuplicate(nums));
    }
}
