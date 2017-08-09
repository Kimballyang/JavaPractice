package laiofferClass10;
import java.util.*;

public class NQueens {
	// Method 1: validate the queen position in O(n) each time.
	public List<List<Integer>> nqueens(int n){
		//Assumptions: n>0
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// cur will be a list of size n, and cur[i] is the column number
		//where the queen on row i positioned
		List<Integer> cur = new ArrayList<Integer>();
		helper(n,cur,result);
		return result;
	}
	
	private void helper(int n, List<Integer> cur, List<List<Integer>> result){
		//base case: when for all the rows we know where the queen is positioned
		if(cur.size() == n){
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i =0; i<n; i++){
			//check if putting a queen at column i at current row is valid
			if (valid(cur,i)){
				cur.add(i);
				helper(n,cur,result);
				cur.remove(cur.size() -1);
			}
		}
	}
	
	private boolean valid(List<Integer> cur, int column){
		int row = cur.size();
		for (int i = 0; i<row; i++){
			if(cur.get(i) == column || Math.abs(cur.get(i) -column) == row -i){
				return false;
			}
		}
		return true;
	}
	
	// Method 2: validate the queen position in O(1) each time
	public List<List<Integer>> nqueensII(int n){
		//Assumptions: n>0
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//cur will be a list of size n, and cur[i] is the column number
		//where the queen on row i positioned
		int[] cur = new int[n];
		//record on which columns there is already a queen
		boolean[] usedColumns = new boolean[n];
		//record on which diagonal lines there is already a queen
		boolean[] usedDiagonals = new boolean[2 * n - 1];
		//record on which reverse diagonal lines there is already a queen.
		boolean[] usedRevDiagonals = new boolean[2 * n - 1];
		helper(n,0,cur,result, usedColumns, usedDiagonals, usedRevDiagonals);
		return result;
	}
	
	private void helper(int n, int row, int[] cur, List<List<Integer>> result,boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals){
		//base case: when for all the rows we know where the queen is positioned
		if (row == n){
			result.add(toList(cur));
			return;
		}
		for(int i=0; i<n; i++){
			if(valid(n,row,i,usedColumns, usedDiagonals, usedRevDiagonals)){
				mark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
				cur[row]=i;
				helper(n,row+1,cur,result,usedColumns,usedDiagonals,
						usedRevDiagonals);
				unMark(n,row,i,usedColumns,usedDiagonals, usedRevDiagonals);
			}
		}
	}
	private boolean valid(int n, int row, int column, boolean[] usedColumns, boolean[]
			usedDiagonals, boolean[] usedRevDiagonals){
		// for the reverse diagonal line, the actual range of column - row is 
		// actually [-(n-1), +(n-1)],
		// we add n-1 to make sure it can fit into the index
		return !usedColumns[column] && !usedDiagonals[column +row] && 
				!usedRevDiagonals[column -row +n -1];
	}
	private void mark(int n, int row, int column, boolean[] usedColumns, boolean[]
			usedDiagonals, boolean[] usedRevDiagonals){
		usedColumns[column]=true;
		usedDiagonals[column+row]=true;
		usedRevDiagonals[column -row +n -1]=true;
		
	}
	private void unMark(int n, int row, int column, boolean[] usedColumns, boolean[] 
			usedDiagonals, boolean[] usedRevDiagonals){
		usedColumns[column]=false;
		usedDiagonals[column +row]=false;
		usedRevDiagonals[column -row +n -1]= false;
	}
	private List<Integer> toList(int[] array){
		List<Integer> list = new ArrayList<>();
		for (int num: array){
			list.add(num);
		}
		return list;
	}

}
