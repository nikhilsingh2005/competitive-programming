import java.io.*;
import java.util.*;

public class Codeforces {


    static void nikhilist(Scanner sc) throws IOException {
        int n = sc.nextInt();
        int[] v = sc.arr(n);
        int[] res = new int[n];


    }

    public static void main(String[] args) throws IOException, java.lang.Exception {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        long t = sc.nextLong();
        while (t-- > 0) {
            nikhilist(sc);
        }
        out.close();
    }

    private static void pv(int[] v) {
        for (long x : v) System.out.print(x + " ");
        System.out.println();
    }

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Scanner(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }

        int[] arr(int n) throws IOException {
            int[] result = new int[n];
            for (int i = 0; i < n; i++)
                result[i] = nextInt();
            return result;
        }

        void sort(int[] arr) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                list.add(arr[i]);
            Collections.sort(list);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
        }

        String[] nstr(int n) throws IOException {
            String[] result = new String[n];
            for (int i = 0; i < n; i++)
                result[i] = next();
            return result;
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        void nextLine() throws IOException {
            br.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }

        float nextFloat() throws NumberFormatException, IOException {
            return Float.parseFloat(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(next());
        }

        boolean ready() throws IOException {
            return br.ready();
        }
    }


    public static boolean isPerfectSquare(long n) {
        if (n < 0) return false;
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public static <T extends Number> long sumArray(T[] arr) {
        long sum = 0;
        for (T num : arr) {
            sum += num.longValue();
        }
        return sum;
    }

    public static boolean isSubsequence(String s1, String s2) {
        int n1 = s1.length(), m = s2.length();
        int i = 0, j = 0;
        while (i < n1 && j < m) {
            if (s1.charAt(i) == s2.charAt(j)) i++;
            j++;
        }
        return i == n1;
    }

    private static List<Long> div(long n) {
        List<Long> div = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                div.add(i);
                if (n / i != i) div.add(n / i);
            }
        }
//        div.add(n);
        return div;
    }

    public static long closestValue(Long[] arr, long val) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int low = 0;
        int high = arr.length;
        // Binary search: find the first index where arr[index] is >= val.
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < val) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // Now, low is the first index with arr[low] >= val
        // Check edge cases:
        if (low == 0) {
            return arr[0];  // val is less than or equal to all elements.
        }
        if (low == arr.length) {
            return arr[arr.length - 1];  // val is greater than all elements.
        }

        // Otherwise, compare the two closest candidates.
        long candidate1 = arr[low - 1];
        long candidate2 = arr[low];
        if (val - candidate1 <= candidate2 - val) {
            return candidate1;
        } else {
            return candidate2;
        }
    }

    // Returns index of first element > val
    public static int upperBound(long[] arr, long val) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= val) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // Index of first element > val (or arr.length if none)
    }

    public static <T extends Comparable<T>> int lowerBound(T[] arr, T value) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].compareTo(value) >= 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    static boolean areAllCharSame(String s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }

    static long min(long[] v) {
        long min = Long.MAX_VALUE;
        for (long x : v) min = Math.min(x, min);
        return min;
    }

    public static void generateDivisors(int n, ArrayList<Integer> list) {
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= n; j += i) {
                list.set(j, list.get(j) + 1);
            }
        }
    }

    public static void getAllDivisors(long n, ArrayList<Long> list) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add((long) i);
                if (i != n / i) {
                    list.add(n / i);
                }
            }
        }
    }

    static class DSU {
        private int[] parent;
        private int[] size;

        public DSU(int n) {
            parent = new int[n + 1];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return false;
            }

            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            } else {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
            return true;
        }

        public int getSize(int x) {
            return size[find(x)];
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }
    }

    static class Pair {
        long f, s;

        Pair(long f, long s) {
            this.f = f;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return f == pair.f && s == pair.s;
        }

        @Override
        public int hashCode() {
            return Objects.hash(f, s);
        }


        @Override
        public String toString() {
            return "(" + f + ", " + s + ")";
        }

    }


    public static long lastDigit(long num) {
        return Math.abs(num % 10);
    }

    public static Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
        return map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), LinkedHashMap::putAll);
    }


    public static long[] suffixSum(int[] arr) {
        int n = arr.length;
        long[] suffixSum = new long[n];

        suffixSum[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = arr[i] + suffixSum[i + 1];
        }

        return suffixSum;
    }

    public static boolean isArraySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean areAllElementsOdd(int[] array) {
        for (int num : array) {
            if (num % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean areAllElementsUnique(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (seen.contains(num)) {
                return false;
            }
            seen.add(num);
        }
        return true;
    }


    private static Set<Long> primeDivisor(long n) {
        Set<Long> primeDivisors = new HashSet<>();
        while (n % 2 == 0) {
            primeDivisors.add(2L);
            n /= 2;
        }
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                primeDivisors.add(i);
                n /= i;
            }
        }

        if (n > 2) {
            primeDivisors.add(n);
        }
        return primeDivisors;
    }


    public static int generateRandomNumber(int n, int m) {
        Random rand = new Random();

        if (n == 1) {
            int randomNum = rand.nextInt(n) + 1;
            if (randomNum >= m) {
                randomNum++;
            }
            return randomNum;
        }


        // Generate a random number in the range [1, n-1]
        int randomNum = rand.nextInt(n - 1) + 1;

        // If the generated number is greater than or equal to m, adjust it by adding 1
        if (randomNum >= m) {
            randomNum++;
        }

        return randomNum;
    }

    public static boolean allCharSame(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) return false;
        }
        return true;
    }

    private static boolean allCharUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }

        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static String reverseString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }


    public static int getMaxElement(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }


    private static int diffBits(int a, int b) {
        StringBuilder A = new StringBuilder(Integer.toString(a, 2));
        StringBuilder B = new StringBuilder(Integer.toString(b, 2));
        while (A.length() != B.length()) {
            if (A.length() < B.length()) {
                A.insert(0, '0');
            } else B.insert(0, '0');
        }
        int c = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) c++;
        }
        return c;
    }

    public static int maxFrequencyElement(int[] arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFreq = 0;
        int element = arr[0];

        for (int num : arr) {
            int count = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, count);

            if (count > maxFreq) {
                maxFreq = count;
                element = num;
            }
        }

        return element;
    }

    private static int maxFreq(int[] arr) {
        Map<Long, Integer> map = new HashMap<>();
        for (long l : arr) {
            map.put(l, map.getOrDefault(l, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (int freq : map.values()) {
            max = Math.max(max, freq);
        }
        return max;
    }

    public static List<Integer> getFrequencyCounts(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> frequencyCounts = new ArrayList<>(frequencyMap.values());
        frequencyCounts.sort(Collections.reverseOrder());
        return frequencyCounts;
    }

    private static long countDigits(long res) {
        long c = 0;
        while (res != 0) {
            c++;
            res /= 10;
        }
        return c;
    }

    private static boolean indexCheck(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private static boolean isCoprime(long x, long y) {
        return gcd(x, y) == 1;
    }

    private static long[] prefixSum(int[] arr) {
        long[] array = new long[arr.length + 1];
        long sum = 0;
        for (int i = 1; i <= arr.length; i++) {
            sum += arr[i - 1];
            array[i] = sum;
        }
        return array;
    }


    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int mod = n % 10;
            sum += mod;
            n /= 10;
        }
        return sum;
    }

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }


    public static boolean isBinSorted(String s) {
        int max = Character.getNumericValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int curr = Character.getNumericValue(s.charAt(i));
            if (curr >= max) {
                max = curr;
            } else return false;
        }
        return true;
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to get next prime >= n
    public static int nextPrime(int n) {
        if (n <= 2) return 2;
        if (n % 2 == 0) n++;  // make n odd because even numbers >2 are not prime

        while (!isPrime(n)) {
            n += 2;  // only check odd numbers
        }
        return n;
    }

    public static long lcm(long a, long b) {
        return Math.abs(a * b) / gcd(a, b);
    }
}