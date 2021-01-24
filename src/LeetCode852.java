/**
 * Tags: #BinarySearch
 */
public class LeetCode852 {
    public int peakIndexInMountainArray(int[] arr) {
        int i=0;
        while(arr[i]<arr[i+1]) {
            i++;
        }
        return i;
    }

    public static int peakIndexInMountainArray2(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        int mid;
        while(left < right) {
            System.out.println(left);
            System.out.println(right);
            mid = (left + right)/2;
            System.out.println(mid);
            System.out.println();
            if (arr[mid] < arr[mid+1]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0};
        int index = peakIndexInMountainArray2(arr);
        System.out.println(index);
    }
}
