package solutions;
/*
思路相当值得学习，把困难的难以思考的问题转化成更符合我们自身思路的问题。
另外，取每一位的数字的方法也值得学习，下次遇到这种问题就不要无脑toString了。
 */
public class Twelve_IntegerToRoman {
    class Solution {
        //An awesome solution
        //Convert roman numerals, that is hard to understand, into a arabic numerals way.
        //Converting a hard problem into one or more easy problems is essential.
        public String intToRoman(int num) {
            String M[]={"","M","MM","MMM"};
            String C[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
            String X[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
            String I[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
            //A way to get each digit of a number. Mark!
            return (M[num/1000]+C[(num%1000)/100]+X[(num%100)/10]+I[(num%10)]);
        }
    }
}
