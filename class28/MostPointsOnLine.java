package laiofferClass28;

import java.awt.Point;
import java.util.HashMap;

public class MostPointsOnLine {
	public int most(Point[] points){
		//Assumptions: points is not null, and points.length >= 2.
		//record the maximum number of points on the same line
		int result = 0;
		//we use each pair of points to form a line
		for (int i = 0; i < points.length; i++){
			//any line can be represented by a point and a slope
			// we take the point as seed and try to find all possible slopers.
			Point seed = points[i];
			// record the points with same<x, y>
			int same = 1;
			//record the points with same x, for the special case of
			// infinite slope
			int sameX = 0;
			//record the maximum number of points on the samle line
			//crossing the seed point
			int most = 0;
			//a map with all possible slopes.
			HashMap<Double, Integer> cnt = new HashMap<Double, Integer>();
			for ( int j = 0; j < points.length; j++){
				if(i == j){
					continue;
				}
				Point tmp = points[j];
				if ( tmp.x == seed.x && tmp.y == seed.y){
					//handle the points with same<x,y>.
					same++;
				} else if (tmp.x == seed.x){
					//handle the points with same x.
					sameX++;
				} else {
					//otherwise, just calculate the slope and increment the counter
					//for the calculated slope
					double slope = ((tmp.y - seed.y) + 0.0) /(tmp.x - seed.x);
					if (!cnt.containsKey(slope)){
						cnt.put(slope, 1);
					}else{
						cnt.put(slope,  cnt.get(slope) + 1);
					}
					most = Math.max(most, cnt.get(slope));
				}
			}
			most = Math.max(most,  sameX) + same;
			result = Math.max(result,  most);
		}
		return result; 
	}
}
