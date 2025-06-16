import java.io.*;
import java.util.*;

class Main {
    public int findSubstring(String s) {
        int[] map = new int[128]; // assuming ASCII
        int counter = 0; // number of characters to satisfy the condition
        int i = 0, j = 0; // window pointers
        int ans = Integer.MAX_VALUE; // use Integer.MIN_VALUE for maximum case
        // int ans = 0; // if finding max length

        // Step 1: Initialize map based on target condition
        // Example: for (char c : t.toCharArray()) map[c]++;

        while (j < s.length()) {
            char endChar = s.charAt(j);
            if (map[endChar] > 0) counter--;  // adjust condition if needed
            map[endChar]--;
            j++;

            // While the window is valid (condition met)
            while (counter == 0) {
                // Update answer
                ans = Math.min(ans, j - i); // or Math.max(...) for max

                char startChar = s.charAt(i);
                map[startChar]++;
                if (map[startChar] > 0) counter++; // losing a required char
                i++; // shrink window
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] Z) throws IOException {

    }
}