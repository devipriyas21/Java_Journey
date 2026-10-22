class Solution {
    public int minimumSum(String s) {
        int n = s.length();
        int sum = 0;
        char prev = '?';

        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            char here = s.charAt(i);
            char mirror = s.charAt(j);

            // A palindrome is impossible if fixed mirrored
            // characters are different.
            if (i < j && here != '?' && mirror != '?' && here != mirror) {
                return -1;
            }

            // Resolve this position using its mirrored character.
            char c = (here != '?') ? here : mirror;

            // Both characters are '?'; skip this unresolved pair.
            if (c == '?') {
                continue;
            }

            if (prev != '?') {
                sum += Math.abs(c - prev);
            }

            prev = c;
        }

        return sum;
    }
}
