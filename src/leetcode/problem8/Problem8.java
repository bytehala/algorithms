package leetcode.problem8;

class Solution {
    public int myAtoi(String str) {

        if (str.isBlank() || str.isEmpty()) {
            return 0;
        }

        str = str.stripLeading();
        int multiplier = 1;
        double number = 0;
        char sign = str.charAt(0);
        int i = 0;
        if (sign == '-') {
            multiplier = -1;
            i = 1;
        } else if (sign == '+') {
            i = 1;
        } else if (!(sign >= '0' && sign <= '9')) {
            return 0;
        }

        for (; i < str.length(); i++) {
            char current = str.charAt(i);
            //System.out.println("current = " + current + " " + (current - '0'));
            if (current >= '0' && current <= '9') {
                number *= 10;
                number += (current - '0');
                System.out.println(number);
                if (number > Integer.MAX_VALUE) {
                    if (multiplier == -1) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                break;
            }
        }

        return (int) (multiplier * number);
    }
}

public class Problem8 {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.myAtoi("-11"));
//        System.out.println(s.myAtoi("-42"));
//        System.out.println(s.myAtoi("42"));
//        System.out.println(s.myAtoi("4193 with words"));
//        System.out.println(s.myAtoi("words and 987"));
//        System.out.println(s.myAtoi("-91283472332"));
        System.out.println(s.myAtoi("2147483646"));
    }
}
