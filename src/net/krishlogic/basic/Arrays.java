package net.krishlogic.basic;

import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Arrays {

    public static void printArray(int[] arr, boolean withComma) {
        for(int i=0; i<arr.length; i++) {
            if (withComma) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.println(arr[i]);
            }
        }
    }

    public static void rotateArray(int[] arr, int n) {

        int[] arr2 = new int[n];

        for (int i=0; i<n; i++) {
            arr2[i] = arr[i];
        }

        int c = 0;
        for (int i=n; i<arr.length; i++) {
            arr[c] = arr[i];
            c++;
        }

        for (int i=arr.length-n, j=0; i<arr.length; i++, j++) {
            arr[i] = arr2[j];
        }

        printArray(arr, true);
    }

    public static void cyclicArrayRotation(int[] arr, int n) {

        for (int i=0; i<n; i++) {
            int tempValue = arr[0];
            for (int j=1; j<arr.length; j++) {
                arr[j-1] = arr[j];
            }
            arr[arr.length-1] = tempValue;

            printArray(arr, true);
            System.out.println("");
        }
    }

    public static int getIndexOf() {
        int[] arr1 = {4, 5, 6, 7, 1, 2, 3};
        int numberToSearch = 2;

        int pivotIndex = findPivotPoint(arr1, 0, arr1.length-1);

        if (arr1[pivotIndex] > numberToSearch) {
            return getIndexOfBinarySearch(arr1, numberToSearch, pivotIndex, arr1.length -1);
        } else if(arr1[pivotIndex] < numberToSearch) {
            return getIndexOfBinarySearch(arr1, numberToSearch, 0, pivotIndex);
        } else {
            return pivotIndex;
        }
    }

    public static int getIndexOfBinarySearch(int arr[], int numberToSearch, int min, int max) {

        if (arr[max] == numberToSearch) {
            return max;
        }

        if (arr[min] == numberToSearch) {
            return min;
        }

        if (arr[max/2] < numberToSearch) {
            return getIndexOfBinarySearch(arr, numberToSearch, min, (min+max)/2);
        } else {
            return getIndexOfBinarySearch(arr, numberToSearch, (max+min)/2, max);
        }
    }

    private static int findPivotPoint(int arr[], int lowIndex, int highIndex) {

        if (lowIndex > highIndex) {
            return -1;
        }
        if (lowIndex == highIndex) {
            return lowIndex;
        }

        int mid = (lowIndex + highIndex)/2;

        if (arr[mid] > arr[mid+1] && arr[mid] < arr[highIndex]) {
            return mid;
        }
        if (mid > lowIndex && arr[mid] > arr[lowIndex]) {
            return mid-1;
        }

        if (arr[mid] <= arr[lowIndex]) {
            return findPivotPoint(arr, lowIndex, mid-1);
        }

        return findPivotPoint(arr, mid+1, highIndex);
    }

    /**
     * for sorted array only
     * @param arr
     * @return index
     */
    private static int findPivotPoint(int arr[]) {
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return i;
            }
        }

        return 0;
    }

    public static boolean isPairInSortedArray() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int sum = 9;
        int lIndex = 0;
        int rIndex = arr1.length-1;

        while (lIndex != rIndex) {
            if (arr1[lIndex] + arr1[rIndex] == sum) {
                System.out.println("sum found at locations: " + lIndex + "," + rIndex);
                return true;
            } else if (arr1[lIndex] + arr1[rIndex] < sum) {
                lIndex++;
            } else {
                rIndex--;
            }
        }

        return false;
    }

    public static boolean isPairInSortedRotated() {
        int[] arr1 = {4, 5, 6, 7, 1, 2, 3};
        int sum = 9;

        int pivotPoint = findPivotPoint(arr1);

        int lIndex = (pivotPoint+1) % arr1.length;
        int rIndex = pivotPoint;

        while(lIndex != rIndex) {

            if (arr1[lIndex] + arr1[rIndex] == sum) {
                System.out.println("sum found at locations: " + lIndex + "," + rIndex);
                return true;
            }

            if (arr1[lIndex] + arr1[rIndex] < sum) {
                lIndex = (lIndex +1) % arr1.length;
            } else {
                rIndex = (rIndex + arr1.length - 1) % arr1.length;
            }
        }

        return false;
    }

    public static int findMaxSum() {
        int[] arr = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int maxSum;
        int currentSum = 0;
        int arrSum = 0;

        for (int i=0; i< arr.length; i++) {
            arrSum = arrSum + arr[i];
            currentSum = currentSum + (i * arr[i]);
        }

        maxSum = currentSum;

        for (int i=1; i<arr.length; i++) {
            currentSum += arrSum - arr.length * (arr[arr.length - i]);

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    public static int getRotationCount() {
        int[] arr1 = {4, 5, 6, 7, 1, 2, 3};

        int min = arr1[0];
        int minIndex = -1;

        for (int i=0; i<arr1.length-1; i++) {
            if (min >arr1[i]) {
                minIndex = i;
                min = arr1[i];
            }
        }

        return minIndex;
    }

    public static int findMinElement() {
        int[] arr1 = {4, 5, 6, 7, 2, 3};
        int min = arr1[0];


        for (int i=0; i<arr1.length; i++) {
            if (min > arr1[i]) {
                min = arr1[i];
            }
        }

        return min;
    }

    public static void rearrange() {
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int index = -1, temp;
        for (int i=0; i<arr.length-1; i++) {

            if (arr[i] <0) {
                index++;
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        int pos = index + 1, neg = 0;

        while(neg < pos && pos < arr.length && arr[neg] < 0) {

            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            neg +=2;
            pos++;
        }

        printArray(arr, true);
    }

    public static void reverse() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};

        int i =0; int j = arr1.length-1;

        while(i != j) {
            int temp = arr1[i];
            arr1[i] = arr1[j];
            arr1[j] = temp;
            i++; j--;
        }

        printArray(arr1, true);
    }

    public static void sortInWaveForm() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};

        java.util.Arrays.sort(arr1);

        for (int i=0; i<arr1.length-1; i+=2) {
            swap(arr1, i, i+1);
        }

        printArray(arr1, true);

    }

    private static void swap(int arr[], int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    private static void sortByAbsDiff() {
        int arr[] = {10, 5, 3, 9, 2};
        int x = 7;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<arr.length; i++) {

            int diff  = x - arr[i];

            if (diff < 0) {
                if (map.containsKey(Math.abs(diff))) {
                    map.put(Math.abs(diff), map.get(diff) + 1);
                } else {
                    map.put(Math.abs(diff), 1);
                }
            }

            arr[i] = Math.abs(diff);
        }

        java.util.Arrays.sort(arr);

        for (int i=0; i<arr.length-1; i++) {
            if (map.containsKey(arr[i])) {
                int val = map.get(arr[i]);
                if (val ==0) {
                    map.remove(arr[i]);
                    arr[i] = x + arr[i];
                } else {
                    map.put(arr[i], map.get(arr[i] - 1));
                    arr[i] = x - arr[i];
                }
            } else {
                arr[i] = x + arr[i];
            }
        }

        printArray(arr, true);
    }

    public static void rearrangeSortedAlt1() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int [] temp = new int[arr1.length];
        int i=0, j=arr1.length-1;
        int k=0;
        boolean flag = true;
        while(i <arr1.length) {
            if (flag) {
                temp[i] = arr1[j--];
            } else {
                temp[i] = arr1[k++];
            }
            i++;
            flag = !flag;
        }

        printArray(temp, true);
    }

    public static void segregate0and1() {
     int arr[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};

     int arr1[] = new int[arr.length];
     int c = 0;
     for (int i=0; i<arr.length; i++) {
         if (arr[i] == 0) {
             arr1[c] = 0;
             c++;
         }
     }
     c = c+1;

     for (;c<arr.length; c++) {
         arr1[c] = 1;
     }

     printArray(arr1, true);
    }

    public static void segregateOddAndEven() {
        int arr[] = {12, 34, 45, 9, 8, 90, 3};
        int left = 0, right = arr.length-1;

        while (left < right) {

            while (arr[left] % 2 == 0 && left < right) {
                left++;
            }

            while (arr[right] % 2 != 0 && left < right) {
                right--;
            }

            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        printArray(arr, true);
    }

    public static void replaceBymultiply() {
        int arr[] = {2, 3, 4, 5, 6};

        int prev = arr[0];
        arr[0] = arr[0] * arr[1];

        for (int i=1; i<arr.length-1; i++) {
            int curr = arr[i];
            arr[i] = arr[i+1] * prev;
            prev = curr;
        }

        arr[arr.length-1] = prev * arr[arr.length-1];

        printArray(arr, true);
    }

    public static void randomize() {
        int arr[] = {2, 3, 4, 5, 6};

        Random random = new Random();
        int length = arr.length;
        for(int i=0; i<length; i++) {
            int x = random.nextInt(length);

            int temp = arr[i];
            arr[i] = arr[x];
            arr[x] = temp;
        }

        printArray(arr, true);
    }

    public static void printLargest() {
        String[] arr = {"54", "546", "548", "60"};
        List<String> myNums = new ArrayList<>();
        myNums = java.util.Arrays.asList(arr);

        Collections.sort(myNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String oA = o1 + o2;
                String oB = o2 + o1;

                return oA.compareTo(oB)> 0 ? -1 : 1;
            }
        });

        for (String myNum : myNums) {
            System.out.print(myNum);
        }
    }

    public static void rearrangeIndexAndNum() {
        int arr[] = {2, 0, 1, 4, 5, 3};
        int temp[] = new int[arr.length];
        int length = arr.length;

        for (int i=0; i<length; i++) {
            temp[arr[i]] = i;
        }

        for (int i=0; i<length; i++) {
            arr[i] = temp[i];
        }

        printArray(arr, true);
    }

    public static int maxDifferenceInTwoHeights(int k) {
        int arr[] = {1, 15, 10};
        int n = arr.length;

        java.util.Arrays.sort(arr);

        int ans = arr[n-1] - arr[0];
        int small = arr[0] + k;
        int big = arr[n-1] - k;
        int temp;

        if (small > big) {
            temp = small;
            small = big;
            big = temp;
        }

        for (int i=1; i<n-1; i++) {

            int add = arr[i] + k;
            int sub = arr[i] - k;

            if (sub >= small || add <= big) {
                continue;
            }

            if (big-sub <= add-small) {
                small = sub;
            } else {
                big = add;
            }
        }

        return Math.min(ans, big-small);
    }

    public static void reorderByIndex() {
        int arr[] = new int[]{50, 40, 70, 60, 90};
        int index[] = new int[]{3,  0,  4,  1,  2};

        int temp[] = new int[index.length];

        for (int i=0; i<index.length; i++) {
            temp[index[i]] = arr[i];
        }

        for (int i=0; i<arr.length; i++) {
            arr[i] = temp[i];
        }

        printArray(arr, true);

    }

    public static void findElements1() {
        int arr[] = { 2, -6 ,3 , 5, 1};

        java.util.Arrays.sort(arr);

        for (int i=0; i<arr.length-2; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("");
    }

    public static void findMinElements2() {
        int arr[] = { 2, -6 ,3 , 5, 1};

        //find second larges element:
        int first = arr[0];
        int second = arr[1];

        for (int i=0; i<arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if(arr[i] > second) {
                second = arr[i];
            }
        }

        for (int i=0; i<arr.length; i++) {
            if (arr[i] < second) {
                System.out.print(arr[i] + ",");
            }
        }
    }

    public static void nextGreaterElement() {
        int arr[] = { 11, 13, 21, 3 };
        int next;

        for (int i=0; i<arr.length; i++) {
            next = -1;
            for (int j= i+1; j< arr.length; j++) {
                if (arr[i] < arr[j]) {
                    next = arr[j];
                    break;
                }
            }
            System.out.println(arr[i] + "--> " + next);
        }
    }

    public static void kMostOccurances() {
        int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
        int k=2;
        HashMap<Integer, Integer> unsortedMap = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            if (unsortedMap.containsKey(arr[i])) {
                int val = unsortedMap.get(arr[i]);
                unsortedMap.put(arr[i], ++val);
            } else {
                unsortedMap.put(arr[i], 1);
            }
        }

        HashMap<Integer, Integer> sortedMap = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        for (Entry<Integer, Integer> entry: sortedMap.entrySet()) {
            if (k==0) {
                break;
            }
            System.out.print(entry.getKey() + " ");
            k--;
        }
    }

    public static int smallestMissingNumber() {
        int arr[] = {0, 1, 2, 6, 9};

        if (arr[0] != 0) {
            return 0;
        }

        for (int i=0; i<arr.length-1;i++) {
            if (arr[i+1] - arr[i] >1) {
                return arr[i]+1;
            }
        }

        return -1;
    }

    public static void twoSmallestElements() {
        int arr[] = {12, 13, 1, 10, 34, 1};

        int first, second;
        first = second = Integer.MAX_VALUE;

        for (int i=0; i<arr.length; i++) {
            if (first > arr[i]) {
                second = first;
                first = arr[i];
            } else if (second > arr[i] && arr[i] != first) {
                second = arr[i];
            }
        }

        System.out.println(first + "  " + second);
    }

    public static void minMax() {
        int arr[] = {1000, 11, 445, 1, 330, 3000};

        int min, max;

        if (arr.length == 1) {
            min = arr[0];
            max = arr[0];
            System.out.println(min +" " + max);
            return;
        }

        if (arr[0] > arr[1]) {
            max = arr[0];
            min = arr[1];
        } else if(arr[0] < arr[1]){
            max = arr[1];
            min = arr[0];
        } else {
            min = max = arr[0];
        }

        for (int i=2; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i]<min) {
                min = arr[i];
            }
        }

        System.out.print(min + " " + max);
    }

    public static void slidingWindowMaximum() {
        int arr[]={12, 1, 78, 90, 57, 89, 56};
        int k=3;

        Deque<Integer> queue = new LinkedList<>();
        int i;

        for (i=0; i<k; i++) {
            while(!queue.isEmpty() && arr[i] >= arr[queue.peek()]) {
                queue.removeLast();
            }

            queue.addLast(i);
        }


        for (; i<arr.length; ++i) {

            System.out.print(arr[queue.peek()] + ",");

            while(!queue.isEmpty() && queue.peek() <= (i-k)) {
                queue.removeFirst();
            }

            while(!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }

        //print the last one
        System.out.print(arr[queue.peek()]);
    }

    public static int findMinDistBetweenTwoElements() {
        int i=0;
        int minDistance = Integer.MAX_VALUE;
        int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        int n = arr.length;
        int x = 3;
        int y = 6;
        int prevIndex=0;

        for (i=0; i<n; i++) {
            if (arr[i] == x || arr[i] == y) {
                prevIndex = i;
                break;
            }
        }

        for (; i<n; i++) {

            if (arr[i] == x || arr[i] == y) {

                if (arr[prevIndex] != arr[i] && minDistance > (i-prevIndex)) {
                    minDistance = i-prevIndex;
                    prevIndex = i;
                } else {
                    prevIndex = i;
                }
            }
        }

        return minDistance;
    }

    public static int findMaxElement() {

        int arr[] = {1, 30, 40, 50, 60, 70, 23, 20};
        int max = arr[0];
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void spiralArray() {

        int arr[][] = {{1,  2,  3}, {4,  5,  6}, {7,  8, 9}};

        int rows = 3;
        int cols = 3;
        int top = 0;
        int bottom = rows-1;
        int left = 0;
        int right = cols-1;
        int dir = 0;

        while(top <= bottom && left <= right) {

            if (dir == 0) {
                for (int i=left; i<=right; i++) {
                    System.out.print(arr[top][i] + " ");
                }
                top++; dir=1;
            } else if (dir == 1) {
                for (int i=top; i<=bottom; i++) {
                    System.out.print(arr[i][right] + " ");
                }
                right--; dir=2;
            } else if (dir == 2) {
                for (int i=right; i>=left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--; dir=3;
            } else if (dir == 3) {
                for (int i=bottom; i>=top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++; dir=0;
            }
        }
    }

    public static int getLargestSumContiguousArr() {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};

        int max = Integer.MIN_VALUE;
        int frameTotal = 0;
        for (int i=0; i<a.length; i++) {

            frameTotal = frameTotal + a[i];
            if (max < frameTotal) {
                max = frameTotal;
            }

            if (frameTotal < 0){
                frameTotal = 0;
            }
        }

        return max;
    }

    public static void printTriangle(int n) {

        int[][] auxArr = new int[n][n];

        for (int lines=0; lines<n; lines++) {
            for (int i=0; i<=lines; i++) {

                if (lines == 0 || i == 0) {
                    auxArr[lines][i] = 1;
                } else {
                    auxArr[lines][i] = auxArr[lines-1][i-1] + auxArr[lines-1][i];
                }
               System.out.print(auxArr[lines][i] + " ");
            }
            System.out.println("");
        }
    }

    public static void mergeOverlappingIntervals() {
        int[][] arr = {{3,5}, {6,7}, {8,10}}; // {1,9}{2,4}{4,7}{6,8} -- after sorting
        int n = 3;

        java.util.Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] > o2[0]){
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        Stack<int[]> stack = new Stack<>();

        stack.push(arr[0]);

        for (int i=1; i<arr.length; i++) {
            int[] temp = stack.peek();

            if (arr[i][0] > temp[1]) {
                stack.push(arr[i]);
            } else if (temp[0] > arr[i][0]) {
                stack.pop();
                arr[i][0]=temp[0];
                stack.push(arr[i]);
            }
        }

        while(!stack.empty()) {
            int[] a = stack.pop();
            System.out.println(a[0]+ ","+a[1]);
        }
    }

    public static int getMaxWaterTrapped() {
        int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = arr.length;

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        int water = 0;
        left[0] = arr[0];

        for (int i=1; i<arr.length; i++) {
            left[i] = Math.max(left[i-1], arr[i]);
        }

        right[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }


        for (int i=0; i<n; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }

        return water;
    }

    public static void rotateMatrix() {
        int arr[][] = { {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12},
            {13, 14, 15, 16}  };

        int endRow = arr[0].length;
        int endCols = arr.length;
        int startRow = 0;
        int startCol = 0;

        int prev = arr[startRow+1][0];

        while(startRow < endRow && startCol < endCols) {

            for (int i=startCol; i<endCols; i++) {

                int curr = arr[startRow][i];
                arr[startRow][i] = prev;
                prev = curr;
            }
            startRow++;

            for (int i=startRow; i<endRow; i++) {
                int curr = arr[i][endCols-1];
                arr[i][endCols-1] = prev;
                prev = curr;
            }
            endCols--;

            if (startRow < endRow) {
                for (int i=endCols-1; i>=startCol; i--) {
                    int curr = arr[endRow-1][i];
                    arr[endRow-1][i] = prev;
                    prev = curr;
                }
            }

            endRow--;

            if (startCol < endCols) {
                for (int i=endRow-1; i>=startRow; i--) {

                    int curr = arr[i][startCol];
                    arr[i][startCol] = prev;
                    prev = curr;
                }

                startCol++;
            }
        }


        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("\nProgram for array rotation: "); rotateArray(arr1, 2);
        System.out.println("\ncyclic array rotation: "); cyclicArrayRotation(arr1, 2);
        System.out.println("Search in sorted and rotated array: " + getIndexOf());
        System.out.println("Given a sorted and rotated array, find if there is a pair with a given sum: " + isPairInSortedRotated());
        System.out.println("Given a sorted array, find if there is a pair with a given sum: " + isPairInSortedArray());
        System.out.println("Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed: " + findMaxSum());
        System.out.println("Find the Rotation Count in Rotated Sorted array : " + getRotationCount());
        System.out.println("Find min element in a sorted rotated array: " + findMinElement());
        System.out.println("Rearrange positive and negative numbers in O(n) time and O(1) extra space: "); rearrange();
        System.out.println("\n Reverse an array: "); reverse();
        System.out.println("\n Sort in wave form: "); sortInWaveForm();
        System.out.println("\n REVISIT: Sort an array according to absolute difference with given value: "); //sortByAbsDiff();
        System.out.println("\n Rearrange an sorted array in maximum minimum form | Set 1: "); rearrangeSortedAlt1();
        System.out.println("\n Segregate 0s and 1s in an array: "); segregate0and1();
        System.out.println("\n Segregate Even and Odd numbers: "); segregateOddAndEven();
        System.out.println("\n Replace every array element by multiplication of previous and next "); replaceBymultiply();
        System.out.println("\n Randomize: "); randomize();
        System.out.println("\n Arrange given numbers to form the biggest number | Set 1: "); printLargest();
        System.out.println("\n Rearrange an array such that ‘arr[j]’ becomes ‘i’ if ‘arr[i]’ is ‘j’: "); rearrangeIndexAndNum();
        System.out.println("\n REVISIT: Minimize the maximum difference between the heights: " + maxDifferenceInTwoHeights(6));
        System.out.println("\n Reorder an array according to given indexes: "); reorderByIndex();
        System.out.println("\n Find all elements in array which have at-least two greater elements: "); findElements1(); findMinElements2();
        System.out.println("\n Next Greater Element : "); nextGreaterElement();
        System.out.println("\n REVISIT WORKS: Find k numbers with most occurrences in the given array : "); kMostOccurances();
        System.out.println("\n Find the smallest missing number: " + smallestMissingNumber());
        System.out.println("\n Find the smallest and second smallest elements in an array: "); twoSmallestElements();
        System.out.println("\n Maximum and minimum of an array using minimum number of comparisons"); minMax();
        System.out.println("\n Sliding Window Maximum: "); slidingWindowMaximum();
        System.out.println("\n Find the minimum distance between two numbers" + findMinDistBetweenTwoElements());
        System.out.println("\n Find the maximum element in an array which is first increasing and then decreasing: " + findMaxElement());
        /**
         *
         * todo: dynamic programming and Longest increasing subsequence
         */

        System.out.println("\n print an array in spiral form: "); spiralArray();
        System.out.println("\n Largest Sum Contiguous Subarray: " + getLargestSumContiguousArr());
        System.out.println("\n Pascal's triangle"); printTriangle(2);
        System.out.println("\n Merge overlapping intervals: "); mergeOverlappingIntervals();
        System.out.println("\n find water trapped: " + getMaxWaterTrapped());
        System.out.println("\n rotate matrix: "); rotateMatrix();
    }
}
