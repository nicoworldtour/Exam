package exam;

import java.io.PrintStream;
import java.util.TreeSet;

public class Exercise1
{
  public static void main(String[] args)
  {
    Exercise1 t = new Exercise1();
    Integer[] v1 = { Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(4), Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(1) };
    Integer[] v12 = { Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(5), Integer.valueOf(8), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(11), Integer.valueOf(8), Integer.valueOf(7) };
    find_deviation(v1, Integer.valueOf(3));
  }
  
  public static void find_deviation(Integer[] v, Integer d)
  {
    TreeSet<Integer> setInteger = new TreeSet();
    int maxDev = 0;
    for (int i = 0; i < d.intValue(); i++) {
      setInteger.add(v[i]);
    }
    System.out.println(setInteger);
    System.out.println("---");
    for (int i = d.intValue(); i < v.length; i++)
    {
      if (setInteger.size() == d.intValue()) {
        setInteger.remove(v[(i - d.intValue())]);
      }
      System.out.println("remove :" + v[(i - d.intValue())]);
      setInteger.add(v[i]);
      System.out.println("add :" + v[i]);
      System.out.println(setInteger);
      
      int min = ((Integer)setInteger.first()).intValue();
      int max = ((Integer)setInteger.last()).intValue();
      int dev = max - min;
      System.out.println("deviation :" + dev);
      System.out.println("---");
      if (maxDev < dev) {
        maxDev = dev;
      }
    }
    System.out.println("max Deviation :" + maxDev);
  }
  
  public static void hill(Integer[] v)
  {
    Integer[] temp = new Integer[v.length];
    int max = 0;
    boolean done;
    do
    {
      done = true;
      max++;
      for (int i = 0; i < v.length; i++) {
        temp[i] = v[i];
      }
      for (int i = 0; i < temp.length; i++)
      {
        Integer[] arrayOfInteger1;
        if ((i > 0) && (temp[i].intValue() < temp[(i - 1)].intValue()))
        {
          //arrayOfInteger1 = temp;i = i;(arrayOfInteger1[i] =  = Integer.valueOf(arrayOfInteger1[i].intValue() + max));
        }
        if ((i < temp.length - 1) && 
          (temp[i].intValue() > temp[(i + 1)].intValue())) {
          if ((i > 0) && (temp[i].intValue() - max < temp[(i - 1)].intValue()))
          {
            temp[i] = Integer.valueOf(temp[(i - 1)].intValue() + 1);
          }
          else
          {
            //arrayOfInteger1 = temp;i = i;(arrayOfInteger1[i] =  = Integer.valueOf(arrayOfInteger1[i].intValue() - max));
          }
        }
        if (i > 0) {
          done = (done) && (temp[i].intValue() > temp[(i - 1)].intValue());
        }
        if (!done) {
          break;
        }
      }
    } while (!done);
    System.out.println("result" + max);
    for (int i = 0; i < temp.length; i++) {
      System.out.println("tab[" + i + "] : " + temp[i]);
    }
  }
}
