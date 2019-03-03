// https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

import java.util.*;

public class Doodle {
    static int jumpingOnClouds(int[] c) {
        int pos = 0;
        int jump = 0;
        while (pos != c.length - 1) {
            pos += 2;
            if (pos >= c.length) {
                pos = c.length - 1;
            }
            if (c[pos] == 1) pos--;
            jump++;
        }

        return jump;
    }


    static int equalizeArray(int[] arr) {
        // put num in HashMap
        // find the biggest occurrences number
        // arr.length - biggest number occurrences
        HashMap<Integer, Integer> map = new HashMap<>();
        int biggest = 0;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > biggest) {
                biggest = entry.getValue();
            }
        }

        return arr.length - biggest;
    }


    static long repeatedString(String s, long n) {
        long totalA = 0;
        int subs = (int) (n % s.length());
        long x = (long) Math.floor(n / s.length());

        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == 'a') {
                totalA += x;
                if (i < subs) {
                    totalA++;
                }
            }
        }

        return totalA;
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        // Create 2 pointer xP, yP
        // create array size 16
        // loop through the x axis and y 3 down
        // sum the values
        int xP = 0;
        int yP = 0;
        int hourGlass = 0;
        int counter = 0;
        int[] res = new int[16];

        while (counter < 16) {
            for (int i = yP; i < yP + 3; i++) {
                hourGlass += arr[xP][i];
            }

            xP++;
            yP++;

            hourGlass += arr[xP][yP];

            xP++;
            yP--;
            for (int i = yP; i < yP + 3; i++) {
                hourGlass += arr[xP][i];
            }

            res[counter] = hourGlass;
            counter++;

            // reset
            hourGlass = 0;
            yP++;
            if (yP > 3) {
                xP--;
                yP = 0;
            } else {
                xP -= 2;
            }
        }

        Arrays.sort(res);
        return res[15];
    }


    static int[] rotLeft(int[] a, int d) {
        // mod of the d % a.length
        // if equal to 0 just return the a
        // get the 4th el to be the first element
        // counter = el + 1
        // while counter != el
        // if counter >= a.length -> counter = 0
        // append rest of the item to the array
        int[] newArray = new int[a.length];
        int rem = d % a.length;
        if (rem == 0) return a;
        int newIndex = 0;
        int counter = rem;

        newArray[newIndex] = a[counter];
        counter++;
        newIndex++;
        while(counter != rem) {
            if (counter >= a.length) {
                counter = 0;
            }
            newArray[newIndex] = a[counter];
            counter++;
            newIndex++;
        }

        int[] arr = {1, 2, 3};

        return newArray;
    }


    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribing = 0;
        int n = q.length;
        for (int i = n - 1; i >= 0; i--) {
            int actualNum = i + 1;
            if (actualNum != q[i]) {
                if ((i - 1 >= 0) && q[i - 1] == i + 1) {
                    bribing++;
                    q[i - 1] = q[i];
                    q[i] = i + 1;
                } else if ((i - 2 >= 0) && q[i - 2] == i + 1) {
                    bribing += 2;
                    q[i - 2] = q[i - 1];
                    q[i - 1] = q[i];
                    q[i] = i + 1;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(bribing);
    }


    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swap = 0;
        for (int i = 0; i < arr.length; i++) {
            int actualNum = i + 1;
            if (actualNum != arr[i]) {
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] == actualNum) {
                        arr[j] = arr[i];
                        arr[i] = actualNum;
                        swap++;
                        break;
                    }
                }
            }
        }
        return swap;
    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
//        int[] result = new int[n + 1];
//        int prev = 0;
//        int max = 0;
//        for (int[] op : queries) {
//            int a = op[0] - 1;
//            int b = op[1];
//            int k = op[2];
//            result[a] += k;
//            result[b] -= k;
//        }
//
//        for (int res : result) {
//            prev += res;
//            max = Math.max(max, prev);
//        }
//
//        return max;
        int[] result = new int[n];
        int max = 0;
        for (int[] op : queries) {
            int a = op[0] - 1;
            int b = op[1] - 1;
            int k = op[2];
            for (int j = a; j <= b; j++) {
                result[j] += k;
            }
        }

        for (int res : result) {
            max = Math.max(max, res);
        }

        return max;
    }


    static void checkMagazine(String[] magazine, String[] note) {
        // create two hashMap for each input
        // map the total alphabet in the note and magazine
        // loop through the note HashMap and compare if magazine has word >= than note
        // if not, return "NO"
        HashMap<String, Integer> mag = new HashMap<>();
        HashMap<String, Integer> target = new HashMap<>();

        for (String magz : magazine) {
            mag.put(magz, mag.getOrDefault(magz, 0) + 1);
        }

        for (String nt : note) {
            target.put(nt, target.getOrDefault(nt, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : target.entrySet()) {
            if (!mag.containsKey(entry.getKey()) || mag.get(entry.getKey()) < entry.getValue()) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    static int makeAnagram(String a, String b) {
        String shortest;
        String longest;
        HashMap<Character, Integer> shortMap = new HashMap<>();
        HashMap<Character, Integer> longMap = new HashMap<>();
        int match = 0;

        if (a.length() < b.length()) {
            shortest = a;
            longest = b;
        } else {
            shortest = b;
            longest = a;
        }

        for (char word : shortest.toCharArray()) {
            shortMap.put(word, shortMap.getOrDefault(word, 0) + 1);
        }

        for (char word : longest.toCharArray()) {
            longMap.put(word, longMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : shortMap.entrySet()) {
            if (longMap.containsKey(entry.getKey())) {
                match += Math.min(entry.getValue(), longMap.get(entry.getKey()));
            }
        }


        return (shortest.length() - match) + (longest.length() - match);
    }


    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i ++) {
            int next = i + 1;
            if (next < arr.length) {
                min = Math.min(min, Math.abs(arr[i] - arr[next]));
            }
        }

        return min;
    }


    // Complete the whatFlavors function below.
    static void whatFlavors(int[] menu, int money) {
//        for (int i = 0; i < cost.length; i++) {
//            for (int j = i + 1; j < cost.length; j++) {
//                if ((cost[i] + cost[j]) == money) {
//                    System.out.println((i + 1) + " " + (j + 1));
//                    return;
//                }
//            }
//        }
        int [] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);

        for (int i = 0; i < sortedMenu.length; i++) {
            int rem = money - sortedMenu[i];
            int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, rem);
            if (location >= 0 && sortedMenu[location] == rem) {
                int[] indices = getIndices(menu, sortedMenu[i], rem);
                System.out.println(indices[0] + " " + indices[1]);
                return;
            }
        }

    }

    private static int[] getIndices(int[] menu, int ic1, int ic2) {
        int index1 = indexOf(ic1, menu, -1);
        int index2 = indexOf(ic2, menu, index1);
        return new int[]{Math.min(index1, index2), Math.max(index1, index2)};
    }

    private static int indexOf(int ice, int[] menu, int exclude) {
        for (int i = 0; i < menu.length; i++) {
            if (i != exclude && ice == menu[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void test(int num) {
        // 5 - 3 =2, 9 - 5 =4, 19 - 10 = 9
        // length = 2x - 1
        // 6 should 1
        // 7 should 0
        int maxLength = (2 * num) - 1;
        int middle = num - 1;
        int ox = Math.abs((num % 2 - 1));

        for (int i = 0; i < middle; i++) {
            for (int j = 0; j < maxLength; j++) {
                if (j >= middle && (j - i) % 2 == Math.abs((num % 2 - 1)) && j <= (middle + i)) {
                    System.out.print("x");
                } else {
                    System.out.print("_");
                }
            }
            System.out.printf("%n");
        }


        for (int j = 0; j < maxLength; j++) {
            if (j % 2 == 0) {
                if (j <= middle) {
                    if (j % 4 == 2) {
                        System.out.print("0");
                    } else {
                        System.out.print("x");
                    }
                } else {
                    if (j % 4 == 0) {
                        System.out.print("0");
                    } else {
                        System.out.print("x");
                    }
                }
            } else {
                System.out.print("_");
            }
        }
        System.out.printf("%n");


        for (int i = middle + 1; i < maxLength; i++) {
            for (int j = 0; j < maxLength; j++) {
                if (j <= middle && (i - j) % 2 == Math.abs((num % 2 - 1)) && j >= (i - middle)) {
                    System.out.print("x");
                } else {
                    System.out.print("_");
                }
            }
            System.out.printf("%n");
        }
    }

//    public static int subPair(List<Integer> a, int k) {
//        int counter = 0;
//        for (int i = 0; i < a.size(); i++) {
//            int pair1 = a.get(i);
//        }
//    }

    static void allFib(int n) {
        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.println(fib(i, memo));
        }
    }

    static int fib(int n, int[] memo) {
        if (n < 2) return n;
        else if (memo[n] > 0) return memo[n];

        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }

    static String isValid(String s) {
        HashMap<Character, Integer> s_hm = countChar(s);
        HashMap<Integer, Integer> freq = getFreq(s_hm);
        int maxFreq = getMaxFreq(freq);

        if (freq.size() == 1 || (freq.size() == 2 && freq.getOrDefault(1, -1) == 1) || (freq.size() == 2 && freq.getOrDefault(maxFreq + 1, -1) == 1) ) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static HashMap<Character, Integer> countChar(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        return hm;
    }

    private static int getMaxFreq(HashMap<Integer, Integer> freq) {
        int maxFreq = 0;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxFreq = entry.getKey();
            }
        }
        return maxFreq;
    }

    static HashMap<Integer, Integer> getFreq(HashMap<Character, Integer> h) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int values : h.values()) {
            freq.put(values, freq.getOrDefault(values, 0) + 1);
        }
        return freq;
    }

//
//    static long substrCount(int n, String s) {
//        long counter= n;
//        int next = 1;
//        while (next < n) {
//            for (int i = 0; i < n - next; i++) {
//                if (isSpecialPalindrome(s.substring(i, i + next + 1))) {
//                    counter++;
//                }
//            }
//            next++;
//        }
//        return counter;
//    }
//
//    static boolean isSpecialPalindrome(String s) {
//        System.out.println(s);
//        int middle = s.length() / 2;
//        char c = s.charAt(0);
//        for(int i = 0; i < middle; i++) {
//            if (s.charAt(i) != c || s.charAt(s.length() - 1 - i) != c) {
//                return false;
//            }
//        }
//        return true;
//    }

//    static int commonChild(String s1, String s2) {
//        int[][] alph = new int[26][2];
//        int counter = 0;
//        int offset = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            int[] sect1 = alph[getCharIndex(s1, i)];
//            sect1[1]++;
//            int[] sect2 = alph[getCharIndex(s2, i)];
//            sect2[1]--;
//            sect2[0] = i;
//            if (sect1[0] >= offset && sect1[1] == 0) {
//                counter++;
//                offset = sect1[0];
//                sect1[0] = 0;
//            }
//        }
//        return counter;
//    }
//
//    private static int getCharIndex(String s, int index) {
//        return s.charAt(index) - 'A';
//    }
    static long substrCount(int n, String s) {
        s.indexOf('a');
        ArrayList<int[]> s_map = mapData(s);
        long counter = 0;
        for (int i = 0; i < s_map.size(); i++) {
            long palindromeCount = countPalindromeAtIndex(i, s_map, s);
            counter += palindromeCount;
        }
        return counter;
    }

    private static long countPalindromeAtIndex(int i, ArrayList<int[]> s_map, String s) {
        int wordCount = s_map.get(i)[1];
        int count = 0;
        if (wordCount > 1) {
            count += (Math.pow(wordCount, 2) + wordCount) / 2;
        } else if (wordCount == 1) {
            int prevIndex = i - 1;
            int nextIndex = i + 1;
            if (prevIndex >= 0 && nextIndex < s_map.size()) {
                int[] prev = s_map.get(prevIndex);
                int[] next = s_map.get(nextIndex);
                if (s.charAt(prev[0]) == s.charAt(next[0])) {
                    count += Math.min(prev[1], next[1]);
                }
            }
            count++;
        }
        return count;
    }

    private static ArrayList<int[]> mapData(String s) {
        ArrayList<int[]> o = new ArrayList<>();
        char prev = s.charAt(0);
        int counter = 1;
        int charIndex = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                counter++;
            } else {
                o.add(new int[]{charIndex, counter});
                counter = 1;
                charIndex = i;
                prev = s.charAt(i);
            }
        }
        o.add(new int[]{charIndex, counter});

        return o;
    }


    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int prev = 0;
        int curr = 0;
        int offset = 0;
        for (int i = 0; i < s1.length(); i++) {
            char s1Char = s1.charAt(i);
            int s2Index = s2.indexOf(s1Char);
            if (s1Char == s2.charAt(offset)) {
                s2Index = s2.indexOf(s1Char, offset + 1);
            }
            if (s2Index >= offset) {
                curr++;
                offset = s2Index;
            }
            if (s2Index != -1 && s2Index < offset) {
                prev = Math.max(prev, curr);
                curr = 1;
                offset = s2Index;
            }
        }

        prev = Math.max(prev, curr);
        return prev;
    }

    static int smallestPositiveNumber(int[] arr) {
        int miss = 1;
        while(true) {
            boolean found = true;
            for (int i1 : arr) {
                if (i1 == miss) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return miss;
            }

            miss++;
        }
    }

    static int findMissingPositive(int arr[], int size)
    {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for(i = 0; i < size; i++)
        {
            int x = Math.abs(arr[i]);
            if(x - 1 < size && arr[x - 1] > 0)
                arr[x - 1] = -arr[x - 1];
        }

        // Return the first index value at which
        // is positive
        for(i = 0; i < size; i++)
            if (arr[i] > 0)
                return i+1;  // 1 is added becuase indexes
        // start from 0

        return size+1;
    }

    static int maxHist(int R,int C,int row[])
    {
        // Create an empty stack. The stack holds indexes of
        // hist[] array/ The bars stored in stack are always
        // in increasing order of their heights.
        Stack<Integer> result = new Stack<Integer>();

        int top_val;     // Top of stack

        int max_area = 0; // Initialize max area in current
        // row (or histogram)

        int area = 0;    // Initialize area with current top

        // Run through all bars of given histogram (or row)
        int i = 0;
        while (i < C)
        {
            // If this bar is higher than the bar on top stack,
            // push it to stack
            if (result.empty() || row[result.peek()] <= row[i])
                result.push(i++);

            else
            {
                // If this bar is lower than top of stack, then
                // calculate area of rectangle with stack top as
                // the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before
                // top in stack is 'left index'
                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;

                if (!result.empty())
                    area = top_val * (i - result.peek() - 1 );
                max_area = Math.max(area, max_area);
            }
        }

        // Now pop the remaining bars from stack and calculate
        // area with every popped bar as the smallest bar
        while (!result.empty())
        {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty())
                area = top_val * (i - result.peek() - 1 );

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }

    // Returns area of the largest rectangle with all 1s in
    // A[][]
    static int maxRectangle(int R,int C,int A[][])
    {
        // Calculate area for first row and initialize it as
        // result
        int result = maxHist(R,C,A[0]);

        // iterate over row to find maximum rectangular area
        // considering each row as histogram
        for (int i = 1; i < R; i++)
        {

            for (int j = 0; j < C; j++)

                // if A[i][j] is 1 then add A[i -1][j]
                if (A[i][j] == 1) A[i][j] += A[i - 1][j];


            // Update result if area with current row (as last
            // row of rectangle) is more
            result = Math.max(result, maxHist(R,C,A[i]));
        }

        return result;
    }



    public static int maxDifference(List<Integer> a) {
        // Write your code here
        int minVal = Integer.MAX_VALUE;
        int maxDiff = 0;
        for (int i = 1; i < a.size(); i++) {
            minVal = Math.min(minVal, a.get(i - 1));
            int curr = a.get(i);
            int diff = curr - minVal;
            maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff;
//        int max = 0;
//        for (int i = a.size() - 1; i >= 0; i--) {
//            int endValue = a.get(i);
//            for (int j = 0; j < i; j++) {
//                int comp = a.get(j);
//                if (comp < endValue) {
//                    max = Math.max(max, endValue - comp);
//                }
//            }
//        }
//
//        return max != 0 ? max : -1;
    }


    public static int numberOfPairs(List<Integer> a, long k) {
        // Write your code here
        int count = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            long val = a.get(i);
            long comp = k - val;
            if (map.containsKey(comp) && map.get(comp) > 0) {
                count++;
                map.put(comp, map.get(comp) - 1);
            } else {
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }

        Arrays.sort(new int[]{2, 3});
        return count;
    }



    public static int degreeOfArray(List<Integer> arr) {
        // Write your code here
        HashMap<Integer, ArrayList<Integer>> arrMap = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            int val = arr.get(i);
            if (arrMap.containsKey(val)) {
                List<Integer> list = arrMap.get(val);
                list.add(i);
            } else {
                arrMap.put(val, new ArrayList<>(Arrays.asList(i)));
            }
        }

        int degree = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : arrMap.entrySet()) {
            degree = Math.max(degree, entry.getValue().size());
        }

        int minSub = Integer.MAX_VALUE;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : arrMap.entrySet()) {
            if (entry.getValue().size() == degree) {
                List<Integer> entryVal = entry.getValue();
                int sub = entryVal.get(entryVal.size() - 1) - entryVal.get(0) + 1;
                minSub = Math.min(minSub, sub);
            }
        }

        return minSub;
    }

    public static String factorial(int n) {
        return factorial(n, 300);
    }

    private static String factorial(int n, int maxSize) {
        int res[] = new int[maxSize];
        res[0] = 1; // Initialize result
        int res_size = 1;

        // Apply simple factorial formula n! = 1 * 2 * 3 * 4... * n
        for (int x = 2; x <= n; x++) {
            res_size = multiply(x, res, res_size);
        }

        StringBuffer buff = new StringBuffer();
        for (int i = res_size - 1; i >= 0; i--) {
            buff.append(res[i]);
        }

        return buff.toString();
    }

    /**
     * This function multiplies x with the number represented by res[]. res_size
     * is size of res[] or number of digits in the number represented by res[].
     * This function uses simple school mathematics for multiplication.
     *
     * This function may value of res_size and returns the new value of res_size.
     */
    private static int multiply(int x, int res[], int res_size) {
        int carry = 0; // Initialize carry.

        // One by one multiply n with individual digits of res[].
        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of 'prod' in res[]
            carry = prod / 10;  // Put rest in carry
        }

        // Put carry in res and increase result size.
        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }

        return res_size;
    }


    public static int sumOfPairs(int arr[], int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int el = arr[i];
            hm.put(el, hm.getOrDefault(el, 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            int el = arr[i];
            int comp = sum - el;
            int valCount = hm.get(el);
            if (hm.get(comp) != null && hm.get(comp) > 0) {
                count += hm.get(comp);
                if (el == comp) {
                    count--;
                }
                hm.put(el, valCount - 1);
            }
        }

        return count;
    }

    static int[] segregate0and1(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int elLeft = arr[left];
            System.out.println(Arrays.toString(arr) + ", left: " + left + ", right: " + right);
            if (elLeft == 1) {
                while (arr[right] == 1) {
                    right--;
                }

                // swap
                arr[left] = arr[right];
                arr[right] = elLeft;
                right--;
                System.out.println(Arrays.toString(arr) + ", left: " + left + ", right: " + right + " (SWAP)");
            }
            left++;
        }
        return arr;
    }

    private static class Graph {

        private int size;
        private LinkedList<Integer>[] nodes;

        public Graph(int size) {
            this.size = size;
            nodes = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new LinkedList<>();
            }
        }

        void addEdge(int source, int dest) {
            nodes[source].add(dest);
        }

        LinkedList<Integer> getNode(int source) {
            return nodes[source];
        }
    }

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if (c_lib < c_road) {
            return c_lib * n;
        }

        Graph graph = toGraph(n, cities);
        boolean isVisited[] = new boolean[n + 1];
        int cost = 0;

        for (int i = 1; i <= n; i++) {
            if (isVisited[i]) continue;
            List<Integer> connectedCities = new ArrayList<>();
            dfs(i, graph, connectedCities, isVisited);

            cost += c_lib + ((connectedCities.size() - 1) * c_road);
        }

        return cost;
//        if (c_lib < c_road) {
//            return c_lib * n;
//        }
//
//        long counterLib = 0;
//        long counterRoad = 0;
//
//        HashSet<Integer> visited = new HashSet<>();
//        HashMap<Integer, Integer> component = new HashMap<>();
//        for (int road = 0; road < cities.length; road++) {
//            int source = cities[road][0];
//            int dest = cities[road][1];
//            if (component.containsKey(source) && component.containsKey(dest)) {
//                counterLib--;
//                counterRoad++;
//
//                // remove component
//                int sourcePair = component.get(source);
//                int destPair = component.get(dest);
//                component.remove(source);
//                component.remove(sourcePair);
//                component.remove(dest);
//                component.remove(destPair);
//            }
//            if (!visited.contains(source) && !visited.contains(dest)) {
//                counterLib++;
//                counterRoad++;
//                component.put(source, dest);
//                component.put(dest, source);
//            } else if (visited.contains(source) && visited.contains(dest)) {
//                // Do nothing
//            } else if (visited.contains(source) || visited.contains(dest)) {
//                counterRoad++;
//            }
//
//            visited.add(source);
//            visited.add(dest);
//        }
//
//        counterLib += (n - visited.size());
//
//        return (counterRoad * c_road) + (counterLib * c_lib);
    }

    private static void dfs(int node, Graph graph, List<Integer> cities, boolean[] isVisited) {
        if (isVisited[node]) return;
        isVisited[node] = true;
        cities.add(node);
        for (Integer integer : graph.getNode(node)) {
            dfs(integer, graph, cities, isVisited);
        }
    }

    private static Graph toGraph(int size, int[][] cities) {
        Graph graph = new Graph(size + 1);
        for (int[] road : cities) {
            graph.addEdge(road[0], road[1]);
            graph.addEdge(road[1], road[0]);
        }
        return graph;
    }

    public static void main(String[] args) {
        HashSet hm = new HashSet();
        System.out.println(roadsAndLibraries(5, 92, 23, new int[][]{{2, 1}, {5, 3}, {5, 1}, {3, 4}, {3, 1}, {5, 4}, {4, 1}, {5, 2}, {4, 2}}));
//        System.out.println(Arrays.toString(segregate0and1(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1,0,1,0,1,0,1,1,1,0,1,0,0})));
//        System.out.println(sumOfPairs(new int[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1}, 11));
//        int n = 6;
//        System.out.printf("Factorial %d = %s%n", n, factorial(n));
//        List<Integer> a = Arrays.asList(3, 4, 10, 1, 9);
//        degreeOfArray(a);
//        System.out.println(maxDifference(a));
//        numberOfPairs(a, 47);
//        int R = 4;
//        int C = 4;
//
//        int A[][] = { {1, 0, 1, 0},
//                {1, 0, 1, 1},
//                {1, 1, 1, 0},
//                {1, 0, 0, 0},
//        };
//        System.out.print("Area of maximum rectangle is " +
//                maxRectangle(R,C,A));

//        System.out.println(findMissingPositive(new int[]{2, 1, 4}, 3));
//        Set<Integer> hash_Set = new HashSet<Integer>();
//        Set<Integer> asd = new HashSet<Integer>();


//        System.out.println(commonChild("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS", "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"));
//        System.out.println(substrCount(5,"abcbaba"));
//        ArrayList<int[]> asd = new ArrayList<>();
//        allFib(10);
//        HashSet<Integer> set = new HashSet<>();
//        set.add(2);
//        set.add(2);
//        isValid("asdsadasd");
//        subPair(Arrays.asList(4, 2, 3, 5, 7), 2); // (4, 2) (3, 5) (5, 7)
//        System.out.println(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}));
//        test(8);
//        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
//        hourglassSum(new int[][]{
////                {1, 1, 1, 0, 0, 0},
////                {0, 1, 0, 0, 0, 0},
////                {1, 1, 1, 0, 0, 0},
////                {0, 0, 2, 4, 4, 0},
////                {0, 0, 0, 2, 0, 0},
////                {0, 0, 1, 2, 4, 0}
////        });

    }
}
