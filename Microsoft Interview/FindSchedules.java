/*
Problem:

You are given a weekly work schedule pattern as a string pattern of length 7 (representing 7 days).
Each character in pattern is either:

A digit '0' to '9' representing the fixed number of work hours for that day.

A question mark '?' representing an unknown number of work hours for that day.

You are also given:

workHours — the total number of hours you must work in the week.

dayHours — the maximum number of hours you can work in a single day.

Your task is to:

Replace every '?' in the schedule with a number from 0 to dayHours (inclusive) such that:

The total number of hours in the week equals workHours.

Generate all possible valid schedules, sorted in lexicographical order.

Input:
workHours = 24
dayHours = 8
pattern = "08??840"

Output:
    [0804840, 0813840, 0822840, 0831840, 0840840]

Explanation:

Known hours: 0 + 8 + 8 + 4 + 0 = 20

Remaining = 24 - 20 = 4

Two ? positions must sum to 4.

All combinations (0–8 allowed) → (0,4), (1,3), (2,2), (3,1), (4,0) → Replaced in order → sorted list above.

 */

import java.util.ArrayList;
import java.util.List;

public class FindSchedules {
    public static void backtrack(char[] pattern, int dayHours, int workHours, int remainingSum, int positions, List<String> result, List<Integer> indexes)
    {
        if(positions == indexes.size())
        {
            if(remainingSum == 0){
                result.add(new String(pattern));
            }
            return;
        }

        for(int hour = 0; hour <=dayHours; hour ++)
        {
            pattern[indexes.get(positions)] = (char) (hour + '0');
            backtrack(pattern,dayHours,workHours,remainingSum - hour,positions+1, result,indexes);
        }
    }
    public static List<String> findSchedules(int dayHours, int workHours, String pattern)
    {
        List<String> result = new ArrayList<>();
        int sum = 0;
        List<Integer> indexes = new ArrayList<>();
        for(int i=0;i<pattern.length();i++)
        {
            char ch = pattern.charAt(i);
            if(ch == '?')
            {
                indexes.add(i);
            }
            else {
                sum += ch - '0';
            }
        }

        int remainingSum = workHours - sum;
        backtrack(pattern.toCharArray(),dayHours, workHours, remainingSum, 0, result, indexes);

        return result;
    }

    public static void main(String args[])
    {
        int dayHours = 8;
        int workHours = 40;
        String pattern = "08??887";

        List<String> result = findSchedules(dayHours, workHours, pattern);
        for(String str : result)
        {
            System.out.println(str);
        }

    }
    
}
