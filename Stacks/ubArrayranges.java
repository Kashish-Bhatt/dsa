import java.util.Scanner;
import java.util.Stack;

public class SubArrayranges {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] leftMax = prevGreater(nums);
        int[] leftMin = prevSmaller(nums);
        int[] rightMax = nextGreater(nums);
        int[] rightMin = nextSmaller(nums);

        long ans = 0;

        for (int i = 0; i < nums.length; i++) {

            long max = (long) nums[i] * leftMax[i] * rightMax[i];
            long min = (long) nums[i] * leftMin[i] * rightMin[i];

            ans += (max - min);
        }

        System.out.println("Sum of Subarray Ranges: " + ans);
    }

    // Previous Greater
    public static int[] prevGreater(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int[] left = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty())
                left[i] = i + 1;
            else
                left[i] = i - st.peek();

            st.push(i);
        }

        return left;
    }

    // Previous Smaller
    public static int[] prevSmaller(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int[] left = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (st.isEmpty())
                left[i] = i + 1;
            else
                left[i] = i - st.peek();

            st.push(i);
        }

        return left;
    }

    // Next Greater
    public static int[] nextGreater(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int[] right = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            if (st.isEmpty())
                right[i] = nums.length - i;
            else
                right[i] = st.peek() - i;

            st.push(i);
        }

        return right;
    }

    // Next Smaller
    public static int[] nextSmaller(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int[] right = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            if (st.isEmpty())
                right[i] = nums.length - i;
            else
                right[i] = st.peek() - i;

            st.push(i);
        }

        return right;
    }
}