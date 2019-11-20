package solutions;

import java.util.ArrayList;
import java.util.List;
//double 100%, 0ms and 34.4MB. Brute way can achieve the best performance.
public class FiftyFour_spiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length==0) return list;

        int amount=matrix.length*matrix[0].length;
        if(amount==1){
            list.add(matrix[0][0]);
            return list;
        }

        if(matrix.length==1){
            for(int i:matrix[0]) list.add(i);
            return list;
        }

        if(matrix[0].length==1){
            for(int[] i:matrix) list.add(i[0]);
            return list;
        }

        int topEdge=0, leftEdge=0, bottomEdge=matrix.length-1, rightEdge=matrix[0].length-1;
        boolean right=true, down=false, left=false, up=false;
        int num=1,col=0,row=0;

        while(num<=amount){
            list.add(matrix[row][col]);
            num++;
            //Decide next position
            if(right && col<rightEdge){
                col++;
                if(col==rightEdge){
                    right=false;
                    down=true;
                }
            }else if(down && row<bottomEdge){
                row++;
                if(row==bottomEdge){
                    down=false;
                    left=true;
                }
            }else if(left && col>leftEdge){
                col--;
                if(col==leftEdge){
                    left=false;
                    up=true;
                }
            }else if(up && row>topEdge+1){
                row--;
                if(row==topEdge+1){
                    up=false;
                    right=true;
                    rightEdge--;
                    topEdge++;
                    leftEdge++;
                    bottomEdge--;
                }
            }
        }

        return list;
    }
}
