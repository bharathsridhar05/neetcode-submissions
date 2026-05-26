/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for(int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            start[i] = interval.start;
            end[i] = interval.end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int currentCount = 0;
        int maxCount = 0;

        int startIndex = 0;
        int endIndex = 0;

        while (startIndex < intervals.size()) {
            if(start[startIndex] < end[endIndex]) {
                currentCount++;
                startIndex++;
            } else {
                currentCount--;
                endIndex++;
            }
            maxCount = Math.max(maxCount, currentCount);
        }

        return maxCount;
    }
}
