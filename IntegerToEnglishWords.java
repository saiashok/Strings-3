// Time Complexity : O(1)
// Space Complexity :  O(1) if we ignore Strings space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * Problem# : 273. Integer to English Words
 * 
 * Remember the properties of English words: 
 * 1-19 all words are different
 * 20 -> 90 all ten's are different
 * 
 * if we split the number into three digits each- the index-1 is thousands place, index-2 is million, index-3 is billion
 * 123,456,789 -> 
 * 123 | 456 | 789
 * MILLION | THOUSAND | ""
 * 2        | 1         | 0
 * 
 * we are solving from index-0 that the hundreds place (right to left || backwards)
 * 
 * Important properties to remember:
 * if we want the number at hundreds place 123 -> 123/100 is 1 ; so One Hundred
 * if we divide a number by 100 we get the 100th position;
 * divide a number by 10 we get the 10th position
 * 
 * %10 of a number gives the remainder - i.e., the One's position
 * 
 * 
 */

import java.util.*;

public class IntegerToEnglishWords {

    String[] BELOW_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen" };

    String[] TENS_BELOW_100 = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety" };

    String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        // do we need any variables?
        int indexOfSplit = 0;
        String result = "";
        while (num > 0) {
            int currNum = num % 1000; // split by 3 words
            if (currNum != 0) {
                // tackling from back
                result = helper(currNum) + THOUSANDS[indexOfSplit] + " " + result;
            }
            num = num / 1000;
            indexOfSplit++;
        }

        return result.trim();

    }

    private String helper(int num) {
        if (num == 0)
            return "";
        if (num < 20) {
            return BELOW_20[num] + " ";
        } else if (num < 100) {
            return TENS_BELOW_100[num / 10] + " " + helper(num % 10);
        } else {
            return BELOW_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
