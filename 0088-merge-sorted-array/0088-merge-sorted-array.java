class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
  if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        } else if (n == 0) {

        } else {
            for (int i = 0; i < n; i++) {
                nums1[i + m] = nums2[i];
            }
        }
        Arrays.sort(nums1);
    }
}