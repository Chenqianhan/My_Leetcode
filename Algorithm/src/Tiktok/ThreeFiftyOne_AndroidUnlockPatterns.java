package Tiktok;

/**
 * The difference between these two is how we count.
 * They performs same. The first is by summing up the return cnt.
 * The second one is by passing a cnt value. So we can see it uses cnt = helper(i, len, cnt, m, n, jump, visited);
 * We persistently update the count as it flows to each recursion.
 */
public class ThreeFiftyOne_AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        int[][] jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[4][6] = jump[6][4] = 5;
        jump[7][9] = jump[9][7] = 8;
        jump[1][7] = jump[7][1] = 4;
        jump[2][8] = jump[8][2] = 5;
        jump[3][9] = jump[9][3] = 6;
        jump[1][9] = jump[9][1] = jump[3][7] = jump[7][3] = 5;

        boolean[] visited = new boolean[10];
        int cnt = 0;
        cnt += helper(1, 1, m, n, jump, visited)*4; //1,3,7,9 is the same;
        cnt += helper(2, 1, m, n, jump, visited)*4;
        cnt += helper(5, 1, m, n, jump, visited);

        return cnt;
    }

    public int helper(int cur, int len, int m, int n, int[][] jump, boolean[] visited){
        if(len >= n) return 1;

        int cnt = 0;
        if(len++ >= m) cnt++;

        visited[cur] = true;
        for(int i = 1; i<10; i++){
            int j = jump[cur][i];
            if(!visited[i] && (j == 0 || visited[j])){
                cnt += helper(i, len, m, n, jump, visited);
            }
        }

        visited[cur] = false;
        return cnt;
    }
    /*
    public int numberOfPatterns(int m, int n) {
        int[][] jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[4][6] = jump[6][4] = 5;
        jump[7][9] = jump[9][7] = 8;
        jump[1][7] = jump[7][1] = 4;
        jump[2][8] = jump[8][2] = 5;
        jump[3][9] = jump[9][3] = 6;
	    jump[1][9] = jump[9][1] = jump[3][7] = jump[7][3] = 5;

        boolean[] visited = new boolean[10];
        int cnt = 0;
        cnt += helper(1, 1, 0, m, n, jump, visited)*4; //1,3,7,9 is the same;
        cnt += helper(2, 1, 0, m, n, jump, visited)*4;
        cnt += helper(5, 1, 0, m, n, jump, visited);

        return cnt;
    }

    public int helper(int cur, int len, int cnt, int m, int n, int[][] jump, boolean[] visited){
        if(len >= m) cnt++;
        len++;
        if(len > n) return cnt;

        visited[cur] = true;
        for(int i = 1; i<10; i++){
            int j = jump[cur][i];
            if(!visited[i] && (j == 0 || visited[j])){
                cnt = helper(i, len, cnt, m, n, jump, visited);
            }
        }

        visited[cur] = false;
        return cnt;
    }
    */
}
