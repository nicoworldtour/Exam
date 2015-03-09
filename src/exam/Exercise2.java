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
public class Exercise2 {
    
    public static void main(String[] args) {
		Exercise2 t = new Exercise2();
		Integer[] v2 = new Integer[] { 5, 4, 3, 2, 8, 3};
		t.hill(v2);
    }
    
    public static void hill(Integer[] v) {
		// Write your code here
		Integer[] temp = new Integer[v.length];
		int max = 0;
		boolean done;

		do {
			done = true;
			max++;
			for (int i = 0; i < v.length; i++) {
				temp[i] = v[i];
                        } // reinitialisation

			for (int i = 0; i < temp.length; i++) {
				if (i > 0) {
					if (temp[i] <= temp[i - 1]) {
                                            int add = (temp[i - 1] - temp[i]) + 1;
                                            if (add <= max ) {                                                 
                                                temp[i] += add;
                                            } else {
                                                done = false;
                                                break;
                                            }                                            
					}
				}
				if (i < temp.length - 1) {
					if (temp[i] >= temp[i + 1]) {
						if (i > 0 && temp[i] - max <= temp[i - 1]) {
							temp[i] = temp[i - 1] + 1;
						} else {
							temp[i] -= max;
						}
					}
				}
				if (i > 0) {
					done = done && temp[i] > temp[i - 1];
				}
				if (!done)
					break;
			}

		} while (!done);

		System.out.println("result :" + max);
		for (int i = 0; i < temp.length; i++) {
			System.out.println("tab[" + i + "] : " + temp[i]);
		}
		// To print results to the standard output you can use
		// System.out.println()
		// Example: System.out.println("Hello world!");

    }
}
