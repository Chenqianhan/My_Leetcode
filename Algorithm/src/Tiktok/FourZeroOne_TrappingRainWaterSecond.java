package Tiktok;

import java.util.PriorityQueue;

public class FourZeroOne_TrappingRainWaterSecond {
    public int trapRainWater(int[][] heightMap) {
        int colEdge = heightMap[0].length - 1, rowEdge = heightMap.length - 1;
        if(colEdge < 2 || rowEdge < 2) return 0;

        boolean[][] isVisited = new boolean[heightMap.length][heightMap[0].length];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        //Initialize
        for(int i=0;i<heightMap.length;i++){
            queue.add(new int[]{i, 0, heightMap[i][0]});
            queue.add(new int[]{i, colEdge, heightMap[i][colEdge]});
            isVisited[i][0] = true;
            isVisited[i][colEdge] = true;
        }

        for(int j=1;j<colEdge;j++){
            queue.add(new int[]{0, j, heightMap[0][j]});
            queue.add(new int[]{rowEdge, j, heightMap[rowEdge][j]});
            isVisited[0][j] = true;
            isVisited[rowEdge][j] = true;
        }

        int volumn = 0;
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] dir:directions){
                int i = cur[0] + dir[0];
                int j = cur[1] + dir[1];
                if(i>=0 && i<heightMap.length && j>=0 && j<heightMap[0].length && !isVisited[i][j]){
                    isVisited[i][j] = true;
                    volumn += Math.max(0, cur[2] - heightMap[i][j]);
                    queue.add(new int[]{i, j, Math.max(heightMap[i][j], cur[2])});

                }
            }
        }

        return volumn;
    }
}
