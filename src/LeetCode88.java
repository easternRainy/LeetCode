public class LeetCode88 {
    /**
     * may be I could come up with a better solution with fewer memory
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0) {return;}

        int p1 = 0;
        int p2 = 0;

        //int tmp = (nums1[p1] <= nums2[p2] ? nums1[p1] : nums2[p2]);
        int[] result = new int[m+n];
        int i = 0;
        while ( p1 < m && p2 < n) {
            int a = nums1[p1];
            int b = nums2[p2];
            if (a <= b) {
                result[i] = a;
                p1++;
            } else {
                result[i] = b;
                p2++;
            }

            i++;
        }

        if (p1 < m) {
            for (int j=p1; j<m; j++) {
                result[i] = nums1[j];
                i++;
            }
        }

        if (p2 < n) {
            for (int j=p2; j<n; j++) {
                result[i] = nums2[j];
                i++;
            }
        }

        for(int j=0; j<m+n; j++) {
            nums1[j] = result[j];
        }

    }
}
