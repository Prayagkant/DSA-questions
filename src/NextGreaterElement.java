import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElementI(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(nums2[i], -1);
            }else{
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }

        for(int i=0; i< nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
    public static int[] nextGreaterElementII(int[] nums){
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int size = nums.length;
        for(int i=2*size-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[(i%size)]){
                stack.pop();
            }
            if(i< size){
                result[(i%size)] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i%size]);
        }
        return result;
    }
    public int nextGreaterElementIII(int n){
        char[] digits = Integer.toString(n).toCharArray();
        int len = digits.length;

        // 1. Find the first dip
        int i= len-2;
        while(i>=0 && digits[i] >= digits[i+1]){
            i--;
        }

        // If no such element is found, return -1;
        if(i == -1) return -1;

        // find the smallest digit on right that is larger than digits[i]
        int j = len-1;
        while(digits[j] <= digits[i]){
            j--;
        }
        // swap digits[i] and digits[j]
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // reverse the suffix
        int s = i+1;
        int e = len-1;
        while(s < e){
            char t = digits[s];
            digits[s] = digits[e];
            digits[e] = t;
            s++;
            e--;
        }

        // convert back to number
        long result = Long.parseLong(new String(digits));

        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }
}
