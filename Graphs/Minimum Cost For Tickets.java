class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        // return rec(days.length - 1, days, costs);

        // memoization
        Integer[] memo = new Integer[n];
        return memo(days.length - 1, days, costs, memo);
    }

    private int memo(int index, int[] days, int[] costs, Integer[] memo) {
        if (index < 0) {
            return 0;
        }

        if(memo[index] != null) return memo[index];

        if (index == 0) {
            return memo[index] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        }
        
        int oneDayPass = costs[0] + memo(getIndexOfNextDay(index, 1, days), days, costs, memo);
        int sevenDayPass = costs[1] + memo(getIndexOfNextDay(index, 7, days), days, costs, memo);
        int thirtyDayPass = costs[2] + memo(getIndexOfNextDay(index, 30, days), days, costs, memo);

        return memo[index] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
    }

    // return the minimum cost
    private int rec(int index, int[] days, int[] costs) {
        if (index < 0) {
            return 0;
        }

        if (index == 0) {
            return Math.min(costs[0], Math.min(costs[1], costs[2]));
        }
        
        int oneDayPass = costs[0] + rec(getIndexOfNextDay(index, 1, days), days, costs);
        int sevenDayPass = costs[1] + rec(getIndexOfNextDay(index, 7, days), days, costs);
        int thirtyDayPass = costs[2] + rec(getIndexOfNextDay(index, 30, days), days, costs);

        return Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
    }

    // return the index of the next applicable day
    /* 
    index = 4, passDays = 7, days = [1,4,6,7,8,20]
    nextDay = 8 - 7 + 1 = 2
    */

    private int getIndexOfNextDay(int index, int passDays, int[] days) {
        int nextDay = days[index] - passDays + 1;
        while(index >= 0 && days[index] >= nextDay) {
            index --;
        }
        return index;
    }
}
