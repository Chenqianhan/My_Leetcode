package String;

public class SixFiftySeven_RobotReturnToOrigin {
    //Easy boring problem.
    public boolean judgeCircle(String moves) {
        //int[] coordinate = new int[2];
        int x = 0, y = 0;
        for(int i=0;i<moves.length();i++){
            switch(moves.charAt(i)){
                case 'U':
                    //coordinate[0]++;
                    y++;
                    break;
                case 'D':
                    //coordinate[0]--;
                    y--;
                    break;
                case 'L':
                    //coordinate[1]--;
                    x--;
                    break;
                case 'R':
                    //coordinate[1]++;
                    x++;
                    //break;
            }
        }
        return x==0&&y==0;
        //return coordinate[0]==0 && coordinate[1]==0;
    }
}
