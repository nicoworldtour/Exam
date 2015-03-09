package exam;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Exercise3
{
  public static void main(String[] args)
  {
    Integer homeCity = Integer.valueOf(1);
    Integer destCity = Integer.valueOf(6);
    Integer[] firstCityRoads = { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(3), Integer.valueOf(4) };
    Integer[] lastCityRoads = { Integer.valueOf(3), Integer.valueOf(3), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(6), Integer.valueOf(2), Integer.valueOf(5) };
    Exercise3 test3 = new Exercise3();
    test3.countPath(Integer.valueOf(7), homeCity, destCity, firstCityRoads, lastCityRoads);
  }
  
  public void countPath(Integer numCity, Integer homeCity, Integer destCity, Integer[] firstCityRoads, Integer[] lastCityRoads)
  {
    HashMap<Integer, Set<Integer>> endings = new HashMap();
    for (int j = 0; j < firstCityRoads.length; j++)
    {
      if (endings.get(firstCityRoads[j]) != null)
      {
        ((Set)endings.get(firstCityRoads[j])).add(lastCityRoads[j]);
      }
      else
      {
        Set<Integer> temp = new HashSet();
        temp.add(lastCityRoads[j]);
        endings.put(firstCityRoads[j], temp);
      }
      if (endings.get(lastCityRoads[j]) != null)
      {
        ((Set)endings.get(lastCityRoads[j])).add(firstCityRoads[j]);
      }
      else
      {
        Set<Integer> temp = new HashSet();
        temp.add(firstCityRoads[j]);
        endings.put(lastCityRoads[j], temp);
      }
    }
    System.out.println(endings);
    

    LinkedList<Integer> queue = new LinkedList();
    Set<Integer> visited = new HashSet();
    visited.add(homeCity);
    queue.push(homeCity);
    int count = 0;
    while (!queue.isEmpty())
    {
      Integer ti = (Integer)queue.remove();
      if (ti == destCity)
      {
        System.out.println(count);
        break;
      }
      Set<Integer> tempCities = (Set)endings.get(ti);
      for (Integer etape : tempCities) {
        if (!visited.contains(etape))
        {
          visited.add(etape);
          queue.push(etape);
        }
      }
      count++;
    }
  }
}
