import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class IntervalScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int instances = scanner.nextInt();

        for (int i = 0; i < instances; i++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[j] = new Interval(start, end);
            }

            int maxIntervals = findMaxIntervals(intervals);
            System.out.println(maxIntervals);
        }
    }

    public static int findMaxIntervals(Interval[] intervals) {
    	// sorts the intervals array in ascending order based on the end attribute of each Interval object
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.end));

        int maxIntervals = 1; // At least one interval can be scheduled
        int currentEndTime = intervals[0].end;

        //when the start of interval[i+1] is bigger than end of the interval[i]
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= currentEndTime) {
                maxIntervals++;
                currentEndTime = intervals[i].end;
            }
        }

        return maxIntervals;
    }
}
