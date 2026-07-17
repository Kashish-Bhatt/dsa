import java.util.Scanner;
import java.util.Stack;

public class SubarrayMin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] left = previousSmaller(arr);
        int[] right = nextSmaller(arr);

        long ans = 0;
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * left[i] * right[i];
            ans = (ans + contribution) % mod;
        }

        System.out.println("Sum of Subarray Minimums: " + ans);
    }

    public static int[] previousSmaller(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int[] left = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = i + 1;
            } else {
                left[i] = i - st.peek();
            }

            st.push(i);
        }

        return left;
    }

    public static int[] nextSmaller(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int[] right = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = arr.length - i;
            } else {
                right[i] = st.peek() - i;
            }

            st.push(i);
        }

        return right;
    }
}