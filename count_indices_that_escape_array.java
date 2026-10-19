class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] state = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            int pos = i;

            while (pos >= 0 && pos < n && state[pos] == 0) {
                if (arr[pos] == 0) {
                    state[pos] = 2;
                    break;
                }

                state[pos] = 3;
                pos += arr[pos];
            }

            boolean good;

            if (pos < 0 || pos >= n) {
                good = true;
            } else if (state[pos] == 1) {
                good = true;
            } else {
                good = false;
            }

            pos = i;

            while (pos >= 0 && pos < n && state[pos] == 3) {
                int next = pos + arr[pos];
                state[pos] = good ? 1 : 2;
                pos = next;
            }

            if (state[i] == 1) {
                count++;
            }
        }

        return count;
    }
}
