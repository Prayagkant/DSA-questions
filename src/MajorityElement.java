import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public static int majorityElement(int[] nums){
        int candidate = -1; // stores the potential majority element.
        int count = 0;  // Tracks the frequency of candidate.
        // Find the potential candidate.
        for(int i=0; i<nums.length; i++){
            // Reset candidate
            if(count == 0){
                candidate = nums[i];
                count++;
                continue;
            }
            // Increase or Decrease frequency of candidate
            if(nums[i] == candidate){
                count++;
            }
            else{
                count--;
            }
        }
        count=0;
        // Verify the candidate ( Optional )
        for(int n: nums){
            if(n == candidate){
                count++;
            }
        }
        // Confirm majority element
        if(count > (nums.length/2)){
            return candidate;
        }
        return -1;
    }
    public static List<Integer> majorityElementII(int[] nums) {
        int candidate1 = -1, candidate2 = -1;
        int count1 = 0, count2 = 0;

        // Step 1: Find the potential candidates
        for(int num: nums){
            if(num == candidate1){
                count1++;
            }
            else if(num == candidate2){
                count2++;
            }
            else if(count1 == 0){
                candidate1 = num;
                count1++;
            }
            else if(count2 == 0){
                candidate2 = num;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify the candidates
        count1 = count2 = 0;
        for(int num: nums){
            if(num == candidate1){
                count1++;
            }
            else if(num == candidate2){
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if(count1 > n/3){
            res.add(candidate1);
        }
        if(count2 > n/3){
            res.add(candidate2);
        }
        return res;
    }
}
