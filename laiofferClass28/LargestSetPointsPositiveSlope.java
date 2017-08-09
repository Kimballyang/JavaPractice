package laiofferClass28;
import java.awt.Point;
import java.util.*;
public class LargestSetPointsPositiveSlope {
	public int largest(Point[] points){
		//Assumptions: points is not null
		//we need to sort the points first by y then by x
		Arrays.sort(points, new MyComparator());
		//similar to longest ascending subsequence.
		int result = 0;
		int[] longest = new int[points.length];
		for (int i = 0; i < longest.length; i++){
			for ( int j = 0; j < i; j++){
				if (points[j].x < points[i].x && points[j].y < points[i].y){
					longest[i] = Math.max(longest[i],  longest[j]);
				}
			}
			longest[i]++;
			result = Math.max(result,  longest[i]);
		}
		return result == 1 ? 0 : result;
	}
	// this comparator will sort the points by y first then by x.
	static class MyComparator implements Comparator<Point> {
		@Override
		public int compare(Point p1, Point p2){
			if(p1.y < p2.y) {
				return -1;
			} else if(p1.y > p2.y){
				return 1;
			} else if( p1.x < p2.x){
				return -1;
			} else if (p1.x > p2.x){
				return 1;
			}
			return 0;
		}
	}
}
