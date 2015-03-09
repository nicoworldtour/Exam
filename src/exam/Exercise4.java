/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exam;

/**
 *
 * @author Nicolas
 */
public class Exercise4 {
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        
        int n = 9;
        int[] arr = new int[n];
        
        arr[0]=3; 
        arr[1]=-5; 
        arr[2]=1;
        arr[3]=-2; 
        arr[4]=8; 
        arr[5]=-2; 
        arr[6]=3; 
        arr[7]=-2; 
        arr[8]=1;

        
        int[] minEndingAt = new int[n];
        int[] minFromAllPrev = new int[n];
        int[] maxStartingAt = new int[n];
        int[] maxFromAllNext = new int[n];
        
        
        
        // compute the MINIMUM subsequence SUM from all subsequence ending at or before I [O(N)]
	for(int i = 0; i < n; ++i)
	{
		int prev = i == 0 ? 0 : minEndingAt[i-1];
		minEndingAt[i] += Math.min(arr[i] , prev + arr[i]);
		minFromAllPrev[i] = minEndingAt[i];
		if( i > 0 )
			minFromAllPrev[i] = Math.min( minFromAllPrev[i] , minFromAllPrev[i-1] );
 
	}
        
                
        // compute the MAXIMUM subsequence SUM from all subsequence starting at or after I [O(N)]
	for(int i = n-1; i >= 0; --i)
	{
		int next = i == n-1 ? 0 : maxStartingAt[i+1];
		maxStartingAt[i] += Math.max(arr[i] , next + arr[i]);
		maxFromAllNext[i] = maxStartingAt[i];
		if( i < n-1 )
			maxFromAllNext[i] = Math.max( maxFromAllNext[i] , maxFromAllNext[i+1] );
	}

        // for each (i-1 , i) get the maximum difference [O(N)]
	int ma = -2000000;
	for(int i = 1; i < n; ++i)
	{
		ma = Math.max( ma , maxFromAllNext[i] - minFromAllPrev[i-1] );
	}
        
        for(int i = 0; i < n; ++i) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("-----");
        
        for(int i = 0; i < n; ++i) {
        System.out.print(minEndingAt[i]+" ");
        }
        System.out.println("-----");
        
        for(int i = 0; i < n; ++i) {
        System.out.print(minFromAllPrev[i]+" ");
        }
        System.out.println("-----");
        System.out.println();
        for(int i = 0; i < n; ++i) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("-----");
        
        
        for(int i = 0; i < n; ++i) {
        System.out.print(maxStartingAt[i]+" ");
        }
        System.out.println("-----");
        
        for(int i = 0; i < n; ++i) {
        System.out.print(maxFromAllNext[i]+" ");
        }
        System.out.println("-----");

        System.out.println(ma);
        
    }
    
    
}
