import java.util.*;


public class Codechef {
    public static void kingKohli(Scanner sc) {
        System.out.println("ASS");
    }


    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        sc.nextLine();
        while (t-- > 0)
            kingKohli(sc);
        sc.close();
    }

    public static void generateDivisors(int n, ArrayList<Integer> list) {
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= n; j += i) {
                list.set(j, list.get(j) + 1);
            }
        }
    }

    public static void getAllDivisors(int n, ArrayList<Integer> list) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i) {
                    list.add(n / i);
                }
            }
        }
    }

    public static Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(
                        LinkedHashMap::new,
                        (m, e) -> m.put(e.getKey(), e.getValue()),
                        LinkedHashMap::putAll
                );
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

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

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
        long[] array = new long[arr.length];
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            array[i] = sum;
        }
        return array;
    }

    public static List<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
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

    public static int nextPrime(int n) {
        while (!isPrime(n)) n++;
        return n;
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

    public static long lcm(long a, long b) {
        return Math.abs(a * b) / gcd(a, b);
    }
}
