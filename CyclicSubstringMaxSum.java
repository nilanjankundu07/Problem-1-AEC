import java.util.Scanner;

public class CyclicSubstringMaxSum {

    public static int maxCyclicSubstringSum(String S) {
        int n = S.length();

        // Create doubled string
        String T = S + S;

        boolean[] visited = new boolean[26];
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < 2 * n; right++) {
            int idx = T.charAt(right) - 'a';

            // Shrink window if duplicate OR size > n
            while (visited[idx] || (right - left + 1) > n) {
                int leftIdx = T.charAt(left) - 'a';
                visited[leftIdx] = false;
                currentSum -= (leftIdx + 1);
                left++;
            }

            // Add current character
            visited[idx] = true;
            currentSum += (idx + 1);

            // Update max
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String S = sc.next();

        int result = maxCyclicSubstringSum(S);

        System.out.println("Maximum Sum = " + result);

        sc.close();
    }
}