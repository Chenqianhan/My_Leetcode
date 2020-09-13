package Interview;

public class OneThirtyFour_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, curTank = 0, start = 0;
        for(int i = 0;i<gas.length;i++){
            total += gas[i] - cost[i];
            curTank += gas[i] - cost[i];
            if(curTank<0){
                start = i+1;
                curTank = 0;
            }
        }
        return total>=0?start:-1;
    }
    /*
    //It is not efficient
    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<gas.length;i++){
            if(gas[i]>=cost[i])
                list.add(i);
        }
        if(list.isEmpty()) return -1;

        for(int idx:list){
            if(travel(gas, cost, (idx+1)%gas.length, gas[idx]-cost[idx], idx)) return idx;
        }

        return -1;
    }

    public boolean travel(int[] gas, int[] cost, int curPosition, int curGas, int dest){
        if(dest==curPosition) return true;
        int nxtGas = curGas + gas[curPosition] - cost[curPosition];
        if(nxtGas<0) return false;

        return travel(gas, cost, (curPosition+1)%gas.length, nxtGas, dest);
    }
    */
}
