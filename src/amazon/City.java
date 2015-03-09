package amazon;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class City
{
  String name;
  int population;
  
  public City() {}
  
  public City(String n, int p)
  {
    this.name = n;
    this.population = p;
  }
  
  public String toString()
  {
    return "Name :" + this.name + "/ population :" + this.population;
  }
  
  public int getPopulation()
  {
    return this.population;
  }
  
  public static void main(String[] args)
  {
    City seattle = new City("Seattle", 60);
    City spokane = new City("Spokane", 21);
    City olympia = new City("Olympia", 5);
    ArrayList<City> listCities = new ArrayList();
    listCities.add(olympia);
    listCities.add(spokane);
    listCities.add(seattle);
    
    int sumPop = 0;
    int[] popRange = new int[listCities.size()];
    int i = 0;
    for (Iterator iterator = listCities.iterator(); iterator.hasNext();)
    {
      City city = (City)iterator.next();
      sumPop += city.getPopulation();
      popRange[(i++)] = sumPop;
    }
    double rd = Math.random();
    long index = Math.round(rd * sumPop);
    
    System.out.println(index);
    System.out.println(sumPop);
    System.out.println(listCities);
    for (int j = 0; j < popRange.length; j++) {
      if (index <= popRange[j])
      {
        System.out.println("Resultat :" + listCities.get(j));
        break;
      }
    }
  }
}
