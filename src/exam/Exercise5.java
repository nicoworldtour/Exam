/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nicolas
 */

public class Exercise5
{
  public static void main(String[] args)
  {
    Integer[] dependencyFirst = { Integer.valueOf(3), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) };
    Integer[] dependencySecond = { Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(6) };
    Exercise5 test5 = new Exercise5();
    test5.listOrder(Integer.valueOf(6), dependencyFirst, dependencySecond);
  }
  
  public void listOrder(Integer totalNumTasks, Integer[] dependencyFirst, Integer[] dependencySecond)
  {
    LinkedList<Integer> queue = new LinkedList();
    List<Integer> noEdges = new ArrayList();
    int[] numIncomingEdges = new int[totalNumTasks.intValue()];
    for (int i = 1; i <= totalNumTasks.intValue(); i++) {
      noEdges.add(Integer.valueOf(i));
    }
    for (int i = 0; i < dependencySecond.length; i++)
    {
      numIncomingEdges[(dependencySecond[i].intValue() - 1)] += 1;
      noEdges.remove(dependencySecond[i]);
    }
    System.out.println(noEdges);
    for (int i = 0; i < totalNumTasks.intValue(); i++) {
      System.out.print(numIncomingEdges[i]);
    }
    while (!noEdges.isEmpty())
    {
      Integer task = (Integer)noEdges.remove(0);
      queue.add(task);
      for (int i = 0; i < dependencyFirst.length; i++) {
        if (dependencyFirst[i] == task)
        {
          numIncomingEdges[(dependencySecond[i].intValue() - 1)] -= 1;
          if (numIncomingEdges[(dependencySecond[i].intValue() - 1)] == 0) {
            noEdges.add(dependencySecond[i]);
          }
          dependencyFirst[i] = Integer.valueOf(0);
          dependencySecond[i] = Integer.valueOf(0);
        }
      }
    }
    System.out.println(queue);
    Iterator<Integer> itr = queue.iterator();
    while (itr.hasNext()) {
      System.out.print(itr.next() + " ");
    }
  }
}

