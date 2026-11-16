class Solution {
    public int findKthSmall(int[] arr, int k) {
        int low = 1;
        int high = k + arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            for (int num : arr) {
                if (num <= mid) {
                    count++;
                }
            }

            int missing = mid - count;

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
