import java.util.Scanner;
import java.util.Stack;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            while (!st.isEmpty() && asteroids[i] < 0 && st.peek() > 0) {

                if (Math.abs(asteroids[i]) > st.peek()) {
                    st.pop();
                    continue;
                }
                if (Math.abs(asteroids[i]) == st.peek()) {
                    st.pop();
                }

                // Current asteroid is destroyed
                asteroids[i] = 0;
                break;
            }
            if (asteroids[i] != 0) {
                st.push(asteroids[i]);
            }
        }
        int[] ans = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of asteroids: ");
        int n = sc.nextInt();

        int[] asteroids = new int[n];

        System.out.println("Enter asteroid values:");

        for (int i = 0; i < n; i++) {
            asteroids[i] = sc.nextInt();
        }

        int[] result = asteroidCollision(asteroids);

        System.out.println("Asteroids after collision:");

        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}