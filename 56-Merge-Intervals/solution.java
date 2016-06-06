/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) 
    {
        if(intervals.size() <= 1)
        {
            return intervals;
        }
        
        Collections.sort(intervals, new Comparator<Interval>()
        {
            @Override
            public int compare(Interval i1, Interval i2)
            {
                return i1.start - i2.start;
            }
        });
        
        List<Interval> result = new ArrayList<Interval>();
        int left = intervals.get(0).start;
        int right = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start >= left && intervals.get(i).start <= right){
                if(intervals.get(i).end > right){
                    right = intervals.get(i).end;
                }
            }else{
                Interval newOne = new Interval(left, right);
                result.add(newOne);
                left = intervals.get(i).start;
                right = intervals.get(i).end;
            }
        }
        Interval newOne = new Interval(left, right);
        result.add(newOne);
        return result;
    }
}