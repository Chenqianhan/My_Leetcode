package DPandGreedy;

public class OneSeventyFour_DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] curHP = new int[dungeon.length][dungeon[0].length];
        int pX = curHP.length-1, pY = curHP[0].length-1;
        curHP[pX][pY] = dungeon[pX][pY]>0?1:1-dungeon[pX][pY];

        for(int i=pY-1;i>=0;i--)
            curHP[pX][i] = Math.max(curHP[pX][i+1] - dungeon[pX][i], 1);

        for(int i=pX-1;i>=0;i--)
            curHP[i][pY] = Math.max(curHP[i+1][pY] - dungeon[i][pY], 1);

        for(int i = pX-1;i>=0;i--){
            for(int j = pY-1;j>=0;j--){
                curHP[i][j] = Math.max(1, Math.min(curHP[i+1][j], curHP[i][j+1]) - dungeon[i][j]);
            }
        }

        return curHP[0][0];
    }
}
