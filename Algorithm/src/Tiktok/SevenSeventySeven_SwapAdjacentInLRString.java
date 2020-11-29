package Tiktok;

public class SevenSeventySeven_SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        int sLen = start.length(), eLen = end.length();
        if(sLen != eLen || !start.replace("X","").equals(end.replace("X","")))
            return false;

        int sp = 0, ep = 0;
        while(sp < sLen && ep < eLen){
            while(sp < sLen && start.charAt(sp) == 'X'){
                sp++;
            }
            while(ep < eLen && end.charAt(ep) == 'X'){
                ep++;
            }

            if(sp == sLen && ep == eLen){
                return true;
            }else if(sp == sLen || ep == eLen){
                return false;
            }

            char sCur = start.charAt(sp), eCur = end.charAt(ep);
            if(sCur != eCur || (sCur == 'L' && sp < ep) || (sCur == 'R' && sp > ep))
                return false;

            sp++;
            ep++;
        }

        return true;
    }
}
