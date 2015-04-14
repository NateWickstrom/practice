package com.company;

/**
 * Created by nate on 4/13/15.
 */
public class Dynamic {

    static int maxValueContinuousSub(int[] a){
        int length = a.length;
        int[] m = new int[length];

        m[0] = a[0];

        for (int i = 1; i < length; i++) {
            m[i] = Math.max(a[i], a[i] + m[i-1]);
        }

        int max = m[0];
        for (int i : m)
            max = Math.max(i, max);

        return max;
    }

    // doesn't have to be continuous
    static int[] longestIncreasingSub(int[] a){
        int n = a.length;
        int[] m = new int[n];

        // init
        for (int i = 0; i < n; i++)
            m[i] = 1;

        //DP
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                if (a[j] < a[i])
                    m[i] = Math.max(m[i], m[j] + 1);

        int max = m[0];
        for (int i : m)
            max = Math.max(i, max);

        // get a sub
        int[] sub = new int[max];
        for (int i = n-1; i >= 0; i--) {
            if (max == m[i]) {
                sub[max-1] = a[i];
                max--;
            }
        }

        return sub;
    }

    static int editDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        //iterate though, and check last char
        for (int i = 0; i < len1; i++) {

            for (int j = 0; j < len2; j++) {

                int replace = dp[i][j] + ( word1.charAt(i) == word2.charAt(j) ? 0 : 1);
                int insert = dp[i][j + 1] + 1;
                int delete = dp[i + 1][j] + 1;

                int min = replace > insert ? insert : replace;
                min = delete > min ? min : delete;
                dp[i + 1][j + 1] = min;
            }
        }

        return dp[len1][len2];
    }

    static int gameStrategy(int[] a) {
        int n = a.length;

        int[][] m = new int[n][n];

        //1 coin left
        for (int i = 0; i < n; i++)
            m[i][0] = a[i];

        //2 coins left
        for (int i = 0; i < n-1; i++)
            m[i][1] = Math.max(a[i], a[i+1]);

        //DP
        for (int j = 2; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                // Assume opponent took the max last turn, leaving us the min
                int take_J = Math.min(m[i][j-2], m[i+1][j-1]) + a[j];
                int take_I = Math.min(m[i+2][j], m[i+1][j-1]) + a[i];

                // we take the max
                m[i][j] =  Math.max(take_J, take_I);
            }
        }

        return m[0][n-1];
    }

}
