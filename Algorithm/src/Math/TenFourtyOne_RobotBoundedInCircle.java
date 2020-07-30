package Math;

public class TenFourtyOne_RobotBoundedInCircle {
    ////We need to ensure robot is in cycle, only when it back to origin or end up with different direction.
    //One mistake I made it's that not include index!=0 in return;
    //Optimized, but seems little improvement.
    public boolean isRobotBounded(String instructions) {
        int x=0,y=0;
        int[][] direction = {{0,1},{-1,0},{0,-1},{1,0}};
        int index = 0; //0:north 1:west 2:south 3:east
        for(int i=0;i<instructions.length();i++){
            char c = instructions.charAt(i);
            if(c=='L'){ index = (index+1)%4;}
            else if(c=='R'){ index = (index+3)%4; }
            else{
                x+=direction[index][0];
                y+=direction[index][1];
            }
        }
        return x==0&&y==0 || index!=0;
    }

    /*
    public boolean isRobotBounded(String instructions) {
        int x=0,y=0;
        int direction = 0; //0:north 1:west 2:south 3:east
        for(int i=0;i<instructions.length();i++){
            char c = instructions.charAt(i);
            if(c=='G'){
                switch(direction){
                    case 0:
                        y++;
                        break;
                    case 1:
                        x--;
                        break;
                    case 2:
                        y--;
                        break;
                    case 3:
                        x++;
                }
            }else if(c=='L'){
                direction = (direction+1)%4;
            }else{ //c=='R'
                direction = (direction+3)%4;
            }
        }
        return x==0&&y==0 || direction!=0;
    }
    */
}
