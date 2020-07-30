package Math;

public class SevenEighty_ReachingPoints {
    //Recursive way performs the same as iterative one. Iterative way is more intelligible.
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        //Corner cases.
        if(tx<sx || ty<sy) return false;
        if(tx==sx) return (ty-sy)%tx==0;
        if(ty==sy) return (tx-sx)%ty==0;

        if(tx>ty) return reachingPoints(sx,sy,tx%ty,ty);
        else if(tx<ty) return reachingPoints(sx,sy,tx,ty%tx);
        else return false;
    }
    /*
    //this work. 100%, 60%
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx<=tx&&sy<=ty){
            if(tx==ty) break;
            if(tx<ty){
                if(tx>sx)
                    ty%=tx;
                else  //tx==sx
                    return (ty-sy)%tx==0;
            }else{
                if(ty>sy)
                    tx%=ty;
                else
                    return (tx-sx)%ty==0;
            }
        }
        return sx==tx&&sy==ty;
    }
    */

    /*
    //Better than below but still fails on extremely large tx and extremely small ty.
    //If we move forward, there are countless possibility. If we move backward, there is only one route.
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx<=tx&&sy<=ty){
            if(tx==sx && ty==sy)
                return true;
            if(tx<ty){
                ty-=tx;
            }else if(ty<tx){
                tx-=ty;
            }else{
                if(sx==tx && sy==tx)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }
    */

    /*Intuitive approach, but fails on extremely large tx,ty.
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx>tx || sy>ty)
            return false;

        if(sx==tx && sy==ty)
            return true;

        return reachingPoints(sx+sy,sy,tx,ty)||reachingPoints(sx,sx+sy,tx,ty);
    }
    */
}
