/*https://www.codingninjas.com/codestudio/problems/1089580?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0*/
import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	// O(n^2) Time Complexity | O(1) space
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
                 // Write your code here.
		ArrayList<ArrayList<Long>> pascalList = new ArrayList<>();
		ArrayList<Long> temp = new ArrayList<>();
		temp.add(1l);
		pascalList.add(temp);
		for(int i=1;i<n;i++){
			ArrayList currentList = new ArrayList<>();
			currentList.add(1l);
			for(int j=1;j<i;j++){
				long value = pascalList.get(i-1).get(j-1)+pascalList.get(i-1).get(j);
				currentList.add(value);
			}
			currentList.add(1l);
			pascalList.add(currentList);
		}
		return pascalList;
	}
}

